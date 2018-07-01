import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Product} from '../Interfaces/Product/product.model';
import { ProductService} from './product.service';
import {Http} from '@angular/http';
import {LoginService} from '../login/login.service';
import { environment } from '../../environments/environment';
import { Cart } from '../Interfaces/Cart/shoppingcart.model';
import { CartService } from '../Cart/cart.service';


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
    private carts: Cart[];
    private cart: Cart;

    constructor(private router: Router, private activatedRoute: ActivatedRoute, public productService: ProductService, private cService: CartService){
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
