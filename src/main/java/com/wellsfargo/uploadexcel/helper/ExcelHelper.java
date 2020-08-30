package com.wellsfargo.uploadexcel.helper;

import java.io.InputStream;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.wellsfargo.uploadexcel.entity.StockDetailsFromExcel;

public class ExcelHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "company_id", "exchange_id", "price", "date", "time" };
	static String SHEET = "Sheet";

	public static boolean hasExcelFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	public static List<StockDetailsFromExcel> excelToStockDetailsFromExcel(InputStream inputStream) {
		try {
		    Workbook workbook = new XSSFWorkbook(inputStream);

		      Sheet sheet = workbook.getSheet(SHEET);
		      Iterator<Row> rows = sheet.iterator();

		      List<StockDetailsFromExcel> stockDetailsList = new ArrayList<StockDetailsFromExcel>();

		      int rowNumber = 0;
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        // skip header
		        if (rowNumber == 0) {
		          rowNumber++;
		          continue;
		        }
		        CreationHelper createHelper = workbook.getCreationHelper(); 
		        CellStyle cellStyle = workbook.createCellStyle();
		        cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("d-m-yy"));  
		        
		        Iterator<Cell> cellsInRow = currentRow.iterator();

		        StockDetailsFromExcel stockDetail = new StockDetailsFromExcel();

		        int cellIdx = 0;
		        while (cellsInRow.hasNext()) {
		          Cell currentCell = cellsInRow.next();
		        //  System.out.println("CELL TYPE: CELL = "+ cellIdx+ " "+currentCell.getCellType());
		          DataFormatter formatter = new DataFormatter();
		          String formattedCellValue = formatter.formatCellValue(currentCell);
		          switch (cellIdx) {
		          		case 0:
		    //      			stockDetail.setStock_id(cellIdx);
		          			System.out.println("ERROR CELL TYPE: CELL = SETCOMPANY_CODE"+ cellIdx+ " "+currentCell.getCellType());
		          			stockDetail.setCompanyCode(formattedCellValue);
		          			break;

		          		case 1:
		          			//System.out.println("ERROR CELL TYPE: CELL = SET_STOCK_EXCHANGE"+ cellIdx+ " "+currentCell.getCellType());
		          			stockDetail.setStockExchangeCode(formattedCellValue);
		          			break;

		          		case 2:
		          			//System.out.println("ERROR CELL TYPE: CELL = SET_PRICE"+ cellIdx+ " "+currentCell.getCellType());
		          			stockDetail.setPricePerShare(formattedCellValue);
		          			break;

		          		case 3:
		          			//System.out.println("ERROR CELL TYPE: CELL = SET_DATE"+ cellIdx+ " "+currentCell.getCellType());
		          			stockDetail.setDate(formattedCellValue);
		          			break;
		          
		          		case 4:
		          			//System.out.println("ERROR CELL TYPE: CELL = SET_TIME"+ cellIdx+ " "+currentCell.getCellType());
		          			stockDetail.setTime(formattedCellValue);
		          			break;

		          		default:
		          			break;
		          }
		          cellIdx++;
		        }
		        stockDetailsList.add(stockDetail);
		    }
		    workbook.close();
		    return stockDetailsList;
		}catch (Exception e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
		
	}
}