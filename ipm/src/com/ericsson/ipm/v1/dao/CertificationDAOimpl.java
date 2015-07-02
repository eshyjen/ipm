package com.ericsson.ipm.v1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ericsson.ipm.v1.domain.Certification;

@Repository("certificationDAO")
@Transactional
public class CertificationDAOimpl extends BaseDAO<Integer, Certification>implements CertificationDAO {

	// property constants
	public static final String EMPLOYEETYPE = "employeeType";
    public static final String TRAININGNAME = "trainingName";
    public static final String DATEWEEKPLANNED = "dateWeekPlanned";
    public static final String DATEATTENDED = "dateAttended";
    public static final String COMPLETIONSTATUS = "completionStatus";
    public static final String TNI= "tni";

    private EntityManager getEntityManager() {
    	return entityManager;
	}
    private static final Logger LOGGER = LoggerFactory.getLogger(CertificationDAOimpl.class);


	@Override
	public Certification save(Certification entity) {
		// TODO Auto-generated method stub
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

	@Override
	public Certification saveOrUpdate(Certification entity) {
		// TODO Auto-generated method stub
		 LOGGER.info("updating MandatoryCertification instance");
         try {
             Certification result = getEntityManager().merge(entity);
             LOGGER.info("update successful");
             return result;
         } catch (RuntimeException re) {
             LOGGER.info("update failed"+ re);
             throw re;
         }
	}
	@Override
	public List<Certification> findByEmployeeType(Object employeeType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Certification> findByTrainingName(Object trainingName) {
		// TODO Auto-generated method stub
		return findByProperty(TRAININGNAME, trainingName);
	}

	@Override
	public List<Certification> findByDateWeekPlanned(Object dateWeekPlanned) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Certification> findByDateAttended(Object dateAttended) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Certification> findByCompletionStatus(Object completionStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Certification> findByTni(Object tni) {
		// TODO Auto-generated method stub
		return null;
	}






    @SuppressWarnings("unchecked")
    public List<Certification> findByProperty(String propertyName,
            final Object value) {
        LOGGER.info(
                "finding Certification instance with property: "
                        + propertyName + ", value: " + value);
        try {
            final String queryString = "select model from Certification model where model."
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
    public List<Certification> findAll() {
        LOGGER.info("finding all Certification instances");
        try {
            final String queryString = "select model from Certification model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            LOGGER.info("find all failed"+ re);
            throw re;
        }
    }

    @Override
    public Certification getCertificationDetail(String id) {
        // TODO Auto-generated method stub
        LOGGER.info(
                "finding MandatoryCertification instance with id: "+ id);
        try {
            final String queryString = "select model from Certification model where model.id= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", Integer.parseInt(id));
            return (Certification) query.getSingleResult();
        } catch (RuntimeException re) {
            LOGGER.info("find by property name failed"+ re);
            throw re;
        }
    }

    @Override
    public void remove(String mcId) {
        Integer certification_Id = Integer.parseInt(mcId);
        Certification entity = findById(certification_Id);
        remove(entity);
    }





}

