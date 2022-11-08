package com.mipresupuesto.personalbudget.application.specification.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.crosscutting.exception.data.ApplicationCustomException;
import com.mipresupuesto.personalbudget.crosscutting.exception.messages.Messages;
import com.mipresupuesto.personalbudget.domain.YearDomain;
import com.mipresupuesto.personalbudget.entity.YearEntity;
import com.mipresupuesto.personalbudget.infrastructure.data.interfaces.YearRepository;

@Service
public class ExistYearSpecification extends CompositeSpecification<YearDomain>{
	@Autowired
	YearRepository yearRepository;
	
	@Override
	public boolean isSatisfiedBy(YearDomain specification) {
		return existYear(specification);
	}
	
	public boolean existYear(YearDomain yearDomain){
		try {
			Optional<YearEntity> response = yearRepository.findYearBy(yearDomain.getId().toString());
			if(response.isEmpty()) {
				throw ApplicationCustomException.CreateTechnicalException(Messages.exist.TECHNICAL_PROBLEM_WITH_YEAR);
			}
			return true;
		} catch (Exception exception) {
			throw ApplicationCustomException.CreateTechnicalException(Messages.exist.TECHNICAL_PROBLEM_WITH_YEAR_INFO, exception);
		}
	}
	

}
