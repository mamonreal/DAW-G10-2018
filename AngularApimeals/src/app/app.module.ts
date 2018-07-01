import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule, JsonpModule } from '@angular/http';
import { routing } from '../app/app.routing';

import { AppComponent } from './app.component';
import { HeaderComponent } from './Header/header.component';
import { HomeComponent } from './Home/home.component';
import { ProductComponent } from './Product/product.component';
import { ProductService } from './Product/product.service';
import { UserService } from './User/user.service';
import { LoginService } from './login/login.service';
import { LoginComponent } from './login/login.component';
import { userProfileComponent } from './User/userProfile.component';
import { CartService } from './Cart/cart.service';
import { CartComponent } from './Cart/cart.component';
import { AdminService } from './Admin/admin.service';
import { AdminComponent } from './Admin/admin.component';
import { SignUpService } from './SignUp/signUp.service';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    ProductComponent,
    userProfileComponent,
    LoginComponent,
    CartComponent,
    AdminComponent,
    SignUpComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    JsonpModule,
    routing
  ],
  providers: [
    ProductService,
    UserService,
    LoginService,
    CartService,
    AdminService,
    SignUpService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
