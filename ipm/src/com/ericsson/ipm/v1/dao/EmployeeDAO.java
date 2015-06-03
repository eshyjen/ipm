package com.ericsson.ipm.v1.dao;

import com.ericsson.ipm.v1.domain.Employee;
import com.ericsson.ipm.v1.domain.JobStage;

public interface EmployeeDAO {

	public Employee save(Employee employee);

	public Employee getRefById(int id);
	
	public JobStage getJobStageId(int jsId);

}
