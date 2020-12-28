import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EmployeeListComponent} from './Employee/component/employee-list/employee-list.component';
import {BodyComponent} from './body/body.component';
import { BookingListComponent } from './Booking/component/bookinglist/booking-list/booking-list.component';
import { CreateEmployeeComponent } from './Employee/component/create-employee/create-employee.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { CustomerListComponent } from './Customer/component/customer-list/customer-list.component';

const routes: Routes = [
  {
    path:'',component:BodyComponent
  },
  {
    path:'employee-list',component:EmployeeListComponent
  },
  {
    path:'booking-list',component:BookingListComponent
  },
  {
    path:'create-employee',component:CreateEmployeeComponent
  },
  {
    path:'footer',component:FooterComponent
  },
  {
    path:'header',component:HeaderComponent
  },
  {
    path:'customer-list',component:CustomerListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
