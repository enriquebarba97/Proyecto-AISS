package aiss.model.reddit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Subreddit {
	
	@JsonProperty("name")
	private String name;
	
    @JsonProperty("banner_img")
    private String bannerImage;

    @JsonProperty("id")
    private String id;

    @JsonProperty("header_img")
    private String headerImage;

    @JsonProperty("title")
    private String title;

    @JsonProperty("over18")
    private boolean over18;

    @JsonProperty("public_description")
    private String description;

    @JsonProperty("subscribers")
    private Long subscribers;

    @JsonProperty("url")
    private String url;

    public String getBannerImage() {
        return bannerImage;
    }

    public String getId() {
        return id;
    }

    public String getHeaderImage() {
        return headerImage;
    }

    public String getTitle() {
        return title;
    }

    public boolean isOver18() {
        return over18;
    }

    public String getDescription() {
        return description;
    }

    public Long getSubscribers() {
        return subscribers;
    }

    public String getUrl() {
        return url;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBannerImage(String bannerImage) {
		this.bannerImage = bannerImage;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setHeaderImage(String headerImage) {
		this.headerImage = headerImage;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setOver18(boolean over18) {
		this.over18 = over18;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setSubscribers(Long subscribers) {
		this.subscribers = subscribers;
	}

	public void setUrl(String url) {
		this.url = url;
	}
    
    
}
