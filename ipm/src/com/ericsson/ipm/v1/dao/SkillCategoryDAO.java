package com.ericsson.ipm.v1.dao;

import java.util.List;

import com.ericsson.ipm.v1.domain.EmployeeSkill;
import com.ericsson.ipm.v1.domain.SkillMaster;

public interface SkillCategoryDAO {

	public List getEmployeeCASkill(int doid, int scid, int eid);

	public void saveEmployeeskill(EmployeeSkill employeeskill);

	public SkillMaster getRefById(int id);

	public void deleteEmployeeSkill( int eid, List<Integer> smIds);

}
