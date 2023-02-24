import { Restaurant, Comment } from './models'
import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { lastValueFrom } from 'rxjs';

@Injectable({
	providedIn: 'root'
})
export class RestaurantService {

	constructor(private httpclient: HttpClient) { }

	public getCuisineList(): Promise<any> {
		// Implememntation in here
		const params = new HttpParams()
		
		return lastValueFrom(this.httpclient.get('https://itchy-doctor-production.up.railway.app/api/cuisines',
		{params: params,})
			);
		}

	// TODO Task 3 
	// Use the following method to get a list of restaurants by cuisine
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	public getRestaurantsByCuisine(cuisineName: String) {
	
			return lastValueFrom(
			  this.httpclient.get<Restaurant>('https://itchy-doctor-production.up.railway.app/api/${cuisines}/restaurants',
			  )
			);
		  }
	
	// TODO Task 4
	// Use this method to find a specific restaurant
	// You can add any parameters (if any) 
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	// public getRestaurant(???): Promise<Restaurant> {
	// 	// Implememntation in here

	// }

	// TODO Task 5
	// Use this method to submit a comment
	// DO NOT CHANGE THE METHOD'S NAME OR SIGNATURE
	// public postComment(comment: Comment): Promise<any> {
	// 	// Implememntation in here

	// }

}