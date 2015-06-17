package com.ericsson.ipm.v1.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ericsson.ipm.v1.dao.MandatoryCertificationDAO;
import com.ericsson.ipm.v1.dao.OperationalDisciplineDAO;
import com.ericsson.ipm.v1.domain.MandatoryCertification;
import com.ericsson.ipm.v1.domain.OperationalDiscipline;
import com.ericsson.ipm.v1.dto.MandatoryCertificationDTO;
import com.ericsson.ipm.v1.dto.OperationalDisciplineDTO;

@Service("mandatoryCertificationService")
@Transactional
public class MandatoryCertificationServiceImpl implements MandatoryCertificationService{



	private static final Logger LOGGER = LoggerFactory.getLogger(MandatoryCertificationServiceImpl.class);

	private MandatoryCertificationDAO mandatoryCertificationDAO;

	private UserProfileService userProfileService;


	@Override
	public List<MandatoryCertification> findByTrainingName(
			String trainingName) {
		// TODO Auto-generated method stub
		return mandatoryCertificationDAO.findByTrainingName(trainingName);

	}

	@Override
	public List<MandatoryCertification> findByDateWeekPlanned(String dateWeekPlanned) {
		// TODO Auto-generated method stub
		return mandatoryCertificationDAO.findByDateWeekPlanned(dateWeekPlanned);
	}

	@Override
	public List<MandatoryCertification> findByDateAttended(String dateAttended) {
		// TODO Auto-generated method stub
		return mandatoryCertificationDAO.findByDateAttended(dateAttended);
	}

	@Override
	public List<MandatoryCertification> findByCompletionStatus(
			String completionStatus) {
		// TODO Auto-generated method stub
		return mandatoryCertificationDAO.findByCompletionStatus(completionStatus);
	}

	@Override
	public MandatoryCertification save(
			MandatoryCertificationDTO mandatoryCertificationDTO) {
		// TODO Auto-generated method stub

		MandatoryCertification mandatoryCertification = new MandatoryCertification();

		mandatoryCertification.setTrainingName(mandatoryCertificationDTO.getTrainingName());
		mandatoryCertification.setDateWeekPlanned(mandatoryCertificationDTO.getDateWeekPlanned());
		mandatoryCertification.setDateAttended(mandatoryCertificationDTO.getDateAttended());
		mandatoryCertification.setCompletionStatus(mandatoryCertificationDTO.getCompletionStatus());
		mandatoryCertification.setUserprofile(userProfileService.findById(mandatoryCertificationDTO.getUserId()));
		return mandatoryCertificationDAO.save(mandatoryCertification);

	}

	@Override
	public void remove(String mcId) {
		// TODO Auto-generated method stub
		mandatoryCertificationDAO.remove(mcId);
	}

	@Override
	public MandatoryCertification saveOrUpdate(
			MandatoryCertification mandatoryCertification) {
		/*
		MandatoryCertification mandatoryCertification = new MandatoryCertification();

		mandatoryCertification.setTrainingName(mandatoryCertificationDTO.getTrainingName());
		mandatoryCertification.setDateWeekPlanned(mandatoryCertificationDTO.getDateWeekPlanned());
		mandatoryCertification.setDateAttended(mandatoryCertificationDTO.getDateAttended());
		mandatoryCertification.setCompletionStatus(mandatoryCertificationDTO.getCompletionStatus());
		String trngName = mandatoryCertificationDTO.getTrainingName(); // SETTING TRAINING NAME AS PRIMARY KEYYYYYYYYY
		if(trngName != null && !trngName.equals("")){
			mandatoryCertification.setTrainingName(trngName);
		}
		mandatoryCertification.setUserprofile(userProfileService.findByTrainingName(mandatoryCertificationDTO.getTrainingName()));
		return mandatoryCertificationDAO.saveOrUpdate(mandatoryCertification);*/
		
		return mandatoryCertificationDAO.saveOrUpdate(mandatoryCertification);

	}

	@Override
	public List<MandatoryCertification> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MandatoryCertification getMandatoryCertificationDetail(String id) {
		// TODO Auto-generated method stub
		return mandatoryCertificationDAO.getMandatoryCertificationDetail(id);
	}
    @Autowired
	public void setMandatoryCertificationDAO(
			MandatoryCertificationDAO mandatoryCertificationDAO) {
		this.mandatoryCertificationDAO = mandatoryCertificationDAO;
	}
    @Autowired
	public void setUserProfileService(UserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}



}
