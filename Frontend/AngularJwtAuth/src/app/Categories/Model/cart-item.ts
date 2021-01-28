import { Cakemodel } from '../Model/cakemodel';

export class CartItem {
    cakeid!: number;
    name!: string;
    image!: string;
    price!: number;
    quantity!: number;
    
    constructor(cake: Cakemodel){
        this.cakeid = cake.cakeid;
        this.name = cake.name;
        this.image = cake.image;
        this.price = cake.price;
        this.quantity = 1
    }
}