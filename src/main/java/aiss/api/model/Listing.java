package aiss.api.model;

import java.util.List;

public class Listing<T> {
	
	private Integer totalResults;
	private Integer startIndex;
	private Integer maxResults;
	private List<T> results;
	
	public Listing(Integer totalResults, List<T> results) {
		this.totalResults = totalResults;
		this.startIndex = 0;
		this.maxResults = 5;
		this.results = results;
	}
	
	public Listing(Integer totalResults, Integer startIndex, Integer maxResults, List<T> results) {
		this.totalResults = totalResults;
		this.startIndex = startIndex;
		this.maxResults = maxResults;
		this.results = results;
	}

	public Integer getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(Integer maxResults) {
		this.maxResults = maxResults;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maxResults == null) ? 0 : maxResults.hashCode());
		result = prime * result + ((results == null) ? 0 : results.hashCode());
		result = prime * result + ((startIndex == null) ? 0 : startIndex.hashCode());
		result = prime * result + ((totalResults == null) ? 0 : totalResults.hashCode());
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Listing<T> other = (Listing<T>) obj;
		if (maxResults == null) {
			if (other.maxResults != null)
				return false;
		} else if (!maxResults.equals(other.maxResults))
			return false;
		if (results == null) {
			if (other.results != null)
				return false;
		} else if (!results.equals(other.results))
			return false;
		if (startIndex == null) {
			if (other.startIndex != null)
				return false;
		} else if (!startIndex.equals(other.startIndex))
			return false;
		if (totalResults == null) {
			if (other.totalResults != null)
				return false;
		} else if (!totalResults.equals(other.totalResults))
			return false;
		return true;
	}
	
	
}
