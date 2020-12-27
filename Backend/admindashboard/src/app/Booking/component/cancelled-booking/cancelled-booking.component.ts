import { Component, OnInit } from '@angular/core';
import { Booking } from '../../model/booking';
import { BookingService } from '../../services/booking.service';

@Component({
  selector: 'app-cancelled-booking',
  templateUrl: './cancelled-booking.component.html',
  styleUrls: ['./cancelled-booking.component.sass']
})
export class CancelledBookingComponent implements OnInit {

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
