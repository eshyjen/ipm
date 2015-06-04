package com.ericsson.ipm.v1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ericsson.ipm.v1.domain.EmployeeSkill;
import com.ericsson.ipm.v1.domain.SkillMaster;


@Repository("skillCategoryDAO")
@Transactional
public class SkillCategoryDAOImpl extends BaseDAO<Integer, SkillMaster> implements SkillCategoryDAO {


	private static final Logger LOGGER = LoggerFactory.getLogger(SkillCategoryDAOImpl.class);

	private EntityManager getEntityManager() {
		return entityManager;
	}
	public List getEmployeeCASkill(int doid, int scid, int eid){

		String nativeQuery = "SELECT REQUIREDSKILL.skillName AS CAName, REQUIREDSKILL.ID AS skillMasterId, REQUIREDSKILL.REQ_SKILL AS CARequiredValue, ACTUALSKILL.ActualSkill As userSelected "
				+ "from (SELECT SKILL_MASTER.skillName, SKILL_MASTER.ID ,REQ_SKILL.REQ_SKILL "
				+ "from REQ_SKILL,SKILL_MASTER  "
				+ "where SKILL_MASTER.Doid=:doid and  SKILL_MASTER.SCid=:scid and REQ_SKILL.SMid=SKILL_MASTER.ID  "
				+ "and REQ_SKILL.JS=(Select Js from EMPLOYEE where ID=:eid)) as REQUIREDSKILL,  "
				+ "(Select T.skillName,T.ID,EMPLOYEE_SKILL.ActualSkill from EMPLOYEE_SKILL Right join  "
				+ "(Select SKILL_MASTER.skillName,SKILL_MASTER.ID from SKILL_MASTER where SKILL_MASTER.Doid=:doid and SKILL_MASTER.SCid=:scid)" +
				" AS T ON  T.ID=EMPLOYEE_SKILL.SMID and EMPLOYEE_SKILL.Eid=:eid) AS ACTUALSKILL where REQUIREDSKILL.ID=ACTUALSKILL.ID";

		 Query query = getEntityManager().createNativeQuery(nativeQuery,"AN_USER_PLUS_SKILL_DETAILS_CONSTRUCTOR");
		 query.setParameter("doid", doid).setParameter("scid", scid).setParameter("eid", eid);
		 List result = query.getResultList();
		 return result;
	}
	@Override
	public void saveEmployeeskill(EmployeeSkill employeeskill) {
		getEntityManager().persist(employeeskill);

	}
	@Override
	public SkillMaster getRefById(int id) {
		return super.getRefById(id);
	}

	@Override
	public void deleteEmployeeSkill( int eid, List<Integer> smIds){

		String nativeQuery = "DELETE FROM EMPLOYEE_SKILL WHERE Eid=:eid and SMID in (:smIds)";

		Query query = getEntityManager().createNativeQuery(nativeQuery);
		query.setParameter("eid", eid);
		query.setParameter("smIds", smIds);
		int result = query.executeUpdate();

	}
	

}
