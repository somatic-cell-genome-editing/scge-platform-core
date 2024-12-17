package edu.mcw.scge.datamodel;

import org.springframework.context.annotation.Configuration;

import java.sql.Date;


@Configuration("application")
public class Application extends StorageProperties {
    private int applicationId;
    private String applicationType;
    private String sponsorName;
    private String applicationNumber;
    private Date submissionDate;
    private String indication;
    private String productName;
    private String routeOfAdministration;
    private String pharmaceuticalFormulation;
    private String manufacturerName;
    private String referenceStandard;
    private String        dosageStrength;
    private String description;
    private String submittedBy;

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getRouteOfAdministration() {
        return routeOfAdministration;
    }

    public void setRouteOfAdministration(String routeOfAdministration) {
        this.routeOfAdministration = routeOfAdministration;
    }

    public String getPharmaceuticalFormulation() {
        return pharmaceuticalFormulation;
    }

    public void setPharmaceuticalFormulation(String pharmaceuticalFormulation) {
        this.pharmaceuticalFormulation = pharmaceuticalFormulation;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getReferenceStandard() {
        return referenceStandard;
    }

    public void setReferenceStandard(String referenceStandard) {
        this.referenceStandard = referenceStandard;
    }

    public String getDosageStrength() {
        return dosageStrength;
    }

    public void setDosageStrength(String dosageStrength) {
        this.dosageStrength = dosageStrength;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }
}
