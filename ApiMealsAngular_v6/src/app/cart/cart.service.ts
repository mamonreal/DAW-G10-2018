import { Injectable } from '@angular/core';
import { Headers, Http, Response, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';

import 'rxjs/Rx';

import { Product } from '../interfaces/Product/product.model';
import { Cart } from '../interfaces/Cart/shoppingcart.model';
import { Menu } from '../interfaces/Menu/menu.model';

import { environment } from '../../environments/environment';

const URL = environment.apiBase + '/ShoppingCart';

@Injectable()
export class CartService {

    service: CartService;
    constructor(private http: Http) {}

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

  createCart(id: number){

    let newCart: Cart;
    const body = JSON.stringify(newCart);
    const headers = new Headers({
        'Content-Type': 'application/json',
        'X-Requested-With': 'XMLHttpRequest'
    });

    const options = new RequestOptions({ withCredentials: true, headers });
      return this.http.post(URL + '/' + id, body, options)
        .map(response => response.json())
        .catch(error => this.handleError(error));
    }

  addProductToCart(cart:Cart, id: number){

    const body = JSON.stringify(cart);
    const headers = new Headers({
      'Content-Type': 'application/json',
      'X-Requested-With': 'XMLHttpRequest'
    });
    const options = new RequestOptions({ withCredentials: true, headers });

    return this.http.put(URL + cart.id + '/' + id + '/product', body, options)
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

  deleteProductInCart(cart:Cart, id: number){

    const headers = new Headers({
      'Content-Type': 'application/json',
      'X-Requested-With': 'XMLHttpRequest'
    })

    const options = new RequestOptions({ withCredentials: true, headers });

    return this.http.delete(URL + cart.id + '/' + id + '/product', options)
    .map(response => response.json())
    .catch(error => this.handleError(error));
  }

  deleteMenuInCart(cart:Cart, id: number){

    const headers = new Headers({
      'Content-Type': 'application/json',
      'X-Requested-With': 'XMLHttpRequest'
    })

    const options = new RequestOptions({ withCredentials: true, headers });

    return this.http.delete(URL + cart.id + '/' + id + '/menu', options)
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