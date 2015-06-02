/**
 * 
 */
package com.ericsson.ipm.v1.web.controllers;

import java.lang.reflect.InvocationTargetException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ericsson.ipm.v1.domain.KPI;
import com.ericsson.ipm.v1.domain.KPIRoleAssignment;
import com.ericsson.ipm.v1.domain.Role;
import com.ericsson.ipm.v1.domain.UserProfile;
import com.ericsson.ipm.v1.domain.UserRoleAssignment;
import com.ericsson.ipm.v1.dto.EmployeeDTO;
import com.ericsson.ipm.v1.dto.KPIIdNameDTO;
import com.ericsson.ipm.v1.security.authentication.vo.ContextAuthenticatedUserDetailsVO;
import com.ericsson.ipm.v1.service.UserProfileService;
import com.ericsson.v1.util.Constants;
import com.ericsson.v1.util.IPMUtility;
import com.google.visualization.datasource.DataSourceHelper;
import com.google.visualization.datasource.DataSourceRequest;
import com.google.visualization.datasource.base.ReasonType;
import com.google.visualization.datasource.base.ResponseStatus;
import com.google.visualization.datasource.base.StatusType;
import com.google.visualization.datasource.base.TypeMismatchException;
import com.google.visualization.datasource.datatable.ColumnDescription;
import com.google.visualization.datasource.datatable.DataTable;
import com.google.visualization.datasource.datatable.value.ValueType;


/**
 * @author iqbal.hosain.khan@ericsson.com
 * <%-- <jsp:include page="/WEB-INF/views/public/include_header.jsp" /> --%>
 */
