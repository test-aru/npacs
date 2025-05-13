package com.npacs.utilities;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {

public static void ReadExcelFile() throws IOException {
    FileInputStream fs = new FileInputStream("./ExcelFiles/TestAutomation.xlsx");
    XSSFWorkbook workbook = new XSSFWorkbook(fs);
    XSSFSheet sheet = workbook.getSheetAt(0);

    String usrn = sheet.getRow(1).getCell(0).getStringCellValue();
    String pwd = sheet.getRow(1).getCell(1).getStringCellValue();

    int rowcount = sheet.getLastRowNum();

    for(int k=0; k<= rowcount; k++){
        XSSFRow row = sheet.getRow(k);
        int cellcount = row.getLastCellNum();
        for(int j=0; j<cellcount;j++){
            String temp = row.getCell(j).getStringCellValue();
            System.out.print(temp+" ");
        }
    }
    workbook.close();
    fs.close();

}

public String[] getUsernamePasswordFromExcel(int rowIndex) throws IOException {
    FileInputStream fs = new FileInputStream("./ExcelFiles/TestAutomation.xlsx");
    XSSFWorkbook workbook = new XSSFWorkbook(fs);
    XSSFSheet sheet = workbook.getSheetAt(0);
    XSSFRow row = sheet.getRow(rowIndex);
    String usrn = row.getCell(0).getStringCellValue();
    String pwd = row.getCell(1).getStringCellValue();
    workbook.close();
    fs.close();

    return new String[] {usrn, pwd};
}

//    public static void main(String[] args) throws IOException {
//        ReadExcel obj = new ReadExcel();
//
//    }

}
