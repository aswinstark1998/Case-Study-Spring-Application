package com.wellsfargo.uploadexcel.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wellsfargo.uploadexcel.helper.ExcelHelper;
import com.wellsfargo.uploadexcel.service.UploadExcelService;

@CrossOrigin("http://localhost:8081")
@RestController
@RequestMapping("/api/excel")
public class UploadExcelFileController {
	
	private UploadExcelService uploadExcelService;
	
	@Autowired
	public UploadExcelFileController(UploadExcelService uploadExcelService) {
		this.uploadExcelService = uploadExcelService;
	}
	
	 @PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";

	    if (ExcelHelper.hasExcelFormat(file)) {
	      try {
	        uploadExcelService.save(file);

	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	      } catch (Exception e) {
	    	  e.printStackTrace();
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	      }
	    }

	    message = "Please upload an excel file!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	 }
}
