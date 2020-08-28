package com.wellsfargo.stock.stockexchange.dao;

import org.springframework.data.repository.CrudRepository;

public interface DataAccessInterface extends CrudRepository<StockExchangeDAO, Integer> {

	
}
