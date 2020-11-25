import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Hotel } from '../../model/hotel';
import { HotelService } from '../../services/hotel.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.sass']
})
export class CreateEmployeeComponent implements OnInit {

  employee : Hotel= new Hotel();

  constructor(private hotelService : HotelService, private router: Router) { }

  ngOnInit(): void {
  }

  saveEmploee(){
    this.hotelService.createEmployee(this.employee).subscribe(data =>{
      console.log(data);
      this.gotoEmployeeList();
    },
    error => console.log(error));
  }

   gotoEmployeeList(){
     this.router.navigate(['/employees']);
   }

  onSubmit(){
    this.saveEmploee();
  }

}
