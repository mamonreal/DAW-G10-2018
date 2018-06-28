import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Product} from '../Interfaces/Product/product.model';
import { ProductService} from './product.service';

@Component({
    selector: 'exercise',
    templateUrl:'./product.component.html'
})


export class ProductComponent implements OnInit {

    id: number;
    name: string;
    category: string;
    description?:string;
    type:string;
    kc:string|number;
    path?:string;
    price:number;

    constructor(private router: Router, activatedRoute: ActivatedRoute, public productService: ProductService){
        let idProduct = activatedRoute.snapshot.params['id'];
        this.id = parseInt(idProduct);

    }

    ngOnInit(){
        this.getProducts();
    }

    getProducts(){
        this.productService.getProduct();
    }
}
