package com.companyMicroservices.Controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.companyMicroservices.Model.IPO;
import com.companyMicroservices.Services.IPOServiceImpl;


@RestController
public class IPOController 
{
	@Autowired
	IPOServiceImpl iposervice;
	
	
	
	 @GetMapping("/getipo/{id}")
	    public List<IPO> getIpo(@PathVariable int id)
	    {
	        return iposervice.getIpo(id);
	    }
	 
	 @PutMapping("/updateipo/{id}")
	    public IPO updateIpo(@PathVariable int id,  @RequestBody Map<String, String> body)
	    {
		String s=body.get("ipo_id");
		String num_of_shares=body.get("num_of_shares");
		String Dd=body.get("open_date");
	    String pps = body.get("price_per_share");
		Float price_per_share=Float.parseFloat(pps);
	    String remarks = body.get("remarks");
	    String companyid=body.get("company_id");
	    int company_id=Integer.parseInt(companyid);

	    return iposervice.updateIpo(s,num_of_shares,Dd,price_per_share,remarks,company_id);
	    }

	
}


