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
    private String developmentStatus;
    private String indicationDOID;
    private String compoundDescription;

    private String withHasResults;
    private String recordStatus;
    public String getWithHasResults() {
        return withHasResults;
    }

    public void setWithHasResults(String withHasResults) {
        this.withHasResults = withHasResults;
    }

    public String getCompoundDescription() {
        return compoundDescription;
    }

    public void setCompoundDescription(String compoundDescription) {
        this.compoundDescription = compoundDescription;
    }

    public String getDevelopmentStatus() {
        return developmentStatus;
    }

    public void setDevelopmentStatus(String developmentStatus) {
        this.developmentStatus = developmentStatus;
    }


    public String getIndicationDOID() {
        return indicationDOID;
    }

    public void setIndicationDOID(String indicationDOID) {
        this.indicationDOID = indicationDOID;
    }

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
        this.sponsorClass = sponsorClass;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
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
        this.eligibilitySex = eligibilitySex;
    }

    public String getElibilityMinAge() {
        return elibilityMinAge;
    }

    public void setElibilityMinAge(String elibilityMinAge) {
        this.elibilityMinAge = elibilityMinAge;
    }

    public String getElibilityMaxAge() {
        return elibilityMaxAge;
    }

    public void setElibilityMaxAge(String elibilityMaxAge) {
        this.elibilityMaxAge = elibilityMaxAge;
    }

    public String getHealthyVolunteers() {
        return healthyVolunteers;
    }

    public void setHealthyVolunteers(String healthyVolunteers) {
        this.healthyVolunteers = healthyVolunteers;
    }

    public String getStandardAge() {
        return standardAge;
    }

    public void setStandardAge(String standardAge) {
        this.standardAge = standardAge;
    }

    public String getIsFDARegulated() {
        return isFDARegulated;
    }

    public void setIsFDARegulated(String isFDARegulated) {
        this.isFDARegulated = isFDARegulated;
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

    public String getStudyStatus() {
        return studyStatus;
    }

    public void setStudyStatus(String studyStatus) {
        this.studyStatus = studyStatus;
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
        return targetGeneOrVariant;
    }

    public void setTargetGeneOrVariant(String targetGeneOrVariant) {
        this.targetGeneOrVariant = targetGeneOrVariant;
    }

    public String getTherapyType() {
        return therapyType;
    }

    public void setTherapyType(String therapyType) {
        this.therapyType = therapyType;
    }

    public String getTherapyRoute() {
        return therapyRoute;
    }

    public void setTherapyRoute(String therapyRoute) {
        this.therapyRoute = therapyRoute;
    }

    public String getMechanismOfAction() {
        return mechanismOfAction;
    }

    public void setMechanismOfAction(String mechanismOfAction) {
        this.mechanismOfAction = mechanismOfAction;
    }

    public String getRouteOfAdministration() {
        return routeOfAdministration;
    }

    public void setRouteOfAdministration(String routeOfAdministration) {
        this.routeOfAdministration = routeOfAdministration;
    }

    public String getDrugProductType() {
        return drugProductType;
    }

    public void setDrugProductType(String drugProductType) {
        this.drugProductType = drugProductType;
    }

    public String getTargetTissueOrCell() {
        return targetTissueOrCell;
    }

    public void setTargetTissueOrCell(String targetTissueOrCell) {
        this.targetTissueOrCell = targetTissueOrCell;
    }

    public String getDeliverySystem() {
        return deliverySystem;
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
        this.recentUpdates = recentUpdates;
    }

    public String getCompoundName() {
        return compoundName;
    }

    public void setCompoundName(String compoundName) {
        this.compoundName = compoundName;
    }

    public String getDose1() {
        return dose1;
    }

    public void setDose1(String dose1) {
        this.dose1 = dose1;
    }

    public String getDose2() {
        return dose2;
    }

    public void setDose2(String dose2) {
        this.dose2 = dose2;
    }

    public String getDose3() {
        return dose3;
    }

    public void setDose3(String dose3) {
        this.dose3 = dose3;
    }

    public String getDose4() {
        return dose4;
    }

    public void setDose4(String dose4) {
        this.dose4 = dose4;
    }

    public String getDose5() {
        return dose5;
    }

    public void setDose5(String dose5) {
        this.dose5 = dose5;
    }

    public List<ClinicalTrialExternalLink> getExternalLinks() {
        return externalLinks;
    }

    public void setExternalLinks(List<ClinicalTrialExternalLink> externalLinks) {
        this.externalLinks = externalLinks;
    }

    public String getPatents() {
        return patents;
    }

    public void setPatents(String patents) {
        this.patents = patents;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String compareAPIFields(ClinicalTrialRecord otherRecord) {
        StringBuilder differences = new StringBuilder();
        ClinicalTrialRecord other=formatRecordValue(otherRecord);
        try {
            if (!this.nctId.equals(other.nctId)) {
                differences.append("NCTID differs: ").append(this.nctId).append(" vs ").append(other.nctId).append("\n");
            }
        }catch (Exception ignored){}try{
        if (!this.description.equals(other.description)) {
            differences.append("Description differs: ").append(this.description).append(" vs ").append(other.description).append("\n");
        }
        }catch (Exception ignored){}try{
        if (!this.interventionName.equals(other.interventionName)) {
            differences.append("interventionName differs: ").append(this.interventionName).append(" vs ").append(other.interventionName).append("\n");
        }
        }catch (Exception ignored){}try{
        if (!this.interventionDescription.equals(other.interventionDescription)) {
            differences.append("interventionDescription differs: ").append(this.interventionDescription).append(" vs ").append(other.interventionDescription).append("\n");
        }
        }catch (Exception ignored){}try{
        if (!this.sponsor.equals(other.sponsor)) {
            differences.append("sponsor differs: ").append(this.sponsor).append(" vs ").append(other.sponsor).append("\n");
        }
        }catch (Exception ignored){}try{
        if (!this.sponsorClass.equals(other.sponsorClass)) {
            differences.append("sponsorClass differs: ").append(this.sponsorClass).append(" vs ").append(other.sponsorClass).append("\n");
        }
        }catch (Exception ignored){}
//        try{
//        if (!this. indication.equals(other. indication)) {
//            differences.append(" indication differs: ").append(this.indication).append(" vs ").append(other.indication).append("\n");
//        }
//        }catch (Exception ignored){}
        try{
        if (!this.   phase.equals(other.   phase)) {
            differences.append("   phase differs: ").append(this.phase).append(" vs ").append(other.phase).append("\n");
        }
        }catch (Exception ignored){}try{
        if (this.enrorllmentCount!=(other.enrorllmentCount)) {
            differences.append("   enrorllmentCount differs: ").append(this.enrorllmentCount).append(" vs ").append(other.enrorllmentCount).append("\n");
        }
        }catch (Exception ignored){}try{
        if (!this.   location.equals(other.   location)) {
            differences.append("   location differs: ").append(this.location).append(" vs ").append(other.location).append("\n");
        }
        }catch (Exception ignored){}try{
        if (this.     numberOfLocations!=(other.     numberOfLocations)) {
            differences.append("     numberOfLocations differs: ").append(this.numberOfLocations).append(" vs ").append(other.numberOfLocations).append("\n");
        }
        }catch (Exception ignored){}try{
        if (!this.  eligibilitySex.equals(other.  eligibilitySex)) {
            differences.append("  eligibilitySex differs: ").append(this.eligibilitySex).append(" vs ").append(other.eligibilitySex).append("\n");
        }
        }catch (Exception ignored){}try{
        if (!this.  elibilityMinAge.equals(other.  elibilityMinAge)) {
            differences.append("  elibilityMinAge differs: ").append(this.elibilityMinAge).append(" vs ").append(other.elibilityMinAge).append("\n");
        }
        }catch (Exception ignored){}try{
        if (!this.  elibilityMaxAge.equals(other.  elibilityMaxAge)) {
            differences.append("  elibilityMaxAge differs: ").append(this.elibilityMaxAge).append(" vs ").append(other.elibilityMaxAge).append("\n");
        }
        }catch (Exception ignored){}try{
        if (!this.  standardAge.equals(other.  standardAge)) {
            differences.append("  standardAge differs: ").append(this.standardAge).append(" vs ").append(other.standardAge).append("\n");
        }
        }catch (Exception ignored){}try{
        if (!this.  isFDARegulated.equals(other.  isFDARegulated)) {
            differences.append("  isFDARegulated differs: ").append(this.isFDARegulated).append(" vs ").append(other.isFDARegulated).append("\n");
        }
        }catch (Exception ignored){}try{
        if (!this.  briefTitle.equals(other.  briefTitle)) {
            differences.append("  briefTitle differs: ").append(this.briefTitle).append(" vs ").append(other.briefTitle).append("\n");
        }
        }catch (Exception ignored){}try{
        if (!this.  officialTitle.equals(other.  officialTitle)) {
            differences.append("  officialTitle differs: ").append(this.officialTitle).append(" vs ").append(other.officialTitle).append("\n");
        }
        }catch (Exception ignored){}try{
        if (!this.  studyStatus.equals(other.  studyStatus)) {
            differences.append("  studyStatus differs: ").append(this.studyStatus).append(" vs ").append(other.studyStatus).append("\n");
        }
        }catch (Exception ignored){}try{
        if (!this.  firstSubmitDate.equals(other.  firstSubmitDate)) {
            differences.append("  firstSubmitDate differs: ").append(this.firstSubmitDate).append(" vs ").append(other.firstSubmitDate).append("\n");
        }
        }catch (Exception ignored){}try{
        if (!this.  estimatedCompleteDate.equals(other.  estimatedCompleteDate)) {
            differences.append("  estimatedCompleteDate differs: ").append(this.estimatedCompleteDate).append(" vs ").append(other.estimatedCompleteDate).append("\n");
        }
        }catch (Exception ignored){}try{
        if (!this.  lastUpdatePostDate.equals(other.  lastUpdatePostDate)) {
            differences.append("  lastUpdatePostDate differs: ").append(this.lastUpdatePostDate).append(" vs ").append(other.lastUpdatePostDate).append("\n");
        }
        }catch (Exception ignored){}try{
        if (!this.  browseConditionTerms.equals(other.  browseConditionTerms)) {
            differences.append("  browseConditionTerms differs: ").append(this.browseConditionTerms).append(" vs ").append(other.browseConditionTerms).append("\n");
        }
        }catch (Exception ignored){}try{
        if (!this.  nCTNumber.equals(other.  nCTNumber)) {
            differences.append("  nCTNumber differs: ").append(this.nCTNumber).append(" vs ").append(other.nCTNumber).append("\n");
        }
        }catch (Exception ignored){}
        try{
            if (!(String.valueOf(this.withHasResults)).equals(String.valueOf(other. withHasResults))) {
                differences.append("  isWithHasResults differs: ").append(this.withHasResults).append(" vs ").append(other.withHasResults).append("\n");
            }
        }catch (Exception ignored){}
        return differences.toString();
    }
    public ClinicalTrialRecord formatRecordValue(ClinicalTrialRecord record){
        try {
            record.setTargetGeneOrVariant(StringUtils.capitalize(record.getTargetGeneOrVariant()));
        }catch (Exception e){}
        try {
            record.setCompoundName(StringUtils.capitalize(record.getCompoundName()));
        }catch (Exception e){}
        try {
            record.setTherapyType(StringUtils.capitalize(record.getTherapyType()));
        }catch (Exception e){}
        try {
            record.setTherapyRoute(StringUtils.capitalize(record.getTherapyRoute()));
        }catch(Exception e){}
        try {
            record.setMechanismOfAction(StringUtils.capitalize(record.getMechanismOfAction()));
        }catch (Exception e){}
        try {
            record.setRouteOfAdministration(StringUtils.capitalize(record.getRouteOfAdministration()));
        }catch (Exception e){}
        try {
            record.setDrugProductType(StringUtils.capitalize(record.getDrugProductType()));
        }catch (Exception e){}
        try {
            record.setTargetTissueOrCell(StringUtils.capitalize(record.getTargetTissueOrCell()));
        }catch (Exception e){}
        try {
            record.setDeliverySystem(StringUtils.capitalize(record.getDeliverySystem()));
        }catch (Exception e){}
        try {
            if(!record.getDose1().equalsIgnoreCase("none"))
                record.setDose1(StringUtils.capitalize(record.getDose1()));
            else record.setDose1("");
        }catch (Exception e){}
        try {
            if(!record.getDose2().equalsIgnoreCase("none"))
                record.setDose2(StringUtils.capitalize(record.getDose2()));
            else record.setDose2("");
        }catch (Exception e){}
        try {
            if(!record.getDose3().equalsIgnoreCase("none"))
                record.setDose3(StringUtils.capitalize(record.getDose3()));
            else record.setDose3("");
        }catch (Exception e){}
        try {
            if(!record.getDose4().equalsIgnoreCase("none"))
                record.setDose4(StringUtils.capitalize(record.getDose4()));
            else record.setDose4("");
        }catch (Exception e){}
        try {
            if(!record.getDose5().equalsIgnoreCase("none"))
                record.setDose5(StringUtils.capitalize(record.getDose5()));
            else record.setDose5("");
        }catch (Exception e){}

        try {
            if(record.getIsFDARegulated()!=null && !record.getIsFDARegulated().equalsIgnoreCase("null"))
                record.setIsFDARegulated(StringUtils.capitalize(record.getIsFDARegulated()));
            else record.setIsFDARegulated("");
        }catch (Exception e){}
        try {
            if(record.getRecentUpdates()!=null && !record.getRecentUpdates().equalsIgnoreCase("null"))
                record.setRecentUpdates(StringUtils.capitalize(record.getRecentUpdates()));

        }catch (Exception e){}

        if(!record.getStudyStatus().equals("")) record.setStudyStatus(formatFieldVal(record.getStudyStatus()));
        if(!record.getSponsorClass().equals("") && !record.getSponsorClass().equalsIgnoreCase("NIH")) record.setSponsorClass(formatFieldVal(record.getSponsorClass()));
        if(!record.getPhase().equals("")) record.setPhase(formatFieldVal(record.getPhase()));
        if(!record.getStandardAge().equals("")) record.setStandardAge(formatFieldVal(record.getStandardAge()));
        if(!record.getWithHasResults().equals("")) record.setWithHasResults(formatFieldVal(record.getWithHasResults()));
        return record;
    }

    public String formatFieldVal(String fieldVal){
        return  Arrays.stream(fieldVal.split(",")).map(str->StringUtils.capitalize(str.toLowerCase().trim().replaceAll("_", " "))).collect(Collectors.joining(", "));
    }
}
