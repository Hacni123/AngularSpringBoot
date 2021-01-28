import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CakeService } from '../../Service/cake.service';
import { Cakemodel } from '../../Model/cakemodel';
import { CartService } from '../../Service/cart.service';
import { CartItem } from 'src/app/Categories/Model/cart-item';

@Component({
  selector: 'app-cake-details',
  templateUrl: './cake-details.component.html',
  styleUrls: ['./cake-details.component.css']
})
export class CakeDetailsComponent implements OnInit {
  cakes: Cakemodel = new Cakemodel();
  info: any;
  constructor(private _activatedRoute: ActivatedRoute,
    private cake: CakeService, private _cartService: CartService) { }
  
    ngOnInit() {
      this._activatedRoute.paramMap.subscribe(
        () => {
          this.getBookInfo();
        }
      )
      
    }
  
    getBookInfo(){
      const id: number = +this._activatedRoute.snapshot.paramMap.get('id')!;
  
      this.cake.get(id).subscribe(
        data => {
          this.cakes = data;
        }
      );
    }
    addToCart(){
      console.log(`cake name: ${this.cakes.name}, and price: ${this.cakes.price}`);
      const cartItem = new CartItem(this.cakes);
      this._cartService.addToCart(cartItem);
    }

    
}

