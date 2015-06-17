package com.ericsson.ipm.v1.dto;


import java.io.Serializable;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
public class MandatoryCertificationDTO implements Serializable {



private static final long serialVersionUID = -3270361677712529188L;

@NotNull
@NotEmpty
private int id;

@NotNull
@NotEmpty
private String trainingName;

@NotNull
@NotEmpty
private String dateWeekPlanned;

private String dateAttended;

@NotNull
@NotEmpty
private String completionStatus;

private String attachFile;

private int userId;

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



public String getAttachFile() {
	return attachFile;
}

public void setAttachFile(String attachFile) {
	this.attachFile = attachFile;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}



}