package com.ericsson.ipm.v1.web.controllers;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

import com.ericsson.ipm.v1.domain.DeliveryQuality;
import com.ericsson.ipm.v1.domain.UserProfile;
import com.ericsson.ipm.v1.dto.DeliveryQualityDTO;
import com.ericsson.ipm.v1.security.authentication.vo.ContextAuthenticatedUserDetailsVO;
import com.ericsson.ipm.v1.service.DeliveryQualityService;
import com.ericsson.ipm.v1.service.UserProfileService;
import com.ericsson.v1.util.Constants;

/**
 * @author iqbal.hosain.khan@ericsson.com
 *
 */

@Controller
@RequestMapping(Constants.BASE_PROTECTED_URL_PATH)
public class DeliveryQualityController extends BaseController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(DeliveryQualityController.class);

	private UserProfileService userProfileService;

	private DeliveryQualityService  deliveryQualityService;


	@RequestMapping(value ="deliveryQuality.html", method = RequestMethod.GET)
	public String showDeliveryQualityForm(final HttpServletRequest request, final Model model) {
	    LOGGER.debug("Rendering deliveryQuality.jsp page.");
	    final DeliveryQualityDTO deliveryQualityDTO = new DeliveryQualityDTO();
	    model.addAttribute("deliveryQualityDTO", deliveryQualityDTO);
	    //model.addAttribute("roles", roleService.findAll());
	    return "protected/deliveryQuality_Update";
	}


	@RequestMapping(value = "saveDeliveryQualityDetails.html", method = RequestMethod.POST)
	public String saveDeliveryQualityDetails(@ModelAttribute("deliveryQualityDTO")DeliveryQualityDTO deliveryQualityDTO, Principal prinicpal,
			HttpServletRequest request, HttpServletResponse response, Model model) {

		/*boolean flag = true;
		String resultMessage = " ";
*/

		String pattern = "MM/dd/yyyy";
	    SimpleDateFormat format = new SimpleDateFormat(pattern);


		UserProfile userProfile = null;
		UserProfile profile = null;
		ContextAuthenticatedUserDetailsVO loggedInUser = getCurrentUser();
		LOGGER.debug("loggedInUser : " + loggedInUser);
		if (loggedInUser != null) {
			profile = loggedInUser.getProfile();
			LOGGER.debug("profile : " + profile);
			userProfile = userProfileService.getRefById(profile.getId());


		DeliveryQuality deliveryQuality = new DeliveryQuality();


		deliveryQuality.setProjectName(deliveryQualityDTO.getProjectName());
		deliveryQuality.setDpiScore(deliveryQualityDTO.getDpiScore());
		try {
			deliveryQuality.setDqiDate(format.parse(deliveryQualityDTO.getDqiDate()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		deliveryQuality.setDqiScore(deliveryQualityDTO.getDqiScore());
		deliveryQuality.setPmOrSpmName(deliveryQualityDTO.getPmOrSpmName());
		deliveryQuality.setProjectType(deliveryQualityDTO.getProjectType());
		deliveryQuality.setSwArchitectName(deliveryQualityDTO.getSwArchitectName());
		deliveryQuality.setTlName(deliveryQualityDTO.getTlName());
		deliveryQuality.setUserprofile(userProfileService.findById(profile.getId()));
		deliveryQualityService.save(deliveryQuality);
		}

		UserProfile UProfile  = userProfileService.findByIdWithDeliveryQuality(profile.getId());
		model.addAttribute(Constants.DELIVERY_QUALITY_LIST,
				UProfile.getDeliveryQualities());
		return "protected/deliveryQuality";
	}


	@RequestMapping(value = "deliveryQualityList.html", method = RequestMethod.GET)
	public String getDeliveryQualityDetails(Model model,
			Principal prinicpal, HttpServletRequest request,
			HttpServletResponse response) {
		LOGGER.info("prinicpal : " + prinicpal);
		UserProfile userProfile = null;
		ContextAuthenticatedUserDetailsVO loggedInUser = getCurrentUser();
		LOGGER.info("loggedInUser : " + loggedInUser);
		if (loggedInUser != null) {
			UserProfile profile = loggedInUser.getProfile();
			LOGGER.info("profile : " + profile);
			LOGGER.info("profile.getId() : " + profile.getId());
			userProfile = userProfileService
					.findByIdWithDeliveryQuality(profile.getId());
		}

		if (prinicpal != null) {
			String useName = prinicpal.getName();
			LOGGER.info("useName : " + useName);
		}

		LOGGER.info("userProfile : " + userProfile);

		LOGGER.info("useName : " + userProfile);
		model.addAttribute(Constants.DELIVERY_QUALITY_LIST,
				userProfile.getDeliveryQualities());
		return "protected/deliveryQuality";
	}


	@RequestMapping(value = "deliveryQualityForUpdate.html", method = RequestMethod.GET)
	public String getDeliveryQualityForUpdate(Model model,
			HttpServletRequest request, HttpServletResponse response) {

		LOGGER.info("deliveryQuality ID:" + request.getParameter("id"));
		String id = request.getParameter("id");
		DeliveryQuality deliveryQuality = deliveryQualityService.getDeliveryQualityDetail(id);
		if (deliveryQuality != null) {
			final DeliveryQualityDTO deliveryQualityDTO = new DeliveryQualityDTO();
			deliveryQualityDTO.setId(id);
			deliveryQualityDTO.setProjectName(deliveryQuality.getProjectName());
			deliveryQualityDTO.setProjectType(deliveryQuality.getProjectType());
			deliveryQualityDTO.setDpiScore(deliveryQuality.getDpiScore());
			deliveryQualityDTO.setDqiDate(deliveryQuality.getDqiScore());
			deliveryQualityDTO.setDqiScore(deliveryQuality.getDqiDate().toString());
			deliveryQualityDTO.setPmOrSpmName(deliveryQuality.getPmOrSpmName());
			deliveryQualityDTO.setSwArchitectName(deliveryQuality.getSwArchitectName());
			deliveryQualityDTO.setTlName(deliveryQuality.getTlName());
			model.addAttribute("deliveryQualityDTO",
					deliveryQualityDTO);
		}
		return "protected/deliveryQuality_Update";
	}



	@RequestMapping(value = "saveOrUpdateDeliveryQuality.html", method = RequestMethod.POST)
	public String saveOrUpdateDeliveryQuality(
			@ModelAttribute("deliveryQualityDTO") DeliveryQualityDTO deliveryQualityDTO,
			HttpServletRequest request, Model model) {
		ContextAuthenticatedUserDetailsVO loggedInUser = getCurrentUser();
		if (loggedInUser != null) {
			UserProfile profile = loggedInUser.getProfile();

			LOGGER.debug("deliveryQualityDTO Project Name from request: "
					+ deliveryQualityDTO.getProjectName());

			//deliveryQualityDTO.setUserId(profile.getId());
			DeliveryQuality deliveryQuality = new DeliveryQuality();
			deliveryQuality.setId(profile.getId());
			deliveryQuality.setProjectName(deliveryQualityDTO.getProjectName());
			deliveryQuality.setProjectType(deliveryQualityDTO.getProjectType());
			deliveryQuality.setDpiScore(deliveryQualityDTO.getDpiScore());
			deliveryQuality.setDqiScore(deliveryQualityDTO.getDqiScore());
			deliveryQuality.setUserprofile(userProfileService.findById(profile.getId()));
			deliveryQualityService.saveOrUpdate(deliveryQuality);
		}

		return "protected/deliveryQuality_Update";
	}


	@RequestMapping(value = "removeDeliveryQualityDetail.html", method = RequestMethod.GET)
	public void removeDeliveryQualityDetail(Model model, Principal prinicpal,
			HttpServletRequest request, HttpServletResponse response) {
		LOGGER.debug("removeAssetDetail : ");
		LOGGER.debug("prinicpal : " + prinicpal);
		UserProfile userProfile = null;
		ContextAuthenticatedUserDetailsVO loggedInUser = getCurrentUser();
		LOGGER.debug("loggedInUser : " + loggedInUser);
		if (loggedInUser != null) {
			UserProfile profile = loggedInUser.getProfile();
			LOGGER.debug("profile : " + profile);
			// userProfile =
			// userProfileService.findByIdWithAsset(profile.getId());
		}

		if (prinicpal != null) {
			String useName = prinicpal.getName();
			LOGGER.debug("useName : " + useName);
		}

			String assetId = request.getParameter("id");

		LOGGER.debug("assetId : " + assetId);

		// model.addAttribute(Constants.ASSET_LIST, userProfile.getAssets());
		return; // "protected/asset";
	}

	public UserProfileService getUserProfileService() {
		return userProfileService;
	}

	@Autowired
	public void setUserProfileService(UserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}


	public DeliveryQualityService getDeliveryQualityService() {
		return deliveryQualityService;
	}

	@Autowired
	public void setDeliveryQualityService(
			DeliveryQualityService deliveryQualityService) {
		this.deliveryQualityService = deliveryQualityService;
	}



}
