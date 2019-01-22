package com.report.ServiceReporting.utils;

import com.report.ServiceReporting.controller.GraphController2018;
import com.report.ServiceReporting.dto.Graphs2018DTO;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;



public class ReadExcelToObject {
	private static final Logger logger = LoggerFactory.getLogger(ReadExcelToObject.class);
	
	
	public ArrayList<Graphs2018DTO> readExcelFileToObject(MultipartFile excelFile) throws FileNotFoundException, IOException{    
		InputStream ExcelFileToRead = new FileInputStream(convert(excelFile));
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		ArrayList<Graphs2018DTO> oListScheduler = new ArrayList<Graphs2018DTO>();
		Graphs2018DTO objScheduler = new Graphs2018DTO();
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		XSSFWorkbook test = new XSSFWorkbook(); 
		
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;

		Iterator rows = sheet.rowIterator();
		int counter = 0;
		while (rows.hasNext())
		{
			counter++;
			if (counter>=3) {
				
			
			objScheduler = new Graphs2018DTO();
			row=(XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			while (cells.hasNext())
			{
				
				 
				cell=(XSSFCell) cells.next();
				
				//Business Unit
				if (cell.getColumnIndex() == 0) {
					System.out.print(cell.getStringCellValue());
					objScheduler.setBUSINESS_UNITS(cell.getStringCellValue());
				}
				//Clarity
				else if (cell.getColumnIndex() == 1) {
					System.out.print(cell.getStringCellValue());
					objScheduler.setCLARITY(cell.getStringCellValue());
				}
				//GADGET_ID
				else if (cell.getColumnIndex() == 2) {
					System.out.print(cell.getStringCellValue());
					objScheduler.setGADGET_ID(cell.getStringCellValue());
				}
				
				//Application
				else if (cell.getColumnIndex() == 3) {
					System.out.print(cell.getStringCellValue());
					objScheduler.setAPPLICATION(cell.getStringCellValue());
				}
				
				//Gadget Category
				else if (cell.getColumnIndex() == 4) {
					System.out.print(cell.getStringCellValue());
					objScheduler.setAPPLICATION(cell.getStringCellValue());
				}
				
				//Everis Delivery Gadget Owner
				else if (cell.getColumnIndex() == 5) {
					System.out.print(cell.getStringCellValue());
					objScheduler.setAPPLICATION(cell.getStringCellValue());
				}
				
				//Everis Delivery Model
				else if (cell.getColumnIndex() == 6) {
					System.out.print(cell.getStringCellValue());
					objScheduler.setDELIVERY_MODEL(cell.getStringCellValue());
				}
				
				//Everis Demand Type
				else if (cell.getColumnIndex() == 7) {
					System.out.print(cell.getStringCellValue());
					objScheduler.setDEMAND_TYPE(cell.getStringCellValue());
				}
				
				//Everis Description
				else if (cell.getColumnIndex() == 8) {
					System.out.print(cell.getStringCellValue());
					objScheduler.setDESCRIPTION(cell.getStringCellValue());
				}
				
				//Everis Status
				else if (cell.getColumnIndex() == 9) {
					System.out.print(cell.getStringCellValue());
					objScheduler.setSTATUS(cell.getStringCellValue());
				}
				
				//Type of Gadget
				else if (cell.getColumnIndex() == 10) {
					System.out.print(cell.getStringCellValue());
					objScheduler.setGADGET_TYPE(cell.getStringCellValue());
				}
				
				//Capacity Type
				else if (cell.getColumnIndex() == 11) {
					System.out.print(cell.getStringCellValue());
					objScheduler.setCAPACITY_TYPE(cell.getStringCellValue());
				}
				
				//Skills
				else if (cell.getColumnIndex() == 12) {
					System.out.print(cell.getStringCellValue());
					objScheduler.setSKILLS(cell.getStringCellValue());
				}
				
				//Name
				else if (cell.getColumnIndex() == 13) {
					System.out.print(cell.getStringCellValue());
					objScheduler.setNAME(cell.getStringCellValue());
				}
				
				//Hours Type
				else if (cell.getColumnIndex() == 14) {
					System.out.print(cell.getStringCellValue());
					objScheduler.setHOURS_TYPE(cell.getStringCellValue());
				}
				
				//Start
				else if (cell.getColumnIndex() == 15) {
					
					objScheduler.setSTART_DATE((Date) cell.getDateCellValue());
				}
				
				//End
				else if (cell.getColumnIndex() == 16) {
					
					objScheduler.setEND_DATE((Date) cell.getDateCellValue());
				}
				
				//dATE
				else if (cell.getColumnIndex() == 17) {
					
					objScheduler.setREGISTRATION_DATE((Date) cell.getDateCellValue());
				}
				
				
				//jAN
				else if (cell.getColumnIndex() == 18) {
					String value = cell.getStringCellValue();
					if(value.equals("")) {
						objScheduler.setJAN_18(0);
					}else {
					objScheduler.setJAN_18(Integer.parseInt(cell.getStringCellValue()));
					//objScheduler.setJAN_18((int)cell.getNumericCellValue());
					}
				}
				//feb
				else if (cell.getColumnIndex() == 19) {
					String value = cell.getStringCellValue();
					if(value.equals("")) {
						objScheduler.setFEB_18(0);
					}else {
					objScheduler.setFEB_18(Integer.parseInt(cell.getStringCellValue()));
					//objScheduler.setFEB_18((int)cell.getNumericCellValue());
					}
				}
				//mar
				else if (cell.getColumnIndex() == 20) {
					String value = cell.getStringCellValue();
					if(value.equals("")) {
						objScheduler.setMAR_18(0);
					}else {
					objScheduler.setMAR_18(Integer.parseInt(cell.getStringCellValue()));
					//objScheduler.setMAR_18((int)cell.getNumericCellValue());
					}
				}
				//apr
				else if (cell.getColumnIndex() == 21) {
					String value = cell.getStringCellValue();
					if(value.equals("")) {
						objScheduler.setAPR_18(0);
					}else {
					objScheduler.setAPR_18(Integer.parseInt(cell.getStringCellValue()));
					//objScheduler.setAPR_18((int)cell.getNumericCellValue());
					}
				}
				//may
				else if (cell.getColumnIndex() == 22) {
					String value = cell.getStringCellValue();
					if(value.equals("")) {
						objScheduler.setMAY_18(0);
					}else {
					objScheduler.setMAY_18(Integer.parseInt(cell.getStringCellValue()));
					//objScheduler.setMAY_18((int)cell.getNumericCellValue());
					}
				}
				//jun
				else if (cell.getColumnIndex() == 23) {
					String value = cell.getStringCellValue();
					if(value.equals("")) {
						objScheduler.setJUN_18(0);
					}else {
					objScheduler.setJUN_18(Integer.parseInt(cell.getStringCellValue()));
					//objScheduler.setJUN_18((int)cell.getNumericCellValue());
					}
				}
				
				//JUL
				else if (cell.getColumnIndex() == 24) {
					String value = cell.getStringCellValue();
					if(value.equals("")) {
						objScheduler.setJUL_18(0);
					}else {
					objScheduler.setJUL_18(Integer.parseInt(cell.getStringCellValue()));
					//objScheduler.setJUL_18((int)cell.getNumericCellValue());
					}
				}
				
				//AUG
				else if (cell.getColumnIndex() == 25) {
					String value = cell.getStringCellValue();
					if(value.equals("")) {
						objScheduler.setAUG_18(0);
					}else {
					objScheduler.setAUG_18(Integer.parseInt(cell.getStringCellValue()));
					//objScheduler.setAUG_18((int)cell.getNumericCellValue());
					}
				}
				
				//SEPT
				else if (cell.getColumnIndex() == 26) {
					String value = cell.getStringCellValue();
					if(value.equals("")) {
						objScheduler.setSEP_18(0);
					}else {
					objScheduler.setSEP_18(Integer.parseInt(cell.getStringCellValue()));
					//objScheduler.setSEP_18((int)cell.getNumericCellValue());
					}
				}
				
				//OCT
				else if (cell.getColumnIndex() == 27) {
					String value = cell.getStringCellValue();
					if(value.equals("")) {
						objScheduler.setOCT_18(0);
					}else {
					objScheduler.setOCT_18(Integer.parseInt(cell.getStringCellValue()));
					//objScheduler.setOCT_18((int)cell.getNumericCellValue());
					}
				}
				
				//NOV
				else if (cell.getColumnIndex() == 28) {
					String value = cell.getStringCellValue();
					if(value.equals("")) {
						objScheduler.setNOV_18(0);
					}else {
					objScheduler.setNOV_18(Integer.parseInt(cell.getStringCellValue()));
					//objScheduler.setNOV_18((int)cell.getNumericCellValue());
					}
				}
				
				//DIC
				else if (cell.getColumnIndex() == 29) {
					String value = cell.getStringCellValue();
					if(value.equals("")) {
						objScheduler.setDEC_18(0);
					}else {
					objScheduler.setDEC_18(Integer.parseInt(cell.getStringCellValue()));
					//objScheduler.setDEC_18((int)cell.getNumericCellValue());
					}
				}
				
				//TOTAL
				else if (cell.getColumnIndex() == 30) {
					String value = cell.getStringCellValue();
					if(value.equals("")) {
						objScheduler.setTOTAL(0);
					}else {
					objScheduler.setTOTAL(Integer.parseInt(cell.getStringCellValue()));
					//objScheduler.setTOTAL((int)cell.getNumericCellValue());
					}
				}
		
				
				
				/*if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
				{
					System.out.print(cell.getStringCellValue()+" ");
				}
				else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
				{
					System.out.print(cell.getNumericCellValue()+" ");
				}*/
				else
				{
					//U Can Handel Boolean, Formula, Errors
				}
			}
			
			oListScheduler.add(objScheduler);
		
		}
		}
		
	    return oListScheduler;
    }
	
	public File convert(MultipartFile file) throws IOException
	{    
	    File convFile = new File(file.getOriginalFilename());
	    convFile.createNewFile(); 
	    FileOutputStream fos = new FileOutputStream(convFile); 
	    fos.write(file.getBytes());
	    fos.close(); 
	    return convFile;
	}
}
