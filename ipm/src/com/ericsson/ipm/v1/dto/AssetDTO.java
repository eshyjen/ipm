package com.ericsson.ipm.v1.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class AssetDTO implements Serializable{


	private static final long serialVersionUID = 1L;



	private int id;

	private String approvalStatus;

	@NotNull(message="AssetName must not be Empty")
    @NotEmpty(message="AssetName must not be Empty")
	private String assetName;

	@NotNull
    @NotEmpty
	private String assetCreationDate;

	@NotNull
    @NotEmpty
	private String assetShortDescription;

	private String effortSave;

	@NotNull
    @NotEmpty
	private String projectName;

	@NotNull
    @NotEmpty
	private String registeredInAssetPortal;
	private String reusedInOtherProjectsName;

	@NotNull
    @NotEmpty
	private Date creationDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}




	public String getAssetShortDescription() {
		return assetShortDescription;
	}

	public void setAssetShortDescription(String assetShortDescription) {
		this.assetShortDescription = assetShortDescription;
	}

	public String getEffortSave() {
		return effortSave;
	}

	public void setEffortSave(String effortSave) {
		this.effortSave = effortSave;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getRegisteredInAssetPortal() {
		return registeredInAssetPortal;
	}

	public void setRegisteredInAssetPortal(String registeredInAssetPortal) {
		this.registeredInAssetPortal = registeredInAssetPortal;
	}

	public String getReusedInOtherProjectsName() {
		return reusedInOtherProjectsName;
	}

	public void setReusedInOtherProjectsName(String reusedInOtherProjectsName) {
		this.reusedInOtherProjectsName = reusedInOtherProjectsName;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getAssetCreationDate() {
		return assetCreationDate;
	}

	public void setAssetCreationDate(String assetCreationDate) {
		this.assetCreationDate = assetCreationDate;
	}

	// private UserProfile userprofile;


}
