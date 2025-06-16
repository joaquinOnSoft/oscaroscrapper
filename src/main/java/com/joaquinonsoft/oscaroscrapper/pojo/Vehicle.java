
package com.joaquinonsoft.oscaroscrapper.pojo;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "children",
    "labels",
    "level",
    "leaf",
    "ancestors"
})
public class Vehicle {

    @JsonProperty("id")
    private String id;
    @JsonProperty("children")
    private List<Child> children;
    @JsonProperty("labels")
    private Object labels;
    @JsonProperty("level")
    private Integer level;
    @JsonProperty("leaf")
    private Boolean leaf;
    @JsonProperty("ancestors")
    private List<Object> ancestors;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("children")
    public List<Child> getChildren() {
        return children;
    }

    @JsonProperty("children")
    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @JsonProperty("labels")
    public Object getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(Object labels) {
        this.labels = labels;
    }

    @JsonProperty("level")
    public Integer getLevel() {
        return level;
    }

    @JsonProperty("level")
    public void setLevel(Integer level) {
        this.level = level;
    }

    @JsonProperty("leaf")
    public Boolean getLeaf() {
        return leaf;
    }

    @JsonProperty("leaf")
    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    @JsonProperty("ancestors")
    public List<Object> getAncestors() {
        return ancestors;
    }

    @JsonProperty("ancestors")
    public void setAncestors(List<Object> ancestors) {
        this.ancestors = ancestors;
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
