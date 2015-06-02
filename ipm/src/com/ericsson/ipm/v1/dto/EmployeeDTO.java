package com.ericsson.ipm.v1.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String signum;
	private String name;
	public String getSignum() {
		return signum;
	}
	public void setSignum(String signum) {
		this.signum = signum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
