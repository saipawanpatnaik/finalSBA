import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { StockpriceService } from '../stockprice.service';

@Component({
  selector: 'app-company-stock-details',
  templateUrl: './company-stock-details.component.html',
  styleUrls: ['./company-stock-details.component.css']
})
export class CompanyStockDetailsComponent implements OnInit {
  
  stockpricelist: any;
  errorMsg!:string;
  stockform = this.formBuilder.group({
    name: ''
  });

  constructor(private stockpriceservice: StockpriceService,  private formBuilder: FormBuilder) { }

  ngOnInit(): void {
  }

   onSubmit()
  {
   this.stockpriceservice.getCompanyStockDetails( this.stockform.value.name).subscribe(item =>
    {
      this.stockpricelist=item;  
    }, (error) => {                              
      console.error(
        this.errorMsg=`${error.error.message}`);
    });
  }

  reloadPage() {
    window.location.reload();
   }
}