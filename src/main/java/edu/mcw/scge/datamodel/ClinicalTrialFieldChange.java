package edu.mcw.scge.datamodel;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * Represents a change to a field in a clinical trial record.
 * Used for tracking updates/audit trail.
 */
public class ClinicalTrialFieldChange {
    private int id;
    private String nctId;
    private String fieldName;
    private String oldValue;
    private String newValue;
    private Date changedAt;
    private String updateDate;
    private String updateBy;

    public ClinicalTrialFieldChange() {}

    public ClinicalTrialFieldChange(String nctId, String fieldName, String oldValue, String newValue, String updateBy) {
        this.nctId = nctId;
        this.fieldName = fieldName;
        if(oldValue!=null)
        this.oldValue = formatFieldVal(oldValue);
        if(newValue!=null)
        this.newValue = formatFieldVal(newValue);
        this.updateBy=updateBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNctId() {
        return nctId;
    }

    public void setNctId(String nctId) {
        this.nctId = nctId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public Date getChangedAt() {
        return changedAt;
    }

    public void setChangedAt(Date changedAt) {
        this.changedAt = changedAt;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public String toString() {
        return "ClinicalTrialFieldChange{" +
                "nctId='" + nctId + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", oldValue='" + truncate(oldValue, 50) + '\'' +
                ", newValue='" + truncate(newValue, 50) + '\'' +
                ", changedAt=" + changedAt +
                ", updateBy=" + updateBy +
                '}';
    }

    private String truncate(String value, int maxLen) {
        if (value == null) return null;
        return value.length() > maxLen ? value.substring(0, maxLen) + "..." : value;
    }

    public String formatFieldVal(String fieldVal){
        return  Arrays.stream(fieldVal.split(",")).map(str-> StringUtils.capitalize(str.toLowerCase().trim().replaceAll("_", " "))).collect(Collectors.joining(", "));
    }
}
