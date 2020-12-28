import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Hotel } from 'src/app/Employee/model/hotel';
import { HotelService } from 'src/app/Employee/services/hotel.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.sass']
})
export class EmployeeListComponent implements OnInit {

  employees? : Hotel[];

  constructor(private hotelService : HotelService,
    private router : Router) { }

  ngOnInit(): void {
  this.getEmployees();
  }

  private getEmployees(){
    this.hotelService.getEmployeeList().subscribe(data => {
      this.employees=data;
    });
    
  }

  updateEmployee(user_id:number){
    this.router.navigate(['update-employee',user_id]);
  }

  deleteEmployee(user_id:number)
  {
    this.router.navigate(['/employee-list']);
    this.hotelService.deleteEmployee(user_id).subscribe(data => {
      console.log(data);
      this.getEmployees();
      
    });
  }
}
