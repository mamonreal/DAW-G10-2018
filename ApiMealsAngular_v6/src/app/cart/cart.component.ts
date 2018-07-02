import { Component, OnInit} from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Headers, Http, Response, RequestOptions } from '@angular/http';

import { DomSanitizer } from '@angular/platform-browser';

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

import 'rxjs/Rx';
import {Subject} from 'rxjs/Subject';
import {debounceTime} from 'rxjs/operator/debounceTime';

import { CartService } from './cart.service';
import { Product } from '../interfaces/Product/product.model';
import { Menu } from '../interfaces/Menu/menu.model';

@Component({
  selector: 'app-cart',
  templateUrl: 'cart.component.html',
})

export class CartComponent implements OnInit {
  //alerts
  private _success = new Subject<string>();
  staticAlertClosed = false;
  successMessage: string;

  products: Product[];
  menus: Menu[];
  address: string;
  img_url: string;

  constructor(private router: Router, private cartservice: CartService, public sanitizer: DomSanitizer, private http: Http, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit() {
      
  }

  checkOut() {
    this.cartservice.checkOut(this.address).subscribe(
      response => {this._success.next(`${new Date()} - 'Your order has been completed successfully.'`);},
      error => console.log(error));
  }
}
