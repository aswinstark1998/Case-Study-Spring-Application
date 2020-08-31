package com.wellsfargo.stocks.stockexchange;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.springframework.test.context.junit4.SpringRunner;

import com.wellsfargo.stocks.stockexchange.dao.StockExchangeDAO;
import com.wellsfargo.stocks.stockexchange.entity.Company;
import com.wellsfargo.stocks.stockexchange.entity.Exchange;
import com.wellsfargo.stocks.stockexchange.entity.StockPrice;
import com.wellsfargo.stocks.stockexchange.repo.ExchangeRepo;
import com.wellsfargo.stocks.stockexchange.service.StockExchangeService;

@RunWith(SpringRunner.class)
@SpringBootTest

class StockExchangeServiceTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private StockExchangeService stockExchangeService;
	
	@MockBean
	private ExchangeRepo exchangeRepo;

	private Company company,company2;
	
	@Test
	public void getStockExchangesListTest()
	{
//		Company company = new Company();
//		StockPrice stockPrice = new StockPrice();
		when(exchangeRepo.findAll()).thenReturn(Stream.of(new Exchange(807,"MockBrief","MockAddress","MockWriteUp")).collect(Collectors.toList()));
		assertEquals(1,stockExchangeService.getStockExchangesList().size());
	}

	@Test
	public void addStockExchangeTest()
	{
		company = new Company(12,"dsd","dfd","dfd","sds","rere");
		Exchange exchange = new Exchange(807,"MockBrief","MockAddress","MockWriteUp");
		exchange.getCompany().add(company);
		company.getExchange().add(exchange);
		when(exchangeRepo.save(exchange)).thenReturn(exchange);
		assertEquals(exchange,stockExchangeService.addStockExchange(exchange));
	}
	
	@Test
	public void getCompaniesListTest()
	{
		int id = 132;
		company = new Company(12,"dsd","dfd","dfd","sds","rere");
		company2 = new Company(15,"dcddsd","fddfd","ddffd","sasds","asdrere");
		
		List<Company> companieslist = new ArrayList<Company>();
		companieslist.add(company);
		companieslist.add(company2);
		
		Exchange exchange = new Exchange(132,"MockBrief","MockAddress","MockWriteUp");
		exchange.getCompany().add(company);
		company.getExchange().add(exchange);
		//Mock t = exchangeRepo.findById(id);
		
		Mockito.doReturn(company).when(exchangeRepo).save(exchange).getCompany();
	//	Mockito.when(exchangeRepo.findById(id)).thenReturn(companieslist);
		assertEquals(2,stockExchangeService.getCompaniesList(id).size());
	}
	
}
