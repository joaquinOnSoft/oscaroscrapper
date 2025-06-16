
package com.joaquinonsoft.oscaroscrapper.pojo;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "full-label-fragment",
    "label"
})
public class Labels {

    @JsonProperty("full-label-fragment")
    private FullLabelFragment fullLabelFragment;
    @JsonProperty("label")
    private Label label;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("full-label-fragment")
    public FullLabelFragment getFullLabelFragment() {
        return fullLabelFragment;
    }

    @JsonProperty("full-label-fragment")
    public void setFullLabelFragment(FullLabelFragment fullLabelFragment) {
        this.fullLabelFragment = fullLabelFragment;
    }

    @JsonProperty("label")
    public Label getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(Label label) {
        this.label = label;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
