package com.ericsson.ipm.v1.web.controllers;

import java.io.PrintWriter;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ericsson.ipm.v1.domain.Asset;
import com.ericsson.ipm.v1.domain.OperationalDiscipline;
import com.ericsson.ipm.v1.domain.UserProfile;
import com.ericsson.ipm.v1.dto.AssetDTO;
import com.ericsson.ipm.v1.dto.DeliveryQualityDTO;
import com.ericsson.ipm.v1.dto.OperationalDisciplineDTO;
import com.ericsson.ipm.v1.security.authentication.vo.ContextAuthenticatedUserDetailsVO;
import com.ericsson.ipm.v1.service.AssetService;
import com.ericsson.ipm.v1.service.UserProfileService;
import com.ericsson.v1.util.Constants;

@Controller
@RequestMapping(Constants.BASE_PROTECTED_URL_PATH)
public class AssetController extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AssetController.class);

	private UserProfileService userProfileService;

	private AssetService assetService;

	@RequestMapping(value="assetDetails.html", method=RequestMethod.GET)
	public String getAssetDetails(Model model, Principal prinicpal, HttpServletRequest request, HttpServletResponse response) {
		LOGGER.info("prinicpal : "+prinicpal);
		UserProfile userProfile = null;
		ContextAuthenticatedUserDetailsVO loggedInUser = getCurrentUser();
		LOGGER.info("loggedInUser : "+loggedInUser);
		if(loggedInUser != null){
			UserProfile profile = loggedInUser.getProfile();
			LOGGER.info("profile : "+profile);
			LOGGER.info("profile.getId() : "+profile.getId());
			userProfile = userProfileService.findByIdWithAsset(profile.getId());
		}

		if(prinicpal != null){
			String useName = prinicpal.getName();
			LOGGER.info("useName : "+useName);
		}

		LOGGER.info("userProfile : "+userProfile);
		if(userProfile != null ){
			LOGGER.info("userProfile getAssets : "+userProfile.getAssets());
		}
		LOGGER.info("useName : "+userProfile);
		model.addAttribute(Constants.ASSET_LIST, userProfile.getAssets());
		return "protected/asset";
	}

	@RequestMapping(value="saveAssetDetails.html", method=RequestMethod.POST)
	public String saveAssetDetails(@ModelAttribute("assetDTO")AssetDTO assetDTO, Model model, Principal prinicpal, HttpServletRequest request, HttpServletResponse response) {

		//String pattern = "MM/dd/yyyy";
	   // SimpleDateFormat format = new SimpleDateFormat(pattern);

	    //UserProfile userProfile = null;
		ContextAuthenticatedUserDetailsVO loggedInUser = getCurrentUser();
		LOGGER.debug("saveAssetDetails : ");
		UserProfile profile = null;
		int id = assetDTO.getId();

		if(loggedInUser != null){
			profile = loggedInUser.getProfile();
			LOGGER.debug("profile : "+profile);
			Asset asset = new Asset();
			asset.setId(id);
			asset.setAssetName(assetDTO.getAssetName());
			asset.setApprovalStatus(assetDTO.getApprovalStatus());
			asset.setAssetShortDescription(assetDTO.getAssetShortDescription());
			asset.setEffortSave(assetDTO.getEffortSave());
			asset.setProjectName(assetDTO.getProjectName());
			asset.setRegisteredInAssetPortal(assetDTO.getRegisteredInAssetPortal());
			asset.setReusedInOtherProjectsName(assetDTO.getReusedInOtherProjectsName());
			asset.setCreationDate(new Date());
			asset.setModifiedDate(new Date());
			asset.setUserprofile(userProfileService.findById(profile.getId()));
			assetService.saveOrUpdate(asset);
		}

		UserProfile uProfile = userProfileService.findByIdWithAsset(profile.getId());
		model.addAttribute(Constants.ASSET_LIST, uProfile.getAssets());

		return "protected/asset";
	}

	@RequestMapping(value = "assetForUpdate.html", method = RequestMethod.GET)
	public String getAssetForUpdate(Model model,
			HttpServletRequest request, HttpServletResponse response) {

		LOGGER.info("Operational Discipline ID:" + request.getParameter("id"));
		String id = request.getParameter("id");
		Asset asset = assetService.getAssetDetail(id);
		if (asset != null) {
			final AssetDTO assetDTO = new AssetDTO();
			assetDTO.setId(asset.getId());
			assetDTO.setApprovalStatus(asset.getApprovalStatus());
			assetDTO.setAssetName(asset.getAssetName());
			assetDTO.setAssetShortDescription(asset.getAssetShortDescription());
			assetDTO.setEffortSave(asset.getEffortSave());
			assetDTO.setProjectName(asset.getProjectName());
			assetDTO.setRegisteredInAssetPortal(asset.getRegisteredInAssetPortal());
			assetDTO.setReusedInOtherProjectsName(asset.getReusedInOtherProjectsName());
			model.addAttribute("assetDTO", assetDTO);
		}
		return "protected/asset_update";
	}


	@RequestMapping(value="removeAssetDetail.html", method=RequestMethod.GET)
	public String removeAssetDetail(Model model, Principal prinicpal, HttpServletRequest request, HttpServletResponse response) {
		LOGGER.debug("removeAssetDetail : ");
		LOGGER.debug("prinicpal : "+prinicpal);
		UserProfile userProfile = null;
		UserProfile profile = null;
		ContextAuthenticatedUserDetailsVO loggedInUser = getCurrentUser();
		LOGGER.debug("loggedInUser : "+loggedInUser);
		if(loggedInUser != null){
			profile = loggedInUser.getProfile();
			LOGGER.debug("profile : "+profile);
			//userProfile = userProfileService.findByIdWithAsset(profile.getId());
		}

		if(prinicpal != null){
			String useName = prinicpal.getName();
			LOGGER.debug("useName : "+useName);
		}

		String assetId = request.getParameter("id");

		LOGGER.debug("assetId : "+assetId);


		assetService.remove(assetId);
		userProfile = userProfileService.findByIdWithAsset(profile.getId());
		model.addAttribute(Constants.ASSET_LIST, userProfile.getAssets());

		return "protected/asset";
	}



	@RequestMapping(value ="asset.html", method = RequestMethod.GET)
	public String showAssetForm(final HttpServletRequest request, final Model model) {
	    LOGGER.debug("Rendering asset.jsp page.");
	    final AssetDTO assetDTO = new AssetDTO();
	    model.addAttribute("assetDTO", assetDTO);
	    //model.addAttribute("roles", roleService.findAll());
	    return "protected/asset_update";
	}



	@Autowired
	public void setUserProfileService(UserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}

	@Autowired
	public void setAssetService(AssetService assetService) {
		this.assetService = assetService;
	}

}
