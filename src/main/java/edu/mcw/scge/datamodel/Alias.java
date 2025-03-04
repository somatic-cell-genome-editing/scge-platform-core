package edu.mcw.scge.datamodel;

import java.sql.Date;

public class Alias {
    private int key;
    private String identifier;
    private Date createdDate;
    private String notes;
    private String aliasTypeLC;
    private String alias;
    private String fieldName;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAliasTypeLC() {
        return aliasTypeLC;
    }

    public void setAliasTypeLC(String aliasTypeLC) {
        this.aliasTypeLC = aliasTypeLC;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
