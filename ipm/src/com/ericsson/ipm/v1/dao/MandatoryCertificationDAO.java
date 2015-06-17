package com.ericsson.ipm.v1.dao;
import java.util.List;

import com.ericsson.ipm.v1.domain.MandatoryCertification;




public interface MandatoryCertificationDAO {

	public MandatoryCertification save(MandatoryCertification entity);
	
	public MandatoryCertification saveOrUpdate(MandatoryCertification entity);
	
	public List<MandatoryCertification> findByTrainingName(
			Object trainingName);

	public List<MandatoryCertification> findByDateWeekPlanned(
			Object dateWeekPlanned);

	public List<MandatoryCertification> findByDateAttended(
			Object dateAttended);

	public List<MandatoryCertification> findByCompletionStatus(
			Object completionStatus);
	
	public List<MandatoryCertification> findByAttachFile(
			Object attachFile);

	public MandatoryCertification getMandatoryCertificationDetail(String id);

	void remove(String opdId);

	
}
