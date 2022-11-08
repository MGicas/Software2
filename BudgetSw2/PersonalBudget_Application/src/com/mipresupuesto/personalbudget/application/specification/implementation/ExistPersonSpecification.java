package com.mipresupuesto.personalbudget.application.specification.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.crosscutting.exception.data.ApplicationCustomException;
import com.mipresupuesto.personalbudget.crosscutting.exception.messages.Messages;
import com.mipresupuesto.personalbudget.domain.PersonDomain;
import com.mipresupuesto.personalbudget.entity.PersonEntity;
import com.mipresupuesto.personalbudget.infrastructure.data.interfaces.PersonRepository;

@Service
public class ExistPersonSpecification extends CompositeSpecification<PersonDomain> {

	@Autowired
	PersonRepository personRepository;
	@Override
	public boolean isSatisfiedBy(PersonDomain personDomain) {
		try {
			Optional<PersonEntity> response = personRepository.findById(personDomain.getId());
			if(response.isEmpty()) {
				throw ApplicationCustomException.CreateTechnicalException(Messages.exist.TECHNICAL_PROBLEM_WITH_PERSON);
			}
			return true;
		} catch (Exception exception) {
			throw ApplicationCustomException.CreateTechnicalException(Messages.exist.TECHNICAL_PROBLEM_WITH_PERSON_INFO, exception);
		}
	}

}
