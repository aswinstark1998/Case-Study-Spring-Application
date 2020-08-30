
package com.wellsfargo.uploadexcel.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.wellsfargo.uploadexcel.entity.StockDetailsFromExcel;
import com.wellsfargo.uploadexcel.helper.ExcelHelper;

@Repository
public class StockDetailsDaoHibernateImpl implements StockDetailsDAO {

	// define field for entity manager
	private EntityManager entityManager;
	
	@Autowired
	public StockDetailsDaoHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void save(List<StockDetailsFromExcel> stockDetailsFromExcelList) {
		Session currentSession = entityManager.unwrap(Session.class);
		//List<StockDetailsFromExcel> details = ExcelHelper.excelToStockDetailsFromExcel(stockDetailsFromExcel.getInputStream());
		for(StockDetailsFromExcel singleObjectDetail : stockDetailsFromExcelList) {
		    currentSession.save(singleObjectDetail);
		}
	}
}