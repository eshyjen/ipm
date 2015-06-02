package com.ericsson.ipm.v1.web.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ericsson.ipm.v1.domain.Employee;
import com.ericsson.ipm.v1.domain.EmployeeSkill;
import com.ericsson.ipm.v1.domain.SkillMaster;
import com.ericsson.ipm.v1.domain.UserProfile;
import com.ericsson.ipm.v1.dto.CADTO;
import com.ericsson.ipm.v1.dto.CADTOs;
import com.ericsson.ipm.v1.dto.NameIdDTO;
import com.ericsson.ipm.v1.security.authentication.vo.ContextAuthenticatedUserDetailsVO;
import com.ericsson.ipm.v1.service.SkillCategoryService;
import com.ericsson.ipm.v1.service.UserProfileService;
import com.ericsson.v1.util.Constants;

@Controller
@RequestMapping(Constants.BASE_PROTECTED_URL_PATH)
public class CompetenceAssessmentController extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CompetenceAssessmentController.class);

	private UserProfileService userProfileService;

	private SkillCategoryService skillCategoryService;

	@RequestMapping(value="caDetails.html", method=RequestMethod.GET)
	public String getCADetails(Model model, Principal prinicpal, HttpServletRequest request, HttpServletResponse response) {
		LOGGER.info("prinicpal : "+prinicpal);
		UserProfile userProfile = null;
		ContextAuthenticatedUserDetailsVO loggedInUser = getCurrentUser();
		LOGGER.info("loggedInUser : "+loggedInUser);


		if(prinicpal != null){
			userProfile = loggedInUser.getProfile();
			String useName = prinicpal.getName();
			LOGGER.info("useName : "+useName);
		}

		int doid = Integer.parseInt(request.getParameter("doid"));
		int scid = Integer.parseInt(request.getParameter("scid"));
		int eid = userProfile.getId();
		CADTOs cadtOs = new CADTOs();
		//LOGGER.info("skillCategoryService : "+skillCategoryService);
		List<CADTO> list = skillCategoryService.getEmployeeCASkill(doid, scid, eid);
		cadtOs.getList().addAll(list);
		model.addAttribute(Constants.CA_LIST , cadtOs);
		return "protected/caTechdetails";
	}


	@RequestMapping(value="saveCADetails.html", method=RequestMethod.POST)
	public String saveCADetails(Model model, Principal prinicpal, HttpServletRequest request, HttpServletResponse response) {
		LOGGER.info("prinicpal : "+prinicpal);
		UserProfile userProfile = null;
		ContextAuthenticatedUserDetailsVO loggedInUser = getCurrentUser();
		LOGGER.info("loggedInUser : "+loggedInUser);


		if(prinicpal != null){
			userProfile = loggedInUser.getProfile();
			String useName = prinicpal.getName();
			LOGGER.info("useName : "+useName);
		}

		Enumeration<String> enumeration =  request.getParameterNames();

		Integer empId = 1;
		List<Integer> smIds =  new ArrayList<Integer>();
		List<EmployeeSkill> employeeSkills =  new ArrayList<EmployeeSkill>();
		while (enumeration.hasMoreElements()) {
			String key = (String) enumeration.nextElement();
			if(StringUtils.isNumeric(key)){
				smIds.add(Integer.parseInt(key));
				EmployeeSkill employeeskill = new EmployeeSkill();
				LOGGER.info("key : "+key);
				String value = request.getParameter(key);
				LOGGER.info("value : "+value);
				String actualValue = value;
				employeeskill.setActualSkill(actualValue);
				SkillMaster skillmaster = skillCategoryService.getRefById(Integer.parseInt(key));
				Employee employee = skillCategoryService.getRefByEmployeeId(empId);
				employeeskill.setSkillMaster(skillmaster);
				employeeskill.setEmployee(employee);
				employeeSkills.add(employeeskill);
			}
		}

		skillCategoryService.deleteEmployeeSkill(empId, smIds);
		skillCategoryService.saveEmployeeskills(employeeSkills);

		/*while (enumeration.hasMoreElements()) {
			String key = (String) enumeration.nextElement();
			if(StringUtils.isNumeric(key)){
				EmployeeSkill employeeskill = new EmployeeSkill();
				LOGGER.info("key : "+key);
				String value = request.getParameter(key);
				LOGGER.info("value : "+value);
				String actualValue = value;
				employeeskill.setActualSkill(actualValue);
				SkillMaster skillmaster = skillCategoryService.getRefById(Integer.parseInt(key));
				Employee employee = skillCategoryService.getRefByEmployeeId(empId);
				employeeskill.setSkillMaster(skillmaster);
				employeeskill.setEmployee(employee);
				skillCategoryService.saveEmployeeskill(employeeskill);
			}
		}*/

		int doid = 1; //Integer.parseInt(request.getParameter("doid"));
		int scid = 1; //Integer.parseInt(request.getParameter("scid"));
		int eid = userProfile.getId();
		CADTOs cadtOs = new CADTOs();
		List<CADTO> list = skillCategoryService.getEmployeeCASkill(doid, scid, eid);
		cadtOs.getList().addAll(list);
		//model.addAttribute(Constants.CA_LIST , getSkillMaster());
		model.addAttribute(Constants.CA_LIST , cadtOs);
		return "protected/caTechdetails";
	}



	@Autowired
	public void setUserProfileService(UserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}

	@Autowired
	public void setSkillCategoryService(SkillCategoryService skillCategoryService) {
		this.skillCategoryService = skillCategoryService;
	}




	private CADTOs getSkillMaster(){
		CADTOs cadtOs = new CADTOs();
		List<CADTO> list =  new ArrayList<CADTO>();

		CADTO cadto1 = new CADTO();
		cadto1.setSkillMasterId(100);
		cadto1.setCARequiredValue("B");
		cadto1.setCAName("JMS");

		CADTO cadto2 = new CADTO();
		cadto2.setSkillMasterId(101);
		cadto2.setCARequiredValue("D");
		cadto2.setCAName("SOA");

		list.add(cadto1);
		list.add(cadto2);

		String caOptions = Constants.CA_OPTIONS;
		String[] caOptionsArray = caOptions.split(",");

		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			CADTO cadto = (CADTO) iterator.next();
			for(int i = 0; i<caOptionsArray.length; i++){
				NameIdDTO nameIdDTO = new NameIdDTO();
				nameIdDTO.setId(caOptionsArray[i]+"-"+cadto.getSkillMasterId());
				nameIdDTO.setName(caOptionsArray[i]);
				cadto.getOptions().add(nameIdDTO);
			}
		}

		cadtOs.getList().addAll(list);

		return cadtOs;

	}

}
