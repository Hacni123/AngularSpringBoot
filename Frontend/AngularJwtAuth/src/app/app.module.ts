import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { JwPaginationModule } from 'jw-angular-pagination';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { PmComponent } from './pm/pm.component';
import { httpInterceptorProviders } from './auth/auth-interceptor';
import { BodyComponent } from './Body/body/body.component';
import { FooterComponent } from './Body/footer/footer.component';
import { HeaderComponent } from './Body/header/header.component';
import { SearchComponent } from './Categories/Component/search/search.component';
import { CakeDetailsComponent } from './Categories/Component/cake-details/cake-details.component';
import { CakesAllComponent } from './Categories/Component/cakes-all/cakes-all.component';
import { CartDetailsComponent } from './Categories/Component/cart-details/cart-details.component';
import { CartStatusComponent } from './Categories/Component/cart-status/cart-status.component';
import { CategoriesComponent } from './Categories/Component/categories/categories.component';
import { PageNotFoundComponent } from './Categories/Component/page-not-found/page-not-found.component';
import { CheckOutComponent } from './Categories/Component/check-out/check-out.component';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserComponent,
    RegisterComponent,
    HomeComponent,
    AdminComponent,
    PmComponent,
    BodyComponent,
    FooterComponent,
    HeaderComponent,
    SearchComponent,
    CakeDetailsComponent,
    CakesAllComponent,
    CartDetailsComponent,
    CartStatusComponent,
    CategoriesComponent,
    PageNotFoundComponent,
    CheckOutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    JwPaginationModule,
    BsDatepickerModule.forRoot()
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
