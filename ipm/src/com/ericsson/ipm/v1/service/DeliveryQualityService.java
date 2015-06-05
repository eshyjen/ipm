package com.ericsson.ipm.v1.service;

import com.ericsson.ipm.v1.domain.DeliveryQuality;
import com.ericsson.ipm.v1.domain.OperationalDiscipline;

public interface DeliveryQualityService {

	
	public DeliveryQuality save(DeliveryQuality entity);
	
	public void remove(DeliveryQuality entity);

	public DeliveryQuality update(DeliveryQuality entity);

	public DeliveryQuality saveOrUpdate(DeliveryQuality entity);

	public DeliveryQuality findById(Integer id);
	
	public DeliveryQuality getDeliveryQualityDetail(String id);
}
