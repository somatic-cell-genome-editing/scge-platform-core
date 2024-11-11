package edu.mcw.scge.datamodel;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClinicalTrialRecord {
    private String nctId;
    private String description;
    private String interventionName;
    private String interventionDescription;
    private String sponsor;
    private String sponsorClass;
    private String indication;
    private String phase;
    private int enrorllmentCount;
    private String location;
    private int numberOfLocations;
    private String eligibilitySex;
    private String elibilityMinAge;
    private String elibilityMaxAge;
    private String healthyVolunteers;
    private String standardAge;
    private String isFDARegulated;
    private String briefTitle;
    private String officialTitle;
    private String nihReportLink;
    private String studyStatus;
    private String firstSubmitDate;
    private String estimatedCompleteDate;
    private String lastUpdatePostDate;
    private String browseConditionTerms;

    private String nCTNumber;
    private String targetGeneOrVariant;
    private String therapyType;
    private String therapyRoute;
    private String mechanismOfAction;
    private String routeOfAdministration;
    private String drugProductType;
    private String targetTissueOrCell;
    private String deliverySystem;
    private String vectorType;
    private String editorType;
    private String recentUpdates;

    private String compoundName;

    private String dose1;
    private String dose2;
    private String dose3;
    private String dose4;
    private String dose5;
    private List<ClinicalTrialExternalLink> externalLinks;

    private String patents;

    public String getNctId() {
        return nctId;
    }

    public void setNctId(String nctId) {
        this.nctId = nctId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInterventionName() {
        return interventionName;
    }

    public void setInterventionName(String interventionName) {
        this.interventionName = interventionName;
    }

    public String getInterventionDescription() {
        return interventionDescription;
    }

    public void setInterventionDescription(String interventionDescription) {
        this.interventionDescription = interventionDescription;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getSponsorClass() {
        return sponsorClass;
    }

    public void setSponsorClass(String sponsorClass) {
        if(sponsorClass!=null)
        this.sponsorClass = formatFieldVal(sponsorClass);
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }



    public int getEnrorllmentCount() {
        return enrorllmentCount;
    }

    public void setEnrorllmentCount(int enrorllmentCount) {
        this.enrorllmentCount = enrorllmentCount;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumberOfLocations() {
        return numberOfLocations;
    }

    public void setNumberOfLocations(int numberOfLocations) {
        this.numberOfLocations = numberOfLocations;
    }

    public String getEligibilitySex() {

        return eligibilitySex;
    }

    public void setEligibilitySex(String eligibilitySex) {
        if(eligibilitySex!=null)
        this.eligibilitySex = formatFieldVal(eligibilitySex);
    }

    public String getElibilityMinAge() {
        return elibilityMinAge;
    }

    public void setElibilityMinAge(String elibilityMinAge) {
        this.elibilityMinAge = elibilityMinAge;
    }



    public String getHealthyVolunteers() {
        return healthyVolunteers;
    }

    public void setHealthyVolunteers(String healthyVolunteers) {
        this.healthyVolunteers = healthyVolunteers;
    }



    public String getIsFDARegulated() {
        return isFDARegulated;
    }

    public void setIsFDARegulated(String isFDARegulated) {
        if(isFDARegulated!=null && !isFDARegulated.equalsIgnoreCase("null"))
        this.isFDARegulated = StringUtils.capitalize(isFDARegulated);
    }

    public String getBriefTitle() {
        return briefTitle;
    }

    public void setBriefTitle(String briefTitle) {
        this.briefTitle = briefTitle;
    }

    public String getOfficialTitle() {
        return officialTitle;
    }

    public void setOfficialTitle(String officialTitle) {
        this.officialTitle = officialTitle;
    }

    public String getNihReportLink() {
        return nihReportLink;
    }

    public void setNihReportLink(String nihReportLink) {
        this.nihReportLink = nihReportLink;
    }

    public String getElibilityMaxAge() {
        return elibilityMaxAge;
    }

    public void setElibilityMaxAge(String elibilityMaxAge) {
        this.elibilityMaxAge = elibilityMaxAge;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        if(phase!=null)
        this.phase =  formatFieldVal(phase);
    }

    public String getStandardAge() {
        return standardAge;
    }

    public void setStandardAge(String standardAge) {
        if(standardAge!=null)
        this.standardAge =formatFieldVal(standardAge);
    }

    public String getStudyStatus() {
        return studyStatus;
    }

    public void setStudyStatus(String studyStatus) {
        if(studyStatus!=null)
        this.studyStatus = formatFieldVal(studyStatus);
    }

    public String getFirstSubmitDate() {
        return firstSubmitDate;
    }

    public void setFirstSubmitDate(String firstSubmitDate) {
        this.firstSubmitDate = firstSubmitDate;
    }

    public String getEstimatedCompleteDate() {
        return estimatedCompleteDate;
    }

    public void setEstimatedCompleteDate(String estimatedCompleteDate) {
        this.estimatedCompleteDate = estimatedCompleteDate;
    }

    public String getLastUpdatePostDate() {
        return lastUpdatePostDate;
    }

    public void setLastUpdatePostDate(String lastUpdatePostDate) {
        this.lastUpdatePostDate = lastUpdatePostDate;
    }

    public String getBrowseConditionTerms() {
        return browseConditionTerms;
    }

    public void setBrowseConditionTerms(String browseConditionTerms) {
        this.browseConditionTerms = browseConditionTerms;
    }

    public String getnCTNumber() {
        return nCTNumber;
    }

    public void setnCTNumber(String nCTNumber) {
        this.nCTNumber = nCTNumber;
    }

    public String getTargetGeneOrVariant() {
        return StringUtils.capitalize(targetGeneOrVariant);
    }

    public void setTargetGeneOrVariant(String targetGeneOrVariant) {
        this.targetGeneOrVariant = targetGeneOrVariant;
    }

    public String getTherapyType() {
        return StringUtils.capitalize(therapyType);
    }

    public void setTherapyType(String therapyType) {
        this.therapyType = therapyType;
    }

    public String getTherapyRoute() {
        return StringUtils.capitalize(therapyRoute);
    }

    public void setTherapyRoute(String therapyRoute) {
        this.therapyRoute = therapyRoute;
    }

    public String getMechanismOfAction() {

        return StringUtils.capitalize(mechanismOfAction);
    }

    public void setMechanismOfAction(String mechanismOfAction) {
        this.mechanismOfAction = mechanismOfAction;
    }

    public String getRouteOfAdministration() {

        return StringUtils.capitalize(routeOfAdministration);
    }

    public void setRouteOfAdministration(String routeOfAdministration) {
        this.routeOfAdministration = routeOfAdministration;
    }

    public String getDrugProductType() {

        return StringUtils.capitalize(drugProductType);
    }

    public void setDrugProductType(String drugProductType) {
        this.drugProductType = drugProductType;
    }

    public String getTargetTissueOrCell() {

        return StringUtils.capitalize(targetTissueOrCell);
    }

    public void setTargetTissueOrCell(String targetTissueOrCell) {
        this.targetTissueOrCell = targetTissueOrCell;
    }

    public String getDeliverySystem() {

        return StringUtils.capitalize(deliverySystem);
    }

    public void setDeliverySystem(String deliverySystem) {
        this.deliverySystem = deliverySystem;
    }

    public String getVectorType() {
        return vectorType;
    }

    public void setVectorType(String vectorType) {
        this.vectorType = vectorType;
    }

    public String getEditorType() {
        return editorType;
    }

    public void setEditorType(String editorType) {
        this.editorType = editorType;
    }

    public String getRecentUpdates() {
        return recentUpdates;
    }

    public void setRecentUpdates(String recentUpdates) {
        if(recentUpdates!=null)
        this.recentUpdates = StringUtils.capitalize(recentUpdates);
    }

    public String getCompoundName() {
        return StringUtils.capitalize(compoundName);
    }

    public void setCompoundName(String compoundName) {
        this.compoundName = compoundName;
    }

    public String getDose1() {
        return dose1;
    }

    public void setDose1(String dose1) {
        if(dose1!=null && !dose1.equalsIgnoreCase("none"))
            this.dose1 = StringUtils.capitalize(dose1);
    }

    public String getDose2() {
        return dose2;
    }

    public void setDose2(String dose2) {
        if(dose2!=null && !dose2.equalsIgnoreCase("none"))
            this.dose2 = StringUtils.capitalize(dose2);
    }

    public String getDose3() {
        return dose3;
    }

    public void setDose3(String dose3) {
        if(dose3!=null && !dose3.equalsIgnoreCase("none"))
        this.dose3 = StringUtils.capitalize(dose3);
    }

    public String getDose4() {
        return dose4;
    }

    public void setDose4(String dose4) {
        if(dose4!=null && !dose4.equalsIgnoreCase("none"))
            this.dose4 = StringUtils.capitalize(dose4);
    }

    public String getDose5() {
        return dose5;
    }

    public void setDose5(String dose5) {
        if(dose5!=null && !dose5.equalsIgnoreCase("none"))
            this.dose5 = StringUtils.capitalize(dose5);
    }

    public String getPatents() {
        return patents;
    }

    public void setPatents(String patents) {
        this.patents = patents;
    }

    public List<ClinicalTrialExternalLink> getExternalLinks() {
        return externalLinks;
    }

    public void setExternalLinks(List<ClinicalTrialExternalLink> externalLinks) {
        this.externalLinks = externalLinks;
    }

    public String formatFieldVal(String fieldVal){
        return  Arrays.stream(fieldVal.split(",")).map(str->StringUtils.capitalize(str.toLowerCase().trim().replaceAll("_", " "))).collect(Collectors.joining(", "));
    }
}
