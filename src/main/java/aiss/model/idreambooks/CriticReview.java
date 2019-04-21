
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
    "snippet",
    "source",
    "review_link",
    "pos_or_neg",
    "star_rating",
    "review_date",
    "smiley_or_sad",
    "source_logo"
})
public class CriticReview {

    @JsonProperty("snippet")
    private String snippet;
    @JsonProperty("source")
    private String source;
    @JsonProperty("review_link")
    private String reviewLink;
    @JsonProperty("pos_or_neg")
    private String posOrNeg;
    @JsonProperty("star_rating")
    private Double starRating;
    @JsonProperty("review_date")
    private String reviewDate;
    @JsonProperty("smiley_or_sad")
    private String smileyOrSad;
    @JsonProperty("source_logo")
    private String sourceLogo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("snippet")
    public String getSnippet() {
        return snippet;
    }

    @JsonProperty("snippet")
    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("review_link")
    public String getReviewLink() {
        return reviewLink;
    }

    @JsonProperty("review_link")
    public void setReviewLink(String reviewLink) {
        this.reviewLink = reviewLink;
    }

    @JsonProperty("pos_or_neg")
    public String getPosOrNeg() {
        return posOrNeg;
    }

    @JsonProperty("pos_or_neg")
    public void setPosOrNeg(String posOrNeg) {
        this.posOrNeg = posOrNeg;
    }

    @JsonProperty("star_rating")
    public Double getStarRating() {
        return starRating;
    }

    @JsonProperty("star_rating")
    public void setStarRating(Double starRating) {
        this.starRating = starRating;
    }

    @JsonProperty("review_date")
    public String getReviewDate() {
        return reviewDate;
    }

    @JsonProperty("review_date")
    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    @JsonProperty("smiley_or_sad")
    public String getSmileyOrSad() {
        return smileyOrSad;
    }

    @JsonProperty("smiley_or_sad")
    public void setSmileyOrSad(String smileyOrSad) {
        this.smileyOrSad = smileyOrSad;
    }

    @JsonProperty("source_logo")
    public String getSourceLogo() {
        return sourceLogo;
    }

    @JsonProperty("source_logo")
    public void setSourceLogo(String sourceLogo) {
        this.sourceLogo = sourceLogo;
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
