package com.ericsson.ipm.v1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ericsson.ipm.v1.domain.Domain;
import com.ericsson.ipm.v1.domain.JobStage;
import com.ericsson.ipm.v1.domain.SkillCat;


@Repository("caBootstrapSetupData")
@Transactional
public class CABootstrapSetupDataImpl implements CABootstrapSetupData {


	private DomainDAO domainDAO;

	private SkillCatDAO skillCatDAO;

	@PersistenceContext
	protected EntityManager entityManager;

	private static final Logger LOGGER = LoggerFactory.getLogger(CABootstrapSetupDataImpl.class);

	private EntityManager getEntityManager() {
		return entityManager;
	}

	public void setUp(JobStage jobstage){

		getEntityManager().persist(jobstage);

	}

	public void saveDomain(Domain domain){

		getEntityManager().persist(domain);

	}

	public void saveSkillcat(SkillCat skillcat){

		getEntityManager().persist(skillcat);

	}

	public SkillCat findById(int id) {
		return entityManager.find(SkillCat.class, id);
	}

	public SkillCat getRefById(int id) {
		return entityManager.getReference(SkillCat.class, id);
	}

	public Domain findByIdDomain(int id) {
		return entityManager.find(Domain.class, id);
	}

	public Domain getRefByIdDomain(int id) {
		return entityManager.getReference(Domain.class, id);
	}

	@Override
	public List<Domain> findByDomainName(Object d_name) {
		return domainDAO.findByDomainName(d_name);
	}

	@Override
	public List<SkillCat> findBySkillCatName(Object skillName) {
		return skillCatDAO.findBySkillCatName(skillName);
	}

	@Autowired
	public void setDomainDAO(DomainDAO domainDAO) {
		this.domainDAO = domainDAO;
	}

	@Autowired
	public void setSkillCatDAO(SkillCatDAO skillCatDAO) {
		this.skillCatDAO = skillCatDAO;
	}





}
