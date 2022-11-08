package com.mipresupuesto.personalbudget.application.usecase.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mipresupuesto.personalbudget.application.entityassembler.EntityAssembler;
import com.mipresupuesto.personalbudget.application.specification.implementation.ValidBudgetSpecification;
import com.mipresupuesto.personalbudget.application.usecase.interfaces.CreateBudgetUseCase;
import com.mipresupuesto.personalbudget.crosscutting.exc.BudgetCustomException;
import com.mipresupuesto.personalbudget.crosscutting.exception.data.ApplicationCustomException;
import com.mipresupuesto.personalbudget.crosscutting.exception.messages.Messages;
import com.mipresupuesto.personalbudget.domain.BudgetDomain;
import com.mipresupuesto.personalbudget.entity.BudgetEntity;
import com.mipresupuesto.personalbudget.infrastructure.data.interfaces.BudgetRepository;

@Service
@Transactional
public class CreateBudgetUseCaseImpl implements CreateBudgetUseCase {

	@Autowired
	private EntityAssembler<BudgetEntity, BudgetDomain> entityAssembler;
	@Autowired
	private BudgetRepository budgetRepository;
	@Autowired
	ValidBudgetSpecification validBudgetSpecification;
	@Override
	public void execute(final BudgetDomain budget) {
		
		try {
			BudgetEntity budgetEntity = entityAssembler.asembleEntity(budget);
			validBudgetSpecification.isSatisfiedBy(budget);
			budgetRepository.save(budgetEntity);
		} catch (BudgetCustomException exception) {
			throw exception;
		}catch(Exception exception) {
			throw ApplicationCustomException.CreateTechnicalException(Messages.CreateBudgetUseCaseImpl.TECHNICAL_PROBLEM_CREATE_BUDGET, exception);
		}

	}

}
