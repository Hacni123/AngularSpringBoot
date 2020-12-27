import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Booking } from '../../model/booking';
import { BookingService } from '../../services/booking.service';


@Component({
  selector: 'app-booking-view',
  templateUrl: './booking-view.component.html',
  styleUrls: ['./booking-view.component.sass']
})
export class BookingViewComponent implements OnInit {
  reviewId!: number
  bookings!: Booking

  constructor(private route: ActivatedRoute, private bookingService: BookingService) { }

  ngOnInit(): void {
    this.reviewId = this.route.snapshot.params['reviewId'];

    this.bookings = new Booking();
    this.bookingService.getBookingById(this.reviewId).subscribe( data => {
      this.bookings = data;
    });
  }

}
