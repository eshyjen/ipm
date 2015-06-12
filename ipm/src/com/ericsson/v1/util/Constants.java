/**
 * 
 */
package com.ericsson.v1.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author iqbal.hosain.khan@ericsson.com
 * 
 */
public class Constants {
	public static final String EJB_LOOKUP_CONTEXT = "java:app/ContextApps-ejb";
	public static final String EJB_LOOKUP_PATH = EJB_LOOKUP_CONTEXT + "/";
	public static final String SPACE = " ";
	public static final String BLANK = "";
	public static final String COMMA = ",";
	
	//private static final Configuration CONFIG = AdaptersConfiguration.getInstance().getConfiguration();
	
		public static final Map<String, String> APPUSER2TWITTER_MAP = new HashMap<String, String>();
	public static final Map<String, String> APPUSER2FACEBOOK_MAP = new HashMap<String, String>();
	static {
		/*APPUSER2TWITTER_MAP.put(APPUSER_FIRSTNAME_KEY, TWITTER_NAME_KEY);
		APPUSER2TWITTER_MAP.put(APPUSER_USERNAME_KEY, TWITTER_USERNAME_KEY);

		APPUSER2FACEBOOK_MAP.put(APPUSER_FIRSTNAME_KEY, FACEBOOK_FIRSTNAME_KEY);
		APPUSER2FACEBOOK_MAP.put(APPUSER_LASTNAME_KEY, FACEBOOK_LASTNAME_KEY);
		APPUSER2FACEBOOK_MAP.put(APPUSER_EMAIL_KEY, FACEBOOK_EMAIL_KEY);*/
	}

	public static final String UNCHECKED_COMPILER_WARNING = "unchecked";

	public static enum APP_ROLES {
		ROLE_CAS_AUTH_GUEST, ROLE_ADMIN, ROLE_SYSADMIN, ROLE_USER, ROLE_MANAGER
	};

	public static final String UTF_CHAR_ENC = "UTF-8";

	
	//public static final String CONSUMER_CAS_URL = AppConfiguration.get("Consumer_Cas_Url");

	public static final String SYSADMIN_EMAIL_KEY = "sysadmin_email";
	public static final String SYSADMIN_PASSWORD_KEY = "sysadmin_password";
	
	public static final String NEWLINE = "\n";
	
	
	public static final String BASE_PROTECTED_URL_PATH = "/v1/protected/";
	public static final String BASE_PUBLIC_URL_PATH = "/v1/public/";
	public static final String BASE_URL_PATH_SUFFIX = ".html";
	
	
	public final static String ASSET_LIST = "assetlist";
	public final static String DELIVERY_QUALITIY_LIST = "deliveryQualitiylist";
	public final static String OPERATIONAL_DISCIPLINE_LIST = "operationalDisciplineList";
	public final static String MANDATORY_CERTIFICATION_LIST= "mandatoryCertificationList";
	public final static String DELIVERY_QUALITY_LIST = "deliveryQualityList";
	public final static String KPI_LIST = "kpilist";
	public final static String KPI_LIST1 = "kpilist1";
	
	/*CONFIG.getProperty("ipm.setupbootstrap.data"); */
	
	/*ipm.controller.registrationController.showRegistrationForm.uri=registration
	ipm.controller.registrationController.registerUserAccount.uri=registration
	ipm.controller.registrationController.resendRegistrationToken.uri=resendRegistrationToken
	ipm.controller.registrationController.regitrationConfirm.uri=regitrationConfirm*/
	public final static String IPM_CONTROLLER_URL_SUFFIX=".html";
	public final static String IPM_CONTROLLER_REGISTRATIONCONTROLLER_SHOWREGISTRATIONFORM_URI="registration";
	public final static String IPM_CONTROLLER_REGISTRATIONCONTROLLER_REGISTERUSERACCOUNT_URI="registration";
	public final static String IPM_CONTROLLER_REGISTRATIONCONTROLLER_RESENDREGISTRATIONTOKEN_URI="resendRegistrationToken";
	public final static String IPM_CONTROLLER_REGISTRATIONCONTROLLER_REGITRATIONCONFIRM_URI="regitrationConfirm";
	
	
	
	////////////////////
		
	
	// People Finder LookUp Constants
	public static final String basePfUrl = "http://gp.internal.ericsson.com/?";
	public static final String[] urlParam = { "x500uid=", "x500uid=" };
	public static final String signumRegularExpression = "[EXQ][A-Z]{6}";
	public static final String EMP_HTML_DIV_TO_PARSE = "div.employee-details";	
	public static final String MGR_HTML_DIV_TO_PARSE = "div.peoplefinder-results";
	public static final int MAX_URL_GENERATION_ATTEMPT = 2;
	public static final int PF_LOOKUP_TIMEOUT_IN_MS = 60000;
	
