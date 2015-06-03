package com.ericsson.ipm.v1.service;

import java.util.List;

import com.ericsson.ipm.v1.domain.Domain;
import com.ericsson.ipm.v1.domain.Employee;
import com.ericsson.ipm.v1.domain.EmployeeSkill;
import com.ericsson.ipm.v1.domain.JobStage;
import com.ericsson.ipm.v1.domain.SkillCat;
import com.ericsson.ipm.v1.domain.SkillMaster;
import com.ericsson.ipm.v1.dto.CADTO;

public interface SkillCategoryService {


	public List<CADTO> getEmployeeCASkill(int doid, int scid, int eid);

	public SkillMaster getRefById(int id);

	public void saveEmployeeskill(EmployeeSkill employeeskill);
	public void saveEmployeeskills(List<EmployeeSkill> employeeskill);

	public Employee getRefByEmployeeId(int id);

	public void deleteEmployeeSkill( int eid, List<Integer> smIds);
	
	public JobStage getJobStageId(int jsId);
	
	public Domain findByDomainName(Object d_name);
	
	public SkillCat findBySkillCatName(Object skillName);
}
