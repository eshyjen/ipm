package com.ericsson.ipm.v1.dao;

import java.util.List;

import com.ericsson.ipm.v1.domain.Domain;

public interface DomainDAO {
	
	public Domain save(Domain entity);
	
	public List<Domain> findByDomainName(Object d_name);

}