	// People Finder Employee Description Details Constants
	public static final String EMP_PF_FULLLNAME_KEY = "FULLNAME";
	public static final String EMP_PF_LNAME_KEY = "LNAME";
	public static final String EMP_PF_FNAME_KEY = "FNAME";
	public static final String EMP_PF_SIGNUM_KEY = "SIGNUM";
	public static final String EMP_PF_EMAIL_KEY = "EMAIL";
	public static final String EMP_PF_PHONE_KEY = "PHONE";
	public static final String EMP_PF_EMPID_KEY = "EMPID";
	public static final String EMP_PF_JOBROLE_KEY = "JOBROLE";
	public static final String EMP_PF_POSITIONNAME_KEY = "POSITIONNAME";
	public static final String EMP_PF_ISLINEMANAGER_KEY = "ISLINEMANAGER";
	public static final String EMP_PF_CURRENTLINEMANGER_KEY = "CURRENTLINEMANGER";
	public static final String EMP_PF_MANAGEDPEOPLELISTURL_KEY = "MANAGEDPEOPLELISTURL";
	public static final String EMP_PF_COSTCENTRE_KEY = "COSTCENTRE";
	
	
	// People Finder Employee Description Row
	public static final int EMP_PF_FULLLNAME_KEY_ROW = 0;
	public static final int EMP_PF_LNAME_KEY_ROW = 3;
	public static final int EMP_PF_FNAME_KEY_ROW = 4;
	public static final int EMP_PF_SIGNUM_KEY_ROW = 7;
	public static final int EMP_PF_EMAIL_KEY_ROW = 8;
	public static final int EMP_PF_PHONE_KEY_ROW = 11;
	public static final int EMP_PF_EMPID_KEY_ROW = 21;
	public static final int EMP_PF_JOBROLE_KEY_ROW = 25;
	public static final int EMP_PF_POSITIONNAME_KEY_ROW = 26;
	public static final int EMP_PF_ISLINEMANAGER_KEY_ROW = 28;
	public static final int EMP_PF_CURRENTLINEMANGER_KEY_ROW = 32;
	public static final int EMP_PF_MANAGEDPEOPLELISTURL_KEY_ROW = 33;
	public static final int EMP_PF_COSTCENTRE_KEY_ROW = 35;	
	public static final int EMP_PF_KEY_MAX_ROW_INDEX = 100;
	
	
	//static final String EMP_PF_FULLLNAME_KEY_ROW = "0";
	//static final String EMP_PF_LNAME_KEY_ROW = "3";
	//static final String EMP_PF_FNAME_KEY_ROW = "4";
	//static final String EMP_PF_EMAIL_KEY_ROW = "8";
	//static final String EMP_PF_PHONE_KEY_ROW = "11";
	//static final String EMP_PF_EMPID_KEY_ROW = "21";
	//static final String EMP_PF_JOBROLE_KEY_ROW = "25";
	//static final String EMP_PF_POSITIONNAME_KEY_ROW = "26";
	//static final String EMP_PF_ISLINEMANAGER_KEY_ROW = "28";
	//static final String EMP_PF_CURRENTLINEMANGER_KEY_ROW = "32";
	//static final String EMP_PF_COSTCENTRE_KEY_ROW = "35";	
	//static final String EMP_PF_MANAGEDPEOPLELISTURL_KEY_ROW = "33";
	//static final int EMP_PF_KEY_MAX_ROW_INDEX = 100;
	
	
	// People Finder Managed People List Column
	public static final int EMP_PF_NAME_COL = 0;
	public static final int EMP_PF_SIGNUM_COL = 4;
	public static final int EMP_PF_MANAGEDPEOPLELIST_KEY_MAX_ROW_INDEX = 100;
	
	// SMS Functionality Constants
	public static final String SMS_SUBJECT = "Smart Conferene Invitation...";
	public static final String SMS_CONTENT = " has invited you for a Conference.";
	public static final String SMSC_PREFIX = "@sms.ericsson.com";
	public static final String SMS_SENDER = "Smart Call Service";
	public static final String SMTP_HOST = "smtp.internal.ericsson.com";
	public static final int SMTP_PORT = 25;
	public static final String SMTP_USER = "iqbal.hosain.khan@ericsson.com";
	public static final String SMTP_PASSWORD = "*******";
	
