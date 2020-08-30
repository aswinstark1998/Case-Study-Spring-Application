package com.wellsfargo.stocks.stockexchange.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.stocks.stockexchange.entity.Company;

public interface CompanyDAO extends JpaRepository<Company, Integer>{

}
