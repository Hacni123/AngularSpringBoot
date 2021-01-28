import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SignUpInfo } from 'src/app/auth/signup-info';
import { Cakemodel } from '../Model/cakemodel';
import { Categorymodel } from '../Model/categorymodel';
import { map } from 'rxjs/operators';
import { Order } from 'src/app/Categories/Model/order';

@Injectable({
  providedIn: 'root'
})
export class CakeService {

  private baseURL = "http://localhost:8080/api/auth/cakes";
  private categoryUrl = "http://localhost:8080/api/auth/cake-category";
  private user = "http://localhost:8080/api/auth/findby";
  private order = "http://localhost:8080/api/auth/orders";

  constructor(private httpClient : HttpClient) { }

  getCakeList(currentCategoryId: number): Observable<Cakemodel[]>{
    const searchUrl =`${this.baseURL}/search/id?id=${currentCategoryId}`;
    return this.getCakes(searchUrl);
  }
  
  private getCakes(searchUrl: string): Observable<Cakemodel[]> {
    return this.httpClient.get<GetResponseCakes>(searchUrl).pipe(
      map(response => response._embedded.cakes)
    );
  }

  searchBooks(keyword: string): Observable<Cakemodel[]>{
    const searchUrl = `${this.baseURL}/search/searchbykeyword?name=${keyword}`;
    //return this.getBooksList(searchUrl);
    return this.getCakes(searchUrl);
  }

  get(cakeId: number): Observable<Cakemodel> {
    const cakeDetailsUrl = `${this.baseURL}/${cakeId}`;
    return this.httpClient.get<Cakemodel>(cakeDetailsUrl);
  }

  getUsers(username: String): Observable<SignUpInfo> {
    const cakeDetailsUrl = `${this.user}/${username}`;
    return this.httpClient.get<SignUpInfo>(cakeDetailsUrl);
  }

  createOrder(order:Order): Observable<Object>{
    return this.httpClient.post(`${this.order}`,order);
  }

  getCakeById(id:number): Observable<Cakemodel>{
    return this.httpClient.get<Cakemodel>(`${this.baseURL}/${id}`);
  }
  
  updateCake(id: number, cake : Cakemodel): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`,cake);
  }

  deleteCake(id:number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }

 getCakeCategories(): Observable<Categorymodel[]>{
    return this.httpClient.get<GetResponseCategory>(this.categoryUrl).pipe(
      map(response => response._embedded.cakeCateogry)
    );
  }
  
  createCategory(cake:Categorymodel): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`,cake);
  }

  getCategoryById(id:number): Observable<Categorymodel>{
    return this.httpClient.get<Categorymodel>(`${this.baseURL}/${id}`);
  }
  
  updateCategory(id: number, cake : Categorymodel): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`,cake);
  }

  deleteCategory(id:number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}

interface GetResponseCakes{
  _embedded: {
    cakes: Cakemodel[];
  }
}


interface GetResponseCategory{
  _embedded: {
    cakeCateogry: Categorymodel[];
  }
}

interface GetResponseUser{
  _embedded: {
    SignUpInfo: SignUpInfo[];
  }
}