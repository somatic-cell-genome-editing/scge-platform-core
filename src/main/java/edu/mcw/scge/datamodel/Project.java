package edu.mcw.scge.datamodel;

import java.util.List;

public class Project {
   private int projectId;
   private String projectTitle;
   private String  projectTitleLc;
   private String projectNumber;
   private String projectShortName;
   private String description;
   private String nihReporterLink;

    public String getNihReporterLink() {
        return nihReporterLink;
    }

    public void setNihReporterLink(String nihReporterLink) {
        this.nihReporterLink = nihReporterLink;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProjectTitleLc() {
        return projectTitleLc;
    }

    public void setProjectTitleLc(String projectTitleLc) {
        this.projectTitleLc = projectTitleLc;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getProjectShortName() {
        return projectShortName;
    }

    public void setProjectShortName(String projectShortName) {
        this.projectShortName = projectShortName;
    }
}
