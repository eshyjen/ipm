package com.ericsson.ipm.v1.domain;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the employeeSkill database table.
 *
 */
@Entity
@Table(name="EMPLOYEE_SKILL")
@NamedQuery(name="EmployeeSkill.findAll", query="SELECT e FROM EmployeeSkill e")
public class EmployeeSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	private String actualSkill;

	//bi-directional many-to-one association to Employee
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Eid")
	private Employee employee;

	//bi-directional many-to-one association to SkillMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SMID")
	private SkillMaster skillMaster;

	public EmployeeSkill() {
	}

	public int getID() {
		return this.id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getActualSkill() {
		return this.actualSkill;
	}

	public void setActualSkill(String actualSkill) {
		this.actualSkill = actualSkill;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public SkillMaster getSkillMaster() {
		return this.skillMaster;
	}

	public void setSkillMaster(SkillMaster skillMaster) {
		this.skillMaster = skillMaster;
	}

}