package com.ericsson.ipm.v1.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ericsson.ipm.v1.dao.CertificationDAO;
import com.ericsson.ipm.v1.domain.Certification;
import com.ericsson.ipm.v1.dto.CertificationDTO;

@Service("certificationService")
@Transactional
public class CerificationServiceImpl implements CertificationService{

	CertificationDAO certificationDAO;

	private static final Logger LOGGER = LoggerFactory.getLogger(CerificationServiceImpl.class);

	private UserProfileService userProfileService;

	@Override
	public List<Certification> findByEmployeeType(String employeeType) {
		// TODO Auto-generated method stub
		return certificationDAO.findByEmployeeType(employeeType);
	}

	@Override
	public List<Certification> findByTrainingName(String trainingName) {
		// TODO Auto-generated method stub
		return certificationDAO.findByTrainingName(trainingName);
	}

	@Override
	public List<Certification> findByDateWeekPlanned(String dateWeekPlanned) {
		// TODO Auto-generated method stub
		return certificationDAO.findByDateWeekPlanned(dateWeekPlanned);
	}

	@Override
	public List<Certification> findByDateAttended(String dateAttended) {
		// TODO Auto-generated method stub
		return certificationDAO.findByDateAttended(dateAttended);
	}

	@Override
	public List<Certification> findByCompletionStatus(String completionStatus) {
		// TODO Auto-generated method stub
		return certificationDAO.findByCompletionStatus(completionStatus);
	}

	@Override
	public List<Certification> findByTni(String tni) {
		// TODO Auto-generated method stub
		return certificationDAO.findByTni(tni);
	}

	@Override
	public Certification save(CertificationDTO certificationDTO) {
		// TODO Auto-generated method stub
		Certification certification = new Certification();
		 certification.setEmployeeType(certificationDTO.getEmployeeType());
		 certification.setTrainingName(certificationDTO.getTrainingName());
		 certification.setDateWeekPlanned(certificationDTO.getDateWeekPlanned());
		 certification.setDateAttended(certificationDTO.getDateAttended());
		 certification.setTni(certificationDTO.getTni());
		 certification.setCompletionStatus(certificationDTO.getCompletionStatus());
		 certification.setUserprofile(userProfileService.findById(certificationDTO.getUserId()));


		return certificationDAO.save(certification);
	}

	@Override
	public void remove(String cId) {
		// TODO Auto-generated method stub
			certificationDAO.remove(cId);
	}

	@Override
	public Certification saveOrUpdate(Certification certification) {
		// TODO Auto-generated method stub
		return certificationDAO.saveOrUpdate(certification);
	}

	@Override
	public List<Certification> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Certification getCertificationDetail(String id) {
		// TODO Auto-generated method stub
		return certificationDAO.getCertificationDetail(id);
	}
	   @Autowired
		public void setCertificationDAO(
				CertificationDAO certificationDAO) {
			this.certificationDAO = certificationDAO;
		}
	    @Autowired
		public void setUserProfileService(UserProfileService userProfileService) {
			this.userProfileService = userProfileService;
		}
}
