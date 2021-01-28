import { Injectable } from '@angular/core';
import { CartItem } from '../Model/cart-item';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cartItems: CartItem[] = [];
  totalPrice: Subject<number> = new Subject<number>();
  totalQuantity: Subject<number> = new Subject<number>();

  constructor() { }

  addToCart(theCartItem: CartItem){
    //check already item in the cart 
    let alreadyExistsInCart: boolean = false;
    let existingCartItem : CartItem | undefined=  undefined;
    
    if(this.cartItems.length > 0){
      //find the item in the cart based on id

      existingCartItem = this.cartItems.find( tempCartItem => tempCartItem.cakeid === theCartItem.cakeid);

      //check if we found it
      alreadyExistsInCart = (existingCartItem != undefined)
    } 

    if(alreadyExistsInCart){
      //increment the quantity
      existingCartItem!.quantity++;
    }else {
      //add to cart item array
      this.cartItems.push(theCartItem);
    }

    this.calculateTotalPrice();
  }
  
  calculateTotalPrice() {
    let totalPriceValue: number = 0;
    let totalQuantityValue: number = 0;

    for(let currentCartItem of this.cartItems){
      totalPriceValue += currentCartItem.quantity * currentCartItem.price;
      totalQuantityValue += currentCartItem.quantity;
    }

    console.log(`Total price: ${totalPriceValue}, Total quantity: ${totalQuantityValue}`);
    
    this.totalPrice.next(totalPriceValue);
    this.totalQuantity.next(totalQuantityValue);
  }

  decrementQuantity(cartItem: CartItem){
    cartItem.quantity--;

    if (cartItem.quantity === 0) {
      this.remove(cartItem);
    }else {
      this.calculateTotalPrice();
    }
  }

  remove(cartItem: CartItem){
    const itemIndex = this.cartItems
                          .findIndex(
                            tempCartItem => tempCartItem.cakeid === cartItem.cakeid
                          );

    if (itemIndex > -1) {
      this.cartItems.splice(itemIndex, 1);
      this.calculateTotalPrice();
    }
  }
}

