import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { HttpModule, JsonpModule } from '@angular/http';
// import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';

import { routing } from './app.routing';

import { IndexComponent } from './index/index.component';
import { ContactComponent } from './contact/contact.component';
// import { CartComponent } from './cart/cart.component';
// import { ProductComponent } from './product/product.component';



@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    ContactComponent
    // ProductComponent,
    // CartComponent
  ],
  imports: [
    BrowserModule,
    routing
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
