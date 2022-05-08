import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})

export class StockpriceService {
  private baseUrl = 'http://localhost:8081/e-stock/api/v1/stock/getStockByCompanyCode';
  
  constructor(private http: HttpClient ) { }

  getCompanyStockDetails(code:number):Observable<any> {
    console.log(this.baseUrl);
    console.log(code);
    return this.http.get(`${this.baseUrl}/${code}`);
  }
  
}
