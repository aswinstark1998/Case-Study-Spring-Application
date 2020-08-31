package com.techprimers.mybatis.springbootmybatis.resource;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.techprimers.mybatis.springbootmybatis.mapper.CompanyMapper;
import com.techprimers.mybatis.springbootmybatis.model.Company;

@RestController
public class CompanyResource {
	private CompanyMapper companyMapper;

	public CompanyResource(CompanyMapper companyMapper) {
		// TODO Auto-generated constructor stub
		this.companyMapper=companyMapper;
	}
	
	@GetMapping("/searchcompany/{pat}")
	public List <Company> searchcomp(@PathVariable String pat)
	{
		return companyMapper.searchcompany(pat);
	}
	
	
	@GetMapping("/deactivate/{id}")
	public boolean deleteById(@PathVariable int id) 
	{
	   companyMapper.delete(id);
	   return true;
	}
	
	@GetMapping("/update/companyId/{companyId}/companyName/{companyName}/turnover/{turnover}/ceo/{ceo}/bod/{bod}/writeUp/{writeUp}/sectorId/{sectorId}")
	 public int updatecompany(@PathVariable int companyId,@PathVariable String companyName,@PathVariable String turnover, @PathVariable String ceo, @PathVariable String bod, @PathVariable String writeUp,@PathVariable int sectorId) 
	{
	      Company c = new Company();
	      c.setCompany_id(companyId);
	      c.setCompany_name(companyName);
	      c.setTurnover(turnover);
	      c.setCeo(ceo);
	      c.setBoard_of_directors(bod);
	      c.setWrite_up(writeUp);
	      c.setSector_id(sectorId);   
	      return companyMapper.update(c);


	  }
	
	@GetMapping("/insert/companyName/{companyName}/turnover/{turnover}/ceo/{ceo}/bod/{bod}/writeUp/{writeUp}/sectorId/{sectorId}")
	  private void insert(@PathVariable String companyName,@PathVariable String turnover, @PathVariable String ceo, @PathVariable String bod, @PathVariable String writeUp,@PathVariable int sectorId) 
	{
	      Company c = new Company();
	      c.setCompany_name(companyName);

	      c.setTurnover(turnover);
	      c.setCeo(ceo);
	      c.setBoard_of_directors(bod);
	      c.setWrite_up(writeUp);
	      c.setSector_id(sectorId);
	      companyMapper.insert(c);

	  }
	
	@GetMapping("/companyall/{name}")
    public List<Company> getAll(@PathVariable String name) 
    {
       return companyMapper.findAll(name);
    }
	
	

}
