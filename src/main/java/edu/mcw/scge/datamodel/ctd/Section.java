package edu.mcw.scge.datamodel.ctd;

import java.util.List;

public class Section extends Module {

    private int sectionId;
    private String sectionCode;
    private String sectionName;
    private String sectionDescription;
    private List<Section> subsections;
    private String parentId;
    private int level;
    private String requiredForInitialIND;
    private String requiredForMarketingApplicationOnly;
    private String submissionTiming;
    private String templateLinkText;
    private String exampleLinkText;
    private String submissionFormat;
    private String notes;
    private String resources;

    public String getSectionDescription() {
        return sectionDescription;
    }

    public void setSectionDescription(String sectionDescription) {
        this.sectionDescription = sectionDescription;
    }

    public String getRequiredForMarketingApplicationOnly() {
        return requiredForMarketingApplicationOnly;
    }

    public void setRequiredForMarketingApplicationOnly(String requiredForMarketingApplicationOnly) {
        this.requiredForMarketingApplicationOnly = requiredForMarketingApplicationOnly;
    }

    public String getSubmissionTiming() {
        return submissionTiming;
    }

    public void setSubmissionTiming(String submissionTiming) {
        this.submissionTiming = submissionTiming;
    }

    public String getTemplateLinkText() {
        return templateLinkText;
    }

    public void setTemplateLinkText(String templateLinkText) {
        this.templateLinkText = templateLinkText;
    }

    public String getExampleLinkText() {
        return exampleLinkText;
    }

    public void setExampleLinkText(String exampleLinkText) {
        this.exampleLinkText = exampleLinkText;
    }

    public String getSubmissionFormat() {
        return submissionFormat;
    }

    public void setSubmissionFormat(String submissionFormat) {
        this.submissionFormat = submissionFormat;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public String getRequiredForInitialIND() {
        return requiredForInitialIND;
    }

    public void setRequiredForInitialIND(String requiredForInitialIND) {
        this.requiredForInitialIND = requiredForInitialIND;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public List<Section> getSubsections() {
        return subsections;
    }

    public void setSubsections(List<Section> subsections) {
        this.subsections = subsections;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
