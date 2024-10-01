package edu.mcw.scge.datamodel;

import java.util.List;

public class ClinicalTrialCuratedData extends ClinicalTrialRecord{
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

   private String dose1;
    private String dose2;
    private String dose3;
    private String dose4;
    private String dose5;

    private List<ClinicalTrialExternalLink> externalLinks;

    private String patents;

    public String getPatents() {
        return patents;
    }

    public void setPatents(String patents) {
        this.patents = patents;
    }

    public String getnCTNumber() {
        return nCTNumber;
    }

    public void setnCTNumber(String nCTNumber) {
        this.nCTNumber = nCTNumber;
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

    public String getTargetGeneOrVariant() {
        return targetGeneOrVariant;
    }

    public void setTargetGeneOrVariant(String targetGeneOrVariant) {
        this.targetGeneOrVariant = targetGeneOrVariant;
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

    public String getRecentUpdates() {
        return recentUpdates;
    }

    public void setRecentUpdates(String recentUpdates) {
        this.recentUpdates = recentUpdates;
    }
}
