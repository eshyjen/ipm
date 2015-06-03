package com.ericsson.ipm.v1.perser;

import static org.apache.commons.lang.StringUtils.isBlank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.v1.util.Constants;

public class PeopleFinderPerser {

	static Map<String, String> rowIndexParamKeyMap = new HashMap<String, String>();
	private static final Logger LOGGER = LoggerFactory.getLogger(PeopleFinderPerser.class);

	static {
		populateRowIndexParamKeyMap();
	}

	private static void populateRowIndexParamKeyMap() {
		rowIndexParamKeyMap.put(Constants.EMP_PF_FULLLNAME_KEY_ROW+"", Constants.EMP_PF_FULLLNAME_KEY);
		rowIndexParamKeyMap.put(Constants.EMP_PF_FNAME_KEY_ROW+"", Constants.EMP_PF_FNAME_KEY);
		rowIndexParamKeyMap.put(Constants.EMP_PF_LNAME_KEY_ROW+"", Constants.EMP_PF_LNAME_KEY);
		rowIndexParamKeyMap.put(Constants.EMP_PF_SIGNUM_KEY_ROW+"", Constants.EMP_PF_SIGNUM_KEY);
		rowIndexParamKeyMap.put(Constants.EMP_PF_EMAIL_KEY_ROW+"", Constants.EMP_PF_EMAIL_KEY);
		rowIndexParamKeyMap.put(Constants.EMP_PF_PHONE_KEY_ROW+"", Constants.EMP_PF_PHONE_KEY);
		rowIndexParamKeyMap.put(Constants.EMP_PF_EMPID_KEY_ROW+"", Constants.EMP_PF_EMPID_KEY);
		rowIndexParamKeyMap.put(Constants.EMP_PF_JOBROLE_KEY_ROW+"", Constants.EMP_PF_JOBROLE_KEY);
		rowIndexParamKeyMap.put(Constants.EMP_PF_CURRENTLINEMANGER_KEY_ROW+"", Constants.EMP_PF_CURRENTLINEMANGER_KEY);
		rowIndexParamKeyMap.put(Constants.EMP_PF_COSTCENTRE_KEY_ROW+"", Constants.EMP_PF_COSTCENTRE_KEY);
		rowIndexParamKeyMap.put(Constants.EMP_PF_POSITIONNAME_KEY_ROW+"", Constants.EMP_PF_POSITIONNAME_KEY);
		rowIndexParamKeyMap.put(Constants.EMP_PF_ISLINEMANAGER_KEY_ROW+"", Constants.EMP_PF_ISLINEMANAGER_KEY);		
	}
	
	public String generateExactPfUrl(int attempt, String signum) throws Exception {
		if (isBlank(signum)) {
			System.out.println("NO SIGNUM PROVIDED FOR LOOKUP");
			throw new Exception("NO SIGNUM PROVIDED FOR LOOKUP");
		}
		signum = signum.trim().toUpperCase();
		if (signum.trim().toUpperCase().matches(Constants.signumRegularExpression)) {
			if (attempt >= 0 & attempt < Constants.MAX_URL_GENERATION_ATTEMPT) {
				return Constants.basePfUrl + Constants.urlParam[attempt] + signum.trim().toUpperCase();
			} else {
				System.out.println("ERROR: MAXIMUM NUMBER OF ATTEMPTS TO GENERATE PEOPLE FINDER URL IS REACHED");
				throw new Exception("ERROR: MAXIMUM NUMBER OF ATTEMPTS TO GENERATE PEOPLE FINDER URL IS REACHED");
			}
		} else {
			System.out.println("ERROR: INVALID SIGNUM PROVIDED FOR LOOKUP");
			throw new Exception("ERROR: INVALID SIGNUM PROVIDED FOR LOOKUP");
		}
	}

	public Map<String, String> fetchPfDataFromUrl(String pfUrl) throws IOException {
		Map<String, String> pfDetailsMap = new HashMap<String, String>();
		Document doc = Jsoup.connect(pfUrl).timeout(Constants.PF_LOOKUP_TIMEOUT_IN_MS).get();
		// Document doc = Jsoup.connect(pfUrl).get();
		// Element employeeDetails = doc.select(HTML_DIV_TO_PARSE).first();
		Elements rows = doc.select(Constants.EMP_HTML_DIV_TO_PARSE).first().select("tr");
		int rowIndex = 0;
		StringBuffer paramValue = new StringBuffer();
		String isLineManager = "NO";
		for (Element row : rows) {
			paramValue.delete(0, paramValue.length());
			rowIndex = row.elementSiblingIndex();
			switch (rowIndex) {
//				case 3:
//				case 4:
//				case 8:
//				case 11:
				case 33:
					//paramValue.append(row.select("a").first().attr("abs:href").trim());
					//break;
					if(isLineManager.equalsIgnoreCase("YES")) {
                        paramValue.append(row.select("a").first().attr("abs:href").trim());
                        break;
                    }
				case 28:
					isLineManager=row.select("td").text().trim();
					if(isLineManager.equalsIgnoreCase("YES")) {
						rowIndexParamKeyMap.remove(Constants.EMP_PF_COSTCENTRE_KEY_ROW);
						rowIndexParamKeyMap.put((Constants.EMP_PF_COSTCENTRE_KEY_ROW+1)+"", Constants.EMP_PF_COSTCENTRE_KEY);
						rowIndexParamKeyMap.put(Constants.EMP_PF_MANAGEDPEOPLELISTURL_KEY_ROW+"", Constants.EMP_PF_MANAGEDPEOPLELISTURL_KEY);
					}
				default:
					paramValue.append(row.select("td").text());
					//System.out.println("ROW-INDEX: " + rowIndex + " PARAM-VALUE: " + paramValue);
					break;
			}
			if (rowIndexParamKeyMap.containsKey(rowIndex + "")) {
				pfDetailsMap.put(rowIndexParamKeyMap.get(rowIndex + ""), paramValue.toString().trim());
			}
			if (rowIndex >= Constants.EMP_PF_KEY_MAX_ROW_INDEX) {
				break;
			}
		}
		if(isLineManager.equalsIgnoreCase("YES")) {
			rowIndexParamKeyMap.remove((Constants.EMP_PF_COSTCENTRE_KEY_ROW+1)+"");
			rowIndexParamKeyMap.remove(Constants.EMP_PF_MANAGEDPEOPLELISTURL_KEY_ROW);
			rowIndexParamKeyMap.put(Constants.EMP_PF_COSTCENTRE_KEY_ROW+"", Constants.EMP_PF_COSTCENTRE_KEY);
			isLineManager = "NO";
		}
		//System.out.println("PF-DETAILS-MAP: " + pfDetailsMap);
		return pfDetailsMap;
		// System.out.println("LAST NAME: " + rows.get(3).select("td").text());
		// System.out.println("FIRST NAME: " + rows.get(4).select("td").text());
		// System.out.println("EMAIL: " + rows.get(8).select("td").select("a").text());
		// System.out.println("PHONE: " + rows.get(11).select("td").select("a").text());
	}

