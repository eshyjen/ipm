package com.ericsson.ipm.v1.web.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ericsson.ipm.v1.domain.Certification;
import com.ericsson.ipm.v1.domain.UserProfile;
import com.ericsson.ipm.v1.dto.CertificationDTO;
import com.ericsson.ipm.v1.security.authentication.vo.ContextAuthenticatedUserDetailsVO;
import com.ericsson.ipm.v1.service.CertificationService;
import com.ericsson.ipm.v1.service.UserProfileService;
import com.ericsson.v1.util.Constants;

@Controller
@RequestMapping(Constants.BASE_PROTECTED_URL_PATH)
public class CertificationController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(Certification.class);
	private UserProfileService userProfileService;
	private CertificationService certificationService;

	@RequestMapping(value="certification.html", method=RequestMethod.GET)
	private String showCertificationDetails(final Model model, HttpServletRequest request ){
		System.out.println("Print cerification");
		final CertificationDTO certificationDTO = new CertificationDTO();
		model.addAttribute("certificationDTO", certificationDTO);
		return "protected/certification";
	}

	@RequestMapping(value="saveCertification.html", method=RequestMethod.POST)
	private String saveCertificationDetails(@Valid @ModelAttribute("certificationDTO") CertificationDTO certificationDTO,
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
				 		certification.setTni(certificationDTO.getTni());
				 		certification.setUserprofile(userProfileService.findById(profile.getId()));

				 		certificationService.saveOrUpdate(certification);
				        UserProfile userProfile = userProfileService
				                .findByIdWithCertification(profile.getId());
				        System.out.println("PROFILE------------------------" + profile);
				        model.addAttribute(Constants.CERTIFICATION_LIST,
				                userProfile.getCertifications());

				 	}
		return "protected/certification_Show";
	}

	@RequestMapping(value = "showCertification.html", method = RequestMethod.GET)
    public String showCertificationForm1(
            final HttpServletRequest request, final Model model) {
        UserProfile profile = null;

        ContextAuthenticatedUserDetailsVO loggedInUser = getCurrentUser();
        if (loggedInUser != null) {
            profile = loggedInUser.getProfile();
        }
        System.out.println("PROFILE1------------------------" + profile);
        UserProfile userProfile = userProfileService
                .findByIdWithCertification(profile.getId());
        System.out.println("PROFILE------------------------" + profile);
        model.addAttribute(Constants.CERTIFICATION_LIST,
                userProfile.getCertifications());

        return "protected/certification_Show";
    }
	@RequestMapping(value = "certificationForUpdate.html", method = RequestMethod.GET)
    public String getMandatoryCertificationForUpdate(Model model,
            HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("id");

        Certification certification = certificationService.getCertificationDetail(id);

        if (certification != null) {
            final CertificationDTO certificationDTO = new CertificationDTO();
            certificationDTO.setId(certificationDTO.getId());
            certificationDTO.setEmployeeType(certificationDTO.getEmployeeType());
            certificationDTO.setTrainingName(certificationDTO.getTrainingName());
            certificationDTO.setDateWeekPlanned(certificationDTO.getDateWeekPlanned());
            certificationDTO.setDateAttended(certificationDTO.getDateAttended());
            certificationDTO.setTni(certificationDTO.getTni());
            certificationDTO.setCompletionStatus(certificationDTO.getCompletionStatus());
            model.addAttribute("certificationDTO",
            		certificationDTO);
        }
        return "protected/certification";
    }


    @RequestMapping(value = "removeCertification.html", method = RequestMethod.GET)
    public String removeMandatoryCertification(Model model,
            Principal prinicpal, HttpServletRequest request,
            HttpServletResponse response) {
        LOGGER.debug("removeCertification : ");
        LOGGER.debug("prinicpal : " + prinicpal);
        UserProfile userProfile = null;
        UserProfile profile = null;
        ContextAuthenticatedUserDetailsVO loggedInUser = getCurrentUser();
        LOGGER.debug("loggedInUser : " + loggedInUser);
        if (loggedInUser != null) {
            profile = loggedInUser.getProfile();
            LOGGER.debug("profile : " + profile);

        }

        if (prinicpal != null) {
            String useName = prinicpal.getName();
            LOGGER.debug("useName : " + useName);
        }

        String id = request.getParameter("id");

        LOGGER.debug("CertificationId : " + id);

        certificationService.remove(id);
        userProfile = userProfileService
                .findByIdWithCertification(profile.getId());
        model.addAttribute(Constants.CERTIFICATION_LIST,
                userProfile.getCertifications());

        return "protected/certification_Show";
    }

    @Autowired
    public void setCertificationService(
            CertificationService certificationService) {
        this.certificationService = certificationService;
    }

    @Autowired
    public void setUserProfileService(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }
}
