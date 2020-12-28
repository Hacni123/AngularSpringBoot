import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {ServicesComponent} from './services/services.component';
import {ContactComponent} from './contact/contact.component';
import {RegistrationComponent} from './registration/registration.component';
import {LoginComponent} from './login/login.component';
import {BlogComponent} from './blog/blog.component';
import {HotellistComponent} from './hotellist/hotellist.component';

const routes: Routes = [
  {
    path:'',component:HomeComponent
  },
  {
    path:'services',component:ServicesComponent
  },
  {
    path:'contact',component:ContactComponent
  },
  {
    path:'hotellist',component:HotellistComponent
  },
  {
    path:'registration',component:RegistrationComponent
  },
  {
    path:'login',component:LoginComponent
  },
  {
    path:'blog',component:BlogComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
