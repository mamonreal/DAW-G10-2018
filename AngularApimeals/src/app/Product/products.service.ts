import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { environment } from '../../environments/environment';
import 'rxjs/Rx';
import { Product} from '../Interfaces/Product/product.model';


const BASE_URL = environment.apiBase + '/Product';


@Injectable()
export class ProductsService {


    constructor(private http :Http){ }

    getProducts(){ //mirar con que pedir el get si con solo id con name o id+tipo
        return this.http.get(BASE_URL)
        .map(response => response.json())
        .catch (error => this.handleError(error));
    }

    getProduct(id:number){
        return this.http.get(BASE_URL + '/' + id)
            .map(response => response.json())
            .catch(error => Observable.throw('Server error'));
    }

    removeProduct(id: number){
        const headers = new Headers({
            'Content-Type': 'application/json',
            'X-Requested-With': 'XMLHttpRequest'
        });
        const options = new RequestOptions({ withCredentials: true, headers});

        return this.http.delete(BASE_URL + 'product/' + id, options)
            .map(response=> response.json)
            .catch(error => this.handleError(error));
    }

    createProduct(name:string, description:string,type:string, category:string, kc: number,  price:number, path?:string){
        let newProduct:Product;
        newProduct={name:name,description:description,type:type,category:category,kc:kc,price:price, path:path}
        const headers = new Headers({
            'Content-Type': 'application/json',
            'X-Requested-With': 'XMLHttpRequest'
        });
        const options = new RequestOptions({ withCredentials: true, headers});
        console.log(BASE_URL + 'product');
            return this.http.post(BASE_URL + 'product', newProduct, options)
                .map(response=> response.json())
                .catch(error=> this.handleError(error));
    }


    private handleError(error: any){
        console.error(error);
        return Observable.throw("Error (" + error.status + "): " + error.text())
    }
}