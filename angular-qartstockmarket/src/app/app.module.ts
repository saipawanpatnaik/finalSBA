import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClient, HttpClientModule } from '@angular/common/http';
//import { AppRoutingModule } from './app-routing.module';


import { AppComponent } from './app.component';
import { CompanyStockDetailsComponent } from './company-stock-details/company-stock-details.component';

@NgModule({
  declarations: [
    AppComponent,
    CompanyStockDetailsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    //AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
