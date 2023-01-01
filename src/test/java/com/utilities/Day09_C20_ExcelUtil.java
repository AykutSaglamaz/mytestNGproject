package com.utilities;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day09_C20_ExcelUtil {
    private Workbook workBook;
    private Sheet workSheet;
    private String path;

    public Day09_C20_ExcelUtil(String path, String sheetName) {//Bu Constructor excel dosyasini acmak ve erisim saglamak icindir
        this.path = path;
        try {
            // Excel file acar
            FileInputStream fileInputStream = new FileInputStream(path);
            //  workbook' erisim saglar
            workBook = WorkbookFactory.create(fileInputStream);
            // worksheet'i getirir
            workSheet = workBook.getSheet(sheetName);
            //sheet'in data icerip icermedigini assert eder
            Assert.assertNotNull(workSheet, "Worksheet: \"" + sheetName + "\" was not found\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //Bu excel dosyasindaki data listesini getirir
    //Bu data type string bir map olan List'tir. Datayi String olarak alir ve String Map olarak dondurur
    public List<Map<String, String>> getDataList() {
        // tum columns'lari getirir
        List<String> columns = getColumnsNames();
        // method will return this
        List<Map<String, String>> data = new ArrayList<>();
        for (int i = 1; i < rowCount(); i++) {
            // her bir row getirir
            Row row = workSheet.getRow(i);
            // column ve value kullanarak Row'dan Map olusturur
            // key=column, value=cell
            Map<String, String> rowMap = new HashMap<String, String>();
            for (Cell cell : row) {
                int columnIndex = cell.getColumnIndex();
                rowMap.put(columns.get(columnIndex), cell.toString());
            }
            data.add(rowMap);
        }
        return data;
    }
    //===============spesifik bir row'da colum sayisini getirme=================
    public int columnCount() {
        //row 1'de kactane number var getirir
        return workSheet.getRow(0).getLastCellNum();
    }
    //=============== en son row'daki numberi nasil alirsiniz? Index'ler 0'dan baslar.====================
    public int rowCount() {
        return workSheet.getLastRowNum() + 1; }// 1 ekleyerek gercek sayiyi getirir
    //==============row ve column number girilince , data alinir ==========
    public String getCellData(int rowNum, int colNum) {
        Cell cell;
        try {
            cell = workSheet.getRow(rowNum).getCell(colNum);
            String cellData = cell.toString();
            return cellData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //============tum datayi 2-dimentional array getirme ve datayi dondurme===
    public String[][] getDataArray() {
        String[][] data = new String[rowCount()][columnCount()];
        for (int i = 0; i < rowCount(); i++) {
            for (int j = 0; j < columnCount(); j++) {
                String value = getCellData(i, j);
                data[i][j] = value;
            }
        }
        return data;
    }
    //==============Ilk row'a gitme ve her column'u birer birer okuma ==================//
    public List<String> getColumnsNames() {
        List<String> columns = new ArrayList<>();
        for (Cell cell : workSheet.getRow(0)) {
            columns.add(cell.toString());
        }
        return columns;
    }
    //=========row ve column sayisi girilince, value dondurme ===============//
    public void setCellData(String value, int rowNum, int colNum) {
        Cell cell;
        Row row;
        try {
            row = workSheet.getRow(rowNum);
            cell = row.getCell(colNum);
            if (cell == null) {//Eger value yok ise, bir cell olustur.
                cell = row.createCell(colNum);
                cell.setCellValue(value);
            } else {
                cell.setCellValue(value);
            }
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            workBook.write(fileOutputStream);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setCellData(String value, String columnName, int row) {
        int column = getColumnsNames().indexOf(columnName);
        setCellData(value, row, column);
    }
    //Bu method 2-boyutlu bir data table dondurur
    //data provider'dan dolayi bu formata ihtiyac duyariz.
    public String[][] getDataArrayWithoutFirstRow() {
        String[][] data = new String[rowCount()-1][columnCount()];
        for (int i = 1; i < rowCount(); i++) {
            for (int j = 0; j < columnCount(); j++) {
                String value = getCellData(i, j);
                data[i-1][j] = value;
            }
        }
        return data;
    }

}
