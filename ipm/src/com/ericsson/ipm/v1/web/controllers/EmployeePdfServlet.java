package com.ericsson.ipm.v1.web.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.ipm.v1.context.SpringApplicationContext;
import com.ericsson.ipm.v1.dao.BootstrapSetupData;
import com.ericsson.ipm.v1.service.UserProfileService;
import com.ericsson.v1.util.PdfUtil;
import com.lowagie.text.DocumentException;

@WebServlet("/v1/protected/employeePdfReport") 
public class EmployeePdfServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(EmployeePdfServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		UserProfileService userProfileService  = (UserProfileService) SpringApplicationContext.getBean("userProfileService");
		
		String signum = req.getParameter("signum");
		
		log.info("signum : "+signum);
		
		DocumentException ex = null;
		
		ByteArrayOutputStream baosPDF = null;
		
		
		try
		{
			
			baosPDF = PdfUtil.generatePDFDocumentBytes(signum, userProfileService,req);
			
			StringBuffer sbFilename = new StringBuffer();
			sbFilename.append("filename_");
			sbFilename.append(System.currentTimeMillis());
			sbFilename.append(".pdf");

			////////////////////////////////////////////////////////
			// Note: 
			//
			// It is important to set the HTTP response headers 
			// before writing data to the servlet's OutputStream 
			//
			////////////////////////////////////////////////////////
			//
			//
			// Read the HTTP 1.1 specification for full details
			// about the Cache-Control header
			//
			resp.setHeader("Cache-Control", "max-age=30");
			
			resp.setContentType("application/pdf");
			
			//
			//
			// The Content-disposition header is explained
			// in RFC 2183
			//
			//    http://www.ietf.org/rfc/rfc2183.txt
			//
			// The Content-disposition value will be in one of 
			// two forms:
			//
			//   1)  inline; filename=foobar.pdf
			//   2)  attachment; filename=foobar.pdf
			//
			// In this servlet, we use "inline"
			//
			StringBuffer sbContentDispValue = new StringBuffer();
			sbContentDispValue.append("inline");
			sbContentDispValue.append("; filename=");
			sbContentDispValue.append(sbFilename);
							
			resp.setHeader(
				"Content-disposition",
				sbContentDispValue.toString());

			resp.setContentLength(baosPDF.size());

			ServletOutputStream sos;

			sos = resp.getOutputStream();
			
			baosPDF.writeTo(sos);
			
			sos.flush();
		}
		catch (DocumentException dex)
		{
			resp.setContentType("text/html");
			PrintWriter writer = resp.getWriter();
			writer.println(
					this.getClass().getName() 
					+ " caught an exception: " 
					+ dex.getClass().getName()
					+ "<br>");
			writer.println("<pre>");
			dex.printStackTrace(writer);
			writer.println("</pre>");
		}
		finally
		{
			if (baosPDF != null)
			{
				baosPDF.reset();
			}
		}
		
	}
}
