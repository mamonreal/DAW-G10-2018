import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Product} from '../Interfaces/Product/product.model';
import { ProductsService } from './products.service';
import {Http} from '@angular/http';
import {LoginService} from '../login/login.service';
import { environment } from '../../environments/environment';
import { Cart } from '../Interfaces/Cart/shoppingcart.model';
import { CartService } from '../Cart/cart.service';


@Component({
    selector: 'products',
    templateUrl:'./products.component.html'
})


export class ProductsComponent implements OnInit {

    id: number;
    /*name: string;
    category: string;
    description?:string;
    type:string;
    kc:string|number;
    path?:string;
    price:number;*/
    private carts: Cart[];
    private cart: Cart;

    constructor(private router: Router, private activatedRoute: ActivatedRoute, public productService: ProductsService, private cService: CartService){
        this.id = activatedRoute.snapshot.params['id'];
    }

    ngOnInit(){
        this.productService.getProducts().subscribe(
            products => this.productService = products,
            error => console.log(error)
        );
    }

    getProduct(id:number){
        this.productService.getProduct(id);
    }

    addToCart(){
    
        this.cService.createCart(this.activatedRoute.snapshot.params['id']).subscribe(
          response => {  this.router.navigate(['/cart']);},
          error => console.log(error) 
        );
      }

    updateCart(){

    for (let cart of this.carts){
    this.cService.getUCart(cart.id);
    this.cService.addProductToCart(cart, this.activatedRoute.snapshot.params['id']).subscribe(
        response => {  this.router.navigate(['/shoppingCart']);},
        error => console.log(error) 
        );
      }
    }
}
