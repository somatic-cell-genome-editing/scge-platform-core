package edu.mcw.scge.datamodel.clinicalTrialModel;

import edu.mcw.scge.datamodel.ClinicalTrialRecord;

import java.util.Set;

public class ClinicalTrialIndexObject extends ClinicalTrialRecord {
    private Set<String> phases;
    private Set<String> status;
    private Set<String> standardAges;
    private Set<String> locations;

    public Set<String> getPhases() {
        return phases;
    }

    public void setPhases(Set<String> phases) {
        this.phases = phases;
    }

    public Set<String> getStatus() {
        return status;
    }

    public void setStatus(Set<String> status) {
        this.status = status;
    }

    public Set<String> getStandardAges() {
        return standardAges;
    }

    public void setStandardAges(Set<String> standardAges) {
        this.standardAges = standardAges;
    }

    public Set<String> getLocations() {
        return locations;
    }

    public void setLocations(Set<String> locations) {
        this.locations = locations;
    }
}
