package aiss.model.reddit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Child<T> {
    @JsonProperty("kind")
    private String kind;

    @JsonProperty("data")
    private T data;

    public String getKind() {
        return kind;
    }

    public T getData() {
        return data;
    }

	public void setKind(String kind) {
		this.kind = kind;
	}

	public void setData(T data) {
		this.data = data;
	}
    
    
}