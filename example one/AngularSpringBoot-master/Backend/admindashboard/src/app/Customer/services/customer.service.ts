import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule} from '@angular/common/http'
import { Observable} from 'rxjs';
import { map} from 'rxjs/operators';
import { Customer } from '../model/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private baseURL = "http://localhost:8080/api/v1/customers";
  constructor(private httpClient : HttpClient) { }

  getCustomerList(): Observable<Customer[]>{
    return this.httpClient.get<GetResponseCustomers>(this.baseURL).pipe(
      map(response => response._embedded.customers)
    );
  }
}

interface GetResponseCustomers{
  _embedded:{
    customers:Customer[];
  }
}