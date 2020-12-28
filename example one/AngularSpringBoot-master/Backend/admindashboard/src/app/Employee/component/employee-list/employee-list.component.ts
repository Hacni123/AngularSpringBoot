import { Component, OnInit } from '@angular/core';
import { Hotel } from 'src/app/Employee/model/hotel';
import { HotelService } from 'src/app/Employee/services/hotel.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.sass']
})
export class EmployeeListComponent implements OnInit {

  employees? : Hotel[];

  constructor(private hotelService : HotelService) { }

  ngOnInit(): void {
  this.getEmployees();
  }

  private getEmployees(){
    this.hotelService.getEmployeeList().subscribe(data => {
      this.employees=data;
    });
  }

}
