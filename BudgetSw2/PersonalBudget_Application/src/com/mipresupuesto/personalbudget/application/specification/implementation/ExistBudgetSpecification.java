package com.mipresupuesto.personalbudget.application.specification.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mipresupuesto.personalbudget.application.specification.CompositeSpecification;
import com.mipresupuesto.personalbudget.domain.BudgetDomain;
import com.mipresupuesto.personalbudget.entity.BudgetEntity;
import com.mipresupuesto.personalbudget.infrastructure.data.interfaces.BudgetRepository;

@Service
public class ExistBudgetSpecification extends CompositeSpecification<BudgetDomain>{

	@Autowired
	BudgetRepository budgetRepository;
	@Override
	public boolean isSatisfiedBy(BudgetDomain budgetDomain) {
		try {
			Optional<BudgetEntity> response = budgetRepository.findById(budgetDomain.getId());
			if(response.isEmpty()) {
				return false;
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
