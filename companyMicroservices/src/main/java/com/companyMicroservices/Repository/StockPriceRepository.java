package com.companyMicroservices.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.companyMicroservices.Model.StockPrice;




public interface StockPriceRepository extends JpaRepository<StockPrice, Integer>
{

	@Query("SELECT s FROM StockPrice s WHERE s.company_id=?1 AND s.date BETWEEN ?2 AND ?3")
	List<StockPrice> getStockPrice(int company_id,Date fromdate,Date todate);
	

}