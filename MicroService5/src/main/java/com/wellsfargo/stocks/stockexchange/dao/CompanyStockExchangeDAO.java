package com.wellsfargo.stocks.stockexchange.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.stocks.stockexchange.entity.CompanyStockExchange;

public interface CompanyStockExchangeDAO extends JpaRepository<CompanyStockExchange, Integer>{

}
