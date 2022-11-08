package com.mipresupuesto.personalbudget.application.specification.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.crosscutting.exception.data.ApplicationCustomException;
import com.mipresupuesto.personalbudget.crosscutting.exception.messages.Messages;
import com.mipresupuesto.personalbudget.domain.BudgetDomain;
import com.mipresupuesto.personalbudget.entity.BudgetEntity;
import com.mipresupuesto.personalbudget.infrastructure.data.interfaces.BudgetRepository;

@Service
public class BudgetNotSameYearSpecification extends CompositeSpecification<BudgetDomain> {

	@Autowired
	BudgetRepository budgetRepository;

	@Override
	public boolean isSatisfiedBy(BudgetDomain specification) {
		return budgetNotSameYear(specification);
	}
	
	public boolean budgetNotSameYear(BudgetDomain budgetDomain) {
		try {
			Optional<BudgetEntity> response = budgetRepository.getByYearandPerson(budgetDomain.getYear().getId(),
					budgetDomain.getPerson().getId());
			if(response.isEmpty()) {
				return true;
			}
			return false;
		} catch (Exception exception) {
			throw ApplicationCustomException.CreateTechnicalException(Messages.exist.TECHNICAL_PROBLEM_WITH_BUDGET_EXIST, exception);
		}
	}

}
