package com.ilwllc.sgerke.geocode;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"results",
"status"
})
public class GeocodeResponse {
 
	private Result[] results ;
	private String status ;

	public Result[] getResults() {
		return results;
	}

	public void setResults(Result[] results) {
		this.results = results;
	}

	public String getStatus() {
		return status;
	}
 
	public void setStatus(String status) {
		this.status = status;
	}

}
