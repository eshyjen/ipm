package com.ericsson.ipm.v1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ericsson.ipm.v1.domain.Domain;

@Repository("domainDAO")
@Transactional
public class DomainDAOImpl implements DomainDAO {


	@PersistenceContext
	protected EntityManager entityManager;

	private static final Logger LOGGER = LoggerFactory.getLogger(DomainDAOImpl.class);

	private EntityManager getEntityManager() {
		return entityManager;
	}

	public Domain save(Domain entity) {
		LOGGER.info("saving Asset instance");
		try {
			getEntityManager().persist(entity);
			LOGGER.info("save successful");
		} catch (RuntimeException re) {
			LOGGER.info("save failed"+ re);
			throw re;
		}
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<Domain> findByProperty(String propertyName, final Object value) {
		LOGGER.info("finding Domain instance with property: "
				+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from Domain model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException re) {
			LOGGER.info("find by property name failed"+ re);
			throw re;
		}
	}

	public List<Domain> findByDomainName(Object d_name) {
		return findByProperty("domainName", d_name);
	}


}
