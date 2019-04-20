package aiss.model.reddit;

import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data<T> {
    @JsonProperty("modhash")
    private String modHash;
    
    @JsonProperty("after")
    private String after;
    
    @JsonProperty("dist")
    private Integer dist;
    
    @JsonProperty("before")
    private String before;

    @JsonProperty("children")
    private ArrayList<Child<T>> children;
    
	public String getModHash() {
		return modHash;
	}

	public String getAfter() {
		return after;
	}

	public Integer getDist() {
		return dist;
	}

	public String getBefore() {
		return before;
	}

	public List<T> getChildren() {
        List<T> flattenedList = new ArrayList<>();
        for(Child<T> child : children){
            flattenedList.add(child.getData());
        }
        return flattenedList;
    }

	public void setModHash(String modHash) {
		this.modHash = modHash;
	}

	public void setAfter(String after) {
		this.after = after;
	}

	public void setDist(Integer dist) {
		this.dist = dist;
	}

	public void setBefore(String before) {
		this.before = before;
	}

	public void setChildren(ArrayList<Child<T>> children) {
		this.children = children;
	}
	
	
}
