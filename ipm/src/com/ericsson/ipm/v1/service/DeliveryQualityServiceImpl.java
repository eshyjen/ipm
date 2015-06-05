package com.ericsson.ipm.v1.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ericsson.ipm.v1.dao.DeliveryQualityDAO;
import com.ericsson.ipm.v1.domain.DeliveryQuality;
import com.ericsson.ipm.v1.domain.OperationalDiscipline;
import com.ericsson.ipm.v1.dto.OperationalDisciplineDTO;

@Service("deliveryQualityService")
@Transactional
public class DeliveryQualityServiceImpl implements DeliveryQualityService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DeliveryQualityServiceImpl.class);

	private DeliveryQualityDAO deliveryQualityDAO;
	
	@Override
	public DeliveryQuality save(DeliveryQuality entity) {
		return deliveryQualityDAO.save(entity);
	}

	@Override
	public void remove(DeliveryQuality entity) {
		
	}

	@Override
	public DeliveryQuality update(DeliveryQuality entity) {
		return deliveryQualityDAO.update(entity);
	}

	@Override
	public DeliveryQuality findById(Integer id) {
		return deliveryQualityDAO.findById(id);
	}

	public DeliveryQualityDAO getDeliveryQualityDAO() {
		return deliveryQualityDAO;
	}

	@Override
	public DeliveryQuality saveOrUpdate(DeliveryQuality deliveryQuality) {
		// TODO Auto-generated method stub
		return deliveryQualityDAO.saveOrUpdate(deliveryQuality);

	}
	
	@Override
	public DeliveryQuality getDeliveryQualityDetail(String id) {
		// TODO Auto-generated method stub
		return deliveryQualityDAO.getDeliveryQualityDetail(id);
	}

	@Autowired
	public void setDeliveryQualityDAO(DeliveryQualityDAO deliveryQualityDAO) {
		this.deliveryQualityDAO = deliveryQualityDAO;
	}

	
	
}
