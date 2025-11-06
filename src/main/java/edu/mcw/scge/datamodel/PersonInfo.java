package edu.mcw.scge.datamodel;

import java.io.Serializable;

/**
 * Created by jthota on 10/9/2019.
 */
public class PersonInfo implements Serializable {
    private int personId;
    private int projectId;
    private int roleKey;
    private String projectTitle;
    private String role;



    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }




    public int getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(int roleKey) {
        this.roleKey = roleKey;
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
}
