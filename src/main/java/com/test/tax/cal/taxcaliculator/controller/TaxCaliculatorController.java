package com.test.tax.cal.taxcaliculator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.tax.cal.taxcaliculator.domain.Employee;
import com.test.tax.cal.taxcaliculator.domain.EmployeeVo;
import com.test.tax.cal.taxcaliculator.service.TaxService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping("api/taxcal/")
public class TaxCaliculatorController {

	@Autowired
	TaxService taxServ;

	@PostMapping(value="taxpayers")
	public ResponseEntity<String> perssiteEmp(@Valid @RequestBody Employee emp) {
		int empId = taxServ.addEmployee(emp);
		return ResponseEntity.ok("Employee Created with ID :" + empId);
	}
	
	
	@GetMapping("taxpayers/{financialYear}")
	public ResponseEntity<List<EmployeeVo>> empData(@PathVariable("financialYear") @Pattern(regexp="\\d{4}") String financialYear) {
		List<EmployeeVo> employeeVoList = taxServ.getEmpData(financialYear);
		return ResponseEntity.ok(employeeVoList);
	}


}
