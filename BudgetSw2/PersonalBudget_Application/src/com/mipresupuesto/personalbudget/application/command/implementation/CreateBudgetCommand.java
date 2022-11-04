package com.mipresupuesto.personalbudget.application.command.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mipresupuesto.personalbudget.application.command.interfaces.CreateBudgetPort;
import com.mipresupuesto.personalbudget.application.dtoassembler.DTOAssembler;
import com.mipresupuesto.personalbudget.application.usecase.interfaces.CreateBudgetUseCase;
import com.mipresupuesto.personalbudget.domain.BudgetDomain;
import com.mipresupuesto.personalbudget.dto.BudgetDTO;

@Service
public class CreateBudgetCommand implements CreateBudgetPort {
	@Autowired
	private DTOAssembler<BudgetDTO, BudgetDomain> dtoAssembler;
	@Autowired
	private CreateBudgetUseCase useCase;

	@Override
	public void execute(BudgetDTO budget) {
		useCase.execute(dtoAssembler.asembleDomain(budget));
	}


}
