package com.wellsfargo.stocks.stockexchange.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.stocks.stockexchange.entity.Exchange;

public interface ExchangeDAO extends JpaRepository<Exchange, Integer> {
	public Exchange findById(int id);
}
