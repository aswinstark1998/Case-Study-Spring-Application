package com.techprimers.mybatis.springbootmybatis.resource;

import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techprimers.mybatis.springbootmybatis.mapper.IPOMapper;
import com.techprimers.mybatis.springbootmybatis.model.IPO;

@RestController
@RequestMapping("/rest/IPO")
public class IPOResource {

    private IPOMapper ipoMapper;

    public IPOResource(IPOMapper ipoMapper) {
        this.ipoMapper = ipoMapper;
    }


    @GetMapping("/all/{name}")
    public List<IPO> getAll(@PathVariable String name) 
    {
       return ipoMapper.findAll(name);
    }

  @GetMapping("/update/ipoId/{ipoId}/pricePerShare/{pricePerShare}/numOfShares/{numOfShares}/openDate/{Dd}/remarks/{remarks}/company/{company}")
    private void update(@PathVariable int ipoId,@PathVariable float pricePerShare,@PathVariable String numOfShares, @PathVariable String Dd, @PathVariable String remarks, @PathVariable String company) 
  {
        IPO ipo = new IPO();
        ipo.setIpoId(ipoId);
        ipo.setNumOfShares(numOfShares);
        ipo.setRemarks(remarks);
        Date D=Date.valueOf(Dd);
        ipo.setOpenDate(D);
        ipo.setCompany(company);
        ipo.setPricePerShare(pricePerShare);
        //System.out.println(ipoId);
        ipoMapper.update(ipo);

   //   return ipoMapper.findAll("Hiiiii");
    }
}
