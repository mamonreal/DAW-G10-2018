import { Component, OnInit} from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Headers, Http, Response, RequestOptions } from '@angular/http';

import { Product} from '../Interfaces/Product/product.model';
import { DomSanitizer } from '@angular/platform-browser';
import { Cart, CartService } from '../Cart/cart.service';

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

import 'rxjs/Rx';
import {Subject} from 'rxjs/Subject';
import {debounceTime} from 'rxjs/operator/debounceTime';


@Component({
  selector: 'app-cart',
  templateUrl: 'cart.component.html',
})

export class CartComponent implements OnInit{
  //alerts
  private _success = new Subject<string>();
  staticAlertClosed = false;
  successMessage: string;

  products: Product[];
  img_url: string;
  carts: Cart[];

  constructor(private router: Router, private cartservice: CartService, public sanitizer: DomSanitizer, private http: Http, private activatedRoute: ActivatedRoute) {
  }

    ngOnInit() {
         //alerts
        setTimeout(() => this.staticAlertClosed = true, 9000);
        this._success.subscribe((message) => this.successMessage = message);
        debounceTime.call(this._success, 9000).subscribe(() => this.successMessage = null);
        //--------//
        this.cartservice.getUCarts().subscribe(
        carts => this.carts = carts,
        error => console.log(error)
      );
    }

    checkOut() {
      for (let order of this.carts){
      this.cartservice.checkOut(order).subscribe(
        response => {this._success.next(`${new Date()} - 'Your order has been completed successfully.'`);},
        error => console.log(error) 
        );
      }
    }

    
  }