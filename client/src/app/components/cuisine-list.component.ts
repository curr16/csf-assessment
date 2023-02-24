import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { Restaurant } from '../models';
import { RestaurantService } from '../restaurant-service';

@Component({
  selector: 'app-cuisine-list',
  templateUrl: './cuisine-list.component.html',
  styleUrls: ['./cuisine-list.component.css']
})

export class CuisineListComponent implements OnInit, OnDestroy{

  restaurants: Restaurant[] = [];
  routeSub$!: Subscription;

  
  constructor (
    private restaurantService: RestaurantService,
    private activateRoute: ActivatedRoute

    ) {}

  ngOnInit(): void {
      this.restaurantService.getCuisineList()
      .then((res) => {
        console.log(res);
        this.restaurants = res.games;
      })
      .catch((err) => {
        console.log(err);
      });
    }

  ngOnDestroy(): void {
    this.routeSub$.unsubscribe();
    }
}
