package com.ericsson.ipm.v1.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ericsson.ipm.v1.domain.Employee;

@Repository("employeeDAO")
@Transactional
public class EmployeeDAOImpl extends BaseDAO<Integer, Employee> implements EmployeeDAO {

	@PersistenceContext
	protected EntityManager entityManager;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(EmployeeDAOImpl.class);

	private EntityManager getEntityManager() {
		return entityManager;
	}

	public Employee save(Employee employee) {
		return save(employee);

	}

	@Override
	public Employee getRefById(int id) {
		return super.getRefById(id);
	}
}
