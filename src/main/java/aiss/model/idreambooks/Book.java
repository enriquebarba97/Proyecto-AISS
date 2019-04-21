
package aiss.model.idreambooks;

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
    "title",
    "sub_title",
    "author",
    "review_count",
    "detail_link",
    "genre",
    "pages",
    "release_date",
    "critic_reviews"
})
public class Book {

    @JsonProperty("title")
    private String title;
    @JsonProperty("sub_title")
    private String subTitle;
    @JsonProperty("author")
    private String author;
    @JsonProperty("review_count")
    private Integer reviewCount;
    @JsonProperty("detail_link")
    private String detailLink;
    @JsonProperty("genre")
    private String genre;
    @JsonProperty("pages")
    private Integer pages;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("critic_reviews")
    private List<CriticReview> criticReviews = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("sub_title")
    public String getSubTitle() {
        return subTitle;
    }

    @JsonProperty("sub_title")
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonProperty("review_count")
    public Integer getReviewCount() {
        return reviewCount;
    }

    @JsonProperty("review_count")
    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    @JsonProperty("detail_link")
    public String getDetailLink() {
        return detailLink;
    }

    @JsonProperty("detail_link")
    public void setDetailLink(String detailLink) {
        this.detailLink = detailLink;
    }

    @JsonProperty("genre")
    public String getGenre() {
        return genre;
    }

    @JsonProperty("genre")
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @JsonProperty("pages")
    public Integer getPages() {
        return pages;
    }

    @JsonProperty("pages")
    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @JsonProperty("release_date")
    public String getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("release_date")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @JsonProperty("critic_reviews")
    public List<CriticReview> getCriticReviews() {
        return criticReviews;
    }

    @JsonProperty("critic_reviews")
    public void setCriticReviews(List<CriticReview> criticReviews) {
        this.criticReviews = criticReviews;
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
