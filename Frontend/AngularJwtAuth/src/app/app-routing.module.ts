import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { PmComponent } from './pm/pm.component';
import { AdminComponent } from './admin/admin.component';

import { BodyComponent } from './Body/body/body.component';
import { FooterComponent } from './Body/footer/footer.component';
import { HeaderComponent } from './Body/header/header.component';
import { CakeDetailsComponent } from './Categories/Component/cake-details/cake-details.component';
import { CakesAllComponent } from './Categories/Component/cakes-all/cakes-all.component';
import { CartDetailsComponent } from './Categories/Component/cart-details/cart-details.component';
import { PageNotFoundComponent } from './Categories/Component/page-not-found/page-not-found.component';
import { CheckOutComponent } from './Categories/Component/check-out/check-out.component';

const routes: Routes = [
    {
        path: 'home',
        component: BodyComponent
    },
    {
      path: 'home1',
      component: HomeComponent
  },
    {
        path: 'user',
        component: UserComponent
    },
    {
        path: 'pm',
        component: PmComponent
    },
    {
        path: 'admin',
        component: AdminComponent
    },
    {
        path: 'auth/login',
        component: LoginComponent
    },
    {
        path: 'signup',
        component: RegisterComponent
    },
    {
        path: '',
        redirectTo: 'home',
        pathMatch: 'full'
    },
    {
        path:'header',component:HeaderComponent
      },
      {
        path:'footer',component:FooterComponent
      },
      {
        path:'check-out',component:CheckOutComponent
      },
      {
        path: 'cakes-all', component: CakesAllComponent
      },
      {
        path: 'category/:id', component: CakesAllComponent
      },
      {
        path: 'search/:keyword', component: CakesAllComponent
      },
      {
        path: 'cakes-all/:id', component: CakeDetailsComponent
      },
      {
        path: 'cart-details', component: CartDetailsComponent
      },
      {
        path: '**',component: PageNotFoundComponent
      },
];

@NgModule({
    imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
    exports: [RouterModule]
})
export class AppRoutingModule { }
