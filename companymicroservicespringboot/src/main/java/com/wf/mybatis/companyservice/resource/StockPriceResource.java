package com.wf.mybatis.companyservice.resource;
import java.util.List;

import java.sql.Date;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wf.mybatis.companyservice.mapper.StockPriceMapper;
import com.wf.mybatis.companyservice.model.StockPrice;

@RestController
public class StockPriceResource {
	private StockPriceMapper stockpriceMapper;


	public StockPriceResource(StockPriceMapper stockpriceMapper) {
		// TODO Auto-generated constructor stub
		this.stockpriceMapper=stockpriceMapper;
	}
	
	@GetMapping("/stockprice/cid/{cid}/from/{fromdate}/to/{todate}")
    public List<StockPrice> getstockprice(@PathVariable int cid,@PathVariable String fromdate,@PathVariable String todate)
    {
		Date Fromdate=Date.valueOf(fromdate);
		Date Todate=Date.valueOf(todate);
		System.out.println(Fromdate);
		return stockpriceMapper.findAllprices(cid,Fromdate,Todate);
		
    		   	
    }
		

}
