import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule} from '@angular/common/http'
import { Observable} from 'rxjs';
import { Booking } from '../model/booking';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  private baseURL = "http://localhost:8080/api/v1/orders";
  constructor(private httpClient : HttpClient) { }

  getBookingList(): Observable<Booking[]>{
    return this.httpClient.get<Booking[]>(`${this.baseURL}`);
  }

  getBookingById(order_id:number): Observable<Booking>{
    return this.httpClient.get<Booking>(`${this.baseURL}/${order_id}`);
  }
  
  updateBooking(order_id: number, hotel : Booking): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${order_id}`,hotel);
  }
  
}
