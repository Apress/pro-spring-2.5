/*
 * Created on 30-Oct-2004
 */
package com.apress.prospring2.ch17.web.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.apress.prospring2.ch17.domain.Product;

/**
 * @author janm
 */
public class ProductsExcelView extends AbstractExcelView {

	private static final int COL_PRODUCT_ID = 0;
	private static final int COL_NAME = 1;
	private static final int COL_EXPIRATION_DATE = 2;

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.view.document.AbstractExcelView#buildExcelDocument(java.util.Map, org.apache.poi.hssf.usermodel.HSSFWorkbook, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void buildExcelDocument(Map model, HSSFWorkbook wb, HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Product> products = (List<Product>)model.get("products");
		HSSFSheet sheet = wb.createSheet("Products");
		int row = 0;
		getCell(sheet, row, COL_PRODUCT_ID).setCellValue("ProductId");
		getCell(sheet, row, COL_NAME).setCellValue("Name");
		getCell(sheet, row, COL_EXPIRATION_DATE).setCellValue("ExpirationDate");
		row++;
		for (Product product : products) {
			getCell(sheet, row, COL_PRODUCT_ID).setCellValue(product.getId());
			getCell(sheet, row, COL_NAME).setCellValue(product.getName());
			getCell(sheet, row, COL_EXPIRATION_DATE).setCellValue(product.getExpirationDate());
			row++;
		}
	}

}
