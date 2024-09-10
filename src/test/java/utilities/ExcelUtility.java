package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	String path;

	public ExcelUtility(String path) {
		this.path=path;
	}


	public int getRowCount(String sheetName) throws IOException {
		
		
		System.out.println("get row count utility");

		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);

		sheet=workbook.getSheet(sheetName)	;
		int rowcount=sheet.getLastRowNum();

		workbook.close();
		fi.close();
		return rowcount;


	}

	public int getCellCount(String sheetName,int rownum) throws IOException {

		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);

		sheet=workbook.getSheet(sheetName)	;
		row=sheet.getRow(rownum);

		int cellcount=row.getLastCellNum();

		workbook.close();
		fi.close();
		return cellcount;


	}

	public void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException {

		File xlfile=new File(path);

		if(!xlfile.exists()) {
			workbook=new XSSFWorkbook();
			fo=new FileOutputStream(path);
			workbook.write(fo);
		}

		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);


		if(workbook.getSheetIndex(sheetName)==-1)
			workbook.createSheet(sheetName);

		sheet=workbook.getSheet(sheetName);



		if(sheet.getRow(rownum)==null)
			sheet.createRow(rownum);
		row=sheet.getRow(rownum);


		cell=row.createCell(colnum);
		cell.setCellValue(data);

		fo=new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();

	}

	
	public String getCellData(String sheetName,int rownum,int cellnum) throws IOException {
		
		workbook=new XSSFWorkbook(path);
		
		sheet=workbook.getSheet(sheetName);//workbook.getSheetAt(0)
		
		int totalrows=sheet.getLastRowNum();
		
		int totalcells=sheet.getRow(1).getLastCellNum();
		
			
		XSSFRow currentrow=	sheet.getRow(rownum);
				
		XSSFCell cell=currentrow.getCell(cellnum);
		String celldata=cell.toString();
		
		workbook.close();
		fi.close();
		
		return celldata;
		
	}
	
	

}
