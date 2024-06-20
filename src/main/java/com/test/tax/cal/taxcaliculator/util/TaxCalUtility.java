package com.test.tax.cal.taxcaliculator.util;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class TaxCalUtility {

	private static final Logger logger = LogManager.getLogger(TaxCalUtility.class);

	/**
	 * 
	 * @param income
	 * @return
	 */
	public Double cessApplied(double income) {
		double cess = 0.0;

		if (income > 2500000) {
			cess = income * 0.02;
		}
		return cess;
	}

	/**
	 * 
	 * @param income
	 * @param doj
	 * @param finacialYear
	 * @return
	 */
	public double taxApplicable(double sal, Date doj, String finacialYear) {
		double income = totalIncomeCheck(doj, sal, finacialYear);
		double tax = 0.0;
		if (income <= 250000) {
			tax = 0.0;
		} else if (income > 250000 && income <= 500000) {
			tax = (income - 250000) * 0.05;
		} else if (income > 500000 && income <= 100000) {
			tax = 12500 + (income - 500000) * 0.1;
		} else if (income > 1000000) {
			tax = (income - 1000000) * 0.2 + 62500;
		}
		return tax;
	}

	/***
	 * 
	 * @param doj
	 * @param income
	 * @param finacialYear
	 * @return
	 */
	private double totalIncomeCheck(Date dateOfJoining, double salary, String financialYear) {
		LocalDate doj = dateOfJoining.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int month = doj.getMonthValue();
		int year = doj.getYear();
		int day = doj.getDayOfMonth();
		LocalDate currentDate = LocalDate.now();
		double totalSalary;

		if (day > 15 && month == 5 && year == currentDate.getYear() && month == currentDate.getMonthValue()) {
			long daysWorked = doj.until(currentDate, ChronoUnit.DAYS) + 1; // +1 to include the current day
			double dailySalary = salary / doj.lengthOfMonth();
			totalSalary = dailySalary * daysWorked;
		} else {
			totalSalary = salary * 12;
		}

		// Logging information
		logger.info("Month: {}", month);
		logger.info("Year: {}", year);

		return totalSalary;
	}

}
