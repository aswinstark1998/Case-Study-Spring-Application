package com.wellsfargo.stocks.stockexchange.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.stocks.stockexchange.dao.ExchangeDAO;
import com.wellsfargo.stocks.stockexchange.entity.Company;
import com.wellsfargo.stocks.stockexchange.entity.Exchange;

@Service
public class StockExchangeService {
	@Autowired
	private ExchangeDAO stockExchangeDAO;
	

	
	public List<Exchange> retrieveAllData() {
		List<Exchange> exchangeListing = new ArrayList<>();
		stockExchangeDAO.findAll().forEach(exchangeListing::add);  // lambda expression
		return exchangeListing;
	}
	
	public void saveExchange(Exchange exchange){
		stockExchangeDAO.save(exchange);
	}
	 @PersistenceContext
	  private EntityManager em;

	 public Exchange findById(int id) {
		 
		 
		
		 Exchange exchange  =em.find(Exchange.class, id);
	        if (exchange == null) {
	            throw new EntityNotFoundException("Can't find Exchange for ID "
	                + id);
	        }
	        

	        return exchange;
	    }

	public List<Company> getCompanyById(int id) {
		Exchange exchange = findById(id);
		
		List<Company> companylist = new ArrayList<Company>();
		companylist = exchange.getCompany();
		return companylist;
	}
	 
}
