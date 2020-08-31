package com.techprimers.mybatis.springbootmybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.techprimers.mybatis.springbootmybatis.model.IPO;
@Mapper
public interface IPOMapper {

    @Select("select * from IPO WHERE companyName=#{companyName} ORDER BY openDate")
	List<IPO> findAll(String companyName );
	//@Select("select * from IPO WHERE remarks=#{name} ORDER BY openDate")
	//List<IPO> findAll(String name);

	
@Update("Update IPO set pricePerShare=#{pricePerShare}, numOfShares=#{numOfShares}, "+" openDate=#{openDate}, "+" remarks=#{remarks} where companyName=#{companyName}")
	    public int update(IPO ip);
	
  //  @Insert("insert into users(name,salary) values(#{name},#{salary})")
  //  @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
    //        before = false, resultType = Integer.class)
    //void insert(Users users);
}
