package com.ericsson.ipm.v1.web.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.util.Date;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.ericsson.ipm.v1.domain.Asset;
import com.ericsson.ipm.v1.domain.MandatoryCertification;
import com.ericsson.ipm.v1.domain.UserProfile;
import com.ericsson.ipm.v1.dto.AssetDTO;
import com.ericsson.ipm.v1.dto.MandatoryCertificationDTO;
import com.ericsson.ipm.v1.security.authentication.vo.ContextAuthenticatedUserDetailsVO;
import com.ericsson.ipm.v1.service.MandatoryCertificationService;
import com.ericsson.ipm.v1.service.MandatoryCertificationServiceImpl;
import com.ericsson.ipm.v1.service.UserProfileService;
import com.ericsson.v1.util.Constants;
import com.sun.mail.iap.Response;

@Controller
@RequestMapping(Constants.BASE_PROTECTED_URL_PATH)
public class MandatoryCertificationController extends BaseController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MandatoryCertificationController.class);

	private MandatoryCertificationService mandatoryCertificationService;

	private UserProfileService userProfileService;

	@RequestMapping(value = "mandatoryCertification.html", method = RequestMethod.GET)
	public String showMandatoryCertificationForm(
			final HttpServletRequest request, final Model model) {
		LOGGER.debug("Rendering MandatoryCertification.jsp page.");
		final MandatoryCertificationDTO mandatoryCertificationDTO = new MandatoryCertificationDTO();
		model.addAttribute("mandatoryCertificationDTO",
				mandatoryCertificationDTO);
		// model.addAttribute("roles", roleService.findAll());
		return "protected/mandatoryCertification";
	}

	@RequestMapping(value = "saveMandatoryCertification.html", method = RequestMethod.POST)
	public String saveMandatoryCertificationForm(
			@ModelAttribute("mandatoryCertificationDTO") MandatoryCertificationDTO mandatoryCertificationDTO,
			   BindingResult result, HttpServletRequest request, Model model) {
		UserProfile profile = null;
		ContextAuthenticatedUserDetailsVO loggedInUser = getCurrentUser();
		int id = mandatoryCertificationDTO.getId();
		if (loggedInUser != null) {
			profile = loggedInUser.getProfile();
			MandatoryCertification mandatoryCertification = new MandatoryCertification();
			mandatoryCertification.setId(id);
			mandatoryCertification.setTrainingName(mandatoryCertificationDTO
					.getTrainingName());
			mandatoryCertification.setDateWeekPlanned(mandatoryCertificationDTO
					.getDateWeekPlanned());
			mandatoryCertification.setDateAttended(mandatoryCertificationDTO
					.getDateAttended());
			mandatoryCertification
					.setCompletionStatus(mandatoryCertificationDTO
							.getCompletionStatus());
			mandatoryCertification.setUserprofile(userProfileService
					.findById(profile.getId()));




			try {

				Part part = request.getPart("uploadedFile");
				InputStream inputStream = part.getInputStream();
				System.out.println("inputStream::"+inputStream);
				String fileName="";
				HashSet<String> headers=(HashSet<String>)part.getHeaders("content-disposition");
		        for(String head:headers)
		        {

		        	if(head.indexOf("filename")>-1)
		        	{
						String[] ar =head.split("=");

						String newStr = ar[ar.length-1];

						fileName=newStr.substring(newStr.lastIndexOf(File.separator)+2, newStr.length()-1);
						mandatoryCertification.setAttachFile(fileName);
		        	}
		        }
		        String signum=request.getRemoteUser();
		        String path="/home/temp/file/"+signum;
		        //System.out.println(signum);
		        boolean success = false;
		        
		        File directory = new File(path);
		        if (directory.exists()==false) 
		        {
		        	success = directory.mkdir();
		        }
				File newFile = new File("/home/temp/file/"+signum+"/"+fileName);
				   if (!newFile.exists()) {
					   	newFile.createNewFile();
				   }
				   FileOutputStream outputStream = new FileOutputStream(newFile);
				   int read = 0;
				   byte[] bytes = new byte[102400];

				   while ((read = inputStream.read(bytes)) != -1) {
				    outputStream.write(bytes, 0, read);
				   }
				  }
		       
			 catch (IllegalStateException | IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}




			mandatoryCertificationService.saveOrUpdate(mandatoryCertification);
		}



		try {

			Part part = request.getPart("uploadedFile");
			InputStream inputStream = part.getInputStream();
			System.out.println("inputStream::"+inputStream);
			String fileName="";
			HashSet<String> headers=(HashSet<String>)part.getHeaders("content-disposition");
	        for(String head:headers)
	        {

	        	if(head.indexOf("filename")>-1)
	        	{
					String[] ar =head.split("=");

					String newStr = ar[ar.length-1];

					fileName=newStr.substring(newStr.lastIndexOf(File.separator)+2, newStr.length()-1);
					//System.out.println("ADSADA:::::::::"+fileName);
	        	}
	        }

			File newFile = new File("/home/temp/file/"+fileName);
			   if (!newFile.exists()) {
			    newFile.createNewFile();
			   }
			   FileOutputStream outputStream = new FileOutputStream(newFile);
			   int read = 0;
			   byte[] bytes = new byte[102400];

			   while ((read = inputStream.read(bytes)) != -1) {
			    outputStream.write(bytes, 0, read);
			   }

		} catch (IllegalStateException | IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		  // FILE END
		LOGGER.debug("saveMandatoryCertification TrainingName: "
				+ mandatoryCertificationDTO.getTrainingName());
		LOGGER.debug("saveMandatoryCertification DateWeekPlanned: "
				+ mandatoryCertificationDTO.getDateWeekPlanned());
		LOGGER.debug("saveMandatoryCertification DateAttended: "
				+ mandatoryCertificationDTO.getDateAttended());
		LOGGER.debug("saveMandatoryCertification CompletionStatus: "
				+ mandatoryCertificationDTO.getCompletionStatus());
		mandatoryCertificationDTO.setUserId(profile.getId());
		// mandatoryCertificationService.save(mandatoryCertificationDTO);
		UserProfile userProfile = userProfileService
				.findByIdWithMandatoryCertification(profile.getId());
		model.addAttribute(Constants.MANDATORY_CERTIFICATION_LIST,
				userProfile.getMandatorycertifications());
		return "protected/mandatoryCertification_Show";
	}

	@RequestMapping(value = "showMandatoryCertification.html", method = RequestMethod.GET)
	public String showMandatoryCertificationForm1(
			final HttpServletRequest request, final Model model) {
		UserProfile profile = null;

		ContextAuthenticatedUserDetailsVO loggedInUser = getCurrentUser();
		if (loggedInUser != null) {
			profile = loggedInUser.getProfile();
		}
		System.out.println("PROFILE1------------------------" + profile);
		UserProfile userProfile = userProfileService
				.findByIdWithMandatoryCertification(profile.getId());
		System.out.println("PROFILE------------------------" + profile);
		model.addAttribute(Constants.MANDATORY_CERTIFICATION_LIST,
				userProfile.getMandatorycertifications());

		return "protected/mandatoryCertification_Show";
	}

	@RequestMapping(value = "mandatoryCertificationForUpdate.html", method = RequestMethod.GET)
	public String getMandatoryCertificationForUpdate(Model model,
			HttpServletRequest request, HttpServletResponse response) {

		LOGGER.info("Mandatory Certification ID:" + request.getParameter("id"));
		String id = request.getParameter("id");
		MandatoryCertification mandatoryCertification = mandatoryCertificationService
				.getMandatoryCertificationDetail(id);

		if (mandatoryCertification != null) {
			final MandatoryCertificationDTO mandatoryCertificationDTO = new MandatoryCertificationDTO();
			mandatoryCertificationDTO.setId(mandatoryCertification.getId());
			mandatoryCertificationDTO.setTrainingName(mandatoryCertification
					.getTrainingName());
			mandatoryCertificationDTO.setDateWeekPlanned(mandatoryCertification
					.getDateWeekPlanned());
			mandatoryCertificationDTO.setDateAttended(mandatoryCertification
					.getDateAttended());
			mandatoryCertificationDTO
					.setCompletionStatus(mandatoryCertification
							.getCompletionStatus());
			mandatoryCertificationDTO.setAttachFile(mandatoryCertification
					.getAttachFile());

			model.addAttribute("mandatoryCertificationDTO",
					mandatoryCertificationDTO);
		}
		return "protected/mandatoryCertification";
	}

	@RequestMapping(value = "removeMandatoryCertification.html", method = RequestMethod.GET)
	public String removeMandatoryCertification(Model model,
			Principal prinicpal, HttpServletRequest request,
			HttpServletResponse response) {
		LOGGER.debug("removeMandatoryCertification : ");
		LOGGER.debug("prinicpal : " + prinicpal);
		UserProfile userProfile = null;
		UserProfile profile = null;
		ContextAuthenticatedUserDetailsVO loggedInUser = getCurrentUser();
		LOGGER.debug("loggedInUser : " + loggedInUser);
		if (loggedInUser != null) {
			profile = loggedInUser.getProfile();
			LOGGER.debug("profile : " + profile);
			// userProfile =
			// userProfileService.findByIdWithAsset(profile.getId());
		}

		if (prinicpal != null) {
			String useName = prinicpal.getName();
			LOGGER.debug("useName : " + useName);
		}

		String id = request.getParameter("id");

		LOGGER.debug("MandatoryCertificationId : " + id);

		mandatoryCertificationService.remove(id);
		userProfile = userProfileService
				.findByIdWithMandatoryCertification(profile.getId());
		model.addAttribute(Constants.MANDATORY_CERTIFICATION_LIST,
				userProfile.getMandatorycertifications());

		return "protected/mandatoryCertification_Show";
	}

	@Autowired
	public void setMandatoryCertificationService(
			MandatoryCertificationService mandatoryCertificationService) {
		this.mandatoryCertificationService = mandatoryCertificationService;
	}

	@Autowired
	public void setUserProfileService(UserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}

}
