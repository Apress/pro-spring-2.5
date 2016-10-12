/*
 * Created on 30-Oct-2004
 */
package com.apress.prospring2.ch17.web.views;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;


import com.apress.prospring2.ch17.domain.Product;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

/**
 * @author janm
 */
public class ProductPdfView extends AbstractPdfView {

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.view.document.AbstractPdfView#buildPdfDocument(java.util.Map, com.lowagie.text.Document, com.lowagie.text.pdf.PdfWriter, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void buildPdfDocument(Map model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Product product = (Product) model.get("product");
		if (product == null) throw new NullPointerException("Product not present in the model");

		Paragraph header = new Paragraph("Product details");
		header.font().setSize(20);
		document.add(header);
		
		Paragraph content = new Paragraph(product.getName());
		document.add(content);
		
		Paragraph footer = new Paragraph("Pro Spring 2 Chapter 17");
		footer.setAlignment(Paragraph.ALIGN_BOTTOM);
		document.add(footer);
	}

}
