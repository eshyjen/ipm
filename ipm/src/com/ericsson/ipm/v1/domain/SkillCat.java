package com.ericsson.ipm.v1.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the skillcat database table.
 *
 */
@Entity
@Table(name="SKILL_CAT")
@NamedQuery(name="Skillcat.findAll", query="SELECT s FROM SkillCat s")
public class SkillCat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;

	private String skillName;

	//bi-directional many-to-one association to Skillmaster
	@OneToMany(mappedBy="skillCat")
	private List<SkillMaster> skillMasters;

	public SkillCat() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSkillName() {
		return this.skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public List<SkillMaster> getSkillMasters() {
		return this.skillMasters;
	}

	public void setSkillmasters(List<SkillMaster> skillMasters) {
		this.skillMasters = skillMasters;
	}

	public SkillMaster addSkillmaster(SkillMaster skillMaster) {
		getSkillMasters().add(skillMaster);
		skillMaster.setSkillCat(this);

		return skillMaster;
	}

	public SkillMaster removeSkillMaster(SkillMaster skillMaster) {
		getSkillMasters().remove(skillMaster);
		skillMaster.setSkillCat(null);

		return skillMaster;
	}

}