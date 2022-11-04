package com.mipresupuesto.personalbudget.application.usecase.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mipresupuesto.personalbudget.application.entityassembler.EntityAssembler;
import com.mipresupuesto.personalbudget.application.usecase.interfaces.CreateBudgetUseCase;
import com.mipresupuesto.personalbudget.domain.BudgetDomain;
import com.mipresupuesto.personalbudget.infrastructure.data.interfaces.BudgetRepository;

import entity.BudgetEntity;

@Service
@Transactional
public class CreateBudgetUseCaseImpl implements CreateBudgetUseCase {

	@Autowired
	private EntityAssembler<BudgetEntity, BudgetDomain> entityAssembler;
	@Autowired
	private BudgetRepository budgetRepository;

	@Override
	public void execute(final BudgetDomain budget) {
		budgetRepository.save(entityAssembler.asembleEntity(budget));

	}

}
