import { OnInit, Component } from "@angular/core";
import { Http } from "@angular/http";

import { ProductService } from './product.service';
import { CartService } from '../cart/cart.service';

import { Product } from "../interfaces/Product/product.model";

@Component({
    selector: 'products',
    templateUrl: 'products.component.html'
})

export class ProductsComponent implements OnInit{
    
    products: Array<Product>;
    
    constructor (private http: Http,
                private productService: ProductService,
                private cartService: CartService) {

    }

    ngOnInit () {
        this.productService.getProducts().subscribe(
            products => this.products,
            error => console.log(error)
        );
    }

    addToCart (id: number) {
        this.cartService.addProductToCart(id);
    }

    removeFromCart (id: number) {
        this.cartService.deleteProductInCart(id);
    }
}