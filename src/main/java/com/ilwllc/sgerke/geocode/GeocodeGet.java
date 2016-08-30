package com.ilwllc.sgerke.geocode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.DeserializationConfig;

public class GeocodeGet {
	public static void main(String[] args) throws ClientProtocolException, IOException {

		int timeout = 5;
		RequestConfig config = RequestConfig.custom()
				.setConnectTimeout(timeout * 1000)
				.setConnectionRequestTimeout(timeout * 1000)
				.setSocketTimeout(timeout * 1000).build();
		CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
		HttpGet url = new HttpGet("https://maps.googleapis.com/maps/api/geocode/json?&address=%205947%20Deerfield%20Blvd%20%23203%2C%20Mason%2C%20OH%2045040");
		HttpResponse httpresponse = client.execute(url);
		BufferedReader br = new BufferedReader (new InputStreamReader(httpresponse.getEntity().getContent()));
		ObjectMapper mapper = new ObjectMapper();
		
		//configuring the ObjectMapper to not FAIL_ON_UNKNOWN_PROPERTIES
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		GeocodeResponse response = (GeocodeResponse)mapper.readValue(br,GeocodeResponse.class);
		
		if(response.getStatus().equals("OK"))
		  {
		   for(Result result : response.getResults())
		   {
		    System.out.println("Formatted Address: "  + result.getFormatted_address());
		    System.out.println("Latitude: "  + result.getGeometry().getLocation().getLat());
		    System.out.println("Longitude: "  + result.getGeometry().getLocation().getLng());
		   }
		  }
		  else
		  {
		   System.out.println(response.getStatus());
		  }
	}
}
