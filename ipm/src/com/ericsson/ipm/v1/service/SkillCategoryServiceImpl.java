package com.ericsson.ipm.v1.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericsson.ipm.v1.dao.EmployeeDAO;
import com.ericsson.ipm.v1.dao.SkillCategoryDAO;
import com.ericsson.ipm.v1.domain.Employee;
import com.ericsson.ipm.v1.domain.EmployeeSkill;
import com.ericsson.ipm.v1.domain.SkillMaster;
import com.ericsson.ipm.v1.dto.CADTO;
import com.ericsson.ipm.v1.dto.NameIdDTO;
import com.ericsson.v1.util.Constants;


@Service("skillCategoryService")
@Transactional
public class SkillCategoryServiceImpl implements SkillCategoryService {

	private SkillCategoryDAO skillCategoryDAO;

	private EmployeeDAO employeeDAO;

	@Override
	public List<CADTO> getEmployeeCASkill(int doid, int scid, int eid) {
		List<CADTO> list =  new ArrayList<CADTO>();
		String caOptions = Constants.CA_OPTIONS;
		String[] caOptionsArray = caOptions.split(",");

		List result = skillCategoryDAO.getEmployeeCASkill(doid, scid, eid);
		Iterator iter = result.iterator();
		while (iter.hasNext())
		{
			CADTO cadto = (CADTO)iter.next();
			for(int i = 0; i<caOptionsArray.length; i++){
				NameIdDTO nameIdDTO = new NameIdDTO();
				nameIdDTO.setId(caOptionsArray[i]);
				//nameIdDTO.setId(caOptionsArray[i]+"-"+cadto.getSkillMasterId());
				nameIdDTO.setName(caOptionsArray[i]);
				cadto.getOptions().add(nameIdDTO);
				if(caOptionsArray[i].equalsIgnoreCase(cadto.getUserSelected())){
					cadto.setUserSelected(cadto.getUserSelected());
				}

			}
			list.add(cadto);
		}

		return list;
	}
	
	public void saveEmployeeskills(List<EmployeeSkill> employeeskills){
		
		for (EmployeeSkill employeeSkill : employeeskills) {
			saveEmployeeskill(employeeSkill);
		}
	}

	public void deleteEmployeeSkill( int eid, List<Integer> smIds){
		skillCategoryDAO.deleteEmployeeSkill(eid, smIds);
	}

	@Override
	public SkillMaster getRefById(int id) {
		return skillCategoryDAO.getRefById(id);
	}

	@Autowired
	public void setSkillCategoryDAO(SkillCategoryDAO skillCategoryDAO) {
		this.skillCategoryDAO = skillCategoryDAO;
	}

	@Autowired
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public void saveEmployeeskill(EmployeeSkill employeeskill) {
		skillCategoryDAO.saveEmployeeskill(employeeskill);
	}

	@Override
	public Employee getRefByEmployeeId(int id) {
		return employeeDAO.getRefById(id);
	}



}
