package com.ericsson.ipm.v1.web.listener;

import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.commons.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.ipm.v1.context.SpringApplicationContext;
import com.ericsson.ipm.v1.dao.BootstrapSetupData;
import com.ericsson.v1.util.AdaptersConfiguration;
import com.ericsson.v1.util.IPMUtility;

@WebListener
public class ApplicationListener implements ServletContextListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationListener.class);

	private static final Configuration CONFIG = AdaptersConfiguration
			.getInstance().getConfiguration();

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		LOGGER.debug("ServletContextEvent : " + arg0);

		BootstrapSetupData bootstrapSetupData = (BootstrapSetupData) SpringApplicationContext.getBean("bootstrapSetupData");
		bootstrapSetupData.setUp();
	}



//	private List<KPIRoleAssignment> populateKPIRoleAssignment(List<KPI> kpisOfRole, Role role){
//		List<KPIRoleAssignment> kpiRoleAssignments = new ArrayList<KPIRoleAssignment>();
//
//		for(KPI kpi : kpisOfRole){
//			KPIRoleAssignment kpiRoleAssignment = new KPIRoleAssignment();
//			kpiRoleAssignment.setKpi(kpi);
//			kpiRoleAssignment.setRole(role);
//			kpiRoleAssignments.add(kpiRoleAssignment);
//		}
//		return kpiRoleAssignments;
//	}
//
//	private void doOriginateRole(RoleService roleService, List<KPI> kpisSWD, List<KPI> kpisSSWD) {
//
//
//	//**********SWD************/
//		Role role = new Role();
//		role.setName("SW Developer");
//		role.setCode("SWD");
//		role.setAssignable(true);
//
//		role.setKpiRoleAssignments(populateKPIRoleAssignment(kpisSWD, role));
//
//		roleService.save(role);
//
//		//**********SSWD************/
//		Role role1 = new Role();
//		role1.setName("Senior SW Developer");
//		role1.setCode("SSWD");
//		role1.setAssignable(true);
//
//		role1.setKpiRoleAssignments(populateKPIRoleAssignment(kpisSSWD, role1));
//
//		roleService.save(role1);
//
//		//**********SA************/
//		Role role2 = new Role();
//		role2.setName("SW Architect");
//		role2.setCode("SA");
//		role2.setAssignable(true);
//
//		roleService.save(role2);
//
//		//**********SSA************/
//		Role role3 = new Role();
//		role3.setName("Senior SW Architect");
//		role3.setCode("SSA");
//		role3.setAssignable(true);
//
//		roleService.save(role3);
//
//		//**********SPM************/
//		Role role4 = new Role();
//		role4.setName("SPM/People Manager");
//		role4.setCode("SPM");
//		role4.setAssignable(true);
//
//		roleService.save(role4);
//
//		//**********CA************/
//		Role role5 = new Role();
//		role5.setName("Design Authority/Chief Architect");
//		role5.setCode("CA");
//		role5.setAssignable(true);
//
//		roleService.save(role5);
//
//		//**********RPM************/
//		Role role6 = new Role();
//		role6.setName("Regional CAC Program Manager");
//		role6.setCode("RPM");
//		role6.setAssignable(true);
//
//		roleService.save(role6);
//
//		//**********SDL************/
//		Role role7 = new Role();
//		role7.setName("Sub-domain Lead");
//		role7.setCode("SDL");
//		role7.setAssignable(true);
//
//		roleService.save(role7);
//
//		//**********DL************/
//		Role role8 = new Role();
//		role8.setName("Domain Lead");
//		role8.setCode("DL");
//		role8.setAssignable(true);
//
//		roleService.save(role8);
//
//		Role role9 = new Role();
//		role9.setName("User");
//		role9.setCode("USER");
//		role9.setAssignable(true);
//
//		roleService.save(role9);
//
//	}
//
//	private UserProfile doOriginateUserProfile(UserProfileService userProfileService,
//			RoleService roleService) {
//		Date date = new Date();
//		UserProfile userProfile = new UserProfile();
//		List<UserRoleAssignment> roleAssignments = new ArrayList<UserRoleAssignment>();
//
//
//		userProfile.setCostCenter("1234567890");
//		userProfile.setCurrentLineManager("ECHABIS");
//		userProfile.setDateOfJoinInMediaAccount(date);
//		userProfile.setEducationalQualification("B.Tech");
//		userProfile.setEmailId("iqbal.hosain.khan@ericsson.com");
//		userProfile.setEmployeeId("EGIL 26438");
//		userProfile.setJobRole("SSD");
//		userProfile.setJobStage("5");
//		userProfile.setLastYearIPMRating("ME");
//		userProfile.setManHourRate("1600");
//		userProfile.setModifiedDate(date);
//		userProfile.setPassword("password");
//		userProfile.setPreviousLineManeger("ECHABIS");
//		userProfile.setPreviousOrganisation("CTS");
//		userProfile.setRegistrationDate(date);
//		userProfile.setRole(Boolean.FALSE);
//		userProfile.setSignunId("EKHIQBA");
//		userProfile.setTotalEricssonExperienceInMonths(16);
//		userProfile.setTotalITExperience(new Double(16));
//		userProfile.setTotalYearsOfExperience(new Double(7.4));
//		userProfile.setUserFristName("Iqbal");
//		userProfile.setUserLastName("Khan");
//		userProfile.setYearOfIPM("2015");
//		userProfile.setYearOfLastPromotion("N/A");
//
//		Object isEnabled = CONFIG.getProperty("ipm.default.user.is_enabled");
//		if(isEnabled != null && "true".equalsIgnoreCase(isEnabled.toString())){
//			userProfile.setIsEnabled(Boolean.getBoolean(isEnabled.toString()));
//		}
//
//		List<Role> roles = roleService.findByCode("SSWD");
//		UserRoleAssignment userRoleAssignment = new UserRoleAssignment();
//		UserRoleAssignment userRoleAssignment1 = new UserRoleAssignment();
//
//		Role role = roles.get(0);
//		userRoleAssignment.setRole(role);
//		userRoleAssignment.setUser(userProfile);
//
//		roleAssignments.add(userRoleAssignment);
//
//
//		List<Role> roles1 = roleService.findByCode("USER");
//		Role role1 = roles1.get(0);
//		userRoleAssignment1.setRole(role1);
//		userRoleAssignment1.setUser(userProfile);
//
//		roleAssignments.add(userRoleAssignment1);
//
//
//		userProfile.setRoleAssignments(roleAssignments);
//
//		userProfile = userProfileService.save(userProfile);
//		return userProfile;
//	}
//
//	private void findQueryOnUserProfile(UserProfileService userProfileService) {
//
//		List<UserProfile> userProfiles = userProfileService.findAll();
//		LOGGER.debug("userProfiles : " + userProfiles);
//
//		List<UserProfile> userProfilesBySignumId = userProfileService
//				.findBySignumId("EKHIQBA");
//		LOGGER.debug("userProfilesBySignumId : " + userProfilesBySignumId);
//
//		UserProfile userProfilesFindById = userProfileService
//				.findById(new Integer(1));
//		LOGGER.debug("userProfilesFindById : " + userProfilesFindById);
//
//		UserProfile userProfilesFindByEmail = userProfileService
//				.findByEmail("iqbal.hosain.khan@ericsson.com");
//		LOGGER.debug("userProfilesFindByEmail : " + userProfilesFindByEmail);
//
//		UserProfile userProfilesFindUserDetailsById = userProfileService
//				.findUserDetailsById(new Integer(1));
//		LOGGER.debug("userProfilesFindUserDetailsById : "
//				+ userProfilesFindUserDetailsById);
//
//		UserProfile userProfileWithAsset = userProfileService.findByIdWithAsset(new Integer(1));
//		LOGGER.debug("userProfileWithAsset : " + userProfileWithAsset);
//	}
//
//	private void findQueryOnSkillCategory(SkillCategoryService skillCategoryService) {
//
//		List<CADTO> cadtos = skillCategoryService.getEmployeeCASkill(1, 1, 1);
//		LOGGER.debug("cadtos : " + cadtos);
//	}
//
//	private List<KPI> populateSWDKPIGoal(KPIService kpiService) {
//
//		List<KPI> kpis = new ArrayList<KPI>();
//
//		Map<String, String> map1 = new HashMap<String, String>();
//
//		String kpiNameSWD1 = "Living E/// Core Values (Professionalism, Respect, Perseverance)";
//		String kpiValueSWD1 = "Fundamental";
//		String kpiDescriptionSWD1 = "Living E/// Core Values (Professionalism, Respect, Perseverance)";
//
//		Map<String, String> mapA1 = IPMUtility.spiltText("kpiName1",
//				kpiNameSWD1, 1000);
//		Map<String, String> mapB1 = IPMUtility.spiltText("kpiDescription1",
//				kpiDescriptionSWD1, 1000);
//		map1.putAll(mapA1);
//		map1.putAll(mapB1);
//
//		KPI kpi1 = new KPI();
//		kpi1.setKpiDisplayName("Core Values");
//		kpi1.setKpiValue(kpiValueSWD1);
//		kpi1.setKpiName1(map1.get("kpiName1"));
//		if (StringUtils.isNotBlank(map1.get("kpiName2")))
//			kpi1.setKpiName1(map1.get("kpiName2"));
//		if (StringUtils.isNotBlank(map1.get("kpiName3")))
//			kpi1.setKpiName1(map1.get("kpiName3"));
//		if (StringUtils.isNotBlank(map1.get("kpiName4")))
//			kpi1.setKpiName1(map1.get("kpiName4"));
//
//		kpi1.setKpiDescription1(map1.get("kpiDescription1"));
//		if (StringUtils.isNotBlank(map1.get("kpiDescription2")))
//			kpi1.setKpiDescription2(map1.get("kpiDescription2"));
//		if (StringUtils.isNotBlank(map1.get("kpiDescription3")))
//			kpi1.setKpiDescription3(map1.get("kpiDescription3"));
//		if (StringUtils.isNotBlank(map1.get("kpiDescription4")))
//			kpi1.setKpiDescription4(map1.get("kpiDescription4"));
//
//		kpiService.save(kpi1);
//
//		kpis.add(kpi1);
//
//		Map<String, String> map2 = new HashMap<String, String>();
//		String kpiNameSWD2 = "Service Satisfaction - Staff Augmentation (As per RcSE)";
//		String kpiValueSWD2 = "R:88 | C:90 | S:91";
//		String kpiDescriptionSWD2 = "Service Satisfaction - Staff Augmentation (As per RcSE)";
//
//		Map<String, String> mapA2 = IPMUtility.spiltText("kpiName1",
//				kpiNameSWD2, 1000);
//		Map<String, String> mapB2 = IPMUtility.spiltText("kpiDescription1",
//				kpiDescriptionSWD2, 1000);
//		map2.putAll(mapA2);
//		map2.putAll(mapB2);
//
//		KPI kpi2 = new KPI();
//		kpi2.setKpiDisplayName("Service Satisfaction (As per RcSE)");
//		kpi2.setKpiValue(kpiValueSWD2);
//		kpi2.setKpiName1(map2.get("kpiName1"));
//		if (StringUtils.isNotBlank(map2.get("kpiName2")))
//			kpi2.setKpiName1(map2.get("kpiName2"));
//		if (StringUtils.isNotBlank(map2.get("kpiName3")))
//			kpi2.setKpiName1(map2.get("kpiName3"));
//		if (StringUtils.isNotBlank(map2.get("kpiName4")))
//			kpi2.setKpiName1(map2.get("kpiName4"));
//
//		kpi2.setKpiDescription1(map2.get("kpiDescription1"));
//		if (StringUtils.isNotBlank(map2.get("kpiDescription2")))
//			kpi2.setKpiDescription2(map2.get("kpiDescription2"));
//		if (StringUtils.isNotBlank(map2.get("kpiDescription3")))
//			kpi2.setKpiDescription3(map2.get("kpiDescription3"));
//		if (StringUtils.isNotBlank(map2.get("kpiDescription4")))
//			kpi2.setKpiDescription4(map2.get("kpiDescription4"));
//
//		kpiService.save(kpi2);
//
//		kpis.add(kpi2);
//
//		Map<String, String> map3 = new HashMap<String, String>();
//		String kpiNameSWD3 = "Service Satisfaction - Work Package";
//		String kpiValueSWD3 = "R:85 | C:87 | S:88";
//		String kpiDescriptionSWD3 = "Service Satisfaction - Work Package+ Feedback from respective SPM on individual’s impact";
//
//		Map<String, String> mapA3 = IPMUtility.spiltText("kpiName1",
//				kpiNameSWD3, 1000);
//		Map<String, String> mapB3 = IPMUtility.spiltText("kpiDescription1",
//				kpiDescriptionSWD3, 1000);
//		map3.putAll(mapA3);
//		map3.putAll(mapB3);
//
//		KPI kpi3 = new KPI();
//		kpi3.setKpiDisplayName("Service Satisfaction");
//		kpi3.setKpiValue(kpiValueSWD3);
//		kpi3.setKpiName1(map3.get("kpiName1"));
//		if (StringUtils.isNotBlank(map3.get("kpiName2")))
//			kpi3.setKpiName1(map3.get("kpiName2"));
//		if (StringUtils.isNotBlank(map3.get("kpiName3")))
//			kpi3.setKpiName1(map3.get("kpiName3"));
//		if (StringUtils.isNotBlank(map3.get("kpiName4")))
//			kpi3.setKpiName1(map3.get("kpiName4"));
//
//		kpi3.setKpiDescription1(map3.get("kpiDescription1"));
//		if (StringUtils.isNotBlank(map3.get("kpiDescription2")))
//			kpi3.setKpiDescription2(map3.get("kpiDescription2"));
//		if (StringUtils.isNotBlank(map3.get("kpiDescription3")))
//			kpi3.setKpiDescription3(map3.get("kpiDescription3"));
//		if (StringUtils.isNotBlank(map3.get("kpiDescription4")))
//			kpi3.setKpiDescription4(map3.get("kpiDescription4"));
//
//		kpiService.save(kpi3);
//
//		kpis.add(kpi3);
//
//		Map<String, String> map4 = new HashMap<String, String>();
//		String kpiNameSWD4 = "Operational Discipline (Competence Assessment, Mandatory Trainings, CV Updates, Time and Expense Booking) - Measured as number of non-compliance instances in the year";
//		String kpiValueSWD4 = "R:2 | C:1 | S:0";
//		String kpiDescriptionSWD4 = "Operational Discipline (Competence Assessment, Mandatory Trainings, CV Updates, Time and Expense Booking) - Measured as number of non-compliance instances in the year";
//
//		Map<String, String> mapA4 = IPMUtility.spiltText("kpiName1",
//				kpiNameSWD4, 1000);
//		Map<String, String> mapB4 = IPMUtility.spiltText("kpiDescription1",
//				kpiDescriptionSWD4, 1000);
//		map4.putAll(mapA4);
//		map4.putAll(mapB4);
//
//		KPI kpi4 = new KPI();
//		kpi4.setKpiDisplayName("Operational Discipline");
//		kpi4.setKpiValue(kpiValueSWD4);
//		kpi4.setKpiName1(map4.get("kpiName1"));
//		if (StringUtils.isNotBlank(map4.get("kpiName2")))
//			kpi4.setKpiName1(map4.get("kpiName2"));
//		if (StringUtils.isNotBlank(map4.get("kpiName3")))
//			kpi4.setKpiName1(map4.get("kpiName3"));
//		if (StringUtils.isNotBlank(map4.get("kpiName4")))
//			kpi4.setKpiName1(map4.get("kpiName4"));
//
//		kpi4.setKpiDescription1(map4.get("kpiDescription1"));
//		if (StringUtils.isNotBlank(map4.get("kpiDescription2")))
//			kpi4.setKpiDescription2(map4.get("kpiDescription2"));
//		if (StringUtils.isNotBlank(map4.get("kpiDescription3")))
//			kpi4.setKpiDescription3(map4.get("kpiDescription3"));
//		if (StringUtils.isNotBlank(map4.get("kpiDescription4")))
//			kpi4.setKpiDescription4(map4.get("kpiDescription4"));
//
//		kpiService.save(kpi4);
//
//		kpis.add(kpi4);
//
//		Map<String, String> map5 = new HashMap<String, String>();
//		String kpiNameSWD5 = "Utilization";
//		String kpiValueSWD5 = "R:83 | C:85 | S:85+";
//		String kpiDescriptionSWD5 = "Utilization";
//
//		Map<String, String> mapA5 = IPMUtility.spiltText("kpiName1",
//				kpiNameSWD5, 1000);
//		Map<String, String> mapB5 = IPMUtility.spiltText("kpiDescription1",
//				kpiDescriptionSWD5, 1000);
//		map5.putAll(mapA5);
//		map5.putAll(mapB5);
//
//		KPI kpi5 = new KPI();
//		kpi5.setKpiDisplayName("Utilization");
//		kpi5.setKpiValue(kpiValueSWD5);
//		kpi5.setKpiName1(map5.get("kpiName1"));
//		if (StringUtils.isNotBlank(map5.get("kpiName2")))
//			kpi5.setKpiName1(map5.get("kpiName2"));
//		if (StringUtils.isNotBlank(map5.get("kpiName3")))
//			kpi5.setKpiName1(map5.get("kpiName3"));
//		if (StringUtils.isNotBlank(map5.get("kpiName4")))
//			kpi5.setKpiName1(map5.get("kpiName4"));
//
//		kpi5.setKpiDescription1(map5.get("kpiDescription1"));
//		if (StringUtils.isNotBlank(map5.get("kpiDescription2")))
//			kpi5.setKpiDescription2(map5.get("kpiDescription2"));
//		if (StringUtils.isNotBlank(map5.get("kpiDescription3")))
//			kpi5.setKpiDescription3(map5.get("kpiDescription3"));
//		if (StringUtils.isNotBlank(map5.get("kpiDescription4")))
//			kpi5.setKpiDescription4(map5.get("kpiDescription4"));
//
//		kpiService.save(kpi5);
//
//		kpis.add(kpi5);
//
//		Map<String, String> map6 = new HashMap<String, String>();
//		String kpiNameSWD6 = "Number of new 3PP Certifications in 2015 by practitioners in the 'CPM' Job Role";
//		String kpiValueSWD6 = "Own certification goal  (BUGS and/or external)as set by manager";
//		String kpiDescriptionSWD6 = "Number of new 3PP Certifications in 2015 by practitioners in the 'CPM' Job Role";
//
//		Map<String, String> mapA6 = IPMUtility.spiltText("kpiName1",
//				kpiNameSWD6, 1000);
//		Map<String, String> mapB6 = IPMUtility.spiltText("kpiDescription1",
//				kpiDescriptionSWD6, 1000);
//		map6.putAll(mapA6);
//		map6.putAll(mapB6);
//
//		KPI kpi6 = new KPI();
//		kpi6.setKpiDisplayName("3PP Certification");
//		kpi6.setKpiValue(kpiValueSWD6);
//		kpi6.setKpiName1(map6.get("kpiName1"));
//		if (StringUtils.isNotBlank(map6.get("kpiName2")))
//			kpi6.setKpiName1(map6.get("kpiName2"));
//		if (StringUtils.isNotBlank(map6.get("kpiName3")))
//			kpi6.setKpiName1(map6.get("kpiName3"));
//		if (StringUtils.isNotBlank(map6.get("kpiName4")))
//			kpi6.setKpiName1(map6.get("kpiName4"));
//
//		kpi6.setKpiDescription1(map6.get("kpiDescription1"));
//		if (StringUtils.isNotBlank(map6.get("kpiDescription2")))
//			kpi6.setKpiDescription2(map6.get("kpiDescription2"));
//		if (StringUtils.isNotBlank(map6.get("kpiDescription3")))
//			kpi6.setKpiDescription3(map6.get("kpiDescription3"));
//		if (StringUtils.isNotBlank(map6.get("kpiDescription4")))
//			kpi6.setKpiDescription4(map6.get("kpiDescription4"));
//
//		kpiService.save(kpi6);
//
//		kpis.add(kpi6);
//
//		Map<String, String> map7 = new HashMap<String, String>();
//		String kpiNameSWD7 = "a) Create KO"
//				+ "b) Conduct training through LANDCD / Organize KSS"
//				+ "c) Hiring / Mentoring"
//				+ "d) BVA and Technical Workgroup Participation and Technical forum";
//		String kpiValueSWD7 = "a) R:1|C:1|S:1";
//		String kpiDescriptionSWD7 = "a) Create KO"
//				+ "b) Conduct training through LANDCD / Organize KSS"
//				+ "c) Hiring / Mentoring"
//				+ "d) BVA and Technical Workgroup Participation and Technical forum";
//
//		Map<String, String> mapA7 = IPMUtility.spiltText("kpiName1",
//				kpiNameSWD7, 1000);
//		Map<String, String> mapB7 = IPMUtility.spiltText("kpiDescription1",
//				kpiDescriptionSWD7, 1000);
//		map7.putAll(mapA7);
//		map7.putAll(mapB7);
//
//		KPI kpi7 = new KPI();
//		kpi7.setKpiDisplayName("KO");
//		kpi7.setKpiValue(kpiValueSWD7);
//		kpi7.setKpiName1(map7.get("kpiName1"));
//		if (StringUtils.isNotBlank(map7.get("kpiName2")))
//			kpi7.setKpiName1(map7.get("kpiName2"));
//		if (StringUtils.isNotBlank(map7.get("kpiName3")))
//			kpi7.setKpiName1(map7.get("kpiName3"));
//		if (StringUtils.isNotBlank(map7.get("kpiName4")))
//			kpi7.setKpiName1(map7.get("kpiName4"));
//
//		kpi7.setKpiDescription1(map7.get("kpiDescription1"));
//		if (StringUtils.isNotBlank(map7.get("kpiDescription2")))
//			kpi7.setKpiDescription2(map7.get("kpiDescription2"));
//		if (StringUtils.isNotBlank(map7.get("kpiDescription3")))
//			kpi7.setKpiDescription3(map7.get("kpiDescription3"));
//		if (StringUtils.isNotBlank(map7.get("kpiDescription4")))
//			kpi7.setKpiDescription4(map7.get("kpiDescription4"));
//
//		kpiService.save(kpi7);
//
//		kpis.add(kpi7);
//
//		Map<String, String> map8 = new HashMap<String, String>();
//		String kpiNameSWD8 = "Delivery quality"
//				+ "a) Technical estimation accuracy "
//				+ "b) Scoping: Coverage of all functional and non functional requirments "
//				+ "c) 100% coverage of functional and non functional requirements in HLD and LLD "
//				+ "d) Defect Reduction in Review and Testing, "
//				+ "e) Ensuring process compliances as per CMMi L5/ Agile practices "
//				+ "f) Closure of NCs from SQA Audits on time "
//				+ "g) Closing of CSR as per SLA ";
//		String kpiValueSWD8 = "R:95 | C: 96 | S :97";
//		String kpiDescriptionSWD8 = "Delivery quality (Being a part of the overall project team that works collectively)"
//				+ "a) Technical estimation accuracy "
//				+ "b) Scoping: Coverage of all functional and non functional requirments "
//				+ "c) 100% coverage of functional and non functional requirements in HLD and LLD "
//				+ "d) Defect Reduction in Review and Testing, "
//				+ "e) Ensuring process compliances as per CMMi L5/ Agile practices "
//				+ "f) Closure of NCs from SQA Audits on time "
//				+ "g) Closing of CSR as per SLA";
//
//		Map<String, String> mapA8 = IPMUtility.spiltText("kpiName1",
//				kpiNameSWD8, 1000);
//		Map<String, String> mapB8 = IPMUtility.spiltText("kpiDescription1",
//				kpiDescriptionSWD8, 1000);
//		map8.putAll(mapA8);
//		map8.putAll(mapB8);
//
//		KPI kpi8 = new KPI();
//		kpi8.setKpiDisplayName("Delivery quality");
//		kpi8.setKpiValue(kpiValueSWD8);
//		kpi8.setKpiName1(map8.get("kpiName1"));
//		if (StringUtils.isNotBlank(map8.get("kpiName2")))
//			kpi8.setKpiName1(map8.get("kpiName2"));
//		if (StringUtils.isNotBlank(map8.get("kpiName3")))
//			kpi8.setKpiName1(map8.get("kpiName3"));
//		if (StringUtils.isNotBlank(map8.get("kpiName4")))
//			kpi8.setKpiName1(map8.get("kpiName4"));
//
//		kpi8.setKpiDescription1(map8.get("kpiDescription1"));
//		if (StringUtils.isNotBlank(map8.get("kpiDescription2")))
//			kpi8.setKpiDescription2(map8.get("kpiDescription2"));
//		if (StringUtils.isNotBlank(map8.get("kpiDescription3")))
//			kpi8.setKpiDescription3(map8.get("kpiDescription3"));
//		if (StringUtils.isNotBlank(map8.get("kpiDescription4")))
//			kpi8.setKpiDescription4(map8.get("kpiDescription4"));
//
//		kpiService.save(kpi8);
//
//		kpis.add(kpi8);
//
//		return kpis;
//	}
//
//	private List<KPI> populateSSWDKPIGoal(KPIService kpiService) {
//
//		List<KPI> kpis = new ArrayList<KPI>();
//
//		Map<String, String> map1 = new HashMap<String, String>();
//
//		String kpiNameSSWD1 = " Living E/// Core Values (Professionalism, Respect, Perseverance)";
//		String kpiValueSSWD1 = "Fundamental";
//		String kpiDescriptionSSWD1 = "Living E/// Core Values (Professionalism, Respect, Perseverance)";
//
//		Map<String, String> mapA1 = IPMUtility.spiltText("kpiName1",
//				kpiNameSSWD1, 1000);
//		Map<String, String> mapB1 = IPMUtility.spiltText("kpiDescription1",
//				kpiDescriptionSSWD1, 1000);
//		map1.putAll(mapA1);
//		map1.putAll(mapB1);
//
//		KPI kpi1 = new KPI();
//		kpi1.setKpiDisplayName("Core Values");
//		kpi1.setKpiValue(kpiValueSSWD1);
//		kpi1.setKpiName1(map1.get("kpiName1"));
//		if (StringUtils.isNotBlank(map1.get("kpiName2")))
//			kpi1.setKpiName1(map1.get("kpiName2"));
//		if (StringUtils.isNotBlank(map1.get("kpiName3")))
//			kpi1.setKpiName1(map1.get("kpiName3"));
//		if (StringUtils.isNotBlank(map1.get("kpiName4")))
//			kpi1.setKpiName1(map1.get("kpiName4"));
//
//		kpi1.setKpiDescription1(map1.get("kpiDescription1"));
//		if (StringUtils.isNotBlank(map1.get("kpiDescription2")))
//			kpi1.setKpiDescription2(map1.get("kpiDescription2"));
//		if (StringUtils.isNotBlank(map1.get("kpiDescription3")))
//			kpi1.setKpiDescription3(map1.get("kpiDescription3"));
//		if (StringUtils.isNotBlank(map1.get("kpiDescription4")))
//			kpi1.setKpiDescription4(map1.get("kpiDescription4"));
//
//		kpiService.save(kpi1);
//
//		kpis.add(kpi1);
//
//		Map<String, String> map2 = new HashMap<String, String>();
//		String kpiNameSSWD2 = " Service Satisfaction - Staff Augmentation (As per RcSE)";
//		String kpiValueSSWD2 = "R:88 | C:90 | S:91";
//		String kpiDescriptionSSWD2 = "Service Satisfaction - Staff Augmentation (As per RcSE)";
//
//		Map<String, String> mapA2 = IPMUtility.spiltText("kpiName1",
//				kpiNameSSWD2, 1000);
//		Map<String, String> mapB2 = IPMUtility.spiltText("kpiDescription1",
//				kpiDescriptionSSWD2, 1000);
//		map2.putAll(mapA2);
//		map2.putAll(mapB2);
//
//		KPI kpi2 = new KPI();
//		kpi2.setKpiDisplayName("Service Satisfaction (As per RcSE)");
//		kpi2.setKpiValue(kpiValueSSWD2);
//		kpi2.setKpiName1(map2.get("kpiName1"));
//		if (StringUtils.isNotBlank(map2.get("kpiName2")))
//			kpi2.setKpiName1(map2.get("kpiName2"));
//		if (StringUtils.isNotBlank(map2.get("kpiName3")))
//			kpi2.setKpiName1(map2.get("kpiName3"));
//		if (StringUtils.isNotBlank(map2.get("kpiName4")))
//			kpi2.setKpiName1(map2.get("kpiName4"));
//
//		kpi2.setKpiDescription1(map2.get("kpiDescription1"));
//		if (StringUtils.isNotBlank(map2.get("kpiDescription2")))
//			kpi2.setKpiDescription2(map2.get("kpiDescription2"));
//		if (StringUtils.isNotBlank(map2.get("kpiDescription3")))
//			kpi2.setKpiDescription3(map2.get("kpiDescription3"));
//		if (StringUtils.isNotBlank(map2.get("kpiDescription4")))
//			kpi2.setKpiDescription4(map2.get("kpiDescription4"));
//
//		kpiService.save(kpi2);
//
//		kpis.add(kpi2);
//
//		Map<String, String> map3 = new HashMap<String, String>();
//		String kpiNameSSWD3 = " Service Satisfaction - Work Package";
//		String kpiValueSSWD3 = "R:85 | C:87 | S:88";
//		String kpiDescriptionSSWD3 = "Service Satisfaction - Work Package+ Feedback from respective SPM on individual’s impact";
//
//		Map<String, String> mapA3 = IPMUtility.spiltText("kpiName1",
//				kpiNameSSWD3, 1000);
//		Map<String, String> mapB3 = IPMUtility.spiltText("kpiDescription1",
//				kpiDescriptionSSWD3, 1000);
//		map3.putAll(mapA3);
//		map3.putAll(mapB3);
//
//		KPI kpi3 = new KPI();
//		kpi3.setKpiDisplayName("Service Satisfaction");
//		kpi3.setKpiValue(kpiValueSSWD3);
//		kpi3.setKpiName1(map3.get("kpiName1"));
//		if (StringUtils.isNotBlank(map3.get("kpiName2")))
//			kpi3.setKpiName1(map3.get("kpiName2"));
//		if (StringUtils.isNotBlank(map3.get("kpiName3")))
//			kpi3.setKpiName1(map3.get("kpiName3"));
//		if (StringUtils.isNotBlank(map3.get("kpiName4")))
//			kpi3.setKpiName1(map3.get("kpiName4"));
//
//		kpi3.setKpiDescription1(map3.get("kpiDescription1"));
//		if (StringUtils.isNotBlank(map3.get("kpiDescription2")))
//			kpi3.setKpiDescription2(map3.get("kpiDescription2"));
//		if (StringUtils.isNotBlank(map3.get("kpiDescription3")))
//			kpi3.setKpiDescription3(map3.get("kpiDescription3"));
//		if (StringUtils.isNotBlank(map3.get("kpiDescription4")))
//			kpi3.setKpiDescription4(map3.get("kpiDescription4"));
//
//		kpiService.save(kpi3);
//
//		kpis.add(kpi3);
//
//		Map<String, String> map4 = new HashMap<String, String>();
//		String kpiNameSSWD4 = " Operational Discipline (Competence Assessment, Mandatory Trainings, CV Updates, Time and Expense Booking) - Measured as number of non-compliance instances in the year";
//		String kpiValueSSW4 = "R:2 | C:1 | S:0";
//		String kpiDescriptionSSWD4 = "Operational Discipline (Competence Assessment, Mandatory Trainings, CV Updates, Time and Expense Booking) - Measured as number of non-compliance instances in the year";
//
//		Map<String, String> mapA4 = IPMUtility.spiltText("kpiName1",
//				kpiNameSSWD4, 1000);
//		Map<String, String> mapB4 = IPMUtility.spiltText("kpiDescription1",
//				kpiDescriptionSSWD4, 1000);
//		map4.putAll(mapA4);
//		map4.putAll(mapB4);
//
//		KPI kpi4 = new KPI();
//		kpi4.setKpiDisplayName("Operational Discipline");
//		kpi4.setKpiValue(kpiValueSSW4);
//		kpi4.setKpiName1(map4.get("kpiName1"));
//		if (StringUtils.isNotBlank(map4.get("kpiName2")))
//			kpi4.setKpiName1(map4.get("kpiName2"));
//		if (StringUtils.isNotBlank(map4.get("kpiName3")))
//			kpi4.setKpiName1(map4.get("kpiName3"));
//		if (StringUtils.isNotBlank(map4.get("kpiName4")))
//			kpi4.setKpiName1(map4.get("kpiName4"));
//
//		kpi4.setKpiDescription1(map4.get("kpiDescription1"));
//		if (StringUtils.isNotBlank(map4.get("kpiDescription2")))
//			kpi4.setKpiDescription2(map4.get("kpiDescription2"));
//		if (StringUtils.isNotBlank(map4.get("kpiDescription3")))
//			kpi4.setKpiDescription3(map4.get("kpiDescription3"));
//		if (StringUtils.isNotBlank(map4.get("kpiDescription4")))
//			kpi4.setKpiDescription4(map4.get("kpiDescription4"));
//
//		kpiService.save(kpi4);
//
//		kpis.add(kpi4);
//
//		Map<String, String> map5 = new HashMap<String, String>();
//		String kpiNameSSWD5 = " Utilization";
//		String kpiValueSSWD5 = "R:83 | C:85 | S:85+";
//		String kpiDescriptionSSWD5 = "Utilization";
//
//		Map<String, String> mapA5 = IPMUtility.spiltText("kpiName1",
//				kpiNameSSWD5, 1000);
//		Map<String, String> mapB5 = IPMUtility.spiltText("kpiDescription1",
//				kpiDescriptionSSWD5, 1000);
//		map5.putAll(mapA5);
//		map5.putAll(mapB5);
//
//		KPI kpi5 = new KPI();
//		kpi5.setKpiDisplayName("Utilization");
//		kpi5.setKpiValue(kpiValueSSWD5);
//		kpi5.setKpiName1(map5.get("kpiName1"));
//		if (StringUtils.isNotBlank(map5.get("kpiName2")))
//			kpi5.setKpiName1(map5.get("kpiName2"));
//		if (StringUtils.isNotBlank(map5.get("kpiName3")))
//			kpi5.setKpiName1(map5.get("kpiName3"));
//		if (StringUtils.isNotBlank(map5.get("kpiName4")))
//			kpi5.setKpiName1(map5.get("kpiName4"));
//
//		kpi5.setKpiDescription1(map5.get("kpiDescription1"));
//		if (StringUtils.isNotBlank(map5.get("kpiDescription2")))
//			kpi5.setKpiDescription2(map5.get("kpiDescription2"));
//		if (StringUtils.isNotBlank(map5.get("kpiDescription3")))
//			kpi5.setKpiDescription3(map5.get("kpiDescription3"));
//		if (StringUtils.isNotBlank(map5.get("kpiDescription4")))
//			kpi5.setKpiDescription4(map5.get("kpiDescription4"));
//
//		kpiService.save(kpi5);
//
//		kpis.add(kpi5);
//
//		Map<String, String> map6 = new HashMap<String, String>();
//		String kpiNameSSWD6 = " Number of new 3PP Certifications in 2015 by practitioners in the 'CPM' Job Role";
//		String kpiValueSSWD6 = "Own certification goal  (BUGS and/or external)as set by manager";
//		String kpiDescriptionSSWD6 = "Number of new 3PP Certifications in 2015 by practitioners in the 'CPM' Job Role";
//
//		Map<String, String> mapA6 = IPMUtility.spiltText("kpiName1",
//				kpiNameSSWD6, 1000);
//		Map<String, String> mapB6 = IPMUtility.spiltText("kpiDescription1",
//				kpiDescriptionSSWD6, 1000);
//		map6.putAll(mapA6);
//		map6.putAll(mapB6);
//
//		KPI kpi6 = new KPI();
//		kpi6.setKpiDisplayName("3PP Certification");
//		kpi6.setKpiValue(kpiValueSSWD6);
//		kpi6.setKpiName1(map6.get("kpiName1"));
//		if (StringUtils.isNotBlank(map6.get("kpiName2")))
//			kpi6.setKpiName1(map6.get("kpiName2"));
//		if (StringUtils.isNotBlank(map6.get("kpiName3")))
//			kpi6.setKpiName1(map6.get("kpiName3"));
//		if (StringUtils.isNotBlank(map6.get("kpiName4")))
//			kpi6.setKpiName1(map6.get("kpiName4"));
//
//		kpi6.setKpiDescription1(map6.get("kpiDescription1"));
//		if (StringUtils.isNotBlank(map6.get("kpiDescription2")))
//			kpi6.setKpiDescription2(map6.get("kpiDescription2"));
//		if (StringUtils.isNotBlank(map6.get("kpiDescription3")))
//			kpi6.setKpiDescription3(map6.get("kpiDescription3"));
//		if (StringUtils.isNotBlank(map6.get("kpiDescription4")))
//			kpi6.setKpiDescription4(map6.get("kpiDescription4"));
//
//		kpiService.save(kpi6);
//
//		kpis.add(kpi6);
//
//		Map<String, String> map7 = new HashMap<String, String>();
//		String kpiNameSWD7 = "a) Create KO"
//				+ "b) Conduct training through LANDCD / Organize KSS"
//				+ "c) Hiring / Mentoring"
//				+ "d) BVA and Technical Workgroup Participation and Technical forum";
//		String kpiValueSWD7 = "a) R:1|C:2|S:2 " + "b) R:1|C:2|S:2 "
//				+ "c) R:1|C:2|S:2 " + "d) R:1|C:1|S:1  "
//				+ "Being a part of the team that works collectively on BVA";
//		String kpiDescriptionSWD7 = "a) Create KO"
//				+ "b) Conduct training through LANDCD / Organize KSS"
//				+ "c) Hiring / Mentoring"
//				+ "d) BVA and Technical Workgroup Participation and Technical forum";
//
//		Map<String, String> mapA7 = IPMUtility.spiltText("kpiName1",
//				kpiNameSWD7, 1000);
//		Map<String, String> mapB7 = IPMUtility.spiltText("kpiDescription1",
//				kpiDescriptionSWD7, 1000);
//		map7.putAll(mapA7);
//		map7.putAll(mapB7);
//
//		KPI kpi7 = new KPI();
//		kpi7.setKpiDisplayName("KO");
//		kpi7.setKpiValue(kpiValueSWD7);
//		kpi7.setKpiName1(map7.get("kpiName1"));
//		if (StringUtils.isNotBlank(map7.get("kpiName2")))
//			kpi7.setKpiName1(map7.get("kpiName2"));
//		if (StringUtils.isNotBlank(map7.get("kpiName3")))
//			kpi7.setKpiName1(map7.get("kpiName3"));
//		if (StringUtils.isNotBlank(map7.get("kpiName4")))
//			kpi7.setKpiName1(map7.get("kpiName4"));
//
//		kpi7.setKpiDescription1(map7.get("kpiDescription1"));
//		if (StringUtils.isNotBlank(map7.get("kpiDescription2")))
//			kpi7.setKpiDescription2(map7.get("kpiDescription2"));
//		if (StringUtils.isNotBlank(map7.get("kpiDescription3")))
//			kpi7.setKpiDescription3(map7.get("kpiDescription3"));
//		if (StringUtils.isNotBlank(map7.get("kpiDescription4")))
//			kpi7.setKpiDescription4(map7.get("kpiDescription4"));
//
//		kpiService.save(kpi7);
//
//		kpis.add(kpi7);
//
//		Map<String, String> map8 = new HashMap<String, String>();
//		String kpiNameSWD8 = "Delivery quality "
//				+ "a) Technical estimation accuracy "
//				+ "b) Scoping: Coverage of all functional and non functional requirments "
//				+ "c) 100% coverage of functional and non functional requirements in HLD and LLD "
//				+ "d) Defect Reduction in Review and Testing, "
//				+ "e) Ensuring process compliances as per CMMi L5/ Agile practices "
//				+ "f) Closure of NCs from SQA Audits on time "
//				+ "g) Closing of CSR as per SLA ";
//		String kpiValueSWD8 = "R:95 | C: 96 | S :97";
//		String kpiDescriptionSWD8 = "Delivery quality (Being a part of the overall project team that works collectively)"
//				+ "a) Technical estimation accuracy "
//				+ "b) Scoping: Coverage of all functional and non functional requirments "
//				+ "c) 100% coverage of functional and non functional requirements in HLD and LLD "
//				+ "d) Defect Reduction in Review and Testing, "
//				+ "e) Ensuring process compliances as per CMMi L5/ Agile practices "
//				+ "f) Closure of NCs from SQA Audits on time "
//				+ "g) Closing of CSR as per SLA";
//
//		Map<String, String> mapA8 = IPMUtility.spiltText("kpiName1",
//				kpiNameSWD8, 1000);
//		Map<String, String> mapB8 = IPMUtility.spiltText("kpiDescription1",
//				kpiDescriptionSWD8, 1000);
//		map8.putAll(mapA8);
//		map8.putAll(mapB8);
//
//		KPI kpi8 = new KPI();
//		kpi8.setKpiDisplayName("Delivery quality");
//		kpi8.setKpiValue(kpiValueSWD8);
//		kpi8.setKpiName1(map8.get("kpiName1"));
//		if (StringUtils.isNotBlank(map8.get("kpiName2")))
//			kpi8.setKpiName1(map8.get("kpiName2"));
//		if (StringUtils.isNotBlank(map8.get("kpiName3")))
//			kpi8.setKpiName1(map8.get("kpiName3"));
//		if (StringUtils.isNotBlank(map8.get("kpiName4")))
//			kpi8.setKpiName1(map8.get("kpiName4"));
//
//		kpi8.setKpiDescription1(map8.get("kpiDescription1"));
//		if (StringUtils.isNotBlank(map8.get("kpiDescription2")))
//			kpi8.setKpiDescription2(map8.get("kpiDescription2"));
//		if (StringUtils.isNotBlank(map8.get("kpiDescription3")))
//			kpi8.setKpiDescription3(map8.get("kpiDescription3"));
//		if (StringUtils.isNotBlank(map8.get("kpiDescription4")))
//			kpi8.setKpiDescription4(map8.get("kpiDescription4"));
//
//		kpiService.save(kpi8);
//
//		kpis.add(kpi8);
//
//		Map<String, String> map9 = new HashMap<String, String>();
//		String kpiNameSSWD9 = " Asset Creation - # of new CA assets created and registered in the asset portal Asset Re Use";
//		String kpiValueSSWD9 = "R:1|C:2|S:3";
//		String kpiDescriptionSSWD9 = "Asset Creation - # of new CA assets created and registered in the asset portal Asset Re Use(Being part of the project team harvesting the asset can be counted)";
//
//		Map<String, String> mapA9 = IPMUtility.spiltText("kpiName1",
//				kpiNameSSWD9, 1000);
//		Map<String, String> mapB9 = IPMUtility.spiltText("kpiDescription1",
//				kpiDescriptionSSWD9, 1000);
//		map9.putAll(mapA9);
//		map9.putAll(mapB9);
//
//		KPI kpi9 = new KPI();
//		kpi9.setKpiDisplayName("Engage in Multiple Projects And Others");
//		kpi9.setKpiValue(kpiValueSSWD9);
//		kpi9.setKpiName1(map8.get("kpiName1"));
//		if (StringUtils.isNotBlank(map8.get("kpiName2")))
//			kpi9.setKpiName1(map8.get("kpiName2"));
//		if (StringUtils.isNotBlank(map8.get("kpiName3")))
//			kpi9.setKpiName1(map8.get("kpiName3"));
//		if (StringUtils.isNotBlank(map8.get("kpiName4")))
//			kpi9.setKpiName1(map8.get("kpiName4"));
//
//		kpi9.setKpiDescription1(map8.get("kpiDescription1"));
//		if (StringUtils.isNotBlank(map8.get("kpiDescription2")))
//			kpi9.setKpiDescription2(map8.get("kpiDescription2"));
//		if (StringUtils.isNotBlank(map8.get("kpiDescription3")))
//			kpi9.setKpiDescription3(map8.get("kpiDescription3"));
//		if (StringUtils.isNotBlank(map8.get("kpiDescription4")))
//			kpi9.setKpiDescription4(map8.get("kpiDescription4"));
//
//		kpiService.save(kpi9);
//
//		kpis.add(kpi9);
//
//		return kpis;
//	}
//
//	private void doOriginateEmployee(EmployeeDAO employeeDAO, JobStage jobstage) {
//		Employee employee = new Employee();
//		employee.setJobStage(jobstage);
//
//		employeeDAO.save(employee);
//	}
//
//
//	private void doOriginateDomain(DomainDAO domainDAO) {
//
//		List<Domain> domains = new ArrayList<Domain>();
//		Domain domain1 = new Domain();
//		domain1.setDomainName("Technology_Skill");
//
//		Domain domain2 = new Domain();
//		domain2.setDomainName("MIO");
//
//		Domain domain3 = new Domain();
//		domain3.setDomainName("MSP");
//
//		Domain domain4 = new Domain();
//		domain4.setDomainName("MSDP");
//
//		Domain domain5 = new Domain();
//		domain5.setDomainName("MPS");
//
//		Domain domain6 = new Domain();
//		domain6.setDomainName("Tool");
//
//		domains.add(domain1);
//		domains.add(domain2);
//		domains.add(domain3);
//		domains.add(domain4);
//		domains.add(domain5);
//		domains.add(domain6);
//
//
//		for(Domain entity : domains){
//			domainDAO.save(entity);
//		}
//
//
//
//	}
//
//	private void doOriginateSkillCat(SkillCatDAO skillCatDAO) {
//
//		List<SkillCat> skillcats = new ArrayList<SkillCat>();
//
//		SkillCat skillcat1 = new SkillCat();
//		skillcat1.setSkillName("Generic");
//
//		SkillCat skillcat2 = new SkillCat();
//		skillcat2.setSkillName("Adaptation");
//
//		SkillCat skillcat3 = new SkillCat();
//		skillcat3.setSkillName("System_Integration");
//
//		skillcats.add(skillcat1);
//		skillcats.add(skillcat2);
//		skillcats.add(skillcat3);
//
//
//		for(SkillCat entity : skillcats){
//			skillCatDAO.save(entity);
//		}
//
//	}
//
//	private JobStage doOriginateForTechnology_SkillCA5(BootstrapSetupData caBootstrapSetupData) {
//
//		List<Domain> domains = caBootstrapSetupData.findByDomainName("Technology_Skill");
//		List<SkillCat> skillcats = caBootstrapSetupData.findBySkillCatName("Generic");
//
//		Domain domain = domains.get(0);
//		SkillCat skillcat = skillcats.get(0);
//
//		JobStage jobstage = new JobStage();
//		jobstage.setJSid(5);
//
//		List<ReqSkill> reqskills = new ArrayList<ReqSkill>();
//
//		ReqSkill reqskill1 = new ReqSkill();
//		reqskill1.setJobStage(jobstage);
//		SkillMaster skillmaster1 = new SkillMaster();
//		reqskill1.setReqSkill("A");
//		skillmaster1.setDomain(domain);
//		skillmaster1.setSkillCat(skillcat);
//		skillmaster1.setSkillName("Core Java");
//
//		reqskill1.setSkillMaster(skillmaster1);
//
//
//
//
//		ReqSkill reqskill2 = new ReqSkill();
//		reqskill2.setJobStage(jobstage);
//		SkillMaster skillmaster2 = new SkillMaster();
//		reqskill2.setReqSkill("B");
//		skillmaster2.setDomain(domain);
//		skillmaster2.setSkillCat(skillcat);
//		skillmaster2.setSkillName("J2EE");
//
//		reqskill2.setSkillMaster(skillmaster2);
//
//
//
//
//		ReqSkill reqskill3 = new ReqSkill();
//		reqskill3.setJobStage(jobstage);
//		SkillMaster skillmaster3 = new SkillMaster();
//		reqskill3.setReqSkill("C");
//		skillmaster3.setDomain(domain);
//		skillmaster3.setSkillCat(skillcat);
//		skillmaster3.setSkillName("Hibernate");
//
//		reqskill3.setSkillMaster(skillmaster3);
//
//
//
//
//		ReqSkill reqskill4 = new ReqSkill();
//		reqskill4.setJobStage(jobstage);
//		SkillMaster skillmaster4 = new SkillMaster();
//		reqskill4.setReqSkill("A");
//		skillmaster4.setDomain(domain);
//		skillmaster4.setSkillCat(skillcat);
//		skillmaster4.setSkillName("Spring");
//
//		reqskill4.setSkillMaster(skillmaster4);
//
//
//
//
//
//		ReqSkill reqskill5 = new ReqSkill();
//		reqskill5.setJobStage(jobstage);
//		SkillMaster skillmaster5 = new SkillMaster();
//		reqskill5.setReqSkill("C");
//		skillmaster5.setDomain(domain);
//		skillmaster5.setSkillCat(skillcat);
//		skillmaster5.setSkillName("Java API for XML Web Services (JAX-WS)");
//
//		reqskill5.setSkillMaster(skillmaster5);
//
//
//
//
//		ReqSkill reqskill6 = new ReqSkill();
//		reqskill6.setJobStage(jobstage);
//		SkillMaster skillmaster6 = new SkillMaster();
//		reqskill6.setReqSkill("T");
//		skillmaster6.setDomain(domain);
//		skillmaster6.setSkillCat(skillcat);
//		skillmaster6.setSkillName("Oracle PL/SQL");
//
//		reqskill6.setSkillMaster(skillmaster6);
//
//
//
//
//		ReqSkill reqskill7 = new ReqSkill();
//		reqskill7.setJobStage(jobstage);
//		SkillMaster skillmaster7 = new SkillMaster();
//		reqskill7.setReqSkill("B");
//		skillmaster7.setDomain(domain);
//		skillmaster7.setSkillCat(skillcat);
//		skillmaster7.setSkillName("JavaScript/JSON, CSS, HTML, XHTML");
//
//		reqskill7.setSkillMaster(skillmaster7);
//
//
//
//		ReqSkill reqskill8 = new ReqSkill();
//		reqskill8.setJobStage(jobstage);
//		SkillMaster skillmaster8 = new SkillMaster();
//		reqskill8.setReqSkill("D");
//		skillmaster8.setDomain(domain);
//		skillmaster8.setSkillCat(skillcat);
//		skillmaster8.setSkillName("SOA Architecture");
//
//		reqskill8.setSkillMaster(skillmaster8);
//
//
//
//
//		ReqSkill reqskill9 = new ReqSkill();
//		reqskill9.setJobStage(jobstage);
//		SkillMaster skillmaster9 = new SkillMaster();
//		reqskill9.setReqSkill("A");
//		skillmaster9.setDomain(domain);
//		skillmaster9.setSkillCat(skillcat);
//		skillmaster9.setSkillName("JSP");
//
//		reqskill9.setSkillMaster(skillmaster9);
//
//
//
//
//		ReqSkill reqskill10 = new ReqSkill();
//		reqskill10.setJobStage(jobstage);
//		SkillMaster skillmaster10 = new SkillMaster();
//		reqskill10.setReqSkill("T");
//		skillmaster10.setDomain(domain);
//		skillmaster10.setSkillCat(skillcat);
//		skillmaster10.setSkillName("Caching technologies");
//
//		reqskill10.setSkillMaster(skillmaster10);
//
//
//
//		ReqSkill reqskill11 = new ReqSkill();
//		reqskill11.setJobStage(jobstage);
//		SkillMaster skillmaster11 = new SkillMaster();
//		reqskill11.setReqSkill("C");
//		skillmaster11.setDomain(domain);
//		skillmaster11.setSkillCat(skillcat);
//		skillmaster11.setSkillName("Basic Knowledge Of RDBM");
//
//		reqskill11.setSkillMaster(skillmaster1);
//
//
//
//
//		ReqSkill reqskill12 = new ReqSkill();
//		reqskill12.setJobStage(jobstage);
//		SkillMaster skillmaster12 = new SkillMaster();
//		reqskill12.setReqSkill("A");
//		skillmaster12.setDomain(domain);
//		skillmaster12.setSkillCat(skillcat);
//		skillmaster12.setSkillName("XML");
//
//		reqskill12.setSkillMaster(skillmaster12);
//
//
//
//		ReqSkill reqskill13 = new ReqSkill();
//		reqskill13.setJobStage(jobstage);
//		SkillMaster skillmaster13 = new SkillMaster();
//		reqskill13.setReqSkill("B");
//		skillmaster13.setDomain(domain);
//		skillmaster13.setSkillCat(skillcat);
//		skillmaster13.setSkillName("Maven");
//
//		reqskill13.setSkillMaster(skillmaster13);
//
//
//		ReqSkill reqskill14 = new ReqSkill();
//		reqskill14.setJobStage(jobstage);
//		SkillMaster skillmaster14 = new SkillMaster();
//		reqskill14.setReqSkill("A");
//		skillmaster14.setDomain(domain);
//		skillmaster14.setSkillCat(skillcat);
//		skillmaster14.setSkillName("Basic Shell Scriptin");
//
//		reqskill14.setSkillMaster(skillmaster14);
//
//
//
//		ReqSkill reqskill15 = new ReqSkill();
//		reqskill15.setJobStage(jobstage);
//		SkillMaster skillmaster15 = new SkillMaster();
//		reqskill15.setReqSkill("A");
//		skillmaster15.setDomain(domain);
//		skillmaster15.setSkillCat(skillcat);
//		skillmaster15.setSkillName("LDAP Overview");
//
//		reqskill15.setSkillMaster(skillmaster15);
//
//
//
//		ReqSkill reqskill16 = new ReqSkill();
//		reqskill16.setJobStage(jobstage);
//		SkillMaster skillmaster16 = new SkillMaster();
//		reqskill16.setReqSkill("T");
//		skillmaster16.setDomain(domain);
//		skillmaster16.setSkillCat(skillcat);
//		skillmaster16.setSkillName("Design Pattern");
//
//		reqskill16.setSkillMaster(skillmaster16);
//
//
//
//		ReqSkill reqskill17 = new ReqSkill();
//		reqskill17.setJobStage(jobstage);
//		SkillMaster skillmaster17 = new SkillMaster();
//		reqskill17.setReqSkill("A");
//		skillmaster17.setDomain(domain);
//		skillmaster17.setSkillCat(skillcat);
//		skillmaster17.setSkillName("Cloud Computing Basic");
//
//		reqskill17.setSkillMaster(skillmaster17);
//
//
//
//		ReqSkill reqskill18 = new ReqSkill();
//		reqskill18.setJobStage(jobstage);
//		SkillMaster skillmaster18 = new SkillMaster();
//		reqskill18.setReqSkill("B");
//		skillmaster18.setDomain(domain);
//		skillmaster18.setSkillCat(skillcat);
//		skillmaster18.setSkillName("Big Data Concep");
//
//		reqskill18.setSkillMaster(skillmaster18);
//
//
//		ReqSkill reqskill19 = new ReqSkill();
//		reqskill19.setJobStage(jobstage);
//		SkillMaster skillmaster19 = new SkillMaster();
//		reqskill19.setReqSkill("D");
//		skillmaster19.setDomain(domain);
//		skillmaster19.setSkillCat(skillcat);
//		skillmaster19.setSkillName("Rest API -Webservices");
//
//		reqskill19.setSkillMaster(skillmaster19);
//
//
//
//		ReqSkill reqskill20 = new ReqSkill();
//		reqskill20.setJobStage(jobstage);
//		SkillMaster skillmaster20 = new SkillMaster();
//		reqskill20.setReqSkill("A");
//		skillmaster20.setDomain(domain);
//		skillmaster20.setSkillCat(skillcat);
//		skillmaster20.setSkillName("Linux");
//
//		reqskill20.setSkillMaster(skillmaster20);
//
//
//
//		ReqSkill reqskill21 = new ReqSkill();
//		reqskill21.setJobStage(jobstage);
//		SkillMaster skillmaster21 = new SkillMaster();
//		reqskill21.setReqSkill("T");
//		skillmaster21.setDomain(domain);
//		skillmaster21.setSkillCat(skillcat);
//		skillmaster21.setSkillName("Network Protocol(HTTP,HTTPS,TCP)");
//
//		reqskill21.setSkillMaster(skillmaster21);
//
//
//
//		ReqSkill reqskill22 = new ReqSkill();
//		reqskill22.setJobStage(jobstage);
//		SkillMaster skillmaster22 = new SkillMaster();
//		reqskill22.setReqSkill("B");
//		skillmaster22.setDomain(domain);
//		skillmaster22.setSkillCat(skillcat);
//		skillmaster22.setSkillName("Version Control Tool(SVN,Git)");
//
//		reqskill22.setSkillMaster(skillmaster22);
//
//		reqskills.add(reqskill1);
//		reqskills.add(reqskill2);
//		reqskills.add(reqskill3);
//		reqskills.add(reqskill4);
//		reqskills.add(reqskill5);
//		reqskills.add(reqskill6);
//		reqskills.add(reqskill7);
//		reqskills.add(reqskill8);
//		reqskills.add(reqskill9);
//		reqskills.add(reqskill10);
//		reqskills.add(reqskill12);
//		reqskills.add(reqskill13);
//		reqskills.add(reqskill14);
//		reqskills.add(reqskill15);
//		reqskills.add(reqskill16);
//		reqskills.add(reqskill17);
//		reqskills.add(reqskill18);
//		reqskills.add(reqskill19);
//		reqskills.add(reqskill20);
//		reqskills.add(reqskill21);
//
//		jobstage.setReqSkills(reqskills);
//
//		caBootstrapSetupData.setUp(jobstage);
//
//		return jobstage;
//
//	}

	public static void main(String[] args) {

		String kpiDescription8 = "Delivery quality (Being a part of the overall project team that works collectively)"
				+ "a) Technical estimation accuracy "
				+ "b) Scoping: Coverage of all functional and non functional requirments "
				+ "c) 100% coverage of functional and non functional requirements in HLD and LLD "
				+ "d) Defect Reduction in Review and Testing, "
				+ "e) Ensuring process compliances as per CMMi L5/ Agile practices "
				+ "f) Closure of NCs from SQA Audits on time "
				+ "g) Closing of CSR as per SLA";

		Map<String, String> map = IPMUtility.spiltText("kpiName1",
				kpiDescription8, 1000);
		System.out.println(map);
	}

}