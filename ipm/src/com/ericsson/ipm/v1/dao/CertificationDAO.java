package com.ericsson.ipm.v1.dao;

import java.util.List;

import com.ericsson.ipm.v1.domain.Certification;


public interface CertificationDAO {


	public Certification save(Certification entity);

	public Certification saveOrUpdate(Certification entity);


	public List<Certification> findByEmployeeType(
			Object employeeType);

	public List<Certification> findByTrainingName(
			Object trainingName);

	public List<Certification> findByDateWeekPlanned(
			Object dateWeekPlanned);

	public List<Certification> findByDateAttended(
			Object dateAttended);

	public List<Certification> findByCompletionStatus(
			Object completionStatus);

	public List<Certification> findByTni(
			Object tni);


	void remove(String cId);

	public Certification getCertificationDetail(String id);


}
