package com.ericsson.ipm.v1.dto;

import java.io.Serializable;


public class DeliveryQualityDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -3270361677712529188L;

	private String id;

	private String projectName;

	private String dqiScore;


	private String dqiDate;


	private String tlName;


	private String projectType;

	private String dpiScore;

	private String pmOrSpmName;

	private String swArchitectName;

	private Integer userId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDqiScore() {
		return dqiScore;
	}

	public void setDqiScore(String dqiScore) {
		this.dqiScore = dqiScore;
	}

	public String getDqiDate() {
		return dqiDate;
	}

	public void setDqiDate(String dqiDate) {
		this.dqiDate = dqiDate;
	}

	public String getTlName() {
		return tlName;
	}

	public void setTlName(String tlName) {
		this.tlName = tlName;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getDpiScore() {
		return dpiScore;
	}

	public void setDpiScore(String dpiScore) {
		this.dpiScore = dpiScore;
	}

	public String getPmOrSpmName() {
		return pmOrSpmName;
	}

	public void setPmOrSpmName(String pmOrSpmName) {
		this.pmOrSpmName = pmOrSpmName;
	}

	public String getSwArchitectName() {
		return swArchitectName;
	}

	public void setSwArchitectName(String swArchitectName) {
		this.swArchitectName = swArchitectName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
