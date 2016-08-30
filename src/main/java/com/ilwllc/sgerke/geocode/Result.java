package com.ilwllc.sgerke.geocode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "address_components",
    "formatted_address",
    "geometry",
    "place_id",
    "types"
})
public class Result {
	
	@JsonProperty("formatted_address")
	public String formattedAddress;

	@JsonProperty("geometry")
	public Geometry geometry;

	public String getFormatted_address() {
		return formattedAddress;
	}

	public void setFormatted_address(String formatted_address) {
		this.formattedAddress = formatted_address;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

}
