package com.ericsson.ipm.v1.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CertificationDTO implements Serializable{

	private static final long serialVersionUID = -3270361677712529188L;

	@NotNull
	@NotEmpty

	private int id;
	@NotNull
	@NotEmpty
	private String employeeType;

	@NotNull
	@NotEmpty
	private String trainingName;

	@NotNull
	@NotEmpty
	private String dateWeekPlanned;

	private String dateAttended;
	
	@NotNull
	@NotEmpty
	private String tni;

	@NotNull
	@NotEmpty
	private String completionStatus;



	private int userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public String getDateWeekPlanned() {
		return dateWeekPlanned;
	}

	public void setDateWeekPlanned(String dateWeekPlanned) {
		this.dateWeekPlanned = dateWeekPlanned;
	}

	public String getDateAttended() {
		return dateAttended;
	}

	public void setDateAttended(String dateAttended) {
		this.dateAttended = dateAttended;
	}

	public String getCompletionStatus() {
		return completionStatus;
	}

	public void setCompletionStatus(String completionStatus) {
		this.completionStatus = completionStatus;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public String getTni() {
		return tni;
	}

	public void setTni(String tni) {
		this.tni = tni;
	}
}
