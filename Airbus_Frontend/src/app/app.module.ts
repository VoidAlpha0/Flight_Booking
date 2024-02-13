import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { UserHomeComponent } from './user-home/user-home.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UserHomeViewFlightsComponent } from './user-home-view-flights/user-home-view-flights.component';
import { UserHomeUpdateUserComponent } from './user-home-update-user/user-home-update-user.component';
import { UserHomeAddPassComponent } from './user-home-add-pass/user-home-add-pass.component';
import { UserHomeViewPassComponent } from './user-home-view-pass/user-home-view-pass.component';
import { BookSeatsComponent } from './book-seats/book-seats.component';
import { UserHomeShowTicketsComponent } from './user-home-show-tickets/user-home-show-tickets.component';
import { LocationComponent } from './location/location.component';
import { AddFlightComponent } from './add-flight/add-flight.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminHomeComponent,
    AdminLoginComponent,
    UserLoginComponent,
    UserRegisterComponent,
    UserHomeComponent,
    UserHomeViewFlightsComponent,
    UserHomeUpdateUserComponent,
    UserHomeAddPassComponent,
    UserHomeViewPassComponent,
    BookSeatsComponent,
    UserHomeShowTicketsComponent,
    LocationComponent,
    AddFlightComponent,
    
    
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      {path : 'admin', component : AdminHomeComponent},
      {path : 'admin-login', component : AdminLoginComponent},
      {path : 'user-login', component : UserLoginComponent},
      {path : 'user-register', component : UserRegisterComponent},
      {path:'user-home', component:UserHomeComponent},
      {path:'user-viewFlights',component:UserHomeViewFlightsComponent},
      {path:'user-update',component:UserHomeUpdateUserComponent},
      {path:'user-addPassenger',component:UserHomeAddPassComponent},
      {path:'user-viewPass',component:UserHomeViewPassComponent},
      {path:'user-book-seats',component:BookSeatsComponent},
      {path:'user-show-tickets',component:UserHomeShowTicketsComponent},
      {path:'location', component:LocationComponent},
      {path:'add-flight', component:AddFlightComponent}
    ]),

    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
