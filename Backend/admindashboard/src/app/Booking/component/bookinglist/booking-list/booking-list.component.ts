import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Booking } from 'src/app/Booking/model/booking';
import { BookingService } from 'src/app/Booking/services/booking.service';

@Component({
  selector: 'app-booking-list',
  templateUrl: './booking-list.component.html',
  styleUrls: ['./booking-list.component.sass']
})
export class BookingListComponent implements OnInit {

  myDate= Date.now();
  bookings? : Booking[];

  constructor(private bookingService : BookingService, private router : Router) { }

  ngOnInit(): void {
    this.getBookings();
  }

  private getBookings(){
    this.bookingService.getBookingList().subscribe(data => {
      this.bookings=data;
    });
  }
  
  viewBooking(order_id: number){
    this.router.navigate(['view-booking', order_id]);
  }
}
