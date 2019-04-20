package aiss.model.reddit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {

    @JsonProperty("subreddit_id")
    private String subredditId;

    @JsonProperty("link_title")
    private String linkTitle;

    @JsonProperty("link_id")
    private String linkId;

    @JsonProperty("link_author")
    private String linkAuthor;

    @JsonProperty("id")
    private String id;

    @JsonProperty("author")
    private String author;

    @JsonProperty("parent_id")
    private String parentId;

    @JsonProperty("score")
    private Integer score;

    @JsonProperty("body")
    private String body;

    @JsonProperty("subreddit")
    private String subreddit;

    @JsonProperty("created")
    private Double createdOn;

    @JsonProperty("link")
    private String link;

    @JsonProperty("ups")
    private Integer upvotes;

    public String getSubredditId() {
        return subredditId;
    }

    public String getLinkTitle() {
        return linkTitle;
    }

    public String getLinkId() {
        return linkId;
    }

    public String getLinkAuthor() {
        return linkAuthor;
    }

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getParentId() {
        return parentId;
    }

    public Integer getScore() {
        return score;
    }

    public String getBody() {
        return body;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public Double getCreatedOn() {
        return createdOn;
    }

    public String getLink() {
        return link;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

	public void setSubredditId(String subredditId) {
		this.subredditId = subredditId;
	}

	public void setLinkTitle(String linkTitle) {
		this.linkTitle = linkTitle;
	}

	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}

	public void setLinkAuthor(String linkAuthor) {
		this.linkAuthor = linkAuthor;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setSubreddit(String subreddit) {
		this.subreddit = subreddit;
	}

	public void setCreatedOn(Double createdOn) {
		this.createdOn = createdOn;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setUpvotes(Integer upvotes) {
		this.upvotes = upvotes;
	}
    
    
}
