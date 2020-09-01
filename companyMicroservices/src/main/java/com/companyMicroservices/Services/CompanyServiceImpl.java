package com.companyMicroservices.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Service;
import com.companyMicroservices.Model.Company;
import java.util.List;
import com.companyMicroservices.Repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService
{
	@Autowired CompanyRepository companyrepository;
	
	@Override
	public List<Company> searchCompany(String pattern)
	{

		List<Company> results = companyrepository.searchCompany(pattern);
		return results;
		
	}
	
	@Override
    public void createCompany(String company_name, String turnover, String ceo, String board_of_directors, String write_up, String sector_id) 
    {
         
          
          int s_id= Integer.parseInt(sector_id);

          Company c = new Company();
     	  c.setCompany_name(company_name);
			c.setTurnover(turnover);
			c.setCeo(ceo);
			c.setBoard_of_directors(board_of_directors);
			c.setWrite_up(write_up);
			c.setSector_id(s_id);
          
	       companyrepository.save(c);

    }
	@Override
	 public Company getCompanyById(Integer id) {
	        return companyrepository.findById(id).get();
	    }
	@Override
	 public void deleteCompany(Integer id) {
        companyrepository.deleteById(id);
    }
}