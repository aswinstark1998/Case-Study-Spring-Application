package com.wellsfargo.uploadexcel.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wellsfargo.uploadexcel.dao.StockDetailsDAO;
import com.wellsfargo.uploadexcel.entity.StockDetailsFromExcel;
import com.wellsfargo.uploadexcel.helper.ExcelHelper;

@Service
public class uploadExcelServiceImpl implements UploadExcelService {

	private StockDetailsDAO stockDAO;
	
	@Autowired
	public uploadExcelServiceImpl(StockDetailsDAO stockDAO) {
		this.stockDAO = stockDAO;
	}

	@Override
	@Transactional
	public void save(MultipartFile stockDetailsFromExcel) {
		try {
		     List<StockDetailsFromExcel> details = ExcelHelper.excelToStockDetailsFromExcel(stockDetailsFromExcel.getInputStream());
		      stockDAO.save(details);
		}catch (RuntimeException e) {
		      throw new RuntimeException("fail to store excel data: " + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
