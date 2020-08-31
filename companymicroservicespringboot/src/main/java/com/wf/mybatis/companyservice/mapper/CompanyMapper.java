package com.wf.mybatis.companyservice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.wf.mybatis.companyservice.model.Company;


@Mapper
public interface CompanyMapper {
	
	@Select("select * from company where company_name like concat('%',#{pat},'%')")
	 List <Company> searchcompany(String pat);
	
	@Delete("delete from company where company_id=#{id}")
	void delete(int id);
	
	@Update("update company set company_name=#{company_name}, turnover=#{turnover}, ceo=#{ceo}, board_of_directors=#{board_of_directors}, write_up=#{write_up}, sector_id={sector_id} where company_id=#{company_id}")
	int update(Company company);
	
	@Insert("insert into company(company_name,turnover,ceo,board_of_directors,write_up,sector_id) "+ " values(#{company_name},#{turnover},#{ceo},#{board_of_directors},#{write_up},#{sector_id})") 	
	int insert(Company company);
	@Select("select * from company WHERE company_name=#{companyName}")
	List<Company> findAll(String companyName );


			
	



	
	
	}
	
	


