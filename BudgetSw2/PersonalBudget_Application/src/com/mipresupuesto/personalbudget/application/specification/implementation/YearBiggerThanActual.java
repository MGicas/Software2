package com.mipresupuesto.personalbudget.application.specification.implementation;

import java.time.Year;

import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.crosscutting.Utils.NumberHelper;
import com.mipresupuesto.personalbudget.crosscutting.exception.data.ApplicationCustomException;
import com.mipresupuesto.personalbudget.crosscutting.exception.messages.Messages;
import com.mipresupuesto.personalbudget.domain.YearDomain;

@Component
public class YearBiggerThanActual extends CompositeSpecification<YearDomain> {

	@Override
	public boolean isSatisfiedBy(YearDomain specification) {
		// TODO Auto-generated method stub
		return false;
	}
	private boolean  YearBigger(YearDomain year) {
		if (year.getYear()==0) {
			throw ApplicationCustomException.CreateTechnicalException(Messages.YearBiggerThanActual.TECHNICAL_PROBLEM_WITH_PROVIDED_NUMBER);
		}
		if(NumberHelper.isGreaterThan(year.getYear(), Year.now().getValue())) {;
		return true;}
		else {
			throw ApplicationCustomException.CreateTechnicalException(Messages.YearBiggerThanActual.TECHNICAL_PROBLEM_PRIVIDED_NUMBER);
		}
	}

}
