import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule, JsonpModule } from '@angular/http';
import { routing } from '../app/app.routing';
import { AppComponent } from './app.component';
import { ProductsComponent } from './Product/products.component';
import { ProductsService } from './Product/products.service';
import { UserService } from './User/user.service';
import { LoginService } from './login/login.service';
import { LoginComponent } from './login/login.component';
import { userProfileComponent } from './User/userProfile.component';
import { CartService } from './Cart/cart.service';
import { CartComponent } from './Cart/cart.component';
import { SignUpService } from './SignUp/signUp.service';
import { IndexComponent } from './Index/index.component';
import { SignUpComponent } from './SignUp/signup.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    userProfileComponent,
    LoginComponent,
    CartComponent,
    SignUpComponent,
    IndexComponent
    ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    JsonpModule,
    routing,
    
  ],
  providers: [
    ProductsService,
    UserService,
    LoginService,
    CartService,
    SignUpService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
