import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Hotel } from 'src/app/Employee/model/hotel';
import { Booking } from 'src/app/Booking/model/booking';
import { HotelService } from 'src/app/Employee/services/hotel.service';
import { BookingService } from 'src/app/Booking/services/booking.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.sass']
})
export class EmployeeListComponent implements OnInit {

  employees? : Hotel[];
  bookings? : Booking[];

  constructor(private hotelService : HotelService,private bookingService : BookingService,
    private router : Router) { }

  ngOnInit(): void {
  this.getEmployees();
  }

  private getEmployees(){
    this.hotelService.getEmployeeList().subscribe(data => {
      this.employees=data;
    });
    this.hotelService.getEmployeeList().subscribe(data => {
      this.employees=data;
    });
    
  }

  updateEmployee(bookId:number){
    this.router.navigate(['update-employee',bookId]);
  }

  deleteEmployee(bookId:number)
  {
    this.router.navigate(['/employee-list']);
    this.hotelService.deleteEmployee(bookId).subscribe(data => {
      console.log(data);
      this.getEmployees();
      
    });
  }
}
