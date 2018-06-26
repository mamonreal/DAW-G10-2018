import {Product} from '../Product/product.model';

xport interface Menu{
    id:number;
    name:string;
    description?:string;
    type:string;
    category:string;
    kc:number;
    path?:string;
    price:number;
    products:Array<Product>;
}