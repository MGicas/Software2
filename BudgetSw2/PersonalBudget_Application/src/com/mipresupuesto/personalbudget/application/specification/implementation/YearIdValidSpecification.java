package com.mipresupuesto.personalbudget.application.specification.implementation;

import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.domain.YearDomain;

@Component
public class YearIdValidSpecification extends CompositeSpecification<YearDomain> {

	@Override
	public boolean isSatisfiedBy(YearDomain specification) {
		return isValidId(specification);
	}
	
	private boolean isValidId(YearDomain budget) {
		if(budget.getId().getClass().getSimpleName()== "UUID") {
			//throw exception
			return true;
		}return false;
	}
}
