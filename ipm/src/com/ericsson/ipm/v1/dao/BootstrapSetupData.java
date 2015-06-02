package com.ericsson.ipm.v1.dao;

import java.util.List;

import com.ericsson.ipm.v1.domain.Domain;
import com.ericsson.ipm.v1.domain.JobStage;
import com.ericsson.ipm.v1.domain.SkillCat;

public interface BootstrapSetupData {


	public void setUp();
	public void setUp(JobStage jobstage);


	public void saveDomain(Domain domain);

	public void saveSkillcat(SkillCat skillcat);

	public SkillCat findById(int id);

	public SkillCat getRefById(int id);

	public Domain findByIdDomain(int id);

	public Domain getRefByIdDomain(int id);

	public List<Domain> findByDomainName(Object d_name);

	public List<SkillCat> findBySkillCatName(Object skillName);

}
