import{Cart} from '../Cart/shoppingcart.model';

export interface user{
    id:number;
    name: string;
    email: string;
    passwordHash: string;
    telephone:number;
    roles:string[];
    userName:string;
    city:string;
    PC:string;
    kc:string;
    cart: Array<Cart>;
}