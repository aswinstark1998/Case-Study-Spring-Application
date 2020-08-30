package com.wellsfargo.uploadexcel.service;

import org.springframework.web.multipart.MultipartFile;

import com.wellsfargo.uploadexcel.entity.StockDetailsFromExcel;

public interface UploadExcelService {
	public void save(MultipartFile stockDetailsFromExcel);
}
