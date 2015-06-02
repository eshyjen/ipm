package com.ericsson.ipm.v1.dao;

import com.ericsson.ipm.v1.domain.Employee;

public interface EmployeeDAO {

	public Employee save(Employee employee);

	public Employee getRefById(int id);

}
