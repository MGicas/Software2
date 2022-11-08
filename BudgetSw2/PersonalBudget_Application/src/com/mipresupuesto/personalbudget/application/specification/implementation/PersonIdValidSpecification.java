package com.mipresupuesto.personalbudget.application.specification.implementation;

import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.crosscutting.Utils.ObjectHelper;
import com.mipresupuesto.personalbudget.crosscutting.exception.data.ApplicationCustomException;
import com.mipresupuesto.personalbudget.crosscutting.exception.messages.Messages;
import com.mipresupuesto.personalbudget.domain.PersonDomain;

@Component
public class PersonIdValidSpecification extends CompositeSpecification<PersonDomain>{

	@Override
	public boolean isSatisfiedBy(PersonDomain specification) {
		return isValidId(specification);
	}
	
	private boolean isValidId(PersonDomain person) {
		if (ObjectHelper.isNull(person.getId())) {
			throw ApplicationCustomException
					.CreateTechnicalException(Messages.IdValidSpecification.TECHNICAL_PROBLEM_WITH_PERSON_ID);
		}if(person.getId().toString().length() == 36) {
			return true;
		}
		
		return false;
	}

}
