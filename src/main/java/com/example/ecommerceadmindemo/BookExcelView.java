///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.example.ecommerceadmindemo;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.apache.poi.hssf.util.HSSFColor;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.FillPatternType;
//import org.apache.poi.ss.usermodel.Font;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.web.servlet.view.document.AbstractXlsView;
//
///**
// *
// * @author The_Humble_Fool
// */
//public class BookExcelView extends AbstractXlsView {
//
//    @Autowired
//    ProductsRepo pr;
//
//    @Override
//    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//        String[] headers = {"Id", "Name", "Description", "Price", "Images", "Product_Type", "Author", "ISBN", "Edition", "Pages", "Lang"};
//
//        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"books.xls\"");
////        List<ProductPersistenceEntityModel> models = pr.findAllByProductType("book");
////        List<BookProductPersistenceEntityModel> books = new ArrayList<>();
////        models.forEach(t -> {
////            books.add((BookProductPersistenceEntityModel) t);
////        });
//        System.out.println("Pr: " + pr);
//        List<ProductPersistenceEntityModel> findAllByProductType = pr.findAllByProductType("book");
//        System.out.println("List: " + findAllByProductType);
//        List<BookProductPersistenceEntityModel> books = new ArrayList<>();
//        findAllByProductType.forEach((t) -> {
//            books.add((BookProductPersistenceEntityModel) t);
//        });
//        Sheet sheet = workbook.createSheet("Book");
//        sheet.setDefaultColumnWidth(30);
//        CellStyle cellStyle = workbook.createCellStyle();
//        Font font = workbook.createFont();
//        font.setFontName("Arial");
////        cellStyle.setFillForegroundColor(font.COLOR_NORMAL);
//        cellStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.BLUE.getIndex());
//        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//        font.setBold(true);
//        font.setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
//        cellStyle.setFont(font);
//
//        Row header = sheet.createRow(0);
//        for (int i = 0; i < headers.length; i++) {
//            header.createCell(i).setCellValue(headers[i]);
//            header.getCell(i).setCellStyle(cellStyle);
//        }
//
//        int rowCount = 1;
//
//        for (BookProductPersistenceEntityModel book : books) {
//            Row data = sheet.createRow(rowCount++);
//            data.createCell(0).setCellValue(book.getId());
//            data.createCell(1).setCellValue(book.getName());
//            data.createCell(2).setCellValue(book.getDescription());
//            data.createCell(3).setCellValue(book.getPrice().setScale(2).doubleValue());
//            data.createCell(4).setCellValue(book.getImages());
//            data.createCell(5).setCellValue(book.getProductType());
//            data.createCell(6).setCellValue(book.getAuthor());
//            data.createCell(7).setCellValue(book.getIsbn());
//            data.createCell(8).setCellValue(book.getEdition());
//            data.createCell(9).setCellValue(book.getPages());
//            data.createCell(10).setCellValue(book.getLang());
//        }
//        workbook.write(response.getOutputStream());
//        workbook.close();
//    }
//}
