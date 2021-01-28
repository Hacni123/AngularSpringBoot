import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
import { CartService } from '../../Service/cart.service';
import { CartItem } from 'src/app/Categories/Model/cart-item';
import { CakeService } from '../../Service/cake.service';
import { SignUpInfo } from 'src/app/auth/signup-info';
import { Order } from 'src/app/Categories/Model/order';
@Component({
  selector: 'app-check-out',
  templateUrl: './check-out.component.html',
  styleUrls: ['./check-out.component.css']
})
export class CheckOutComponent implements OnInit {
  info: any;
  users: SignUpInfo;
  order : Order;
  cartItems: CartItem[] = [];
  totalPrice: number = 0;
  totalQuantity: number = 0;

  constructor(private token: TokenStorageService,private _cartService: CartService,private cake: CakeService) { }

  ngOnInit(): void {
    this.info = {
      token: this.token.getToken(),
      username: this.token.getUsername(),
      authorities: this.token.getAuthorities()
      
    };
    this._cartService.totalPrice.subscribe(
      data => this.order.total_price = data
    );

    
    this.cartDetails();
    this.getUserInfo();
  }

  saveOrder(){
    this.order = new Order(
      this.info.id,
      this.info.status,
      this.info.order_date,
      this.info.total_price,
      this.info.cakeid,
      );

    this.cake.createOrder(this.order).subscribe(data =>{
      console.log(data);
     
    },
    error => console.log(error));
  }
  
  cartDetails(){
    this.cartItems = this._cartService.cartItems;

    this._cartService.totalPrice.subscribe(
      data => this.totalPrice = data
    );

    this._cartService.totalQuantity.subscribe(
      data => this.totalQuantity = data
    );

    this._cartService.calculateTotalPrice();
  }

  getUserInfo(){
    const username: String = this.token.getUsername();

    this.cake.getUsers(username).subscribe(
      data => {
        this.users = data;
      }
    );
  }
  onSubmit(){
    this.saveOrder();
    
  }
}
