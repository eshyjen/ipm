package com.ericsson.ipm.v1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ericsson.ipm.v1.domain.Employee;
import com.ericsson.ipm.v1.domain.JobStage;

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
	
	@Override
	public JobStage getJobStageId(int jsId){
		Query query =  getEntityManager().createQuery("select model from JobStage model where model.jsId=:jsId");
		query.setParameter("jsId", jsId);
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<JobStage> result = query.getResultList();
		return (result.size() == 0) ? null : result.get(0);
	}
}