@Controller
@RequestMapping(Constants.BASE_PROTECTED_URL_PATH)
public class UserController extends BaseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	
	private UserProfileService userProfileService;
	
	@RequestMapping(value="userDetails.html", method=RequestMethod.GET)
	public String getUserDetails(Model model) {
		ContextAuthenticatedUserDetailsVO loggedInUser = getCurrentUser();
		LOGGER.debug("loggedInUser : "+loggedInUser);
		model.addAttribute(loggedInUser.getProfile());
		return "protected/userdetails";
	}
	
	/*<%
	
	Set<KPIIdNameDTO> kpiIdNameDTOs = (HashSet<KPIIdNameDTO>)session.getAttribute("kpiDisplayNames");
	for(KPIIdNameDTO dto : kpiIdNameDTOs){
		
	}
	%>*/
	
	@RequestMapping(value="ipmDashboard.html", method=RequestMethod.GET)
	public String getIPMDashboard(Model model, Principal prinicpal, HttpServletRequest request) {
		List<KPI> kpis = new ArrayList<KPI>();
		Set<KPIIdNameDTO> kpiIdNameDTOs = new HashSet<KPIIdNameDTO>();
		LOGGER.debug("prinicpal : "+prinicpal);
		
		ContextAuthenticatedUserDetailsVO loggedInUser = getCurrentUser();
		LOGGER.debug("loggedInUser : "+loggedInUser);
		if(loggedInUser != null){
			UserProfile profile = loggedInUser.getProfile();
			LOGGER.debug("profile : "+profile);
			
			for(UserRoleAssignment  userRoleAssignment : profile.getRoleAssignments()){
				Role role = userRoleAssignment.getRole();
				for(KPIRoleAssignment KPIRoleAssignment : role.getKpiRoleAssignments()) {
					KPI kpi = KPIRoleAssignment.getKpi();
					kpis.add(kpi);	
					KPIIdNameDTO nameDTO = new KPIIdNameDTO();
					nameDTO.setId(IPMUtility.getParamValue(kpi.getKpiDisplayName()));
					nameDTO.setName(kpi.getKpiDisplayName());
					kpiIdNameDTOs.add(nameDTO);
				}
				
			}
		}
		
		if(prinicpal != null){
			String useName = prinicpal.getName();
			LOGGER.debug("useName : "+useName);
		}
		
		
		model.addAttribute("kpis", kpis);
		HttpSession session = request.getSession();
		session.setAttribute("kpiDisplayNames", kpiIdNameDTOs);
		//model.addAttribute("kpiDisplayNames", kpiIdNameDTOs);
		return "protected/welcome";
	}
	
	@Autowired
	public void setUserProfileService(UserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}
	
	
	
	
	@RequestMapping(value="updateUserDetails.html", method=RequestMethod.POST)
	public String updateUserDetails(HttpServletRequest request, Model model) {
		String[] props = {
		"userFristName",
		"userLastName",
		"emailId",
		"costCenter",
		"currentLineManager",
		"educationalQualification",
		"employeeId",
		"jobRole",
		"jobStage",
		"lastYearIPMRating",
		"manHourRate",
		"previousLineManeger",
		"previousOrganisation",
		"signunId",
		"yearOfIPM",
		"yearOfLastPromotion"};
		
		// "dateOfJoinInMediaAccount",
		// "id",
		// "totalEricssonExperienceInMonths",
		// "totalITExperience",
		// "totalYearsOfExperience",
		
		LOGGER.debug("updateUserDetails : "+request);
		
		/*ContextAuthenticatedUserDetailsVO loggedInUser = getCurrentUser();
		LOGGER.debug("loggedInUser : "+loggedInUser);
			UserProfile profile = loggedInUser.getProfile();
			LOGGER.debug("profile : "+profile);*/
			
			List<UserProfile> userProfiles = userProfileService.findBySignumId(request.getParameter("signunId"));
			UserProfile profile = null;
			if (userProfiles != null && userProfiles.size() > 0) {
				profile = userProfiles.get(0);
			}
			for (int i = 0; i < props.length; i++) {
			String value = request.getParameter(props[i]);
			try {
				BeanUtils.copyProperty(profile, props[i], value);
			} catch (IllegalAccessException e) {
				LOGGER.error("updateUserDetails IllegalAccessException : "+profile);
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				LOGGER.error("updateUserDetails InvocationTargetException : "+profile);
				e.printStackTrace();
			}
		}
		
			profile = userProfileService.update(profile);
			model.addAttribute(profile);
			LOGGER.debug("updateUserDetails profile : "+profile);
		return "protected/userdetails";
	}
	
	
	
	@RequestMapping(value="orgChartDetails.html", method=RequestMethod.GET)
	public String getOrgChartDetails(Model model, HttpServletRequest request, HttpServletResponse response) {
		ContextAuthenticatedUserDetailsVO loggedInUser = getCurrentUser();
		LOGGER.debug("loggedInUser : "+loggedInUser);
		//model.addAttribute(loggedInUser.getProfile());
		return "protected/OrgChart";
	}
	
	@RequestMapping(value="managedPeopleDetails.html", method=RequestMethod.GET)
	public String getManagedPeopleDetails(Model model, HttpServletRequest request, HttpServletResponse response) {
		ContextAuthenticatedUserDetailsVO loggedInUser = getCurrentUser();
		LOGGER.debug("loggedInUser : "+loggedInUser);
		
		String signum = null;
		ContextAuthenticatedUserDetailsVO authenticatedUserDetailsVO = null;
		Map<String, String> managedPeopleMap = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		LOGGER.debug("principal : "+principal);
	    if (principal instanceof UserDetails) 
	    {
	        signum = ((UserDetails) principal).getUsername();
	        LOGGER.debug("signum : "+signum);
	    	authenticatedUserDetailsVO = (ContextAuthenticatedUserDetailsVO)principal;
	    }
	    if(StringUtils.isNotBlank(signum)){
	    	Map<String, String> pfDetailsMap = userProfileService.generateExactPfUrl(signum);
	    	managedPeopleMap = userProfileService.fetchManagedPeopleList(pfDetailsMap);
	    }
		
	    List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
		
	    Set<String> set = managedPeopleMap.keySet();
		for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			String string = (String) iterator.next();
			employeeDTO.setSignum(string);
			employeeDTO.setName(managedPeopleMap.get(string));
			employeeDTOs.add(employeeDTO);
		}
	    
		model.addAttribute(Constants.EMPLOYEE_LIST, employeeDTOs);
		return "protected/managedPeople";
	}
	
	
	@RequestMapping(value="orgChart.html", method=RequestMethod.GET)
	public void getOrgChartDetail(Model model, HttpServletRequest request, HttpServletResponse response) {
		ContextAuthenticatedUserDetailsVO loggedInUser = getCurrentUser();
		LOGGER.debug("loggedInUser : "+loggedInUser);
		
		String signum = null;
		ContextAuthenticatedUserDetailsVO authenticatedUserDetailsVO = null;
		Map<String, String> managedPeopleMap = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		LOGGER.debug("principal : "+principal);
	    if (principal instanceof UserDetails) 
	    {
	        signum = ((UserDetails) principal).getUsername();
	        LOGGER.debug("signum : "+signum);
	    	authenticatedUserDetailsVO = (ContextAuthenticatedUserDetailsVO)principal;
	    }
	    if(StringUtils.isNotBlank(signum)){
	    	Map<String, String> pfDetailsMap = userProfileService.generateExactPfUrl(signum);
	    	managedPeopleMap = userProfileService.fetchManagedPeopleList(pfDetailsMap);
	    }
	    
	    DataTable data = generateMyDataTable(signum, authenticatedUserDetailsVO, managedPeopleMap);
		DataSourceRequest dsRequest = null;
		
		try {
			// Extract the datasource request parameters.
			dsRequest = new DataSourceRequest(request);
			// NOTE: If you want to work in restricted mode, which means that
			// only
			// requests from the same domain can access the data source,
			// uncomment the following call.
			//
			// DataSourceHelper.verifyAccessApproved(dsRequest);
			// Apply the query to the data table.
			//DataTable newData = DataSourceHelper.applyQuery(dsRequest.getQuery(), data, dsRequest.getUserLocale());
			// Set the response.
			DataSourceHelper.setServletResponse(data, dsRequest, response);
		} catch (Exception rte) {
			LOGGER.error("A runtime exception has occured", rte);
			ResponseStatus status = new ResponseStatus(StatusType.ERROR,
					ReasonType.INTERNAL_ERROR, rte.getMessage());
			if (dsRequest == null) {
				dsRequest = DataSourceRequest.getDefaultDataSourceRequest(request);
			}
		} 
		return ;
	}
	
	
	
	
	
	
	
	
	private DataTable generateMyDataTable(String signum, ContextAuthenticatedUserDetailsVO authenticatedUserDetailsVO, 
			Map<String, String> managedPeopleMap) {
		// Create a data table,
		DataTable data = new DataTable();
		ArrayList<ColumnDescription> cd = new ArrayList<ColumnDescription>();
		cd.add(new ColumnDescription("Name", ValueType.TEXT, "Name"));
		cd.add(new ColumnDescription("Manager", ValueType.TEXT, "Manager"));
		cd.add(new ColumnDescription("ToolTip", ValueType.TEXT, "ToolTip"));
		data.addColumns(cd);
		// Fill the data table.
		try {
			UserProfile profile = authenticatedUserDetailsVO.getProfile();
			data.addRowFromValues(signum, profile.getUserFristName() +" "+profile.getUserLastName()+"<div style='color:red; font-style:italic'>President</div>", "The President");
			Set<String> set = managedPeopleMap.keySet();
			for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
				String string = (String) iterator.next();
				data.addRowFromValues(string,signum, managedPeopleMap.get(string));
			}

		} catch (TypeMismatchException e) {
			System.out.println("Invalid type!");
		}
		return data;
	}
	
	
	/*private static UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		UserController.userService = userService;
	}
	
	public static User getCurrentUser()
	{
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    if (principal instanceof UserDetails) 
	    {
	    	String email = ((UserDetails) principal).getUsername();
	    	User loginUser = userService.findUserByEmail(email);
	    	return new SecurityUser(loginUser);
	    }

	    return null;
	}*/
}

