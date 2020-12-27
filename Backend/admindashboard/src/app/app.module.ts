import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeListComponent } from './Employee/component/employee-list/employee-list.component';
import { HeaderComponent } from './header/header.component';
import { BodyComponent } from './body/body.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { FooterComponent } from './footer/footer.component';
import { HttpClientModule} from '@angular/common/http';
import { BookingListComponent } from './Booking/component/bookinglist/booking-list/booking-list.component';
import { CreateEmployeeComponent } from './Employee/component/create-employee/create-employee.component';
import{FormsModule,ReactiveFormsModule} from '@angular/forms';
import { UpdateEmployeeComponent } from './Employee/component/update-employee/update-employee.component';

import { BookingViewComponent } from './Booking/component/booking-view/booking-view.component';
import { NewBookingComponent } from './Booking/component/new-booking/new-booking.component';
import { CancelledBookingComponent } from './Booking/component/cancelled-booking/cancelled-booking.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    HeaderComponent,
    BodyComponent,
    SidebarComponent,
    FooterComponent,
    BookingListComponent,
    CreateEmployeeComponent,
    UpdateEmployeeComponent,
    BookingViewComponent,
    NewBookingComponent,
    CancelledBookingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
