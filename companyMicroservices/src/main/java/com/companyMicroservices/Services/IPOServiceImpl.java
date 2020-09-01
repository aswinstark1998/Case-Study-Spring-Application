package com.companyMicroservices.Services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyMicroservices.Model.IPO;
import com.companyMicroservices.Repository.IPORepository;

@Service
public class IPOServiceImpl implements IPOService 
{
	  @Autowired
	  IPORepository ipoRepository;
	  

	    @Override
		public List<IPO> getIpo(int id)
		{
	    	
			List<IPO> results = ipoRepository.searchIpo(id);
			return results;
			
		}
	    
	    @Override
	    public IPO updateIpo(String ipo_id,String num_of_shares,String D,Float price_per_share,String remarks,int company_id)
	    {
	    	int id=Integer.parseInt(ipo_id);
	    	IPO oldipo = ipoRepository.getOne(id);
	        oldipo.setNum_of_shares(num_of_shares);
	       
	     
	        Date ts=Date.valueOf(D);
	        oldipo.setOpen_date(ts);
	        oldipo.setPrice_per_share(price_per_share);
	        oldipo.setRemarks(remarks);
	        oldipo.setCompany_id(company_id);	        
	        return ipoRepository.save(oldipo);
	    }

	    
}


   
   

   