package com.ericsson.ipm.v1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ericsson.ipm.v1.domain.SkillCat;

@Repository("skillCatDAO")
@Transactional
public class SkillCatDAOImpl implements SkillCatDAO {

	@PersistenceContext
	protected EntityManager entityManager;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(SkillCatDAOImpl.class);

	private EntityManager getEntityManager() {
		return entityManager;
	}

	public SkillCat save(SkillCat entity) {
		LOGGER.info("saving SkillCat instance");
		try {
			getEntityManager().persist(entity);
			LOGGER.info("save successful");
		} catch (RuntimeException re) {
			LOGGER.info("save failed" + re);
			throw re;
		}
		return entity;
	}


	@SuppressWarnings("unchecked")
	public List<SkillCat> findByProperty(String propertyName, final Object value) {
		LOGGER.info("finding SkillCat instance with property: "
				+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from SkillCat model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException re) {
			LOGGER.info("find by property name failed"+ re);
			throw re;
		}
	}

	public List<SkillCat> findBySkillCatName(Object skillName) {
		return findByProperty("skillName", skillName);
	}

}
