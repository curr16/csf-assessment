package vttp2022.csf.assessment.server.models;

import org.bson.Document;

import jakarta.json.Json;
import jakarta.json.JsonObject;

// Do not modify this class
public class Restaurant {
	
	private String restaurantId;
	private String name;
	private String cuisine;
	private String address;
	private LatLng coordinates;
	private String mapUrl;

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantId() {
		return this.restaurantId;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public String getCuisine() {
		return this.cuisine;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return this.address;
	}

	public void setCoordinates(LatLng coordinates) {
		this.coordinates = coordinates;
	}
	public LatLng getCoordinates() {
		return this.coordinates;
	}

	public void setMapURL(String mapUrl) {
		this.mapUrl = mapUrl;
	}
	public String getMapURL() {
		return this.mapUrl;
	}

	public static Restaurant create(Document d) {
		Restaurant r = new Restaurant();
		r.setRestaurantId(d.getString("restaurant_id"));
		r.setName(d.getString("name"));
		r.setCuisine(d.getString("cuisine"));
		r.setAddress(d.getString("address"));
		return r;
	}

	public JsonObject toJSON() {
		return Json.createObjectBuilder()
				.add("cuisine", getCuisine())
				.build();
	}


	public JsonObject toJSONName() {
		return Json.createObjectBuilder()
				.add("cuisine", getCuisine())
				.add("name", getName())
				.build();
	}

}
	
