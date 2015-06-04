package com.ericsson.ipm.v1.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;







import org.apache.commons.configuration.Configuration;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ericsson.ipm.v1.dao.UserProfileDAO;
import com.ericsson.ipm.v1.dao.VerificationTokenDAO;
import com.ericsson.ipm.v1.domain.Employee;
import com.ericsson.ipm.v1.domain.JobStage;
import com.ericsson.ipm.v1.domain.Role;
import com.ericsson.ipm.v1.domain.UserProfile;
import com.ericsson.ipm.v1.domain.UserRoleAssignment;
import com.ericsson.ipm.v1.domain.VerificationToken;
import com.ericsson.ipm.v1.dto.RegistrationDTO;
import com.ericsson.ipm.v1.exception.EmailExistsException;
import com.ericsson.ipm.v1.perser.PeopleFinderPerser;
import com.ericsson.v1.util.AdaptersConfiguration;
import com.ericsson.v1.util.Constants;

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserProfileServiceImpl.class);

	private static final Configuration CONFIG = AdaptersConfiguration
			.getInstance().getConfiguration();
	
	private UserProfileDAO userProfileDAO;
	
	private RoleService roleService;
	
	private VerificationTokenDAO verificationTokenDAO;
	
	private SkillCategoryService skillCategoryService;
	
	@Override
	public List<UserProfile> findBySignumId(String signumId) {
		LOGGER.debug("signumId : "+signumId);
		return userProfileDAO.findBySignunid(signumId);
	}

	@Override
	public UserProfile findById(Integer userId) {
		LOGGER.debug("userId : "+userId);
		return userProfileDAO.findById(userId);
	}

	@Override
	public UserProfile findByEmail(String email) {
		LOGGER.debug("email : "+email);
		return null;
	}

	@Override
	public UserProfile findUserDetailsById(Integer userId) {
		LOGGER.debug("userId : "+userId);
		return null;
	}

	@Override
	public UserProfile save(UserProfile entity) {
		
		return userProfileDAO.save(entity);
	}

	@Override
	public void remove(UserProfile entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserProfile update(UserProfile entity) {
		return userProfileDAO.update(entity);
	}

	@Override
	public List<UserProfile> findAll() {
		return userProfileDAO.findAll();
	}
	
	public List<UserProfile> findBySignunidWithRole(Object signunid) {
		return userProfileDAO.findBySignunidWithRole(signunid);
	}
	
	public UserProfile findByIdWithAsset(Object id) {
		UserProfile userProfile = null;
		List<UserProfile> userProfiles = userProfileDAO.findByIdWithAsset(id);
		LOGGER.debug("userProfiles : "+userProfiles);
		if(userProfiles != null && userProfiles.size() > 0){
			userProfile = userProfiles.get(0);
			
			
		}
		LOGGER.debug("userProfile : "+userProfile);
		return userProfile;
		
	}

	@Override
	public UserProfile getRefById(Integer userId) {
		// TODO Auto-generated method stub
		return userProfileDAO.getRefById(userId);
	}
	
	public UserProfile findByIdWithDeliveryQuality(Object id) {
		UserProfile userProfile = null;
		List<UserProfile> userProfiles = userProfileDAO.findByIdWithDeliveryQuality(id);
		LOGGER.debug("userProfiles : "+userProfiles);
		if(userProfiles != null && userProfiles.size() > 0){
			userProfile = userProfiles.get(0);
		}
		LOGGER.debug("userProfile : "+userProfile);
		return userProfile;
		
	}

	public UserProfile findByIdWithOperationalDiscipline(Object id) {
		UserProfile userProfile = null;
		List<UserProfile> userProfiles = userProfileDAO.findByIdWithOperationalDiscipline(id);
		LOGGER.debug("userProfiles for OperationalDiscipline: "+userProfiles);
		if(userProfiles != null && userProfiles.size() > 0){
			userProfile = userProfiles.get(0);
		}
		LOGGER.debug("userProfile : "+userProfile);
		return userProfile;

	}

	@Override
    public UserProfile registerNewUserAccount(final RegistrationDTO accountDto) throws EmailExistsException {
        if (emailExist(accountDto.getEmailId())) {
            throw new EmailExistsException("There is an account with that email adress: " + accountDto.getEmailId());
        }
        final Date date = new Date();
		final UserProfile userProfile = new UserProfile();
		final List<UserRoleAssignment> roleAssignments = new ArrayList<UserRoleAssignment>();
		
		Role role = roleService.findById(accountDto.getUserSelectedRole());

		userProfile.setCostCenter(accountDto.getCostCenter());
		userProfile.setCurrentLineManager(accountDto.getCurrentLineManager());
		userProfile.setDateOfJoinInMediaAccount(date);
		userProfile.setEducationalQualification(accountDto.getEducationalQualification());
		userProfile.setEmailId(accountDto.getEmailId());
		userProfile.setEmployeeId(accountDto.getEmployeeId());
		userProfile.setJobRole(role.getCode());
		userProfile.setJobStage(accountDto.getJobStage());
		userProfile.setLastYearIPMRating(accountDto.getLastYearIPMRating());
		userProfile.setManHourRate(accountDto.getManHourRate());
		userProfile.setModifiedDate(date);
		userProfile.setPassword(accountDto.getPassword());
		userProfile.setPreviousLineManeger(accountDto.getPreviousLineManeger());
		userProfile.setPreviousOrganisation(accountDto.getPreviousOrganisation());
		userProfile.setRegistrationDate(date);
		userProfile.setRole(Boolean.FALSE);
		userProfile.setSignunId(accountDto.getEmailId());
		userProfile.setTotalEricssonExperienceInMonths(accountDto.getTotalEricssonExperienceInMonths());
		userProfile.setTotalITExperience(accountDto.getTotalITExperience());
		userProfile.setTotalYearsOfExperience(accountDto.getTotalYearsOfExperience());
		userProfile.setUserFristName(accountDto.getUserFristName());
		userProfile.setUserLastName(accountDto.getUserLastName());
		userProfile.setYearOfIPM("2015");
		userProfile.setYearOfLastPromotion("N/A");
		
		Object isEnabled = CONFIG.getProperty("ipm.default.user.is_enabled");
		if(isEnabled != null && "true".equalsIgnoreCase(isEnabled.toString())){
			userProfile.setIsEnabled(Boolean.getBoolean(isEnabled.toString()));
		}

		
		UserRoleAssignment userRoleAssignment = new UserRoleAssignment();
		UserRoleAssignment userRoleAssignment1 = new UserRoleAssignment();
		
		userRoleAssignment.setRole(role);
		userRoleAssignment.setUser(userProfile);

		roleAssignments.add(userRoleAssignment);
		
		
		List<Role> roles1 = roleService.findByCode("USER");
		Role role1 = roles1.get(0);
		userRoleAssignment1.setRole(role1);
		userRoleAssignment1.setUser(userProfile);

		roleAssignments.add(userRoleAssignment1);
		
		
		userProfile.setRoleAssignments(roleAssignments);
		
		JobStage jobStageEntity = null;
    		jobStageEntity = skillCategoryService.getJobStageId(5);
    		
    		if(jobStageEntity != null){
	    		Employee employee = new Employee();
				employee.setUserprofile(userProfile);
				employee.setJobStage(jobStageEntity);
				userProfile.setEmployee(employee);
	    	}

        return userProfileDAO.save(userProfile);
    }

	 private boolean emailExist(final String emailid) {
	        final List<UserProfile> users = userProfileDAO.findByEmailid(emailid);
	        LOGGER.debug("users email : "+users);
	        if (users != null && users.size() > 0) {
	            return true;
	        }
	        return false;
	    }
	 
	 
	 
	 @Override
	    public void createVerificationTokenForUser(final UserProfile user, final String token) {
	        final VerificationToken myToken = new VerificationToken(token, user);
	        verificationTokenDAO.save(myToken);
	    }
	 
	 	@Override
	    public VerificationToken getVerificationToken(final String VerificationToken) {
	        return verificationTokenDAO.findByToken(VerificationToken);
	    }

	    @Override
	    public VerificationToken generateNewVerificationToken(final String existingVerificationToken) {
	        VerificationToken vToken = verificationTokenDAO.findByToken(existingVerificationToken);
	        vToken.updateToken(UUID.randomUUID().toString());
	        vToken = verificationTokenDAO.save(vToken);
	        return vToken;
	    }
	    
	    @Override
	    public UserProfile getUser(final String verificationToken) {
	        final UserProfile user = verificationTokenDAO.findByToken(verificationToken).getUser();
	        return user;
	    }
	    
	    
	    
	    /*
	    @Override
	    public void createPasswordResetTokenForUser(final User user, final String token) {
	        final PasswordResetToken myToken = new PasswordResetToken(token, user);
	        passwordTokenRepository.save(myToken);
	    }

	    @Override
	    public PasswordResetToken getPasswordResetToken(final String token) {
	        return passwordTokenRepository.findByToken(token);
	    }

	    @Override
	    public UserProfile getUserByPasswordResetToken(final String token) {
	        return passwordTokenRepository.findByToken(token).getUser();
	    }*/

	 
		public UserProfile register(String signum) {
	    	
	    	PeopleFinderPerser pfs = new PeopleFinderPerser();
	    	
	    	String pfUrl;
			//String managedPeopleListUrl="";
			Boolean role = Boolean.FALSE;
			
	    	Map<String, String> pfDetailsMap = new HashMap<String,String>();
	    	//Map<String, String> managedPeopleMap = new HashMap<String, String>();
	    	
	    	try{
	    		for (int attempt = 1; attempt < Constants.MAX_URL_GENERATION_ATTEMPT; attempt++) {
					pfUrl = pfs.generateExactPfUrl(attempt, signum);
					LOGGER.debug("PEOPLE FINDER URL:ATTEMPT-" + attempt + ": " + pfUrl);
					pfDetailsMap = pfs.fetchPfDataFromUrl(pfUrl);
					LOGGER.debug("PF-DETAILS-MAP: " + pfDetailsMap);
				}
		    	
		    	
		    	
		    	if(pfDetailsMap.get(Constants.EMP_PF_ISLINEMANAGER_KEY).equalsIgnoreCase("YES")) {
		    		role = Boolean.TRUE;
					/*managedPeopleListUrl=pfDetailsMap.get(Constants.EMP_PF_MANAGEDPEOPLELISTURL_KEY);
					for (int attempt = 1; attempt < Constants.MAX_URL_GENERATION_ATTEMPT; attempt++) {
						LOGGER.debug("MANAGED PEOPLE LIST URL:ATTEMPT-" + attempt + ": " + managedPeopleListUrl);
						managedPeopleMap = pfs.fetchManagedPeopleList(managedPeopleListUrl);
					}	*/		
				}
		    	
		    	
		    	String jobStage = getJobStage(pfDetailsMap.get("POSITIONNAME"));
		    	JobStage jobStageEntity = null;
		    	if(StringUtils.isNotBlank(jobStage)){
		    		jobStageEntity = skillCategoryService.getJobStageId(Integer.parseInt(jobStage));
		    	}
		    	
		    	List<UserRoleAssignment> roleAssignments = new ArrayList<UserRoleAssignment>();
		    	
		    	UserProfile profile = new UserProfile();
		    	profile.setCostCenter(pfDetailsMap.get("COSTCENTRE"));
		    	profile.setUserFristName(pfDetailsMap.get("FNAME")); 
		    	profile.setSignunId(pfDetailsMap.get("SIGNUM"));
		    	profile.setUserLastName(pfDetailsMap.get("LNAME"));
	    		//pfDetailsMap.get("PHONE");
	    		//pfDetailsMap.get("POSITIONNAME");
	    		//profilepfDetailsMap.get("ISLINEMANAGER");
		    	profile.setEmployeeId(pfDetailsMap.get("EMPID"));
		    	//pfDetailsMap.get("MANAGEDPEOPLELISTURL")); 
	    		//pfDetailsMap.get("FULLNAME"));
		    	profile.setCurrentLineManager(pfDetailsMap.get("CURRENTLINEMANGER")); 
		    	profile.setEmailId(pfDetailsMap.get("EMAIL")); 
		    	profile.setJobRole(pfDetailsMap.get("JOBROLE"));
		    	profile.setRole(role);
		    	Object defaultPassword = CONFIG.getProperty("ipm.default.user.password");
		    	profile.setPassword(defaultPassword.toString());
		    	profile.setIsEnabled(true);
		    	
		    	if(jobStageEntity != null){
		    		Employee employee = new Employee();
					employee.setUserprofile(profile);
					employee.setJobStage(jobStageEntity);
					profile.setEmployee(employee);
		    	}
		    	
		    	String userRole = getEmployeeRole(pfDetailsMap.get("POSITIONNAME"), pfDetailsMap.get("JOBROLE"));
		    	
		    			if(StringUtils.isNotBlank(userRole)){
		    				List<Role> roles = roleService.findByCode("SSWD");
		    				UserRoleAssignment userRoleAssignment = new UserRoleAssignment();

		    				Role role0 = roles.get(0);
		    				userRoleAssignment.setRole(role0);
		    				userRoleAssignment.setUser(profile);

		    				roleAssignments.add(userRoleAssignment);
		    			}


				List<Role> roles1 = roleService.findByCode("USER");
				UserRoleAssignment userRoleAssignment1 = new UserRoleAssignment();
				Role role1 = roles1.get(0);
				userRoleAssignment1.setRole(role1);
				userRoleAssignment1.setUser(profile);

				roleAssignments.add(userRoleAssignment1);


				profile.setRoleAssignments(roleAssignments);
		    	
		        return userProfileDAO.save(profile);
	    	}catch(Exception e){
	    		e.printStackTrace();
	    		LOGGER.error("error : " +e);
	    	}
	    	
	    	return null;
	    }
		
		private String getJobStage(String positionName){
			
			String jobStage4 = "4";
			String jobStage5 = "5";
			String jobStage6 = "6";
			
			if("Senior Software Developer".equalsIgnoreCase(positionName)){
				return jobStage5;
			} else if("Senior Solution Integrator".equalsIgnoreCase(positionName)){
				return jobStage5;
			} else if("Solution Architect".equalsIgnoreCase(positionName)){
				return jobStage6;
			} else if("Solution Integrator - CSI ADM & PMO".equalsIgnoreCase(positionName)){
				return jobStage4;
			} else if("Solution Integrator".equalsIgnoreCase(positionName)){
				return jobStage4;
			} else if(positionName.startsWith("Senior Solution Integrator")){
				return jobStage5;
			}
			return null;
		}
		
		private String getEmployeeRole(String positionName, String jobRole){
			
			String jobStage4 = "SWD";
			String jobStage5 = "SSWD";
			String jobStage6 = "SA";
			String jobStage7 = "SSA";
			
			if("Senior Software Developer".equalsIgnoreCase(positionName)){
				return jobStage5;
			} else if("Senior Solution Integrator".equalsIgnoreCase(positionName)){
				return jobStage5;
			} else if("Solution Architect".equalsIgnoreCase(positionName)){
				return jobStage6;
			} else if("Senior Solution Architect".equalsIgnoreCase(positionName)){
				return jobStage7;
			} else if("Solution Integrator - CSI ADM & PMO".equalsIgnoreCase(positionName)){
				return jobStage4;
			} else if("Solution Integrator".equalsIgnoreCase(positionName)){
				return jobStage4;
				
			} else if(jobRole.equalsIgnoreCase("CUSTOMER PROJECT MANAGER")){
				return "SPM";
			} else if(jobRole.equalsIgnoreCase("DESIGN AUTHORITY") || jobRole.equalsIgnoreCase("CHIEF ARCHITECT") ){
				return "CA";
			} else if(jobRole.equalsIgnoreCase("Senior Solution Integrator")){
				return "";
			} else if(jobRole.equalsIgnoreCase("Senior Solution Integrator")){
				return "";
			}
			return null;
		}
	
	    
	    

	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@Autowired
	public void setUserProfileDAO(UserProfileDAO userProfileDAO) {
		this.userProfileDAO = userProfileDAO;
	}

	@Autowired
	public void setVerificationTokenDAO(VerificationTokenDAO verificationTokenDAO) {
		this.verificationTokenDAO = verificationTokenDAO;
	}
	
	@Autowired
    public void setSkillCategoryService(SkillCategoryService skillCategoryService) {
		this.skillCategoryService = skillCategoryService;
	}

	@Override
	public Map<String, String> generateExactPfUrl(String signum) {
		PeopleFinderPerser pfs = new PeopleFinderPerser();
		Map<String, String> pfDetailsMap = new HashMap<String,String>();
		String pfUrl;
		try{
    		for (int attempt = 1; attempt < Constants.MAX_URL_GENERATION_ATTEMPT; attempt++) {
				pfUrl = pfs.generateExactPfUrl(attempt, signum);
				LOGGER.debug("PEOPLE FINDER URL:ATTEMPT-" + attempt + ": " + pfUrl);
				pfDetailsMap = pfs.fetchPfDataFromUrl(pfUrl);
				LOGGER.debug("PF-DETAILS-MAP: " + pfDetailsMap);
			}
		}catch(Exception e){
    		
    	}
		return pfDetailsMap;
	}

	@Override
	public Map<String, String> fetchManagedPeopleList(Map<String, String> pfDetailsMap) {
		PeopleFinderPerser pfs = new PeopleFinderPerser();
		Map<String, String> managedPeopleMap = new HashMap<String, String>();
		String managedPeopleListUrl="";
		managedPeopleListUrl=pfDetailsMap.get(Constants.EMP_PF_MANAGEDPEOPLELISTURL_KEY);
		try{
		for (int attempt = 1; attempt < Constants.MAX_URL_GENERATION_ATTEMPT; attempt++) {
			LOGGER.debug("MANAGED PEOPLE LIST URL:ATTEMPT-" + attempt + ": " + managedPeopleListUrl);
			managedPeopleMap = pfs.fetchManagedPeopleList(managedPeopleListUrl);
		}	
		}catch(Exception e){
    		
    	}
		return managedPeopleMap;
	}
	 
	public UserProfile getUserDetails(String signunid){
		return userProfileDAO.getUserDetails(signunid);
	}
	
}
