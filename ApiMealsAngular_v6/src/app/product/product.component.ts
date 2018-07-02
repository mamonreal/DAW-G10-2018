import { OnInit, Component } from "@angular/core";
import { Http } from "@angular/http";

import { ProductService } from '../product/product.service';

import { Product } from "../interfaces/Product/product.model";

@Component({
    selector: 'product',
    templateUrl: './product.component.html'

})

export class ProductComponent implements OnInit{
    
    constructor (private http: Http) {

    }

    ngOnInit () {

    }
}