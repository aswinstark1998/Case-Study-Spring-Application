package com.wellsfargo.uploadexcel.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.wellsfargo.uploadexcel.entity.StockDetailsFromExcel;

public interface StockDetailsDAO {
	public void save(List<StockDetailsFromExcel> stockDetailsFromExcelList);
}
