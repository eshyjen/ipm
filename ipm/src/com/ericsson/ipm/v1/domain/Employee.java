package com.ericsson.ipm.v1.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the employee database table.
 *
 */
@Entity
@Table(name="EMPLOYEE")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
    //@PrimaryKeyJoinColumn(name="ID")
	//@Column(name = "ID")
	@OneToOne
	@JoinColumn(name="ID")
    private UserProfile userprofile;
	//private int id;

	//@GeneratedValue should no auto increment
	//@Column(name = "ID")
	//private int id;

	//bi-directional many-to-one association to Jobstage
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Js")
	private JobStage jobStage;

	//bi-directional many-to-one association to Employeeskill
	@OneToMany(mappedBy="employee")
	private List<EmployeeSkill> employeeSkills;



	public Employee() {
	}

	/*public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}*/

	public JobStage getJobstage() {
		return this.jobStage;
	}

	public void setJobStage(JobStage jobStage) {
		this.jobStage = jobStage;
	}

	public List<EmployeeSkill> getEmployeeSkills() {
		return this.employeeSkills;
	}

	public void setEmployeeSkills(List<EmployeeSkill> employeeSkills) {
		this.employeeSkills = employeeSkills;
	}

	public EmployeeSkill addEmployeeSkill(EmployeeSkill employeeSkill) {
		getEmployeeSkills().add(employeeSkill);
		employeeSkill.setEmployee(this);

		return employeeSkill;
	}

	public EmployeeSkill removeEmployeeskill(EmployeeSkill employeeSkill) {
		getEmployeeSkills().remove(employeeSkill);
		employeeSkill.setEmployee(null);

		return employeeSkill;
	}

	public JobStage getJobStage() {
		return jobStage;
	}

	public UserProfile getUserprofile() {
		return userprofile;
	}

	public void setUserprofile(UserProfile userprofile) {
		this.userprofile = userprofile;
	}




}