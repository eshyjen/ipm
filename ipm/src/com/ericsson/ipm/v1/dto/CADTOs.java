package com.ericsson.ipm.v1.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CADTOs implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private String CADomainName;
	private String CASkillName;
	private Integer caDomainId;
	private Integer caSkillId;
	
	private List<CADTO> list =  new ArrayList<CADTO>();
	
	public String getCADomainName() {
		return CADomainName;
	}
	public void setCADomainName(String cADomainName) {
		CADomainName = cADomainName;
	}
	public String getCASkillName() {
		return CASkillName;
	}
	public void setCASkillName(String cASkillName) {
		CASkillName = cASkillName;
	}
	
	public Integer getCaDomainId() {
		return caDomainId;
	}
	public void setCaDomainId(Integer caDomainId) {
		this.caDomainId = caDomainId;
	}
	public Integer getCaSkillId() {
		return caSkillId;
	}
	public void setCaSkillId(Integer caSkillId) {
		this.caSkillId = caSkillId;
	}
	public List<CADTO> getList() {
		return list;
	}
	public void setList(List<CADTO> list) {
		this.list = list;
	}
	
}
