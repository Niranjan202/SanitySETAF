USE TPTracMerge
GO


DECLARE @AuditorUser NVARCHAR(MAX) = 'bhuban.tripathy@secureyesdev.com,testuser1@secureyesdev.com'
DECLARE @VendorUser NVARCHAR(MAX) = 'sampleuser1@secureyesdev.com,mo_bank_7@secureyesdev.com'
DECLARE @Vendor NVARCHAR(MAX) = 'Suraj sam'
DECLARE @VendorCategory NVARCHAR(MAX) = 'Computer,L1'
DECLARE @Framework NVARCHAR(MAX) = 'April 10th New Framework,Maximize Levels,April 16th New Framework'



DELETE FROM auditor.UserLogin WHERE UserID IN (SELECT UserID FROM auditor.UserMaster WHERE UserName IN (SELECT value from STRING_SPLIT(@AuditorUser, ',')) )
DELETE FROM auditor.UserMaster WHERE UserName IN (SELECT value from STRING_SPLIT(@AuditorUser, ','))

DELETE FROM vendor.UserLogin WHERE UserID IN (SELECT UserID FROM vendor.UserMaster WHERE UserName IN (SELECT value from STRING_SPLIT(@VendorUser, ',')) )
DELETE FROM vendor.UserCaptcha WHERE UserID IN (SELECT UserID FROM vendor.UserMaster WHERE UserName IN (SELECT value from STRING_SPLIT(@VendorUser, ',')) )
DELETE FROM vendor.UserMaster WHERE UserName IN (SELECT value from STRING_SPLIT(@VendorUser, ','))

DELETE FROM vendor.MemberMaster WHERE Name IN (SELECT value from STRING_SPLIT(@Vendor, ','))
DELETE FROM master.MemberCategories WHERE CategoryName IN (SELECT value from STRING_SPLIT(@VendorCategory, ','))

DELETE FROM master.ControlMaster WHERE ControlID IN (SELECT ControlID FROM master.NodeMaster WHERE NodeMetaID IN (SELECT NodeMetaID FROM master.NodeMeta WHERE FWID IN (SELECT FWID FROM master.FrameworkMaster WHERE Name IN (SELECT value from STRING_SPLIT(@Framework, ',')))))
DELETE FROM master.NodeMaster WHERE NodeMetaID IN (SELECT NodeMetaID FROM master.NodeMeta WHERE FWID IN (SELECT FWID FROM master.FrameworkMaster WHERE Name IN (SELECT value from STRING_SPLIT(@Framework, ','))))
DELETE FROM master.NodeMeta WHERE FWID IN (SELECT FWID FROM master.FrameworkMaster WHERE Name IN (SELECT value from STRING_SPLIT(@Framework, ',')))
DELETE FROM master.MaturityLevelMaster WHERE FWID IN (SELECT FWID FROM master.FrameworkMaster WHERE Name IN (SELECT value from STRING_SPLIT(@Framework, ',')))
DELETE FROM master.FrameworkMaster WHERE Name IN (SELECT value from STRING_SPLIT(@Framework, ','))