	public Map<String, String> fetchManagedPeopleList(String managedListUrl) throws IOException {
		Map<String, String> managedPeopleMap = new HashMap<String, String>();
		Document doc = Jsoup.connect(managedListUrl).timeout(Constants.PF_LOOKUP_TIMEOUT_IN_MS).get();
		Elements rows = doc.select(Constants.MGR_HTML_DIV_TO_PARSE).first().select("tr");
		int rowIndex = 0;
		StringBuffer empSignum = new StringBuffer();
		StringBuffer empName = new StringBuffer();
		for (Element row : rows) {
			empSignum.delete(0, empSignum.length());
			empName.delete(0, empName.length());
			rowIndex = row.elementSiblingIndex();
			switch (rowIndex) {
				default:
					empName.append(row.child(Constants.EMP_PF_NAME_COL).text());
					empSignum.append(row.child(Constants.EMP_PF_SIGNUM_COL).text());					
					//System.out.println("ROW-INDEX: " + rowIndex + " EMP-SIGNUM: " + empSignum + " EMP-NAME: " + empName);
					break;
			}
			if (!empName.toString().trim().equalsIgnoreCase("NAME")) {
				managedPeopleMap.put(empSignum.toString().trim().toUpperCase(), empName.toString().trim());
			}
			if (rowIndex >= Constants.EMP_PF_MANAGEDPEOPLELIST_KEY_MAX_ROW_INDEX) {
				break;
			}
		}
		//System.out.println("MANAGED-PEOPLE-MAP: " + managedPeopleMap);
		return managedPeopleMap;
	}
	
	public Map<String, String> getPeopleFinderDetails(String signum) throws Exception {
		Map<String, String> pfDetailsMap = null;
		PeopleFinderPerser pfs = new PeopleFinderPerser();
		String pfUrl;
		for (int attempt = 1; attempt < Constants.MAX_URL_GENERATION_ATTEMPT; attempt++) {
			pfUrl = generateExactPfUrl(attempt, signum);
			System.out.println("PEOPLE FINDER URL:ATTEMPT-" + attempt + ": " + pfUrl);
			pfDetailsMap = pfs.fetchPfDataFromUrl(pfUrl);
			System.out.println("PF-DETAILS-MAP: " + pfDetailsMap);
		}
		return pfDetailsMap;
	}
	
	public List<Map<String, String>> getPeopleFinderDetailsList(List<String> signumList) throws Exception {
		List<Map<String, String>> pfDetailsList = new ArrayList<Map<String, String>>();
		for(String signum:signumList) {
			try {
				pfDetailsList.add(getPeopleFinderDetails(signum));
			} catch (Exception e) {
				System.out.println("ERROR: COULD NOT FIND DETAILS FOR SIGNUM: " + signum);
			}			
		}
		return pfDetailsList;
	}

	public static void main(String[] args) throws Exception {
		String signum = "ESHYJEN";
		PeopleFinderPerser pfs = new PeopleFinderPerser();
		String pfUrl;
		String managedPeopleListUrl="";
		Map<String, String> pfDetailsMap = new HashMap<String,String>();
		Map<String, String> managedPeopleMap = new HashMap<String, String>();
		for (int attempt = 1; attempt < Constants.MAX_URL_GENERATION_ATTEMPT; attempt++) {
			pfUrl = pfs.generateExactPfUrl(attempt, signum);
			System.out.println("PEOPLE FINDER URL:ATTEMPT-" + attempt + ": " + pfUrl);
			pfDetailsMap = pfs.fetchPfDataFromUrl(pfUrl);
			System.out.println("PF-DETAILS-MAP: " + pfDetailsMap);
		}
		if(pfDetailsMap.get(Constants.EMP_PF_ISLINEMANAGER_KEY).equalsIgnoreCase("YES")) {
			managedPeopleListUrl=pfDetailsMap.get(Constants.EMP_PF_MANAGEDPEOPLELISTURL_KEY);
			for (int attempt = 1; attempt < Constants.MAX_URL_GENERATION_ATTEMPT; attempt++) {
				System.out.println("MANAGED PEOPLE LIST URL:ATTEMPT-" + attempt + ": " + managedPeopleListUrl);
				managedPeopleMap = pfs.fetchManagedPeopleList(managedPeopleListUrl);
				System.out.println("MANAGED-PEOPLE-MAP: " + managedPeopleMap);
			}			
		}
	}

	
}
