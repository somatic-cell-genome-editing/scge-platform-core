package edu.mcw.scge.datamodel;

import java.util.List;

/**
 * Created by jthota on 9/10/2019.
 */
public class SCGEGroup {
    private int groupId;
    private String groupName;
    private String groupShortName;
    private String groupNameLC;
    private String groupType;
    private List<Person> members;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupShortName() {
        return groupShortName;
    }

    public void setGroupShortName(String groupShortName) {
        this.groupShortName = groupShortName;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public List<Person> getMembers() {
        return members;
    }

    public void setMembers(List<Person> members) {
        this.members = members;
    }

    public String getGroupNameLC() {
        return groupNameLC;
    }

    public void setGroupNameLC(String groupNameLC) {
        this.groupNameLC = groupNameLC;
    }
}
