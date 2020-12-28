import { Component, OnInit } from '@angular/core';
import { Booking } from 'src/app/Booking/model/booking';
import { BookingService } from 'src/app/Booking/services/booking.service';

@Component({
  selector: 'app-booking-list',
  templateUrl: './booking-list.component.html',
  styleUrls: ['./booking-list.component.sass']
})
export class BookingListComponent implements OnInit {

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
