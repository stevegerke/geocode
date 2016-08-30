package com.ilwllc.sgerke.geocode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lat",
    "lng"
})
public class Location {

	@JsonProperty("lat")
	public String lat;

	@JsonProperty("lng")
	public String lng;

	public String getLat() {
    	return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}
    
	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}
}
