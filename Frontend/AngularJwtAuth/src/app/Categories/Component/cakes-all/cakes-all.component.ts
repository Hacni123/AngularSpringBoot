import { Component, OnInit } from '@angular/core';
import { Cakemodel } from '../../Model/cakemodel';
import { CakeService } from '../../Service/cake.service';
import { CartService } from '../../Service/cart.service';
import { CartItem } from 'src/app/Categories/Model/cart-item';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-cakes-all',
  templateUrl: './cakes-all.component.html',
  styleUrls: ['./cakes-all.component.css']
})
export class CakesAllComponent implements OnInit {
  cakes: Cakemodel[] = [];
  currentCategoryId?:number;
  searchMode!: Boolean;

  pageOfItems!: Array<Cakemodel>;
  pageSize: number = 6;
  constructor(private cake: CakeService, private _activatedRoute: ActivatedRoute,
     private _cartService: CartService) { }

  ngOnInit(): void {
    
    this._activatedRoute.paramMap.subscribe(()=>{
      this.listCakes();
    })
  }

  pageClick(pageOfItems:Array<Cakemodel>){
    this.pageOfItems=pageOfItems;
  }

  private listCakes(){
    this.searchMode = this._activatedRoute.snapshot.paramMap.has('keyword');

    if(this.searchMode){
      //do search work
      this.handleSearchCakes();
    }else {
      //display books based on category
      this.handleListCakes();
    }
  }

  handleListCakes(){
    const hasCategoryId: boolean = this._activatedRoute.snapshot.paramMap.has('id');
    
    if (hasCategoryId) {
      this.currentCategoryId = +this._activatedRoute.snapshot.paramMap.get('id')!;
    }else {
      this.currentCategoryId = 1;
    }

    this.cake.getCakeList(this.currentCategoryId).subscribe(
      data => this.cakes = data
    )
  }

  handleSearchCakes(){
    const keyword: string = this._activatedRoute.snapshot.paramMap.get('keyword')!;
    this.cake.searchBooks(keyword)
      .subscribe(
        data =>{
          this.cakes=data;
        }
      )
  }
  
  addToCart(cakes: Cakemodel){
    console.log(`book name: ${cakes.name}, and price: ${cakes.price}`);
    const cartItem = new CartItem(cakes);
    this._cartService.addToCart(cartItem);
  }


}
