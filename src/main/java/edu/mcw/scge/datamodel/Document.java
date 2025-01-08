package edu.mcw.scge.datamodel;

import org.springframework.context.annotation.Configuration;

import java.sql.Date;

@Configuration("document")
public class Document extends Application{
    private int documentId;
//    private int         applicationId;
    private String documentType;
    private String         documentName;
//    private String sponsorName;
    private int        module;
    private String section;
    private Date uploadDate;
    private String version;
    private String        status;
    private int tier;
    private String         uploadedBy;

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

//    public int getApplicationId() {
//        return applicationId;
//    }
//
//    public void setApplicationId(int applicationId) {
//        this.applicationId = applicationId;
//    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

//    public String getSponsorName() {
//        return sponsorName;
//    }
//
//    public void setSponsorName(String sponsorName) {
//        this.sponsorName = sponsorName;
//    }

    public int getModule() {
        return module;
    }

    public void setModule(int module) {
        this.module = module;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }
}
