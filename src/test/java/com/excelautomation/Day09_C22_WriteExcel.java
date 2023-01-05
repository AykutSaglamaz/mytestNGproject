package com.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day09_C22_WriteExcel {
    /*
     Dosya path icin String bir kontainer olustur
     Dosyayi ac
     workbook ac
     ilk worksheet'i ac
     ilk row'a git
     ilk row 3. column'da bir cell olustur
     cell'de “Nufus” yaz
     2. row 3. cell'de (index 2) cell olustur ve 150000 yaz
     3. row 3. cell de bir cell olustur ve 250000 yaz
     4. row 3. cell'de bir cell olustur ve 54000 yaz
     workbook kaydet
     Dosyayi kapat
     Workbook'u kapat
     */
    @Test
    public void writeExcel() throws IOException {
//       Dosya path icin String bir kontainer olustur
        String path = "./src/test/java/resources/Capitals.xlsx";
//        Dosyayi ac
        FileInputStream fileInputStream = new FileInputStream(path);
//        workbook ac
        Workbook workbook = WorkbookFactory.create(fileInputStream);
//        ilk worksheet'i ac/olustur
        Sheet sheet = workbook.getSheetAt(0);//index of sheet starts at 0
//        ilk row'a git
        Row firstRow  = sheet.getRow(0);//index of row starts at 0
//        ilk row 3. column'da bir cell olustur
        //creating a cell on 3rd column(2nd index)
        Cell row1Cell3=firstRow.createCell(2);
//        cell'de “Nufus” yaz
        row1Cell3.setCellValue("Nufus");

//        2. row 3. cell'de (index 2) cell olustur ve 150000 yaz (Create a cell on the 2nd row 3rd cell(index2), and write 150000
        sheet.getRow(1).createCell(2).setCellValue("150001");
//       3. row 3. cell de bir cell olustur ve 250000 yaz ( Create a cell on the 3rd row 3rd cell(index2), and write 250000
        sheet.getRow(2).createCell(2).setCellValue("250001");
//        4. row 3. cell'de bir cell olustur ve 54000 yaz (Create a cell on the 4th row 3rd cell(index2), and write 54000
        sheet.getRow(3).createCell(2).setCellValue("54001");

//        workbook kaydet
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

//        Dosyayi kapat
        fileInputStream.close();
        fileOutputStream.close();
//        Workbook'u kapat
        workbook.close();

    }
}
