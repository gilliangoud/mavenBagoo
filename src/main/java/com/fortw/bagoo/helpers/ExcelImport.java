/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fortw.bagoo.helpers;

import com.fortw.bagoo.models.Bagage;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Giel
 */
public class ExcelImport {
    public static List<Bagage> importBagageVanExcel(String fileName){
        List<Bagage> list = new ArrayList<>();
        
        try
        {
            FileInputStream fileInputStream = new FileInputStream(new File(fileName));

            // Create Workbook instance holding .xls file
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

            // Get the first worksheet
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Iterate through each rows
            Iterator rowIterator = sheet.iterator();
            
            
            while (rowIterator.hasNext())
            {
                // Get Each Row
                Row row = (Row) rowIterator.next();
                
                //Leaving the first row alone as it is header
                if(row.getRowNum() < 4)
                    continue;
                
                // Iterating through Each column of Each Row
                Iterator cellIterator = row.cellIterator();
                
                Bagage bagage = new Bagage();
                while (cellIterator.hasNext())
                {
                    Cell cell = (Cell) cellIterator.next();
                    
                    int columnIndex = cell.getColumnIndex();
                    
                    switch (columnIndex+1)
                    {
                    case 4:
                        //bagage.setType(cell.getStringCellValue());
                        break;
                    case 5:
                        bagage.setMerk(cell.getStringCellValue());
                        break;
                    case 6:
                        bagage.setVluchtNr(cell.getStringCellValue());
                        break;
                    case 7:
                        bagage.setBagageNr((int) cell.getNumericCellValue());
                        break;
                    case 8:
                        //bagage.setLocatieNr();
                        break;
                    case 9:
                        //bagage.setKleur();
                        break;
                    case 10:
                        //bagage.setKleur2();
                        break;
                    case 11:
                        //bagage.setKleur();
                        break;
                    case 12:
                        bagage.setGewicht(cell.getStringCellValue());
                        break;
                    case 14:
                        bagage.setOpmerking(cell.getStringCellValue());
                        break;
                    }
                }
                list.add(bagage);
            }
        } catch (IOException ie)
        {
            ie.printStackTrace();
        }
        
        return list;
    }
    
}
