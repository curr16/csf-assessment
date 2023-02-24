package vttp2022.csf.assessment.server.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import vttp2022.csf.assessment.server.models.Restaurant;
import vttp2022.csf.assessment.server.services.RestaurantService;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping (path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)

public class RestaurantController {

    @Autowired
	private RestaurantService restaurantService;
	
    @GetMapping(path = "/cuisines")
    public ResponseEntity<String> getCuisines() {

    List<Restaurant> cuisineResults = restaurantService.getCuisines();

    List<JsonObject> CuisineList = new LinkedList<>();

    for (Restaurant r : cuisineResults) {
        JsonObject j = r.toJSON();
        CuisineList.add(j);
    }

    JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
    for (JsonObject jo : CuisineList)
        arrBuilder.add(jo);

    return ResponseEntity
            .status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(Json.createObjectBuilder()
                    .build().toString());
    
    }

    @GetMapping(path = "/{cuisines}/restaurants")
    public ResponseEntity<String> getRestaurantsByCuisines(
    @PathVariable String listOfCuisines) {

    JsonObject result = null;

    Restaurant selectedCuisine = restaurantService.getRestaurantsByCuisine(listOfCuisines);
    JsonObjectBuilder objBuilder = Json.createObjectBuilder();

    objBuilder.add("name", selectedCuisine.toJSONName());
 	result = objBuilder.build();

   		return ResponseEntity
				.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(result.toString());
  } 
}
