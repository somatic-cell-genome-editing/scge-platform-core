package edu.mcw.scge.datamodel.ctd;

public class CTDResource {
    private int resourceId;
    private String resourceName;
    private String resourceDescription;
    private String resourceUrl;
    private String ctdSection;
    private String dateIssued;

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceDescription() {
        return resourceDescription;
    }

    public void setResourceDescription(String resourceDescription) {
        this.resourceDescription = resourceDescription;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getCtdSection() {
        return ctdSection;
    }

    public void setCtdSection(String ctdSection) {
        this.ctdSection = ctdSection;
    }

    public String getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(String dateIssued) {
        this.dateIssued = dateIssued;
    }
}
