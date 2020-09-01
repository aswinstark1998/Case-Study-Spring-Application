package com.companyMicroservices.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.companyMicroservices.Model.Company;

import com.companyMicroservices.Repository.CompanyRepository;
import com.companyMicroservices.Services.CompanyServiceImpl;
@RestController
public class CompanyController {
	
	@Autowired
	CompanyServiceImpl companyservice;
	
	@Autowired
	CompanyRepository companyrepository;
	
	@GetMapping("/getcompany/{id}")
	public Company getCompany(@PathVariable Integer id){
		return companyservice.getCompanyById(id);
	}
	
	@GetMapping("/searchcompany/{pattern}")
		public List<Company> searchcompany(@PathVariable String pattern)
		{
			return companyservice.searchCompany(pattern);
		}
	@PostMapping("/insertcompany")
    public void createCompany(@RequestBody Map<String, String> body)
   {
	
	String company_name = body.get("company_name");
	String turnover = body.get("turnover");
	String ceo = body.get("ceo");
	String board_of_directors = body.get("board_of_directors");
	String write_up= body.get("write_up");
	String sector_id = body.get("sector_id");

        companyservice.createCompany(company_name,turnover,ceo,board_of_directors,write_up,sector_id);
    }
	@DeleteMapping("/deactivatecompany/{id}")
	public void deleteCompany(@PathVariable Integer id){

		companyservice.deleteCompany(id);
	}

	

}
