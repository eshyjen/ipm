package com.ericsson.ipm.v1.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the jobstage database table.
 *
 */
@Entity
@Table(name="JOB_STAGE")
@NamedQuery(name="Jobstage.findAll", query="SELECT j FROM JobStage j")
public class JobStage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	private int JSid;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="jobStage")
	private List<Employee> employees;

	//bi-directional many-to-one association to Reqskill
	@OneToMany(mappedBy="jobStage", cascade=CascadeType.ALL)
	private List<ReqSkill> reqSkills;

	public JobStage() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getJSid() {
		return this.JSid;
	}

	public void setJSid(int JSid) {
		this.JSid = JSid;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setJobStage(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setJobStage(null);

		return employee;
	}

	public List<ReqSkill> getReqSkills() {
		return this.reqSkills;
	}

	public void setReqSkills(List<ReqSkill> reqSkills) {
		this.reqSkills = reqSkills;
	}

	public ReqSkill addReqSkill(ReqSkill reqSkill) {
		getReqSkills().add(reqSkill);
		reqSkill.setJobStage(this);

		return reqSkill;
	}

	public ReqSkill removeReqSkill(ReqSkill reqSkill) {
		getReqSkills().remove(reqSkill);
		reqSkill.setJobStage(null);

		return reqSkill;
	}

}