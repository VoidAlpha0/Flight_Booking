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

@NgModule({
  declarations: [
    AppComponent,
    AdminHomeComponent,
    AdminLoginComponent,
    UserLoginComponent,
    UserRegisterComponent,
    UserHomeComponent,
    
    
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      {path : 'admin', component : AdminHomeComponent},
      {path : 'admin-login', component : AdminLoginComponent},
      {path : 'user-login', component : UserLoginComponent},
      {path : 'user-register', component : UserRegisterComponent},
      {path:'user-home/:userId', component:UserHomeComponent}
    ]),

    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
