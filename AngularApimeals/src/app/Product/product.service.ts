import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { environment } from '../../environments/environment';
import 'rxjs/Rx';
import { Product} from '../Interfaces/Product/product.model';


const URL = environment.apiBase + '/product';


@Injectable()
export class ProductService {


    constructor(private http :Http){ }

    getProduct(){ //mirar con que pedir el get si con solo id con name o id+tipo
        return this.http.get(URL)
        .map(response=> response.json().content)
        .catch (error=> this.handlerError(error));
    }


    private handlerError(error: any){
        console.error(error);
        return Observable.throw("Error (" + error.status + "): " + error.text())
    }
}