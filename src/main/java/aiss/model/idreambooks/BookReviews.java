
package aiss.model.idreambooks;

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
    "total_results",
    "book"
})
public class BookReviews {

    @JsonProperty("total_results")
    private Integer totalResults;
    @JsonProperty("book")
    private Book book;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("total_results")
    public Integer getTotalResults() {
        return totalResults;
    }

    @JsonProperty("total_results")
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    @JsonProperty("book")
    public Book getBook() {
        return book;
    }

    @JsonProperty("book")
    public void setBook(Book book) {
        this.book = book;
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
