package edu.mcw.scge.datamodel.ctd;

import java.util.List;

public class Section extends Module {

    private int sectionId;
    private String sectionCode;
    private String sectionName;
    private List<Section> subsections;
    private String parentId;
    private int level;
    private String requiredForInitialIND;

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
