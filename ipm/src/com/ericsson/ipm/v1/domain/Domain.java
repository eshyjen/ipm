package com.ericsson.ipm.v1.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the domain database table.
 *
 */
@Entity
@Table(name="DOMAIN")
@NamedQuery(name="Domain.findAll", query="SELECT d FROM Domain d")
public class Domain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	@Column(name = "DOMAIN_NAME")
	private String domainName;

	//bi-directional many-to-one association to Skillmaster
	@OneToMany(mappedBy="domain")
	private List<SkillMaster> skillMasters;

	public Domain() {
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}



	public List<SkillMaster> getSkillMasters() {
		return skillMasters;
	}


	public void setSkillMasters(List<SkillMaster> skillMasters) {
		this.skillMasters = skillMasters;
	}


	public SkillMaster addSkillmaster(SkillMaster skillMaster) {
		getSkillMasters().add(skillMaster);
		skillMaster.setDomain(this);

		return skillMaster;
	}

	public SkillMaster removeSkillmaster(SkillMaster skillMaster) {
		getSkillMasters().remove(skillMaster);
		skillMaster.setDomain(null);

		return skillMaster;
	}

}