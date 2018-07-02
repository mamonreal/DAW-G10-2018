import { Injectable } from '@angular/core';
import { Headers, Http, Response, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';

import 'rxjs/Rx';

import { Product } from '../interfaces/Product/product.model';

import { CartService } from '../cart/cart.service';

import { environment } from '../../environments/environment';

const URL = environment.apiBase + '/Product';

@Injectable()
export class ProductService {

    constructor (private http: Http) {}

}