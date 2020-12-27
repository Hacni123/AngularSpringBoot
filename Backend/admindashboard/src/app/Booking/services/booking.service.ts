import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule} from '@angular/common/http'
import { Observable} from 'rxjs';
import { Booking } from '../model/booking';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  private baseURL = "http://localhost:8080/api/review";
  constructor(private httpClient : HttpClient) { }

  getBookingList(): Observable<Booking[]>{
    return this.httpClient.get<Booking[]>(`${this.baseURL}`);
  }

  getBookingById(reviewId:number): Observable<Booking>{
    return this.httpClient.get<Booking>(`${this.baseURL}/${reviewId}`);
  }
  
  updateBooking(reviewId: number, hotel : Booking): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${reviewId}`,hotel);
  }
  
}
