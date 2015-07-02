package com.ericsson.ipm.v1.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ericsson.ipm.v1.domain.Certification;
import com.ericsson.ipm.v1.domain.MandatoryCertification;
import com.ericsson.ipm.v1.domain.UserProfile;
import com.ericsson.ipm.v1.dto.CertificationDTO;
import com.ericsson.ipm.v1.dto.MandatoryCertificationDTO;
import com.ericsson.ipm.v1.security.authentication.vo.ContextAuthenticatedUserDetailsVO;
import com.ericsson.ipm.v1.service.CertificationService;
import com.ericsson.ipm.v1.service.UserProfileService;
import com.ericsson.v1.util.Constants;

@Controller
@RequestMapping(Constants.BASE_PROTECTED_URL_PATH)
public class CertificationController extends BaseController {
	private UserProfileService userProfileService;
	private CertificationService certificationService;
	@RequestMapping(value="showCertification.html", method=RequestMethod.GET)
	private String showCertificationDetails(@ModelAttribute("certificationDTO") CertificationDTO certificationDTO,
            BindingResult result,final Model model, HttpServletRequest request ){
		System.out.println("Print cerification");

		model.addAttribute("certification", certificationDTO);
		return "protected/certification_Show";
	}
	@RequestMapping(value="certification.html", method=RequestMethod.GET)
	private String addCertificationDetails(final Model model , HttpServletRequest request){
		CertificationDTO certificationDTO = new CertificationDTO();
		model.addAttribute("certificationDTO", certificationDTO);
		return "protected/certification";
	}
	@RequestMapping(value="saveCertification.html", method=RequestMethod.POST)
	private String saveCertificationDetails(@ModelAttribute("certificationDTO") CertificationDTO certificationDTO,
            BindingResult result,final Model model, HttpServletRequest request){
				UserProfile profile;
				 ContextAuthenticatedUserDetailsVO loggedInUser = getCurrentUser();
				 	int id = certificationDTO.getId();
				 	if(loggedInUser != null){
				 		profile = loggedInUser.getProfile();
				 		Certification certification = new Certification();
				 		certification.setId(id);
				 		certification.setEmployeeType(certificationDTO.getEmployeeType());
				 		certification.setTrainingName(certificationDTO.getTrainingName());
				 		certification.setDateWeekPlanned(certificationDTO.getDateWeekPlanned());
				 		certification.setDateAttended(certificationDTO.getDateAttended());
				 		certification.setCompletionStatus(certificationDTO.getCompletionStatus());
				 		certification.setUserprofile(userProfileService.findById(profile.getId()));

				 		certificationService.saveOrUpdate(certification);
				 	}
		return null;
	}


}
