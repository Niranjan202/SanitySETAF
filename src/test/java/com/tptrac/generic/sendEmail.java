package com.tptrac.generic;

import java.io.File;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class sendEmail {

    public void emailfunction() throws EmailException, MalformedURLException {
        // Get the latest report file from the directory
        String reportsDirPath = System.getProperty("user.dir") + "\\Reports\\TpTracReport\\";
        File latestReport = getLatestReportFile(reportsDirPath);

        if (latestReport == null || !latestReport.exists()) {
            System.out.println("No report found to attach.");
            return;
        }

        // Create the attachment
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(latestReport.getAbsolutePath());
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("TestNG Extent Report");
        attachment.setName("TpTracReport.html");

        // Create the email message
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.office365.com");
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator("tptracsupport@secureyes.net", "Mun17026")); // secure this
        email.setStartTLSRequired(true);
        email.addTo("niranjan.srichandan@secureyes.net");
        email.addTo("boda.sagar@secureyes.net");
        email.setFrom("tptracsupport@secureyes.net");
        email.setSubject("TestNG Extent Report");
        email.setMsg("Here is the latest graphical extent report. Please open it in Firefox for best experience.");

        // Add the attachment
        email.attach(attachment);

        // Send the email
         //email.send(); 
        System.out.println("Email with report sent successfully.");
    }

    private File getLatestReportFile(String directoryPath) {
        File dir = new File(directoryPath);
        File[] files = dir.listFiles((dir1, name) -> name.endsWith(".html"));

        if (files == null || files.length == 0) {
            return null;
        }

        File latestFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (files[i].lastModified() > latestFile.lastModified()) {
                latestFile = files[i];
            }
        }
        return latestFile;
    }
}
