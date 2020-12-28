import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule} from '@angular/common/http'
import { Hotel } from '../model/hotel';
import { Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  private baseURL = "http://localhost:8080/api/v1/employees";
  constructor(private httpClient : HttpClient) { }

  getEmployeeList(): Observable<Hotel[]>{
    return this.httpClient.get<Hotel[]>(`${this.baseURL}`);
  }

  createEmployee(employee:Hotel): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`,employee);
  }
}