	// Conference Details Constants
	public static final String CONFERENCE_TITLE = "CONFERENCE_TITLE";
	public static final String CONFERENCE_TIME = "CONFERENCE_TIME";
	public static final String CONFERENCE_ORGANIZER_NAME = "CONFERENCE_ORGANIZER_NAME";
	public static final String CONFERENCE_ORGANIZER_EMAIL = "CONFERENCE_ORGANIZER_EMAIL";
	
	
	
	/*PEOPLE FINDER URL:ATTEMPT-1: http://gp.internal.ericsson.com/?x500uid=EBICHAK
	PF-DETAILS-MAP: {COSTCENTRE=2828081300, FNAME=Biswajit, SIGNUM=EBICHAK, LNAME=Chaki, 
	PHONE=+918017990814, POSITIONNAME=Senior Manager, ISLINEMANAGER=Yes, EMPID=EGIL08922,
	MANAGEDPEOPLELISTURL=http://gp.internal.ericsson.com/wps/portal/pf/pf_default/!ut/p/a1/hY1dC4IwFIZ_kZy1PnSX6oKNhBCL2m5i2KhR05ER2a9vo6Ar7Vy-53nfByTsQTbqYU7qbtpGXUGAkPFhwgjGBGG-LjBFPCtnhM0ZRjSGCiTI7lafc05BLDOes3QVMlWHiU3vNAin20orD_0eILpPsrXqaax56WOQy8WwDHlAeAANXIr-9XfBP4IU-AuMKJy1ydRGSR9dyjdMCrqs/dl5/d5/L2dBISEvZ0FBIS9nQSEh/pw/Z7_1H922902IOL2D0IBQ49H5H20D7/act/id=0/p=actionType=peoSearch/p=action=search/p=actionList=listOfPeople/p=srchMGR=EBICHAK/p=srchMOD=exact/p=srchEMP=Workforce/293477565668/=/, 
	FULLNAME=Biswajit Chaki, CURRENTLINEMANGER=Geeti Mathur, EMAIL=biswajit.chaki@ericsson.com, 
	JOBROLE=CUSTOMER PROJECT MANAGER}
	}
	MANAGED PEOPLE LIST URL:ATTEMPT-1: http://gp.internal.ericsson.com/wps/portal/pf/pf_default/!ut/p/a1/hY1dC4IwFIZ_kZy1PnSX6oKNhBCL2m5i2KhR05ER2a9vo6Ar7Vy-53nfByTsQTbqYU7qbtpGXUGAkPFhwgjGBGG-LjBFPCtnhM0ZRjSGCiTI7lafc05BLDOes3QVMlWHiU3vNAin20orD_0eILpPsrXqaax56WOQy8WwDHlAeAANXIr-9XfBP4IU-AuMKJy1ydRGSR9dyjdMCrqs/dl5/d5/L2dBISEvZ0FBIS9nQSEh/pw/Z7_1H922902IOL2D0IBQ49H5H20D7/act/id=0/p=actionType=peoSearch/p=action=search/p=actionList=listOfPeople/p=srchMGR=EBICHAK/p=srchMOD=exact/p=srchEMP=Workforce/293477565668/=/
	MANAGED-PEOPLE-MAP: {ENAMLAK=Naman Lakhani, ERSVWWX=Sumeet Kumar, ESUVBOS=Suvankar Bose, EBISSAH=Bishnu Saha, EMUKKAU=Kaustuv Mukherjee, ERATNCH=Ratnopam Chakrabarti, ESUDASA=Sudarsan Sahoo, EFHJLMU=Mukesh Kumar, ESRSANT=Santosh Kumar Srivastava, EJAISCH=Chandra Prakash Jaiswal, ESIHALK=Alok Singh, EMSEKUM=M Senthil Kumar, ESUVGHO=Suvendu Ghosh, EABCHOU=Abhishek Choudhury, ENASUMA=Suman Nandi, ERANAKU=Rana Kundu, EYACDEL=Rajesh Kumar Singh, ESREROY=Sreemoyee Roy, ECHOAVI=Avishek Pal Chowdhury, EASHICH=Ashish Chatterjee, ERAYRAJ=Rajarshi Ray, ERANSUS=Sushanta Rana, ESHYJEN=Shyam Sundar Jena, ESAHASA=Sandip Saha, ETANROU=Tanushri Routh, EARNMAJ=Arnab Majumdar, ESAYAPA=Sayan Pal, EVYZZCS=Sandipan Sen, ERANJSE=Ranjan Sen, EKHIQBA=Iqbal Hosain Khan}
	*/
	public static final String CA_OPTIONS = " ,T,A,B,C,D";
	
	public final static String CA_LIST = "CADTOs";
	
	public final static String EMPLOYEE_LIST = "employees";


}
