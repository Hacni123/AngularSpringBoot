import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EmployeeListComponent} from './Employee/component/employee-list/employee-list.component';
import {BodyComponent} from './body/body.component';
import { BookingListComponent } from './Booking/component/bookinglist/booking-list/booking-list.component';
import { CreateEmployeeComponent } from './Employee/component/create-employee/create-employee.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { UpdateEmployeeComponent } from './Employee/component/update-employee/update-employee.component';
import { NewBookingComponent } from './Booking/component/new-booking/new-booking.component';
import { CancelledBookingComponent } from './Booking/component/cancelled-booking/cancelled-booking.component';
import { BookingViewComponent } from './Booking/component/booking-view/booking-view.component';

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
    path:'update-employee/:id',component:UpdateEmployeeComponent
  },
  {
    path:'new-booking',component:NewBookingComponent
  },
  {
    path:'cancelled-booking',component:CancelledBookingComponent
  },
  {
    path:'view-booking/:id',component:BookingViewComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
