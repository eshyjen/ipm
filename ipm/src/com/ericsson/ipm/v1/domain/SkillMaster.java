package com.ericsson.ipm.v1.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.ericsson.ipm.v1.dto.CADTO;


/**
 * The persistent class for the skillMaster database table.
 *
 */
@Entity
@Table(name="SKILL_MASTER")
@NamedQuery(name="SkillMaster.findAll", query="SELECT s FROM SkillMaster s")
@SqlResultSetMapping(name="AN_USER_PLUS_SKILL_DETAILS_CONSTRUCTOR", classes={
        @ConstructorResult(targetClass=CADTO.class,
            columns={@ColumnResult(name="CAName"), @ColumnResult(name="skillMasterId"), @ColumnResult(name="CARequiredValue"), @ColumnResult(name="userSelected")}),
     })

/*@SqlResultSetMapping(name="AN_USER_PLUS_SKILL_DETAILS_CONSTRUCTOR", classes={
        @ConstructorResult(targetClass=CADTO.class,
            columns={@ColumnResult(name="CAName"), @ColumnResult(name="CARequiredValue"), @ColumnResult(name="userSelected")}),
     })*/

public class SkillMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;

	private String skillName;

	//bi-directional many-to-one association to Employeeskill
	@OneToMany(mappedBy="skillMaster")
	private List<EmployeeSkill> employeeSkills;

	//bi-directional many-to-one association to Reqskill
	@OneToMany(mappedBy="skillMaster")
	private List<ReqSkill> reqSkills;

	//bi-directional many-to-one association to Skillcat
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SCid")
	private SkillCat skillCat;

	//bi-directional many-to-one association to Domain
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Doid")
	private Domain domain;

	public SkillMaster() {
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

	public List<EmployeeSkill> getEmployeeSkills() {
		return this.employeeSkills;
	}

	public void setEmployeeSkills(List<EmployeeSkill> employeeSkills) {
		this.employeeSkills = employeeSkills;
	}

	public EmployeeSkill addEmployeeSkill(EmployeeSkill employeeSkill) {
		getEmployeeSkills().add(employeeSkill);
		employeeSkill.setSkillMaster(this);

		return employeeSkill;
	}

	public EmployeeSkill removeEmployeeskill(EmployeeSkill employeeSkill) {
		getEmployeeSkills().remove(employeeSkill);
		employeeSkill.setSkillMaster(null);

		return employeeSkill;
	}

	public List<ReqSkill> getReqskills() {
		return this.reqSkills;
	}

	public void setReqskills(List<ReqSkill> reqSkills) {
		this.reqSkills = reqSkills;
	}

	public ReqSkill addReqskill(ReqSkill reqSkill) {
		getReqskills().add(reqSkill);
		reqSkill.setSkillMaster(this);

		return reqSkill;
	}

	public ReqSkill removeReqskill(ReqSkill reqSkill) {
		getReqskills().remove(reqSkill);
		reqSkill.setSkillMaster(null);

		return reqSkill;
	}

	public SkillCat getSkillCat() {
		return this.skillCat;
	}

	public void setSkillCat(SkillCat skillCat) {
		this.skillCat = skillCat;
	}

	public Domain getDomain() {
		return this.domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

}