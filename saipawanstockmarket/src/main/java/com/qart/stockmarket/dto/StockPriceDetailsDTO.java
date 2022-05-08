package com.qart.stockmarket.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import com.fasterxml.jackson.annotation.JsonFormat;

public class StockPriceDetailsDTO {
	

	@Column
	private Long Id;
	
	@NotNull
	private Long companyCode;
	
	@NotNull(message = "Please enter Current Stock Price")
    @Column(precision=10, scale=2)
	private Double currentStockPrice;
	
	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    @PastOrPresent
    @NotNull
	private LocalDate stockPriceDate;
	
	//@Temporal(TemporalType.TIME)
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="hh:mm:ss a")
	@PastOrPresent
    @NotNull
	private LocalTime stockPriceTime;
	

	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}
	public Long getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(Long companyCode) {
		this.companyCode = companyCode;
	}
	public Double getCurrentStockPrice() {
		return currentStockPrice;
	}
	public void setCurrentStockPrice(Double currentStockPrice) {
		this.currentStockPrice = currentStockPrice;
	}
	public LocalDate getStockPriceDate() {
		return stockPriceDate;
	}
	public void setStockPriceDate(LocalDate stockPriceDate) {
		this.stockPriceDate = stockPriceDate;
	}
	public LocalTime getStockPriceTime() {
		return stockPriceTime;
	}
	public void setStockPriceTime(LocalTime stockPriceTime) {
		this.stockPriceTime = stockPriceTime;
	}
}
