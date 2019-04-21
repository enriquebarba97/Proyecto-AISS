
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
    "id",
    "imageUrl",
    "title",
    "ratings",
    "orders",
    "freight",
    "priceOptions"
})
public class Item {

    @JsonProperty("id")
    private String id;
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("title")
    private String title;
    @JsonProperty("ratings")
    private Double ratings;
    @JsonProperty("orders")
    private Integer orders;
    @JsonProperty("freight")
    private Freight freight;
    @JsonProperty("priceOptions")
    private List<PriceOption> priceOptions = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("imageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("ratings")
    public Double getRatings() {
        return ratings;
    }

    @JsonProperty("ratings")
    public void setRatings(Double ratings) {
        this.ratings = ratings;
    }

    @JsonProperty("orders")
    public Integer getOrders() {
        return orders;
    }

    @JsonProperty("orders")
    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    @JsonProperty("freight")
    public Freight getFreight() {
        return freight;
    }

    @JsonProperty("freight")
    public void setFreight(Freight freight) {
        this.freight = freight;
    }

    @JsonProperty("priceOptions")
    public List<PriceOption> getPriceOptions() {
        return priceOptions;
    }

    @JsonProperty("priceOptions")
    public void setPriceOptions(List<PriceOption> priceOptions) {
        this.priceOptions = priceOptions;
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
