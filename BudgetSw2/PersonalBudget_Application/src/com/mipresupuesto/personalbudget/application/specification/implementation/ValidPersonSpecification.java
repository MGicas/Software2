package com.mipresupuesto.personalbudget.application.specification.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.domain.PersonDomain;

@Component
public class ValidPersonSpecification extends CompositeSpecification<PersonDomain> {

	@Autowired
	PersonIdValidSpecification personIdValid;
	@Autowired
	PersonNotDefaultSpecification personNotDefault;
	@Autowired
	PersonMandatoryValuesNotNullSpecification personValuesNotNull;
	@Autowired
	ExistPersonSpecification personExist;
	@Override
	public boolean isSatisfiedBy(PersonDomain object) {
		//return personNotDefault.and(personIdValid).and(personExist).and(personValuesNotNull);
		if(personNotDefault.isSatisfiedBy(object)&& personIdValid.isSatisfiedBy(object)&&personValuesNotNull.isSatisfiedBy(object)&&personExist.isSatisfiedBy(object)) {
			return true;
		}
		return false;
	}

}
