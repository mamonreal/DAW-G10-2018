import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Product} from '../Interfaces/Product/product.model';
import { ProductsService } from './products.service';
import {Http} from '@angular/http';
import {LoginService} from '../login/login.service';
import { environment } from '../../environments/environment';


@Component({
    selector: 'products',
    templateUrl:'./products.component.html'
})


export class ProductsComponent implements OnInit {

    id: number;
   products:Product[];
    



    constructor(private router: Router, activatedRoute: ActivatedRoute, private productsService: ProductsService){
        this.id = activatedRoute.snapshot.params['id'];
    }

    ngOnInit(){
        this.productsService.getProducts().subscribe(
            products => this.products = products,
            error => console.log(error)
        );
    }

    getProduct(id:number){
        this.productsService.getProduct(id);
    }
}
