import { Component, OnInit } from '@angular/core';
import { Categorymodel } from '../../Model/categorymodel';
import { CakeService } from '../../Service/cake.service';


@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {
  categories: Categorymodel[] = [];
  constructor(private cakeService: CakeService) { }

  ngOnInit(): void {
    this.listCakeCategories();
  }

  listCakeCategories(){
    this.cakeService.getCakeCategories().subscribe(
      data => this.categories = data
    );
  }
  
}
