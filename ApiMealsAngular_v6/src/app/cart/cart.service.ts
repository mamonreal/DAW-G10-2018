import { Injectable } from '@angular/core';
import { Headers, Http, Response, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';

import 'rxjs/Rx';

import { Product } from '../interfaces/Product/product.model';
import { Cart } from '../interfaces/Cart/shoppingcart.model';
import { Menu } from '../interfaces/Menu/menu.model';

import { ProductService } from '../product/product.service';

import { environment } from '../../environments/environment';

const URL = environment.apiBase + '/ShoppingCart';

@Injectable()
export class CartService {

    service: CartService;
    constructor(private http: Http, private productService: ProductService) {}

    getCarts() {
      return this.http.get(URL + "/shoppingCart", { withCredentials: true })
        .map(response => response.json())
        .catch(error => this.handleError(error));
    }

    getUCarts() {
    return this.http.get(URL + "/shoppingCart", { withCredentials: true })
      .map(response => response.json())
      .catch(error => this.handleError(error));
  }

  getUCart(id:number): Observable<Cart>{
    return this.getUCarts()
      .map(carts => carts.find(cart => cart.id))
  }

  addProductToCart(id: number){

    const body = JSON.stringify(this.productService.getProduct(id));
    const headers = new Headers({
      'Content-Type': 'application/json',
      'X-Requested-With': 'XMLHttpRequest'
    });
    const options = new RequestOptions({ withCredentials: true, headers });

    return this.http.put(URL + '/Product/' + id, body, options)
      .map(response => response.json())
      .catch(error => this.handleError(error));
  }

  private handleError(error: any) {
    console.error(error);
    return Observable.throw('Server error (' + error.status + '): ' + error.text());
  }

  addMenuToCart(cart:Cart, id: number){

    const body = JSON.stringify(cart);
    const headers = new Headers({
      'Content-Type': 'application/json',
      'X-Requested-With': 'XMLHttpRequest'
    });
    const options = new RequestOptions({ withCredentials: true, headers });

    return this.http.put(URL + cart.id + '/' + id + '/menu', body, options)
      .map(response => response.json())
      .catch(error => this.handleError(error));
  }

  deleteProductInCart(id: number){

    const headers = new Headers({
      'Content-Type': 'application/json',
      'X-Requested-With': 'XMLHttpRequest'
    })

    const options = new RequestOptions({ withCredentials: true, headers });

    return this.http.delete(URL + '/removeProduct/' + id, options)
    .map(response => response.json())
    .catch(error => this.handleError(error));
  }

  deleteMenuInCart(id: number){

    const headers = new Headers({
      'Content-Type': 'application/json',
      'X-Requested-With': 'XMLHttpRequest'
    })

    const options = new RequestOptions({ withCredentials: true, headers });

    return this.http.delete(URL + '/' + id + '/menu', options)
    .map(response => response.json())
    .catch(error => this.handleError(error));
  }

  checkOut(address: String) {

    const headers = new Headers({
      'Content-Type': 'application/json',
      'X-Requested-With': 'XMLHttpRequest'
    });

    const options = new RequestOptions({ withCredentials: true, headers });
    
    return this.http.put(URL + '/checkout' + address, '', options)
      .map(response => response.json())
      .catch(error => this.handleError(error));
  }

}