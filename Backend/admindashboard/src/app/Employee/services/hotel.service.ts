import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule} from '@angular/common/http'
import { Hotel } from '../model/hotel';
import { Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HotelService {

  private baseURL = "http://localhost:8080/api/employees";
  constructor(private httpClient : HttpClient) { }

  getEmployeeList(): Observable<Hotel[]>{
    return this.httpClient.get<Hotel[]>(`${this.baseURL}`);
  }

  createEmployee(employee:Hotel): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`,employee);
  }

  getEmployeeById(user_id:number): Observable<Hotel>{
    return this.httpClient.get<Hotel>(`${this.baseURL}/${user_id}`);
  }
  
  updateEmployee(user_id: number, hotel : Hotel): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${user_id}`,hotel);
  }

  deleteEmployee(user_id:number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${user_id}`);
  }
}
