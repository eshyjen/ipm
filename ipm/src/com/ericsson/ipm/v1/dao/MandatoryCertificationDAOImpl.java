package com.ericsson.ipm.v1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ericsson.ipm.v1.domain.Asset;
import com.ericsson.ipm.v1.domain.MandatoryCertification;
import com.ericsson.ipm.v1.domain.OperationalDiscipline;

@Repository("mandatoryCertificationDAO")
@Transactional
public class MandatoryCertificationDAOImpl extends BaseDAO<Integer, MandatoryCertification>  implements MandatoryCertificationDAO {


    // property constants
        public static final String TRAININGNAME = "trainingName";
        public static final String DATEWEEKPLANNED = "dateWeekPlanned";
        public static final String DATEATTENDED = "dateAttended";
        public static final String COMPLETIONSTATUS = "completionStatus";
        public static final String ATTACHFILE= "attachFile";

        private EntityManager getEntityManager() {
            return entityManager;
        }


        private static final Logger LOGGER = LoggerFactory.getLogger(MandatoryCertificationDAOImpl.class);


        public MandatoryCertification save(MandatoryCertification entity) {
            LOGGER.info("saving MandatoryCertification instance");
            try {
                getEntityManager().persist(entity);
                LOGGER.info("save successful");
            } catch (RuntimeException re) {
                LOGGER.info("save failed"+ re);
                throw re;
            }
            return entity;
        }

        public MandatoryCertification saveOrUpdate(MandatoryCertification entity) {
            LOGGER.info("updating MandatoryCertification instance");
            try {
                MandatoryCertification result = getEntityManager().merge(entity);
                LOGGER.info("update successful");
                return result;
            } catch (RuntimeException re) {
                LOGGER.info("update failed"+ re);
                throw re;
            }
        }


    public List<MandatoryCertification> findByTrainingName(Object trainingName) {
        return findByProperty(TRAININGNAME, trainingName);
    }


    public List<MandatoryCertification> findByDateWeekPlanned(
            Object dateWeekPlanned) {
        return findByProperty(DATEWEEKPLANNED, dateWeekPlanned);
    }

    public List<MandatoryCertification> findByDateAttended(
            Object dateAttended){
        return findByProperty(DATEATTENDED, dateAttended);
    }


    public List<MandatoryCertification> findByCompletionStatus(
            Object completionStatus) {
        return findByProperty(COMPLETIONSTATUS, completionStatus);
    }


    @SuppressWarnings("unchecked")
    public List<MandatoryCertification> findByProperty(String propertyName,
            final Object value) {
        LOGGER.info(
                "finding MandatoryCertification instance with property: "
                        + propertyName + ", value: " + value);
        try {
            final String queryString = "select model from MandatoryCertification model where model."
                    + propertyName + "= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            LOGGER.info("find by property name failed"+ re);
            throw re;
        }
    }

    @SuppressWarnings("unchecked")
    public List<MandatoryCertification> findAll() {
        LOGGER.info("finding all MandatoryCertification instances");
        try {
            final String queryString = "select model from MandatoryCertification model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            LOGGER.info("find all failed"+ re);
            throw re;
        }
    }

    @Override
    public MandatoryCertification getMandatoryCertificationDetail(String id) {
        // TODO Auto-generated method stub
        LOGGER.info(
                "finding MandatoryCertification instance with id: "+ id);
        try {
            final String queryString = "select model from MandatoryCertification model where model.id= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", Integer.parseInt(id));
            return (MandatoryCertification) query.getSingleResult();
        } catch (RuntimeException re) {
            LOGGER.info("find by property name failed"+ re);
            throw re;
        }
    }

    /*@Override
    public void remove(String opdId) {
        MandatoryCertification entity = findById(Integer.parseInt(opdId));
        remove(entity);
    }*/
    @Override
    public void remove(String mcId) {
        Integer mandatoryCertification_Id = Integer.parseInt(mcId);
        MandatoryCertification entity = findById(mandatoryCertification_Id);
        remove(entity);
    }

	@Override
	public List<MandatoryCertification> findByAttachFile(Object attachFile) {
		// TODO Auto-generated method stub
		return findByProperty(ATTACHFILE, attachFile);
	}


}
