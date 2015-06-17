package com.ericsson.ipm.v1.service;

import java.util.List;

import com.ericsson.ipm.v1.domain.MandatoryCertification;
import com.ericsson.ipm.v1.domain.OperationalDiscipline;
import com.ericsson.ipm.v1.dto.MandatoryCertificationDTO;
import com.ericsson.ipm.v1.dto.OperationalDisciplineDTO;


public interface MandatoryCertificationService {

	public List<MandatoryCertification> findByTrainingName(
			String trainingName);

	public List<MandatoryCertification> findByDateWeekPlanned(
			String dateWeekPlanned);

	public List<MandatoryCertification> findByDateAttended(
			String dateAttended);

	public List<MandatoryCertification> findByCompletionStatus(
			String completionStatus);


	public MandatoryCertification save(MandatoryCertificationDTO mandatoryCertificationDTO);

	public void remove(String mcId);

	public MandatoryCertification saveOrUpdate(MandatoryCertification entity);

	public List<MandatoryCertification> findAll();

	public MandatoryCertification getMandatoryCertificationDetail(String id);




}
