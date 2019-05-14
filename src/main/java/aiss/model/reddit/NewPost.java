package aiss.model.reddit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class NewPost {
	
	@JsonProperty("api_type")
	private String api_type = "json";
	@JsonProperty("kind")
	private String kind = "self";
	@JsonProperty("spoiler")
	private Boolean spoiler;
	@JsonProperty("sr")
	private String sr = "test";
	@JsonProperty("text")
	private String text;
	@JsonProperty("title")
	private String title;
	
	public NewPost(String title, String text, Boolean spoiler) {
		this.title = title;
		this.text = text;
		this.spoiler = spoiler;
	}

	public String getApi_type() {
		return api_type;
	}

	public void setApi_type(String api_type) {
		this.api_type = api_type;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Boolean getSpoiler() {
		return spoiler;
	}

	public void setSpoiler(Boolean spoiler) {
		this.spoiler = spoiler;
	}

	public String getSr() {
		return sr;
	}

	public void setSr(String sr) {
		this.sr = sr;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
