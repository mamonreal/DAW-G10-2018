import {Product} from '../Product/product.model';
import {Menu} from '../Menu/menu.model';


export interface Cart{
    id:number;
    totalPrice:number;
    adress:string;
    productCart?:Array<Product>;
    menus?: Array<Menu>;
    
}