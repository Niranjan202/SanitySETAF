package com.tptrac.generic;

import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcSQLServerConnection {

    // DB constants
    private static final String HOST = "10.0.1.28";
    private static final String PORT = "1433";
    private static final String JDBC_URL = "jdbc:sqlserver://" + HOST + ":" + PORT;
    private static final String FRAMEWORK_ACCOUNT_GUID = "858E1FC8-AFC0-4716-9CD5-CB751DCE024E";

    // Logger
    private static final Logger LOGGER = Logger.getLogger(JdbcSQLServerConnection.class.getName());

    // Config properties
    private static final String USERNAME;
    private static final String PASSWORD;
    private static final String FRAMEWORK_NAME;

    static {
        FileLib fileLib = new FileLib();
        String user = "", pass = "", framework = "";
        try {
            user = fileLib.getPropertyData("username1");
            pass = fileLib.getPropertyData("password1");
            framework = fileLib.getPropertyData("frameworkName");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to read properties", e);
        }
        USERNAME = user;
        PASSWORD = pass;
        FRAMEWORK_NAME = framework;
    }

    /**
     * Entry point to clean up test data.
     */
    public void deleteData() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement()) {

            logMetadata(conn);

            // Deletion ordered by dependencies
            deleteVendorUsers(stmt);
            deleteAuditorUsers(stmt);
            deleteDepartments(stmt, Arrays.asList("HM"));
            deleteAssessmentCalendarData(stmt);
            updateVendorStatus(stmt);
            deleteMemberRiskResponses(stmt);
            deleteVendorMembers(stmt);
            deleteMemberCategories(stmt, Arrays.asList("IT Category", "Cyber", "Sales"));
            deleteVendorOnboardingHistory(stmt);
            deleteQuestionnaireData(stmt);
            deleteFrameworkData(stmt);

            LOGGER.info("✅ Data cleanup completed successfully.");

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQL Exception occurred during data cleanup", e);
        }
    }

    private void logMetadata(Connection conn) throws SQLException {
        DatabaseMetaData dm = conn.getMetaData();
        LOGGER.info("Driver: " + dm.getDriverName() + " " + dm.getDriverVersion());
        LOGGER.info("Database: " + dm.getDatabaseProductName() + " " + dm.getDatabaseProductVersion());
    }

    // ----------------------------------------------------------------------
    // User Deletion
    // ----------------------------------------------------------------------

    private void deleteVendorUsers(Statement stmt) throws SQLException {
        deleteUsers(stmt, "TPTrac.vendor.UserMaster", Arrays.asList("mo_bank_10@secureyesdev.com", "mo_bank_12@secureyesdev.com"), true);
        LOGGER.info("Vendor users deleted.");
    }

    private void deleteAuditorUsers(Statement stmt) throws SQLException {
        deleteUsers(stmt, "TPTrac.auditor.UserMaster", Arrays.asList("testuser21", "testuser22"), false);
        LOGGER.info("Auditor users deleted.");
    }

    private void deleteUsers(Statement stmt, String userTable, List<String> usernames, boolean includeCaptcha) throws SQLException {
        for (String user : usernames) {
            int id = getUserId(stmt, userTable, user);
            if (id > 0) {
                String baseTable = userTable.substring(0, userTable.lastIndexOf('.'));
                stmt.addBatch("DELETE FROM " + baseTable + ".UserLogin WHERE UserID=" + id);
                if (includeCaptcha) {
                    stmt.addBatch("DELETE FROM " + baseTable + ".UserCaptcha WHERE UserID=" + id);
                }
                stmt.addBatch("DELETE FROM " + userTable + " WHERE UserID=" + id);
            }
        }
        stmt.executeBatch();
    }

    // ----------------------------------------------------------------------
    // Department Deletion
    // ----------------------------------------------------------------------

    private void deleteDepartments(Statement stmt, List<String> names) throws SQLException {
        if (names.isEmpty()) return;
        String inClause = "'" + String.join("','", names) + "'";
        String query = "DELETE FROM [TPTrac].[auditor].[DepartmentMaster] WHERE Name IN (" + inClause + ")";
        int rows = stmt.executeUpdate(query);
        LOGGER.info("Departments deleted. Rows affected: " + rows);
    }

    // ----------------------------------------------------------------------
    // Member-Related Deletion
    // ----------------------------------------------------------------------

    private void deleteMemberRiskResponses(Statement stmt) throws SQLException {
        deleteByMemberId(stmt, "TPTrac.auditor.MemberRiskResponseLN", Arrays.asList("OLX", "SE Vendor 2", "Nitin kumar"));
        LOGGER.info("Member risk responses deleted.");
    }

    private void deleteVendorMembers(Statement stmt) throws SQLException {
        deleteByMemberId(stmt, "TPTrac.vendor.MemberMaster", Arrays.asList("OLX", "SE Vendor 2", "Nitin kumar"));
        LOGGER.info("Vendor members deleted.");
    }

    private void deleteByMemberId(Statement stmt, String table, List<String> memberNames) throws SQLException {
        for (String name : memberNames) {
            int memberId = getMemberId(stmt, name);
            if (memberId > 0) {
                stmt.addBatch("DELETE FROM " + table + " WHERE MemberID=" + memberId);
            }
        }
        stmt.executeBatch();
    }

    private void deleteMemberCategories(Statement stmt, List<String> categories) throws SQLException {
        if (categories.isEmpty()) return;
        String inClause = "'" + String.join("','", categories) + "'";
        String query = "DELETE FROM [TPTrac].[master].[MemberCategories] WHERE CategoryName IN (" + inClause + ")";
        int rows = stmt.executeUpdate(query);
        LOGGER.info("Member categories deleted. Rows affected: " + rows);
    }

    private void deleteVendorOnboardingHistory(Statement stmt) throws SQLException {
        int memberId = getMemberIdFromHistory(stmt, "secureyesdev\\tptrac-UpdateMemberMaster");
        if (memberId > 0) {
            stmt.executeUpdate("DELETE FROM TPTrac.master.VendorOnboardingHistory WHERE MemberID=" + memberId);
            LOGGER.info("Vendor onboarding history deleted.");
        }
    }

    private void updateVendorStatus(Statement stmt) throws SQLException {
        int rows = stmt.executeUpdate("UPDATE TPTrac.vendor.MemberMaster SET VendorStatusID=1 WHERE Name='SE Vendor 2' AND VendorStatusID=2");
        LOGGER.info("Vendor status updated. Rows affected: " + rows);
    }

    // ----------------------------------------------------------------------
    // Assessment & Questionnaire Cleanup
    // ----------------------------------------------------------------------

    


    private void deleteQuestionnaireData(Statement stmt) throws SQLException {
        List<String> tables = Arrays.asList(
            "Questionnaire_AssociationTypeLnk",
            "Questionnaire_ControlLnk",
            "Questionnaire_SectionLnk",
            "Questionnaire_VendorCategoryLnk",
            "Questionnaire_VendorLnk",
            "Questionnaire_VendorTypeLnk",
            "QuestionnaireLibrary",
            "QuestionnaireSection",
            "Questionnaire_TemplateLnk",
            "QuestionnaireTemplate_VendorCategoryLnk",
            "QuestionnaireTemplate_VendorLnk",
            "QuestionnaireTemplate"
        );

        for (String table : tables) {
            stmt.addBatch("DELETE FROM TPTrac.master." + table + " WHERE AccountGUID='" + FRAMEWORK_ACCOUNT_GUID + "'");
        }

        stmt.executeBatch();
        LOGGER.info("Questionnaire data deleted for AccountGUID: " + FRAMEWORK_ACCOUNT_GUID);
    }
    
    private void deleteAssessmentCalendarData(Statement stmt) throws SQLException {
        List<String> queries = Arrays.asList(
            // 1. Delete dependent child tables
            "DELETE FROM [TPTrac].[vendor].[Assessment_ReviewComments]",
            "DELETE FROM [TPTrac].[master].[NodeAnswers]",
            "DELETE FROM [TPTrac].[vendor].[FWControlQuestionResponse]",
            "DELETE FROM [TPTrac].[vendor].[NodeAnswersDraft]",
            "DELETE FROM [TPTrac].[vendor].[QuestionnaireResponse]",
            "DELETE FROM [TPTrac].[vendor].[SelfAssessmentEvidencesDraft]",

            // 2. Delete from ObservationsMaster ONLY where it references target MasterNodeDataIDs
            "DELETE FROM [TPTrac].[vendor].[ObservationsMaster] " +
            "WHERE MasterNodeDataID IN (" +
            "    SELECT MasterNodeDataID FROM [TPTrac].[vendor].[AssessmentCalendarMaster] " +
            "    WHERE AccountGUID = '" + FRAMEWORK_ACCOUNT_GUID + "')",

            // 3. Then delete from AssessmentCalendarMaster
            "DELETE FROM [TPTrac].[vendor].[AssessmentCalendarMaster] " +
            "WHERE AccountGUID = '" + FRAMEWORK_ACCOUNT_GUID + "'"
        );

        for (String query : queries) {
            int rows = stmt.executeUpdate(query);
            LOGGER.info("Executed: " + query + " | Rows affected: " + rows);
        }
    }




    // ----------------------------------------------------------------------
    // Framework Deletion
    // ----------------------------------------------------------------------

    private void deleteFrameworkData(Statement stmt) throws SQLException {
        if (FRAMEWORK_NAME == null || FRAMEWORK_NAME.trim().isEmpty()) {
            LOGGER.warning("Framework name is empty. Skipping framework deletion.");
            return;
        }

        String escapedName = FRAMEWORK_NAME.replace("'", "''");
        String fwidSubQuery = "SELECT FWID FROM TPTrac.master.FrameworkMaster WHERE Name IN (SELECT value FROM STRING_SPLIT('" + escapedName + "', ',')) AND AccountGUID = '" + FRAMEWORK_ACCOUNT_GUID + "'";

        List<String> queries = Arrays.asList(
            "DELETE FROM TPTrac.master.NodeMaster WHERE NodeMetaID IN (SELECT NodeMetaID FROM TPTrac.master.NodeMeta WHERE FWID IN (" + fwidSubQuery + "))",
            "DELETE FROM TPTrac.master.MaturityLevelMaster WHERE FWID IN (" + fwidSubQuery + ")",
            "DELETE FROM TPTrac.master.NodeMeta WHERE FWID IN (" + fwidSubQuery + ")",
            "DELETE FROM TPTrac.master.FrameworkMaster WHERE FWID IN (" + fwidSubQuery + ")"
        );

        for (String query : queries) {
            stmt.addBatch(query);
        }

        stmt.executeBatch();
        LOGGER.info("Framework data deleted for: " + FRAMEWORK_NAME + " with AccountGUID: " + FRAMEWORK_ACCOUNT_GUID);
    }

    // ----------------------------------------------------------------------
    // Utility Methods
    // ----------------------------------------------------------------------

    private int getUserId(Statement stmt, String table, String username) throws SQLException {
        try (ResultSet rs = stmt.executeQuery("SELECT UserID FROM " + table + " WHERE UserName='" + username + "'")) {
            return rs.next() ? rs.getInt("UserID") : 0;
        }
    }

    private int getMemberId(Statement stmt, String name) throws SQLException {
        try (ResultSet rs = stmt.executeQuery("SELECT MemberID FROM TPTrac.vendor.MemberMaster WHERE Name='" + name + "'")) {
            return rs.next() ? rs.getInt("MemberID") : 0;
        }
    }

    private int getMemberIdFromHistory(Statement stmt, String createdBy) throws SQLException {
        try (ResultSet rs = stmt.executeQuery("SELECT MemberID FROM TPTrac.master.VendorOnboardingHistory WHERE CreatedBy='" + createdBy + "'")) {
            return rs.next() ? rs.getInt("MemberID") : 0;
        }
    }
}
