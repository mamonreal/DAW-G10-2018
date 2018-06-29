import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Product} from '../Interfaces/Product/product.model';
import { ProductService} from './product.service';
import {Http} from '@angular/http';
import {LoginService} from '../login/login.service';
import { environment } from '../../environments/environment';


@Component({
    selector: 'exercise',
    templateUrl:'./product.component.html'
})


export class ProductComponent implements OnInit {

    id: number;
    /*name: string;
    category: string;
    description?:string;
    type:string;
    kc:string|number;
    path?:string;
    price:number;*/

    constructor(private router: Router, activatedRoute: ActivatedRoute, public productService: ProductService){
        this.id = activatedRoute.snapshot.params['id'];


    }

    ngOnInit(){
        this.getProducts();
    }

    getProducts(){
        this.productService.getProducts();
    }

    getProduct(id:number){
        
    }
}
