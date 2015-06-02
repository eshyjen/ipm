package com.ericsson.ipm.v1.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CADTOs implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private String CADomainName;
	private String CASkillName;
	private String CADomainId;
	private String CASkillId;
	
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
	public String getCADomainId() {
		return CADomainId;
	}
	public void setCADomainId(String cADomainId) {
		CADomainId = cADomainId;
	}
	public String getCASkillId() {
		return CASkillId;
	}
	public void setCASkillId(String cASkillId) {
		CASkillId = cASkillId;
	}
	public List<CADTO> getList() {
		return list;
	}
	public void setList(List<CADTO> list) {
		this.list = list;
	}
	
}
