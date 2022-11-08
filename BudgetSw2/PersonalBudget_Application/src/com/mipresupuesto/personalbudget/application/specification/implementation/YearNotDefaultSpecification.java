package com.mipresupuesto.personalbudget.application.specification.implementation;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.crosscutting.Utils.UtilUUID;
import com.mipresupuesto.personalbudget.crosscutting.exception.data.ApplicationCustomException;
import com.mipresupuesto.personalbudget.crosscutting.exception.messages.Messages;
import com.mipresupuesto.personalbudget.domain.YearDomain;

@Component
public class YearNotDefaultSpecification extends CompositeSpecification<YearDomain>{

	@Override
	public boolean isSatisfiedBy(YearDomain specification) {
		return notDefault(specification);
	}
	
	private boolean notDefault(YearDomain year) {
		if(Objects.equals(year.getId().toString(), UtilUUID.DEFAULT_UUID_STRING)&&"".equals(year.getId())&&"".equals(year.getYear())){
			throw ApplicationCustomException.CreateTechnicalException(Messages.notDefault.TECHNICAL_PROBLEM_WITH_INFO_YEAR);
		}else return true;
	}

}
