import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { Restaurant } from '../models';
import { RestaurantService } from '../restaurant-service';

@Component({
  selector: 'app-restaurant-cuisine',
  templateUrl: './restaurant-cuisine.component.html',
  styleUrls: ['./restaurant-cuisine.component.css']
})
export class RestaurantCuisineComponent implements OnInit, OnDestroy{

  cuisineName!: string;
  routeSub$!: Subscription;
  restaurant!: Restaurant;
  
  constructor(
    private restaurantService: RestaurantService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.routeSub$ = this.activatedRoute.params.subscribe((params) => {
      this.cuisineName = params['cuisine'];
    });

    this.restaurantService
      .getRestaurantsByCuisine(this.cuisineName)
      .then((res) => {
        this.restaurant = res;
      })
      .catch((err) => {
        console.log(err);
      });
  }

  ngOnDestroy(): void {
    this.routeSub$.unsubscribe();
  }
}




