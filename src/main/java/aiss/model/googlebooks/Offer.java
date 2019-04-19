
package aiss.model.googlebooks;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "finskyOfferType",
    "listPrice",
    "retailPrice",
    "giftable"
})
public class Offer {

    @JsonProperty("finskyOfferType")
    private Integer finskyOfferType;
    @JsonProperty("listPrice")
    private ListPrice_ listPrice;
    @JsonProperty("retailPrice")
    private RetailPrice_ retailPrice;
    @JsonProperty("giftable")
    private Boolean giftable;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("finskyOfferType")
    public Integer getFinskyOfferType() {
        return finskyOfferType;
    }

    @JsonProperty("finskyOfferType")
    public void setFinskyOfferType(Integer finskyOfferType) {
        this.finskyOfferType = finskyOfferType;
    }

    @JsonProperty("listPrice")
    public ListPrice_ getListPrice() {
        return listPrice;
    }

    @JsonProperty("listPrice")
    public void setListPrice(ListPrice_ listPrice) {
        this.listPrice = listPrice;
    }

    @JsonProperty("retailPrice")
    public RetailPrice_ getRetailPrice() {
        return retailPrice;
    }

    @JsonProperty("retailPrice")
    public void setRetailPrice(RetailPrice_ retailPrice) {
        this.retailPrice = retailPrice;
    }

    @JsonProperty("giftable")
    public Boolean getGiftable() {
        return giftable;
    }

    @JsonProperty("giftable")
    public void setGiftable(Boolean giftable) {
        this.giftable = giftable;
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
