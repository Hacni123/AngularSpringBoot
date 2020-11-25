import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule} from '@angular/common/http'
import { Observable} from 'rxjs';
import { Booking } from '../model/booking';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  private baseURL = "http://localhost:8080/api/v1/bookings";
  constructor(private httpClient : HttpClient) { }

  getBookingList(): Observable<Booking[]>{
    return this.httpClient.get<Booking[]>(`${this.baseURL}`);
  }
}
