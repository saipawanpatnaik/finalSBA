import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompanyStockDetailsComponent } from './company-stock-details.component';

describe('CompanyStockDetailsComponent', () => {
  let component: CompanyStockDetailsComponent;
  let fixture: ComponentFixture<CompanyStockDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CompanyStockDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CompanyStockDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
