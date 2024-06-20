package com.test.tax.cal.taxcaliculator.service;

import java.util.List;

import com.test.tax.cal.taxcaliculator.domain.Employee;
import com.test.tax.cal.taxcaliculator.domain.EmployeeVo;

public interface TaxService {

	public int addEmployee(Employee emp);

	public List<EmployeeVo> getEmpData(String financialYear);

}
