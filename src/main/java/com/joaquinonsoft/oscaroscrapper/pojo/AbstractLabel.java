package com.joaquinonsoft.oscaroscrapper.pojo;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "es",
        "fr"
})
public abstract class AbstractLabel {

    @JsonProperty("de")
    protected String de;

    @JsonProperty("es")
    protected String es;

    @JsonProperty("fr")
    protected String fr;

    @JsonProperty("it")
    protected String it;

    @JsonProperty("pt")
    protected String pt;

    @JsonIgnore
    protected Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();


    @JsonProperty("de")
    public String getDe() {
        return de;
    }

    @JsonProperty("de")
    public void setDe(String de) {
        this.de = de;
    }

    @JsonProperty("es")
    public String getEs() {
        return es;
    }

    @JsonProperty("es")
    public void setEs(String es) {
        this.es = es;
    }

    @JsonProperty("fr")
    public String getFr() {
        return fr;
    }

    @JsonProperty("fr")
    public void setFr(String fr) {
        this.fr = fr;
    }

    @JsonProperty("it")
    public String getIt() {
        return it;
    }

    @JsonProperty("it")
    public void setIt(String it) {
        this.it = it;
    }

    @JsonProperty("pt")
    public String getPt() {
        return pt;
    }

    @JsonProperty("pt")
    public void setPt(String pt) {
        this.pt = pt;
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
