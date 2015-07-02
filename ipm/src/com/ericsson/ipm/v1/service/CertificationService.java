package com.ericsson.ipm.v1.service;

import java.util.List;

import com.ericsson.ipm.v1.domain.Certification;
import com.ericsson.ipm.v1.dto.CertificationDTO;


public interface CertificationService {

	public List<Certification> findByEmployeeType(
			String employeeType);

	public List<Certification> findByTrainingName(
			String trainingName);

	public List<Certification> findByDateWeekPlanned(
			String dateWeekPlanned);

	public List<Certification> findByDateAttended(
			String dateAttended);

	public List<Certification> findByCompletionStatus(
			String completionStatus);

	public List<Certification> findByTni(
			String tni);


	public Certification save(CertificationDTO certificationDTO);

	public void remove(String mcId);

	public Certification saveOrUpdate(Certification entity);

	public List<Certification> findAll();

	public Certification getCertificationDetail(String id);

}
