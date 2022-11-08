package com.mipresupuesto.personalbudget.application.specification.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.domain.YearDomain;

@Component
public class ValidYearSpecification extends CompositeSpecification<YearDomain> {

	@Autowired
	YearNotDefaultSpecification yearNotDefault;
	@Autowired
	YearIdValidSpecification yearIdValid;
	@Autowired
	ExistYearSpecification existYear;
	@Autowired
	NextYearValidateSpecification nextYearValidate;

	@Override
	public boolean isSatisfiedBy(YearDomain specification) {
		if (yearNotDefault.isSatisfiedBy(specification) && yearIdValid.isSatisfiedBy(specification)
				&& nextYearValidate.isSatisfiedBy(specification) && existYear.isSatisfiedBy(specification)) {
			return true;
		}
		return false;
	}

}
