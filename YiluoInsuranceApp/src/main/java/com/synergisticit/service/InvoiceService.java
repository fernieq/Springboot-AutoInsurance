package com.synergisticit.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.synergisticit.domain.Policy;
import com.synergisticit.domain.Request;

@Service
public class InvoiceService {
	public byte[] generateInvoice(Policy policy, Request request) {
		Document document = new Document();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			PdfWriter.getInstance(document, outputStream);
			document.open();
			writeContent(document, policy, request);
			document.close();
			System.out.println("PDF invoice written!!!!");
			return outputStream.toByteArray();
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch ( IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	private void writeContent(Document document, Policy policy, Request request) throws DocumentException{
		Font headerFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
		Font regularFont = new Font(Font.FontFamily.TIMES_ROMAN, 14);
		
		//header
		Paragraph headerParagraph = new Paragraph("Invoice", headerFont);
		headerParagraph.setAlignment(Element.ALIGN_CENTER);
		document.add(headerParagraph);
		
		//body
		document.add(new Paragraph("\n"));
		
		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100);
		table.setWidths(new float[] {1,2});
		
		PdfPCell pCell;
		
		pCell = new PdfPCell(new Phrase("Insurance Policy Number: ", regularFont));
		table.addCell(pCell);
		pCell = new PdfPCell(new Phrase(String.valueOf("#" + policy.getPolicyId()), regularFont));
		table.addCell(pCell);
		
		pCell = new PdfPCell(new Phrase("Payment Date: ", regularFont));
		table.addCell(pCell);
		pCell = new PdfPCell(new Phrase(getCurrentDate(), regularFont));
		table.addCell(pCell);
		
		pCell = new PdfPCell(new Phrase("Customer Name: ", regularFont));
		table.addCell(pCell);
		pCell = new PdfPCell(new Phrase(String.valueOf(request.getCustomerName()), regularFont));
		table.addCell(pCell);
		
		pCell = new PdfPCell(new Phrase("Customer Email: ", regularFont));
		table.addCell(pCell);
		pCell = new PdfPCell(new Phrase(String.valueOf(request.getEmail()), regularFont));
		table.addCell(pCell);
						
		pCell = new PdfPCell(new Phrase("Insurance Details: ", regularFont));
		table.addCell(pCell);
		pCell = new PdfPCell(new Phrase(String.valueOf(request.getProductName()), regularFont));
		table.addCell(pCell);
		
		pCell = new PdfPCell(new Phrase("Insurance Type: ", regularFont));
		table.addCell(pCell);
		pCell = new PdfPCell(new Phrase(String.valueOf(request.getType()), regularFont));
		table.addCell(pCell);
		
		pCell = new PdfPCell(new Phrase("Insurance Start Date: ", regularFont));
		table.addCell(pCell);
		pCell = new PdfPCell(new Phrase(String.valueOf(request.getStartDate()), regularFont));
		table.addCell(pCell);
		
		pCell = new PdfPCell(new Phrase("Insurance End Date: ", regularFont));
		table.addCell(pCell);
		pCell = new PdfPCell(new Phrase(String.valueOf(request.getEndDate()), regularFont));
		table.addCell(pCell);
		
		pCell = new PdfPCell(new Phrase("Insurance Total Duration", regularFont));
		table.addCell(pCell);
		pCell = new PdfPCell(new Phrase(String.valueOf(request.getDuration() + " month(s)"), regularFont));
		table.addCell(pCell);
		
		pCell = new PdfPCell(new Phrase("Insurance Deductables: ", regularFont));
		table.addCell(pCell);
		pCell = new PdfPCell(new Phrase(String.valueOf("$" + request.getDeductables()) , regularFont));
		table.addCell(pCell);
		
		document.add(table);
		
		//end
		document.add(new Paragraph("\n"));
		Paragraph totalSavings = new Paragraph("Final Charges: $" + request.getAmount() + "USD", headerFont);
		totalSavings.setAlignment(Element.ALIGN_RIGHT);
		document.add(totalSavings);
		
	}

	private String getCurrentDate() {
		java.util.Date todayDate = new java.util.Date();
		return todayDate.toString();
	}
	
}
