package com.wellsfargo.stock.stockexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wellsfargo.stock.stockexchange.dao.DataAccessInterface;
import com.wellsfargo.stock.stockexchange.dao.StockExchangeDAO;

@Controller
public class StockExchangeController {
	
	
	@Autowired 
	DataAccessInterface stockexchangedao;
	
	@RequestMapping("/")
	public String home()
	{
		return "AddStocks.jsp";
		
	}
	
	@RequestMapping("/addStockExchange")
	public String addstockexchange(StockExchangeDAO stockinfo)
	{
		stockexchangedao.save(stockinfo);
		return "AddStocks.jsp";	
		
		
		
	}

}
