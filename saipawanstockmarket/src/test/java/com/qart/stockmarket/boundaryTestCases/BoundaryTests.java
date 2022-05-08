package com.qart.stockmarket.boundaryTestCases;

import java.io.IOException;
import java.io.Serializable;
import java.util.Set;

import static com.qart.stockmarket.utilTestClass.TestUtils.boundaryTestFile;
import static com.qart.stockmarket.utilTestClass.TestUtils.currentTest;
import static com.qart.stockmarket.utilTestClass.TestUtils.testAssert;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.qart.stockmarket.dto.CompanyDetailsDTO;
import com.qart.stockmarket.dto.StockPriceDetailsDTO;
import com.qart.stockmarket.dto.StockPriceIndexDTO;
import com.qart.stockmarket.utilTestClass.MasterData;

@ExtendWith(SpringExtension.class)
public class BoundaryTests implements Serializable{

	private static final long serialVersionUID = 5967325887443106688L;

	private Validator validator;

	@BeforeEach
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testStockExchangeLength() throws Exception 
	{
		CompanyDetailsDTO companyDetails = MasterData.getCompanyDetailsDTO();
		companyDetails.setStockExchange("SE");
		Set<ConstraintViolation<CompanyDetailsDTO>> violations = validator.validate(companyDetails);
		testAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}

	//---------------------------------------------------------------------------------------------	
	@Test
	public void testCompanyNameLength() throws Exception 
	{
		CompanyDetailsDTO companyDetails = MasterData.getCompanyDetailsDTO();
		companyDetails.setCompanyName("CO");
		Set<ConstraintViolation<CompanyDetailsDTO>> violations = validator.validate(companyDetails);
		testAssert(currentTest(),!violations.isEmpty()? true : false, boundaryTestFile);
	}
	//---------------------------------------------------------------------------------------------	
	@Test
	public void testCompanyCEOLength() throws Exception
	{
		CompanyDetailsDTO companyDetails = MasterData.getCompanyDetailsDTO();
		companyDetails.setCompanyCEO("NA");
		Set<ConstraintViolation<CompanyDetailsDTO>> violations = validator.validate(companyDetails);
		testAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
	//---------------------------------------------------------------------------------------------	
	@Test
	public void testTurnoverLength() throws Exception
	{
		CompanyDetailsDTO companyDetails = MasterData.getCompanyDetailsDTO();
		companyDetails.setTurnover(null);
		Set<ConstraintViolation<CompanyDetailsDTO>> violations = validator.validate(companyDetails);
		testAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}	
	//---------------------------------------------------------------------------------------------	
	@Test
	public void testBoardOfDirectorsLength() throws Exception
	{
		CompanyDetailsDTO companyDetails = MasterData.getCompanyDetailsDTO();
		companyDetails.setBoardOfDirectors("AAA");
		Set<ConstraintViolation<CompanyDetailsDTO>> violations = validator.validate(companyDetails);
		testAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
	//---------------------------------------------------------------------------------------------	
	@Test
	public void testCompanyProfileLength() throws Exception
	{
		CompanyDetailsDTO companyDetails = MasterData.getCompanyDetailsDTO();
		companyDetails.setCompanyProfile("Ba");
		Set<ConstraintViolation<CompanyDetailsDTO>> violations = validator.validate(companyDetails);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	//=============================================================================================
	//			1.1 CompanyDetails - Post Company Details Success or Failure
	//=============================================================================================

	//----------------------------------------------------------------------------------------------
	@Test
	public void testPostCompanyDetailsFailed() throws IOException {
		CompanyDetailsDTO companyDetails = MasterData.getCompanyDetailsDTO();
		companyDetails.setCompanyName(null);
		Set<ConstraintViolation<CompanyDetailsDTO>> violations = validator.validate(companyDetails);
		// changed 'true : false' to 'false : true' - 29-09-21
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	//=============================================================================================
	//			2. StockPriceDetails - Validating length of all properties
	//=============================================================================================
	@Test
	public void testCurrentStockPriceLength() throws Exception
	{
		StockPriceDetailsDTO stockPrice = MasterData.getStockPriceDetailsDTO();
		stockPrice.setCurrentStockPrice(null);
		Set<ConstraintViolation<StockPriceDetailsDTO>> violations = validator.validate(stockPrice);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}
	//---------------------------------------------------------------------------------------------	
	@Test
	public void testStockPriceDateLength() throws Exception
	{
		StockPriceDetailsDTO stockPrice = MasterData.getStockPriceDetailsDTO();
		stockPrice.setStockPriceDate(null);
		Set<ConstraintViolation<StockPriceDetailsDTO>> violations = validator.validate(stockPrice);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}
	//---------------------------------------------------------------------------------------------	
	@Test
	public void testStockPriceTimeLength() throws Exception
	{
		StockPriceDetailsDTO stockPrice = MasterData.getStockPriceDetailsDTO();
		stockPrice.setStockPriceTime(null);
		Set<ConstraintViolation<StockPriceDetailsDTO>> violations = validator.validate(stockPrice);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	//=============================================================================================
	//			2.1 StockPriceDetails - Post Stock Price Details Success or Failure
	//=============================================================================================

	//----------------------------------------------------------------------------------------------
	@Test
	public void testPostStockPriceDetailsFailed() throws IOException {
		StockPriceDetailsDTO stockPrice = MasterData.getStockPriceDetailsDTO();
		stockPrice.setCompanyCode(null);
		Set<ConstraintViolation<StockPriceDetailsDTO>> violations = validator.validate(stockPrice);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	//=============================================================================================
	//			3. StockPriceIndexDTO - Validating length of all properties
	//=============================================================================================
	@Test
	public void testStockPriceListLength() throws Exception
	{
		StockPriceIndexDTO stockPriceIndex = MasterData.getStockPriceIndexDTO();
		stockPriceIndex.setStockPriceList(null);
		Set<ConstraintViolation<StockPriceIndexDTO>> violations = validator.validate(stockPriceIndex);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}
	@Test
	public void testMaxStockPriceLength() throws Exception
	{
		StockPriceIndexDTO stockPriceIndex = MasterData.getStockPriceIndexDTO();
		stockPriceIndex.setMaxStockPrice(0.1234567);
		Set<ConstraintViolation<StockPriceIndexDTO>> violations = validator.validate(stockPriceIndex);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}
	@Test
	public void testAvgStockPriceLength() throws Exception
	{
		StockPriceIndexDTO stockPriceIndex = MasterData.getStockPriceIndexDTO();
		stockPriceIndex.setAvgStockPrice(0.1234567);
		Set<ConstraintViolation<StockPriceIndexDTO>> violations = validator.validate(stockPriceIndex);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}
	@Test
	public void testMinStockPriceLength() throws Exception
	{
		StockPriceIndexDTO stockPriceIndex = MasterData.getStockPriceIndexDTO();
		stockPriceIndex.setMinStockPrice(0.1234567);
		Set<ConstraintViolation<StockPriceIndexDTO>> violations = validator.validate(stockPriceIndex);
		testAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}	

}
