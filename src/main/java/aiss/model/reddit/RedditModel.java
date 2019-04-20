package aiss.model.reddit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RedditModel<T> {
    @JsonProperty("data")
    private Data<T> data;

    @JsonProperty("kind")
    private String kind;

    public Data<T> getData() {
        return data;
    }

    public String getKind() {
        return kind;
    }

	public void setData(Data<T> data) {
		this.data = data;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
    
}
