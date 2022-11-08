package com.mipresupuesto.personalbudget.application.specification.implementation;

import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.crosscutting.exception.data.ApplicationCustomException;
import com.mipresupuesto.personalbudget.crosscutting.exception.messages.Messages;
import com.mipresupuesto.personalbudget.domain.PersonDomain;

@Component
public class PersonMandatoryValuesNotNullSpecification extends CompositeSpecification<PersonDomain> {

	@Override
	public boolean isSatisfiedBy(PersonDomain object) {
		return mandatoryValuesNotNullSpecification(object);
	}
	
	private boolean mandatoryValuesNotNullSpecification (PersonDomain person) {
		if(person.getFirstname() == null || "".equals(person.getFirstname())) {
			throw ApplicationCustomException.CreateTechnicalException(Messages.mandatoryValues.TECHNICAL_PROBLEM_WITH_MANDATORY_VALUES_FIRST_NAME);
		}
		if(person.getMiddlename()==null) {
			throw ApplicationCustomException.CreateTechnicalException(Messages.mandatoryValues.TECHNICAL_PROBLEM_WITH_MANDATORY_VALUES_MIDDLE_NAME);
		}
		if(person.getIdCard()==null || "".equals(person.getIdCard())) {
			throw ApplicationCustomException.CreateTechnicalException(Messages.mandatoryValues.TECHNICAL_PROBLEM_WITH_MANDATORY_VALUES_ID_CARD);
		}
		if(person.getLastname()==null || "".equals(person.getLastname())) {
			throw ApplicationCustomException.CreateTechnicalException(Messages.mandatoryValues.TECHNICAL_PROBLEM_WITH_MANDATORY_VALUES_LAST_NAME);
		}
		return true;
	}

}
