import { OnInit, Component } from "@angular/core";
import { Http } from "@angular/http";

import { ProductService } from '../product/product.service';
import { CartService } from '../cart/cart.service';

import { Product } from "../interfaces/Product/product.model";

@Component({
    selector: 'products',
    templateUrl: 'products.component.html'
})

export class ProductsComponent implements OnInit{
    
    products: Array<Product>;
    
    constructor (private http: Http) {

    }

    ngOnInit () {

    }
}