
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
    "title",
    "author",
    "isbns",
    "book_link",
    "review_snippet",
    "review_date",
    "review_publication_name",
    "review_link",
    "review_rating_image",
    "review_publication_logo"
})
public class AcclaimedBook {

    @JsonProperty("title")
    private String title;
    @JsonProperty("author")
    private String author;
    @JsonProperty("isbns")
    private String isbns;
    @JsonProperty("book_link")
    private String bookLink;
    @JsonProperty("review_snippet")
    private String reviewSnippet;
    @JsonProperty("review_date")
    private String reviewDate;
    @JsonProperty("review_publication_name")
    private String reviewPublicationName;
    @JsonProperty("review_link")
    private String reviewLink;
    @JsonProperty("review_rating_image")
    private String reviewRatingImage;
    @JsonProperty("review_publication_logo")
    private String reviewPublicationLogo;
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

    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonProperty("isbns")
    public String getIsbns() {
        return isbns;
    }

    @JsonProperty("isbns")
    public void setIsbns(String isbns) {
        this.isbns = isbns;
    }

    @JsonProperty("book_link")
    public String getBookLink() {
        return bookLink;
    }

    @JsonProperty("book_link")
    public void setBookLink(String bookLink) {
        this.bookLink = bookLink;
    }

    @JsonProperty("review_snippet")
    public String getReviewSnippet() {
        return reviewSnippet;
    }

    @JsonProperty("review_snippet")
    public void setReviewSnippet(String reviewSnippet) {
        this.reviewSnippet = reviewSnippet;
    }

    @JsonProperty("review_date")
    public String getReviewDate() {
        return reviewDate;
    }

    @JsonProperty("review_date")
    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    @JsonProperty("review_publication_name")
    public String getReviewPublicationName() {
        return reviewPublicationName;
    }

    @JsonProperty("review_publication_name")
    public void setReviewPublicationName(String reviewPublicationName) {
        this.reviewPublicationName = reviewPublicationName;
    }

    @JsonProperty("review_link")
    public String getReviewLink() {
        return reviewLink;
    }

    @JsonProperty("review_link")
    public void setReviewLink(String reviewLink) {
        this.reviewLink = reviewLink;
    }

    @JsonProperty("review_rating_image")
    public String getReviewRatingImage() {
        return reviewRatingImage;
    }

    @JsonProperty("review_rating_image")
    public void setReviewRatingImage(String reviewRatingImage) {
        this.reviewRatingImage = reviewRatingImage;
    }

    @JsonProperty("review_publication_logo")
    public String getReviewPublicationLogo() {
        return reviewPublicationLogo;
    }

    @JsonProperty("review_publication_logo")
    public void setReviewPublicationLogo(String reviewPublicationLogo) {
        this.reviewPublicationLogo = reviewPublicationLogo;
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
