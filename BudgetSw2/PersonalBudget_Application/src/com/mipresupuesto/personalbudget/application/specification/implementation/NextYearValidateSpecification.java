package com.mipresupuesto.personalbudget.application.specification.implementation;

import java.time.Year;

import org.springframework.stereotype.Component;
import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.crosscutting.Utils.NumberHelper;
import com.mipresupuesto.personalbudget.domain.YearDomain;

@Component
public class NextYearValidateSpecification extends CompositeSpecification<YearDomain> {

	@Override
	public boolean isSatisfiedBy(YearDomain specification) {
		return validId(specification);
	}
	
	public boolean validId(YearDomain year) {
		return NumberHelper.isGreaterThan(year.getYear(), Year.now().getValue());
	}
	
	

}
