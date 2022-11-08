package com.mipresupuesto.personalbudget.application.specification.implementation;

import java.util.Objects;
import org.springframework.stereotype.Component;
import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.crosscutting.Utils.UtilUUID;
import com.mipresupuesto.personalbudget.crosscutting.exception.data.ApplicationCustomException;
import com.mipresupuesto.personalbudget.crosscutting.exception.messages.Messages;
import com.mipresupuesto.personalbudget.domain.PersonDomain;

@Component
public class PersonNotDefaultSpecification extends CompositeSpecification<PersonDomain>{

	@Override
	public boolean isSatisfiedBy(PersonDomain object) {
		try {
			return notDefault(object);
		} catch (ApplicationCustomException exception) {
			throw exception;
		}
	}
	
	private boolean notDefault(PersonDomain person) {
		if(Objects.equals(person.getId().toString(), UtilUUID.DEFAULT_UUID_STRING)&&"".equals(person.getFirstname())&&"".equals(person.getLastname())) {
			throw ApplicationCustomException.CreateTechnicalException(Messages.notDefault.TECHNICAL_PROBLEM_WITH_INFO_PERSON);
		}else return true;
	}

}
