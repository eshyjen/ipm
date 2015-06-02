package com.ericsson.ipm.v1.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CADTO implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private int id;
	private String CAName;
	private String CARequiredValue;
	private String userSelected;
	private Integer skillMasterId;
	
	private List<NameIdDTO> options =  new ArrayList<NameIdDTO>();
	
	public CADTO() {
		
	}
	
	public CADTO(String cAName, Integer skillMasterId, String cARequiredValue,
			String userSelected) {
		super();
		CAName = cAName;
		CARequiredValue = cARequiredValue;
		this.userSelected = userSelected;
		this.skillMasterId = skillMasterId;
	}
	
	public CADTO(String cAName, String cARequiredValue,
			String userSelected) {
		super();
		CAName = cAName;
		CARequiredValue = cARequiredValue;
		this.userSelected = userSelected;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCAName() {
		return CAName;
	}
	public void setCAName(String cAName) {
		CAName = cAName;
	}
	public String getCARequiredValue() {
		return CARequiredValue;
	}
	public void setCARequiredValue(String cARequiredValue) {
		CARequiredValue = cARequiredValue;
	}
	public String getUserSelected() {
		return userSelected;
	}
	public void setUserSelected(String userSelected) {
		this.userSelected = userSelected;
	}
	public Integer getSkillMasterId() {
		return skillMasterId;
	}
	public void setSkillMasterId(Integer skillMasterId) {
		this.skillMasterId = skillMasterId;
	}
	public List<NameIdDTO> getOptions() {
		return options;
	}
	public void setOptions(List<NameIdDTO> options) {
		this.options = options;
	}
}
