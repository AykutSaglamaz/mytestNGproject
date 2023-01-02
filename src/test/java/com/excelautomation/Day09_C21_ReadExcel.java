package com.excelautomation;

import com.utilities.Day09_C20_ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

    /*
    Import the apache poi dependency in your pom file
    resources package olustur > java altinda acilmali (java'ya sag tikla ve dosyayi olustur)
    Add the excel file on the resources folder
    Yeni package olustur: excelautomation
    Yeni class olustur : ReadExcel
    test method olustur: readExcel()
    Dosyanin adresini String olarak bir konteynira koy
    dosyayi ac
    fileinputstream kullanarak workbook'u ac
    ilk worksheet'i ac
    ilk row'a git
    ilk row'daki ilk cell'e git ve yazdir
    ilk row'daki ikinci cell'e git ve yazdir
    2nd row'daki ilk cell'e git ve datanin ABD'ye esit oldugunu assert e
    3rd row'daki 2nd cell-chain the row and cell
    row sayisini bul
    Kullanilan row sayisini bul
    Ulke ve baskent key-value ciftlerini map object olarak yazdir
    */
public class Day09_C21_ReadExcel {

    @Test
    public void readExcel() throws IOException {

//        Dosyanin adresini String olarak bir konteynira koy
        String path = "./src/test/java/resources/Capitals.xlsx";
//        dosyayi ac
        FileInputStream fileInputStream = new FileInputStream(path);

//        fileinputstream kullanarak workbook'u ac
        Workbook workbook = WorkbookFactory.create(fileInputStream);

//        ilk worksheet'i ac
        Sheet sheet = workbook.getSheetAt(0);//index of sheet starts at 0

//        ilk row'a git
        Row firstRow  = sheet.getRow(0);//index of row starts at 0

//        ilk row'daki ilk cell'e git ve yazdir
        Cell firstCell = firstRow.getCell(0);//index of cell stars at 0
        System.out.println(firstCell);//ulke

//        ilk row'daki ikinci cell'e git ve yazdir
//        Row secondRow = sheet.getRow(1);
//        Cell cell21 = secondRow.getCell(0);
//        System.out.println(cell21);
        //2.yol
//        sheet.getRow(ROW INDEX NUMBER).getCell(CELL INDEX NUMBER)
        Cell row1Cell2=sheet.getRow(0).getCell(1);//we can chain the methods
        System.out.println(row1Cell2);//Baskent

//        2nd row'daki ilk cell'e git ve datanin ABD'ye esit oldugunu assert et
        Cell row2Cell1=sheet.getRow(1).getCell(0);
        System.out.println("Data ABD olmali : "+row2Cell1 );//ABD

        boolean isEqual = row2Cell1.toString().equals("ABD");
        System.out.println(isEqual);
        Assert.assertTrue(isEqual);

//        3rd row'daki 2nd cell-chain the row and cell
        Cell row3Cell2=sheet.getRow(2).getCell(1);
        System.out.println(row3Cell2.toString());//Paris

//        row sayisini bu
        int lastRowNumber = sheet.getLastRowNum()+1;//index starts at 0
        System.out.println(lastRowNumber);

//        Kullanilan row sayisini bul
        int usedNumberOfRow = sheet.getPhysicalNumberOfRows();
        System.out.println(usedNumberOfRow);//number starts at 1

//        Ulke ve baskent key-value ciftlerini map object olarak yazdir

        Map<String, String> dunyaBaskentleri = new HashMap<>();

        int ulkeColumn = 0;
        int baskentColumn = 1;

        /*
         * Starting row number : 1- cunku Header 0 index'tir
         * Ending Row Number  : lastRowNumber - or - sheet.getLastRowNum()+1;
         *
         * ABD :      sheet   .getRow(1)       .getCell(0)
         * Fransa     sheet   .getRow(2)       .getCell(0)
         * Ingiltere    sheet   .getRow(3)       .getCell(0)
         *
         * D.C -     sheet    .getRow(1)        .getCell(1)
         * Paris-    sheet    .getRow(2)        .getCell(1)
         * Londra-   sheet    .getRow(3)        .getCell(1)
         *
         *           sheet.getRow(rowNumber).getCell(columnNumber)
         * */

        for (int rowNumber = 1; rowNumber<lastRowNumber; rowNumber++){
            String ulkeler = sheet.getRow(rowNumber).getCell(ulkeColumn).toString();
            String baskentler = sheet.getRow(rowNumber).getCell(baskentColumn).toString();

            System.out.println("Ulke : " + ulkeler);
            System.out.println("Baskent : " + baskentler);

                dunyaBaskentleri.put(ulkeler, baskentler);//map'e ulke ve baskent ekleme
            }

        System.out.println(dunyaBaskentleri);

    }

    @Test
    public void excelUtilDemo(){
        //We use Util classes to do faster and accurate automation script
        //Using some of the ExcelUtil methods
        String path = "./src/test/java/resources/Capitals.xlsx";
        String sheetName="capitals_sheet";

        //ExcelUtil class'i okumak icin once ExcelUtil Object olusturulmali
        Day09_C20_ExcelUtil excelUtil = new Day09_C20_ExcelUtil(path,sheetName);

        //Reusable excel methods'larini cagirabiliriz
        //getDataList()
        System.out.println(excelUtil.getDataList());

        //Baskent'teki column sayisini bulun
        System.out.println(excelUtil.columnCount());//2

        //Baskent sheet'teki row sayisini bulun
        System.out.println(excelUtil.rowCount());//11

        //row 9 column 1'deki datayi bulun
        System.out.println(excelUtil.getCellData(8,0));//Almanya

        //column header isimlerinin tumunu bulun
        System.out.println(excelUtil.getColumnsNames());//[COUNTRY-R0C0, CAPITAL-R0C1]

    }
}
