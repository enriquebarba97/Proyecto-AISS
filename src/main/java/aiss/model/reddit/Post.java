package aiss.model.reddit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {
	
	@JsonProperty("name")
	private String name;
	
    @JsonProperty("domain")
    private String domain;

    @JsonProperty("subreddit")
    private String subreddit;

    @JsonProperty("id")
    private String id;

    @JsonProperty("gilded")
    private Integer amountGilded;

    @JsonProperty("author")
    private String author;

    @JsonProperty("score")
    private Integer score;

    @JsonProperty("subreddit_id")
    private String subredditId;

    @JsonProperty("permalink")
    private String permalink;

    @JsonProperty("created_utc")
    private Double createdOn;

    @JsonProperty("url")
    private String url;

    @JsonProperty("title")
    private String title;

    @JsonProperty("ups")
    private Integer upvotes;

    public String getDomain() {
        return domain;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public String getId() {
        return id;
    }

    public Integer getAmountGilded() {
        return amountGilded;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getScore() {
        return score;
    }

    public String getSubredditId() {
        return subredditId;
    }

    public String getPermalink() {
        return permalink;
    }

    public Double getCreatedOn() {
        return createdOn;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public Integer getUpvotes() {
        return upvotes;
    }
    
    public String getName() {
    	return name;
    }

	public void setName(String name) {
		this.name = name;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public void setSubreddit(String subreddit) {
		this.subreddit = subreddit;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setAmountGilded(Integer amountGilded) {
		this.amountGilded = amountGilded;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public void setSubredditId(String subredditId) {
		this.subredditId = subredditId;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	public void setCreatedOn(Double createdOn) {
		this.createdOn = createdOn;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUpvotes(Integer upvotes) {
		this.upvotes = upvotes;
	}
    
    
}
