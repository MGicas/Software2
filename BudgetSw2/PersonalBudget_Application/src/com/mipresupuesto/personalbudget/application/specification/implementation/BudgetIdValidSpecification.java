package com.mipresupuesto.personalbudget.application.specification.implementation;

import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.crosscutting.Utils.ObjectHelper;
import com.mipresupuesto.personalbudget.crosscutting.exception.data.ApplicationCustomException;
import com.mipresupuesto.personalbudget.crosscutting.exception.messages.Messages;
import com.mipresupuesto.personalbudget.domain.BudgetDomain;

@Component
public class BudgetIdValidSpecification extends CompositeSpecification<BudgetDomain> {

	@Override
	public boolean isSatisfiedBy(BudgetDomain object) {
		return isValidId(object);
	}

	private boolean isValidId(BudgetDomain budget) {
		if (ObjectHelper.isNull(budget.getId())) {
			throw ApplicationCustomException
					.CreateTechnicalException(Messages.IdValidSpecification.TECHNICAL_PROBLEM_WITH_BUDGET_ID);
		}
		return true;
	}

}
