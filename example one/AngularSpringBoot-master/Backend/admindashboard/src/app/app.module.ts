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
import{FormsModule} from '@angular/forms';
import { CustomerListComponent } from './Customer/component/customer-list/customer-list.component';
import{BookingService} from './Booking/services/booking.service';

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
    CustomerListComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [BookingService],
  bootstrap: [AppComponent]
})
export class AppModule { }
