package com.ericsson.ipm.v1.dao;

import java.util.List;

import com.ericsson.ipm.v1.domain.SkillCat;

public interface SkillCatDAO {

	public SkillCat save(SkillCat entity);

	public List<SkillCat> findBySkillCatName(Object skillName);
}
