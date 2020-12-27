import { Component, OnInit } from '@angular/core';
import { Booking } from '../../model/booking';
import { BookingService } from '../../services/booking.service';

@Component({
  selector: 'app-new-booking',
  templateUrl: './new-booking.component.html',
  styleUrls: ['./new-booking.component.sass']
})
export class NewBookingComponent implements OnInit {

  myDate= Date.now();
  bookings? : Booking[];

  constructor(private bookingService : BookingService) { }

  ngOnInit(): void {
    this.getBookings();
  }

  private getBookings(){
    this.bookingService.getBookingList().subscribe(data => {
      this.bookings=data;
    });
  }
  
}
