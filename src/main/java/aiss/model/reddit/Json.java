
package aiss.model.reddit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ratelimit",
    "errors"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class Json {

    @JsonProperty("ratelimit")
    private Double ratelimit;
    @JsonProperty("errors")
    private List<List<String>> errors = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ratelimit")
    public Double getRatelimit() {
        return ratelimit;
    }

    @JsonProperty("ratelimit")
    public void setRatelimit(Double ratelimit) {
        this.ratelimit = ratelimit;
    }

    @JsonProperty("errors")
    public List<List<String>> getErrors() {
        return errors;
    }

    @JsonProperty("errors")
    public void setErrors(List<List<String>> errors) {
        this.errors = errors;
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
