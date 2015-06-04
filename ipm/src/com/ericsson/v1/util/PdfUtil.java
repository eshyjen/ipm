package com.ericsson.v1.util;

import java.io.ByteArrayOutputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import com.ericsson.ipm.v1.domain.Asset;
import com.ericsson.ipm.v1.domain.UserProfile;
import com.ericsson.ipm.v1.service.UserProfileService;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.Chapter;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Section;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfUtil {

	
	public static ByteArrayOutputStream generatePDFDocumentBytes(String signunid, 
			UserProfileService userProfileService, HttpServletRequest request) throws DocumentException {
		
		Document document = new Document();
		
		ByteArrayOutputStream baosPDF = new ByteArrayOutputStream();
		PdfWriter writer = null;
		
		try
		{
			
			UserProfile profile = getUserDetails(signunid, userProfileService);
			writer = PdfWriter.getInstance(document, baosPDF);

				document.open();
				
				
				
				
				 /* Paragraph title1 = new Paragraph("Chapter 1", 

						   FontFactory.getFont(FontFactory.HELVETICA, 
						   
						   18, Font.BOLDITALIC, new CMYKColor(0, 255, 255,17)));
						   
						Chapter chapter1 = new Chapter(title1, 1);
						      
						chapter1.setNumberDepth(0);
						
						Paragraph title11 = new Paragraph("Employee Details", 

							       FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, 
							   
							       new CMYKColor(0, 255, 255,17)));
							   
							Section section1 = chapter1.addSection(title11);

							Paragraph someSectionText = new Paragraph("This  text comes as part of section 1 of chapter 1.");

							section1.add(someSectionText);

							someSectionText = new Paragraph("Following is a 2 X 2 table.");

							section1.add(someSectionText);
							
							
							PdfPTable t = new PdfPTable(2);

						      t.setSpacingBefore(25);
						      
						      t.setSpacingAfter(25);
						      
						     PdfPCell c1 = new PdfPCell(new Phrase("Header1"));  
						      
						      t.addCell(c1);
						      
						      PdfPCell c2 = new PdfPCell(new Phrase("Header2"));
						      
						      t.addCell(c2);
						      
						      PdfPCell c3 = new PdfPCell(new Phrase("Header3"));
						      
						      t.addCell(c3);
						      
						      t.addCell("1.1");
						      
						      t.addCell("1.2");
						      
						      t.addCell("1.3");
						     
						      
						      
						      PdfPCell c1 = new PdfPCell(new Phrase("NAME :"));
						      
						      t.addCell(c1);
						      
						      t.addCell(profile.getUserFristName() +" "+profile.getUserLastName());
						      
						      
						      PdfPCell c2 = new PdfPCell(new Phrase("SIGNUM :"));
						      
						      t.addCell(c2);
						      
						      t.addCell(profile.getSignunId());
						      
						      
						      section1.add(t);
						      
						      document.add(chapter1); 
						      
						      
						      //// asset //////
						      
						      /*Paragraph title2 = new Paragraph("Chapter 2", 

									   FontFactory.getFont(FontFactory.HELVETICA, 
									   
									   18, Font.BOLDITALIC, new CMYKColor(0, 255, 255,17)));
									   
									Chapter chapter2 = new Chapter(title2, 1);
									      
									chapter2.setNumberDepth(0);
									
									Paragraph title12 = new Paragraph("Employee Details", 

										       FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, 
										   
										       new CMYKColor(0, 255, 255,17)));
										   
										Section section2 = chapter2.addSection(title12);

										Paragraph someSectionText2 = new Paragraph("This  text comes as part of section 1 of chapter 1.");

										section2.add(someSectionText2);

										 someSectionText2 = new Paragraph("Following is a 2 X 2 table.");

										section2.add(someSectionText2);
										
										
										PdfPTable t2 = new PdfPTable(2);

									      t2.setSpacingBefore(25);
									      
									      t2.setSpacingAfter(25);
									      
									     
									      for(Asset asset : profile.getAssets()){
									    	  PdfPCell c11 = new PdfPCell(new Phrase("Asset NAME"));
										      
										      t2.addCell(c11);
										      
										      t2.addCell(asset.getAssetName());
										      
										      
										      PdfPCell c22 = new PdfPCell(new Phrase("ProjectName"));
										      
										      t2.addCell(c22);
										      
										      t2.addCell(asset.getProjectName());
										      
									      }
									      section2.add(t2);
									      document.add(chapter2);*/
						      
						      ///////////////
						      
						      
						      
						      
						      document.add(new Paragraph("This is a multi-page document."));
							
						      document.add( makeGeneralRequestDetailsElement(request) );
							
						      document.newPage();
							
						      document.add( makeHTTPHeaderInfoElement(request) );
							
						      document.newPage();
							
						      document.add( makeHTTPParameterInfoElement(request) );
						      
						      
						      document.close();
						      
		}
		catch (DocumentException dex)
		{
			baosPDF.reset();
			throw dex; 
		}
		finally
		{
			if (document != null)
			{
				document.close();
			}
			if (writer != null)
			{
				writer.close();
			}
		}
		
		if (baosPDF.size() < 1)
		{
			throw new DocumentException(
				"document has "
				+ baosPDF.size()
				+ " bytes");		
		}
		return baosPDF;

	}
	
	
	
	
	private static UserProfile getUserDetails(String signunid, UserProfileService userProfileService){
		return userProfileService.getUserDetails(signunid);
	}
	
	
	
	/**
	 * 
	 * @param req HTTP request object
	 * @return an iText Element object
	 * 
	 */
	protected static Element makeHTTPHeaderInfoElement(final HttpServletRequest req)
	{
		Map mapHeaders = new java.util.TreeMap();
		
		Enumeration enumHeaderNames = req.getHeaderNames();
		while (enumHeaderNames.hasMoreElements())
		{
			String strHeaderName = (String) enumHeaderNames.nextElement();
			String strHeaderValue = req.getHeader(strHeaderName);
			
			if (strHeaderValue == null)
			{
				strHeaderValue = "";
			}
			mapHeaders.put(strHeaderName, strHeaderValue);
		}

		Table tab = makeTableFromMap(
				"HTTP header name",
				"HTTP header value",
				mapHeaders);
		
		return (Element) tab;
	}

	/**
	 *  
	 * @param req HTTP request object 
	 * @return an iText Element object
	 * 
	 */
	protected static Element makeGeneralRequestDetailsElement(
						final HttpServletRequest req)
	{
		Map mapRequestDetails = new TreeMap();
		 
		mapRequestDetails.put("Scheme", req.getScheme());
				
		mapRequestDetails.put("HTTP method", req.getMethod());
				
		mapRequestDetails.put("AuthType", req.getAuthType());
				
		mapRequestDetails.put("QueryString", req.getQueryString());
				
		mapRequestDetails.put("ContextPath", req.getContextPath());
				
		mapRequestDetails.put("Request URI", req.getRequestURI());
				
		mapRequestDetails.put("Protocol", req.getProtocol());
				
		mapRequestDetails.put("Remote address", req.getRemoteAddr());
				
		mapRequestDetails.put("Remote host", req.getRemoteHost());
				
		mapRequestDetails.put("Server name", req.getServerName());
				
		mapRequestDetails.put("Server port", "" + req.getServerPort());
				
		mapRequestDetails.put("Preferred locale", req.getLocale().toString());
				
		Table tab = null;
		
		tab = makeTableFromMap(
						"Request info", 
						"Value",
						mapRequestDetails);
		
		return (Element) tab;
	}

	/**
	 * 
	 * 
	 * @param req HTTP request object
	 * @return an iText Element object
	 * 
	 */
	protected static Element makeHTTPParameterInfoElement(
					final HttpServletRequest req)
	{
		Map mapParameters = null;
		
		mapParameters = new java.util.TreeMap(req.getParameterMap());

		Table tab = null;

		tab = makeTableFromMap(
				"HTTP parameter name",
				"HTTP parameter value",
				mapParameters);
		
		return (Element) tab;
	}
	
	/**
	 *
	 * @param firstColumnTitle
	 * @param secondColumnTitle
	 * @param m map containing the data for column 1 and column 2
	 * 
	 * @return an iText Table
	 * 
	 */
	private static Table makeTableFromMap(
			final String firstColumnTitle,
			final String secondColumnTitle,
			final java.util.Map m)
	{
		Table tab = null;

		try
		{
			tab = new Table(2 /* columns */);
		}
		catch (BadElementException ex)
		{
			throw new RuntimeException(ex);
		}
		
		tab.setBorderWidth(1.0f);
		tab.setPadding(5);
		tab.setSpacing(5);

		tab.addCell(new Cell(firstColumnTitle));
		tab.addCell(new Cell(secondColumnTitle));
		
		tab.endHeaders();

		if (m.keySet().size() == 0)
		{
			Cell c = new Cell("none");
			c.setColspan(tab.columns());
			tab.addCell(c);
		}
		else
		{
			Iterator iter = m.keySet().iterator();
			while (iter.hasNext())
			{
				String strName = (String) iter.next();
				Object value = m.get(strName);
				String strValue = null;
				if (value == null)
				{
					strValue = "";
				}
				else if (value instanceof String[])
				{
					String[] aValues = (String[]) value;   
					strValue = aValues[0];
				}
				else
				{
					strValue = value.toString();
				}
				
				tab.addCell(new Cell(strName));
				tab.addCell(new Cell(strValue));
			}
		}
		
		return tab;
	}
	
	
	
}
