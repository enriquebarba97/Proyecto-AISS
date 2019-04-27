
package aiss.model.aliexpress;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "text",
    "category",
    "priceRange",
    "attributes",
    "shipToCountry",
    "shipFromCountry",
    "sort",
    "skip"
})
public class Search {

    @JsonProperty("text")
    private String text;
    @JsonProperty("category")
    private String category;
    @JsonProperty("priceRange")
    private PriceRange priceRange;
    @JsonProperty("attributes")
    private List<Attribute> attributes = null;
    @JsonProperty("shipToCountry")
    private String shipToCountry;
    @JsonProperty("shipFromCountry")
    private String shipFromCountry;
    @JsonProperty("sort")
    private String sort;
    @JsonProperty("skip")
    private Integer skip;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    public Search(String query) {
    	this.text = query;
    	this.sort = "BEST_MATCH";
    	this.category = "";
    	this.priceRange = null;
    	this.attributes = null;
    	this.shipToCountry = "";
    	this.shipFromCountry = "";
    	this.skip = 0;
	}
    
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("priceRange")
    public PriceRange getPriceRange() {
        return priceRange;
    }

    @JsonProperty("priceRange")
    public void setPriceRange(PriceRange priceRange) {
        this.priceRange = priceRange;
    }

    @JsonProperty("attributes")
    public List<Attribute> getAttributes() {
        return attributes;
    }

    @JsonProperty("attributes")
    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    @JsonProperty("shipToCountry")
    public String getShipToCountry() {
        return shipToCountry;
    }

    @JsonProperty("shipToCountry")
    public void setShipToCountry(String shipToCountry) {
        this.shipToCountry = shipToCountry;
    }

    @JsonProperty("shipFromCountry")
    public String getShipFromCountry() {
        return shipFromCountry;
    }

    @JsonProperty("shipFromCountry")
    public void setShipFromCountry(String shipFromCountry) {
        this.shipFromCountry = shipFromCountry;
    }

    @JsonProperty("sort")
    public String getSort() {
        return sort;
    }

    @JsonProperty("sort")
    public void setSort(String sort) {
        this.sort = sort;
    }

    @JsonProperty("skip")
    public Integer getSkip() {
        return skip;
    }

    @JsonProperty("skip")
    public void setSkip(Integer skip) {
        this.skip = skip;
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
