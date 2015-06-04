package com.ericsson.ipm.v1.domain;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the reqskill database table.
 *
 */
@Entity
@Table(name="REQ_SKILL")
@NamedQuery(name="Reqskill.findAll", query="SELECT r FROM ReqSkill r")
public class ReqSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	@Column(name = "REQ_SKILL")
	private String reqSkill;

	//bi-directional many-to-one association to Skillmaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SMid")
	private SkillMaster skillMaster;

	//bi-directional many-to-one association to Jobstage
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="JS")
	private JobStage jobStage;

	public ReqSkill() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReqSkill() {
		return reqSkill;
	}

	public void setReqSkill(String reqSkill) {
		this.reqSkill = reqSkill;
	}

	public SkillMaster getSkillMaster() {
		return this.skillMaster;
	}

	public void setSkillMaster(SkillMaster skillMaster) {
		this.skillMaster = skillMaster;
	}

	public JobStage getJobStage() {
		return this.jobStage;
	}

	public void setJobStage(JobStage jobStage) {
		this.jobStage = jobStage;
	}

}