package com.ericsson.ipm.v1.web.controllers;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ericsson.ipm.v1.domain.Asset;
import com.ericsson.ipm.v1.domain.MandatoryCertification;
import com.ericsson.ipm.v1.domain.UserProfile;
import com.ericsson.ipm.v1.dto.MandatoryCertificationDTO;
import com.ericsson.ipm.v1.security.authentication.vo.ContextAuthenticatedUserDetailsVO;
import com.ericsson.ipm.v1.service.MandatoryCertificationService;
import com.ericsson.ipm.v1.service.MandatoryCertificationServiceImpl;
import com.ericsson.ipm.v1.service.UserProfileService;
import com.ericsson.v1.util.Constants;
import com.sun.mail.iap.Response;


@Controller
@RequestMapping(Constants.BASE_PROTECTED_URL_PATH)
public class MandatoryCertificationController extends BaseController{

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MandatoryCertificationController.class);

	private MandatoryCertificationService mandatoryCertificationService;

	private UserProfileService userProfileService;


	@RequestMapping(value = "mandatoryCertification.html", method = RequestMethod.GET)
	public String showMandatoryCertificationForm(
			final HttpServletRequest request, final Model model) {
		LOGGER.debug("Rendering MandatoryCertification.jsp page.");
		final MandatoryCertificationDTO mandatoryCertificationDTO = new MandatoryCertificationDTO();
		model.addAttribute("mandatoryCertificationDTO", mandatoryCertificationDTO);
		// model.addAttribute("roles", roleService.findAll());
		return "protected/mandatoryCertification";
	}



	@RequestMapping(value = "saveMandatoryCertification.html", method = RequestMethod.POST)
	public String saveMandatoryCertificationForm(@ModelAttribute("mandatoryCertificationDTO") MandatoryCertificationDTO mandatoryCertificationDTO,
			HttpServletRequest request, Model model)
	{

		UserProfile profile = null;

		ContextAuthenticatedUserDetailsVO loggedInUser = getCurrentUser();
		int id=mandatoryCertificationDTO.getId();
		if (loggedInUser != null) {
			 profile = loggedInUser.getProfile();
			 
			 MandatoryCertification mandatoryCertification=new MandatoryCertification();
			 mandatoryCertification.setId(id);
			 mandatoryCertification.setTrainingName(mandatoryCertificationDTO.getTrainingName());
			 mandatoryCertification.setDateWeekPlanned(mandatoryCertificationDTO.getDateWeekPlanned());
			 mandatoryCertification.setDateAttended(mandatoryCertificationDTO.getDateAttended());
			 mandatoryCertification.setCompletionStatus(mandatoryCertificationDTO.getCompletionStatus());
			 mandatoryCertification.setUserprofile(userProfileService.findById(profile.getId()));
			 
			 mandatoryCertificationService.saveOrUpdate(mandatoryCertification);
			 
		}

		LOGGER.debug("saveMandatoryCertification TrainingName: "
				+ mandatoryCertificationDTO.getTrainingName());
		LOGGER.debug("saveMandatoryCertification DateWeekPlanned: "
				+ mandatoryCertificationDTO.getDateWeekPlanned());
		LOGGER.debug("saveMandatoryCertification DateAttended: "
				+ mandatoryCertificationDTO.getDateAttended());
		LOGGER.debug("saveMandatoryCertification CompletionStatus: "
				+ mandatoryCertificationDTO.getCompletionStatus());

		mandatoryCertificationDTO.setUserId(profile.getId());
		//mandatoryCertificationService.save(mandatoryCertificationDTO);
		UserProfile userProfile = userProfileService
				.findByIdWithMandatoryCertification(profile.getId());
		
		model.addAttribute(Constants.MANDATORY_CERTIFICATION_LIST,
				userProfile.getMandatorycertifications());
		return "protected/mandatoryCertification_Show";





	}

	@RequestMapping(value="showMandatoryCertification.html", method=RequestMethod.POST)

	public String showMandatoryCertificationForm1(final HttpServletRequest request, final Model model) {
		LOGGER.debug("Rendering MandatoryCertification_Show.jsp page.");
		final MandatoryCertificationDTO mandatoryCertificationDTO = new MandatoryCertificationDTO();
		model.addAttribute("mandatoryCertificationDTO", mandatoryCertificationDTO);
		// model.addAttribute("roles", roleService.findAll());
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
