package com.mipresupuesto.personalbudget.application.specification.implementation;


import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.crosscutting.Utils.ObjectHelper;
import com.mipresupuesto.personalbudget.crosscutting.Utils.UtilUUID;
import com.mipresupuesto.personalbudget.crosscutting.exception.data.ApplicationCustomException;
import com.mipresupuesto.personalbudget.crosscutting.exception.messages.Messages;
import com.mipresupuesto.personalbudget.domain.BudgetDomain;

@Component
public class ValidBudgetSpecification extends CompositeSpecification<BudgetDomain> {

	@Autowired
	BudgetIdValidSpecification budgetIdValidSpecification;
	@Autowired
	ValidYearSpecification validYearSpecification;
	@Autowired
	ValidPersonSpecification validPersonSpecification;
	@Autowired
	BudgetNotSameYearSpecification budgetNotSameYearSpecification;

	@Override
	public boolean isSatisfiedBy(BudgetDomain specification) {
		try {
			return notNullnotInfo(specification) && budgetIdValidSpecification.isSatisfiedBy(specification)
					&& validYearSpecification.isSatisfiedBy(specification.getYear())
					&& validPersonSpecification.isSatisfiedBy(specification.getPerson())
					&& budgetNotSameYearSpecification.isSatisfiedBy(specification);
		} catch (ApplicationCustomException exception) {
			throw exception;
		}
	}

	private boolean notNullnotInfo(BudgetDomain budget) {

		boolean personDefault;

		try {
			new PersonNotDefaultSpecification().isSatisfiedBy(budget.getPerson());
			personDefault = false;
		} catch (ApplicationCustomException exception) {
			personDefault = true;
		}
		boolean yearDefault;
		try {
			new YearNotDefaultSpecification().isSatisfiedBy(budget.getYear());
			yearDefault = false;
		} catch (ApplicationCustomException exception) {
			yearDefault = true;
		}
		boolean idDefault = Objects.equals(budget.getId().toString(), UtilUUID.DEFAULT_UUID_STRING);
		if(ObjectHelper.isNull(budget)||(personDefault && yearDefault && idDefault)) {
			throw ApplicationCustomException.CreateTechnicalException(Messages.exist.TECHNICAL_PROBLEM_WITH_BUDGET_INFO);
		}
		
		return true;
	}

}
