

export interface Product{
    id:number;
    name:string;
    description?:string;
    type:string;
    category:string;
    kc:number|string;
    path?:string;
    price:number;
}