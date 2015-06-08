package com.ericsson.ipm.v1.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ericsson.ipm.v1.domain.Asset;
import com.ericsson.ipm.v1.domain.DeliveryQuality;
import com.ericsson.ipm.v1.domain.OperationalDiscipline;


@Repository("deliveryQualityDAO")
@Transactional
public class DeliveryQualityDAOImpl extends BaseDAO<Integer, DeliveryQuality> implements DeliveryQualityDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(DeliveryQualityDAOImpl.class);



	private EntityManager getEntityManager() {
		return entityManager;
	}

	public DeliveryQuality save(DeliveryQuality entity) {
		LOGGER.info("saving DeliveryQualityDAOImpl instance");
		try {
			getEntityManager().persist(entity);
			LOGGER.info("save successful");
		} catch (RuntimeException re) {
			LOGGER.info("save failed"+ re);
			throw re;
		}
		return entity;
	}

	public DeliveryQuality saveOrUpdate(DeliveryQuality entity) {
		LOGGER.info("updating DeliveryQualityDAOImpl instance");
		try {
			DeliveryQuality result = getEntityManager().merge(entity);
			LOGGER.info("update successful");
			return result;
		} catch (RuntimeException re) {
			LOGGER.info("update failed"+ re);
			throw re;
		}
	}

	@Override
	public DeliveryQuality getDeliveryQualityDetail(String id) {
		// TODO Auto-generated method stub
		LOGGER.info(
				"finding DeliveryQuality instance with id: "+ id);
		try {
			final String queryString = "select model from DeliveryQuality model where model.id= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", Integer.parseInt(id));
			return (DeliveryQuality) query.getSingleResult();
		} catch (RuntimeException re) {
			LOGGER.info("find by property name failed"+ re);
			throw re;
		}
	}

	@Override
	public void remove(String dqId) {
		Integer Id = Integer.parseInt(dqId);
		DeliveryQuality entity = findById(Id);
		remove(entity);
	}

}
