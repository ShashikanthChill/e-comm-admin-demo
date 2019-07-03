/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ecommerceadmindemo;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author The_Humble_Fool
 */
@Controller
public class ProductsController {

    @Autowired
    ProductTypesRepo ptr;

    @Autowired
    ProductsRepo pr;

    @RequestMapping(path = "/productstypes")
    public String productTypesPageHandler(Model model) {
        List<ProductTypesPersistenceEntityModel> allProductTypes = ptr.findAll();
        List<List<ProductTypesPersistenceEntityModel>> listOfProductTypesList = new ArrayList<>();
        int rowCount = (int) Math.ceil(allProductTypes.size() / 3.0);

        for (int i = 0, j = 0; j < rowCount; j++) {
            List<ProductTypesPersistenceEntityModel> productTypesList = new ArrayList<>();
            for (int k = 0; k < 3; k++) {
                if (i < allProductTypes.size()) {
                    productTypesList.add(allProductTypes.get(i));
                    i++;
                }
            }
            listOfProductTypesList.add(productTypesList);
        }
        model.addAttribute("listOfProductTypesList", listOfProductTypesList);
        return "productstypepage";
    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public String productsPageHandler(@RequestParam("type-name") String typeName, Model model) {
        String type = ptr.findTypeOnName(typeName);
        List<ProductPersistenceEntityModel> products = pr.findAllByProductType(type);
        switch (type) {
            case "book": {
                List<BookProductPersistenceEntityModel> bookProducts = new ArrayList<>();
                products.forEach((t) -> {
                    bookProducts.add((BookProductPersistenceEntityModel) t);
                });
                model.addAttribute("products", bookProducts);
                return "bookproductspage";
            }
            case "mobile": {
                List<MobileProductPersistenceEntityModel> bookProducts = new ArrayList<>();
                products.forEach((t) -> {
                    bookProducts.add((MobileProductPersistenceEntityModel) t);
                });
                model.addAttribute("products", bookProducts);
                return "mobileproductspage";
            }
            case "computer": {
                List<ComputerProductPersistenceEntityModel> bookProducts = new ArrayList<>();
                products.forEach((t) -> {
                    bookProducts.add((ComputerProductPersistenceEntityModel) t);
                });
                model.addAttribute("products", bookProducts);
                return "computerproductspage";
            }
            case "bike": {
                return null;
            }
            default:
                return null;
        }
    }

    @RequestMapping(path = "/bookproduct")
    public String bookProductPageHandler(@RequestParam("productId") Integer productId, Model model) {
        if (productId == null) {
            model.addAttribute("product", new BookProductPersistenceEntityModel());
        } else {
            Optional<ProductPersistenceEntityModel> findById = pr.findById(productId);
            model.addAttribute("product", (BookProductPersistenceEntityModel) findById.get());
        }
        return "bookproductpage";
    }

    @RequestMapping(path = "/mobileproduct")
    public String mobileProductPageHandler(@RequestParam("productId") Integer productId, Model model) {
        if (productId == null) {
            model.addAttribute("product", new MobileProductPersistenceEntityModel());
        } else {
            Optional<ProductPersistenceEntityModel> findById = pr.findById(productId);
            model.addAttribute("product", (MobileProductPersistenceEntityModel) findById.get());
        }
        return "mobileproductpage";
    }

    @RequestMapping(path = "/computerproduct")
    public String computerProductPageHandler(@RequestParam("productId") Integer productId, Model model) {
        if (productId == null) {
            model.addAttribute("product", new ComputerProductPersistenceEntityModel());
        } else {
            System.out.println("Got product id: " + productId);
            Optional<ProductPersistenceEntityModel> findById = pr.findById(productId);
            model.addAttribute("product", (ComputerProductPersistenceEntityModel) findById.get());
        }
        return "computerproductpage";
    }

    @RequestMapping(path = "/updatebooks", method = RequestMethod.POST)
    public String updateBooksHandler(@ModelAttribute("product") BookProductPersistenceEntityModel book, @RequestParam("productImage") MultipartFile imageFile, Model model) {
        updateBooksInTable(book, imageFile);
        return "redirect:/products?type-name=books";
    }

    @RequestMapping(path = "/updatecomputers", method = RequestMethod.POST)
    public String updateComputersHandler(@ModelAttribute("product") ComputerProductPersistenceEntityModel computer, @RequestParam("productImage") MultipartFile imageFile, Model model) {
        updateComputersInTable(computer, imageFile);
        return "redirect:/products?type-name=computers";
    }

    @RequestMapping(path = "/updatemobiles", method = RequestMethod.POST)
    public String updateMobilesHandler(@ModelAttribute("product") MobileProductPersistenceEntityModel mobile, @RequestParam("productImage") MultipartFile imageFile, Model model) {
        updateMobilesInTable(mobile, imageFile);
        return "redirect:/products?type-name=mobiles";
    }

    private void updateBooksInTable(BookProductPersistenceEntityModel entityModel, MultipartFile imageFile) {
        if (imageFile.getOriginalFilename().isEmpty()) {
            pr.saveAndFlush(entityModel);
        } else {
            try {
                ProductPersistenceEntityModel savedEntityModel = pr.save(entityModel);
                byte[] bytes = imageFile.getBytes();
                Path p = Paths.get("/home/The_Humble_Fool/NetBeansProjects/InitializrSpringbootProject/src/main/resources/static/images/products/" + savedEntityModel.getId() + ".jpg");
                Path image = Files.write(p, bytes);
                savedEntityModel.setImages("/images/products/" + image.getFileName());
                pr.saveAndFlush(savedEntityModel);
            } catch (IOException ex) {
                System.out.println("Error storing image");
            }
        }
    }

    private void updateComputersInTable(ComputerProductPersistenceEntityModel entityModel, MultipartFile imageFile) {
        if (imageFile.getOriginalFilename().isEmpty()) {
            pr.saveAndFlush(entityModel);
        } else {
            try {
                ProductPersistenceEntityModel savedEntityModel = pr.save(entityModel);
                byte[] bytes = imageFile.getBytes();
                Path p = Paths.get("/home/The_Humble_Fool/NetBeansProjects/InitializrSpringbootProject/src/main/resources/static/images/products/" + savedEntityModel.getId() + ".jpg");
                Path image = Files.write(p, bytes);
                savedEntityModel.setImages("/images/products/" + image.getFileName());
                pr.saveAndFlush(savedEntityModel);
            } catch (IOException ex) {
                System.out.println("Error storing image");
            }
        }
    }

    private void updateMobilesInTable(MobileProductPersistenceEntityModel entityModel, MultipartFile imageFile) {
        if (imageFile.getOriginalFilename().isEmpty()) {
            pr.saveAndFlush(entityModel);
        } else {
            try {
                ProductPersistenceEntityModel savedEntityModel = pr.save(entityModel);
                byte[] bytes = imageFile.getBytes();
                Path p = Paths.get("/home/The_Humble_Fool/NetBeansProjects/InitializrSpringbootProject/src/main/resources/static/images/products/" + savedEntityModel.getId() + ".jpg");
                Path image = Files.write(p, bytes);
                savedEntityModel.setImages("/images/products/" + image.getFileName());
                pr.saveAndFlush(savedEntityModel);
            } catch (IOException ex) {
                System.out.println("Error storing image");
            }
        }
    }

    @RequestMapping(path = "/deletefromtable")
    public String updateTableHandler(@RequestParam("productId") Integer productId, Model model, HttpServletRequest req) {
        String referer = req.getHeader("referer");
        pr.deleteById(productId);
        if (referer != null && !referer.isEmpty()) {
            return "redirect:" + referer;
        }
        return "redirect:/productstypes";
    }

    @RequestMapping(path = "/exportbooks")
    public void exportBooksHandler(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException, CsvDataTypeMismatchException, Exception {
//        String fileName = "books.csv";
//        response.setContentType("text/csv");
//        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + fileName + "\"");
//
//        StatefulBeanToCsv<BookProductPersistenceEntityModel> writer = new StatefulBeanToCsvBuilder<BookProductPersistenceEntityModel>(response.getWriter())
//                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
//                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
//                .withOrderedResults(false)
//                .build();
//
//        try {
//            List<ProductPersistenceEntityModel> findAllByProductType = pr.findAllByProductType("book");
//            List<BookProductPersistenceEntityModel> books = new ArrayList<>();
//            findAllByProductType.forEach((t) -> {
//                books.add((BookProductPersistenceEntityModel) t);
//            });
//            writer.write(books);
//        } catch (CsvRequiredFieldEmptyException ex) {
//            System.out.println(ex);
//        }
//        BookExcelView ev = new BookExcelView();
//        ev.setPr(pr);
//        ev.buildExcelDocument(null, new HSSFWorkbook(), request, response);
        String[] headers = {"Id", "Name", "Description", "Price", "Images", "Product_Type", "Author", "ISBN", "Edition", "Pages", "Lang"};

        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"books.xls\"");
        response.setContentType("application/vnd.ms-excel");

        List<ProductPersistenceEntityModel> findAllByProductType = pr.findAllByProductType("book");
        List<BookProductPersistenceEntityModel> books = new ArrayList<>();
        findAllByProductType.forEach((t) -> {
            books.add((BookProductPersistenceEntityModel) t);
        });
        try (Workbook workbook = new HSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Books");
            sheet.setDefaultColumnWidth(30);
            CellStyle cellStyle = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setFontName("Arial");
            cellStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.BLUE.getIndex());
            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            font.setBold(true);
            font.setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
            cellStyle.setFont(font);

            Row header = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                header.createCell(i).setCellValue(headers[i]);
                header.getCell(i).setCellStyle(cellStyle);
            }

            int rowCount = 1;

            for (BookProductPersistenceEntityModel book : books) {
                Row data = sheet.createRow(rowCount++);
                data.createCell(0).setCellValue(book.getId());
                data.createCell(1).setCellValue(book.getName());
                data.createCell(2).setCellValue(book.getDescription());
                data.createCell(3).setCellValue(book.getPrice().doubleValue());
                data.createCell(4).setCellValue(book.getImages());
                data.createCell(5).setCellValue(book.getProductType());
                data.createCell(6).setCellValue(book.getAuthor());
                data.createCell(7).setCellValue(book.getIsbn());
                data.createCell(8).setCellValue(book.getEdition());
                data.createCell(9).setCellValue(book.getPages());
                data.createCell(10).setCellValue(book.getLang());
            }
            workbook.write(response.getOutputStream());
        }
    }

    @RequestMapping(path = "/exportcomputers")
    public void exportComputersHandler(HttpServletResponse response) throws IOException, CsvDataTypeMismatchException {
//        String fileName = "computers.csv";
//        response.setContentType("text/csv");
//        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + fileName + "\"");
//
//        StatefulBeanToCsv<ComputerProductPersistenceEntityModel> writer = new StatefulBeanToCsvBuilder<ComputerProductPersistenceEntityModel>(response.getWriter())
//                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
//                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
//                .withOrderedResults(false)
//                .build();
//
//        try {
//            List<ProductPersistenceEntityModel> findAllByProductType = pr.findAllByProductType("computer");
//            List<ComputerProductPersistenceEntityModel> computers = new ArrayList<>();
//            findAllByProductType.forEach((t) -> {
//                computers.add((ComputerProductPersistenceEntityModel) t);
//            });
//            writer.write(computers);
//        } catch (CsvRequiredFieldEmptyException ex) {
//            System.out.println(ex);
//        }
        String[] headers = {"Id", "Name", "Description", "Price", "Images", "Product_Type", "Manufacturer", "Size", "Colour", "Processor", "Graphics", "Ram", "OS", "Battery", "Storage"};

        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"computers.xls\"");
        response.setContentType("application/vnd.ms-excel");

        List<ProductPersistenceEntityModel> findAllByProductType = pr.findAllByProductType("computer");
        List<ComputerProductPersistenceEntityModel> computers = new ArrayList<>();
        findAllByProductType.forEach((t) -> {
            computers.add((ComputerProductPersistenceEntityModel) t);
        });
        try (Workbook workbook = new HSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Computers");
            sheet.setDefaultColumnWidth(30);
            CellStyle cellStyle = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setFontName("Arial");
            cellStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.BLUE.getIndex());
            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            font.setBold(true);
            font.setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
            cellStyle.setFont(font);

            Row header = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                header.createCell(i).setCellValue(headers[i]);
                header.getCell(i).setCellStyle(cellStyle);
            }

            int rowCount = 1;

            for (ComputerProductPersistenceEntityModel computer : computers) {
                Row data = sheet.createRow(rowCount++);
                data.createCell(0).setCellValue(computer.getId());
                data.createCell(1).setCellValue(computer.getName());
                data.createCell(2).setCellValue(computer.getDescription());
                data.createCell(3).setCellValue(computer.getPrice().setScale(2).doubleValue());
                data.createCell(4).setCellValue(computer.getImages());
                data.createCell(5).setCellValue(computer.getProductType());
                data.createCell(6).setCellValue(computer.getManufacturer());
                data.createCell(7).setCellValue(computer.getSize().doubleValue());
                data.createCell(8).setCellValue(computer.getColour());
                data.createCell(9).setCellValue(computer.getProcessor());
                data.createCell(10).setCellValue(computer.getGraphics());
                data.createCell(11).setCellValue(computer.getRam());
                data.createCell(12).setCellValue(computer.getOs());
                data.createCell(13).setCellValue(computer.getBattery());
                data.createCell(14).setCellValue(computer.getStorage());
            }
            workbook.write(response.getOutputStream());
        }
    }

    @RequestMapping(path = "/exportmobiles")
    public void exportMobilesHandler(HttpServletResponse response) throws IOException, CsvDataTypeMismatchException {
//        String fileName = "mobiles.csv";
//        response.setContentType("text/csv");
//        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + fileName + "\"");
//
//        StatefulBeanToCsv<MobileProductPersistenceEntityModel> writer = new StatefulBeanToCsvBuilder<MobileProductPersistenceEntityModel>(response.getWriter())
//                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
//                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
//                .withOrderedResults(false)
//                .build();
//
//        try {
//            List<ProductPersistenceEntityModel> findAllByProductType = pr.findAllByProductType("mobile");
//            List<MobileProductPersistenceEntityModel> mobiles = new ArrayList<>();
//            findAllByProductType.forEach((t) -> {
//                mobiles.add((MobileProductPersistenceEntityModel) t);
//            });
//            writer.write(mobiles);
//        } catch (CsvRequiredFieldEmptyException ex) {
//            System.out.println(ex);
//        }
        String[] headers = {"Id", "Name", "Description", "Price", "Images", "Product_Type", "Manufacturer", "Model Number", "Size", "Colour", "Processor", "Ram", "OS", "Battery", "Storage"};

        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"mobiles.xls\"");
        response.setContentType("application/vnd.ms-excel");

        List<ProductPersistenceEntityModel> findAllByProductType = pr.findAllByProductType("mobile");
        List<MobileProductPersistenceEntityModel> mobiles = new ArrayList<>();
        findAllByProductType.forEach((t) -> {
            mobiles.add((MobileProductPersistenceEntityModel) t);
        });
        try (Workbook workbook = new HSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Computers");
            sheet.setDefaultColumnWidth(30);
            CellStyle cellStyle = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setFontName("Arial");
            cellStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.BLUE.getIndex());
            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            font.setBold(true);
            font.setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
            cellStyle.setFont(font);

            Row header = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                header.createCell(i).setCellValue(headers[i]);
                header.getCell(i).setCellStyle(cellStyle);
            }

            int rowCount = 1;

            for (MobileProductPersistenceEntityModel mobile : mobiles) {
                Row data = sheet.createRow(rowCount++);
                data.createCell(0).setCellValue(mobile.getId());
                data.createCell(1).setCellValue(mobile.getName());
                data.createCell(2).setCellValue(mobile.getDescription());
                data.createCell(3).setCellValue(mobile.getPrice().setScale(2).doubleValue());
                data.createCell(4).setCellValue(mobile.getImages());
                data.createCell(5).setCellValue(mobile.getProductType());
                data.createCell(6).setCellValue(mobile.getManufacturer());
                data.createCell(7).setCellValue(mobile.getModelNumber());
                data.createCell(8).setCellValue(mobile.getSize().doubleValue());
                data.createCell(9).setCellValue(mobile.getColour());
                data.createCell(10).setCellValue(mobile.getProcessor());
                data.createCell(11).setCellValue(mobile.getRam());
                data.createCell(12).setCellValue(mobile.getOs());
                data.createCell(13).setCellValue(mobile.getBattery());
                data.createCell(14).setCellValue(mobile.getStorage());
            }
            workbook.write(response.getOutputStream());
        }
    }
}
