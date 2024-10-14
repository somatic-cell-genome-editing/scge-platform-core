
package edu.mcw.scge.datamodel.clinicalTrialAPIModel;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "measure",
    "description",
    "timeFrame"
})
@Generated("jsonschema2pojo")
public class SecondaryOutcome {

    @JsonProperty("measure")
    private String measure;
    @JsonProperty("description")
    private String description;
    @JsonProperty("timeFrame")
    private String timeFrame;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("measure")
    public String getMeasure() {
        return measure;
    }

    @JsonProperty("measure")
    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public SecondaryOutcome withMeasure(String measure) {
        this.measure = measure;
        return this;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public SecondaryOutcome withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("timeFrame")
    public String getTimeFrame() {
        return timeFrame;
    }

    @JsonProperty("timeFrame")
    public void setTimeFrame(String timeFrame) {
        this.timeFrame = timeFrame;
    }

    public SecondaryOutcome withTimeFrame(String timeFrame) {
        this.timeFrame = timeFrame;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public SecondaryOutcome withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SecondaryOutcome.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("measure");
        sb.append('=');
        sb.append(((this.measure == null)?"<null>":this.measure));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("timeFrame");
        sb.append('=');
        sb.append(((this.timeFrame == null)?"<null>":this.timeFrame));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.measure == null)? 0 :this.measure.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.timeFrame == null)? 0 :this.timeFrame.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SecondaryOutcome) == false) {
            return false;
        }
        SecondaryOutcome rhs = ((SecondaryOutcome) other);
        return (((((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description)))&&((this.measure == rhs.measure)||((this.measure!= null)&&this.measure.equals(rhs.measure))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.timeFrame == rhs.timeFrame)||((this.timeFrame!= null)&&this.timeFrame.equals(rhs.timeFrame))));
    }

}
