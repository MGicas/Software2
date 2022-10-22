package com.mipresupuesto.personalbudget.application.command.implementation;

import com.mipresupuesto.personalbudget.application.command.interfaces.CreateBudgetPort;
import com.mipresupuesto.personalbudget.application.dtoassembler.DTOAssembler;
import com.mipresupuesto.personalbudget.application.usecase.interfaces.CreateBudgetUseCase;
import com.mipresupuesto.personalbudget.domain.BudgetDomain;
import com.mipresupuesto.personalbudget.dto.BudgetDTO;

public class CreateBudgetCommand implements CreateBudgetPort {

	private DTOAssembler<BudgetDTO, BudgetDomain> dtoAssembler;

	private CreateBudgetUseCase useCase;

	@Override
	public void execute(BudgetDTO budget) {
		useCase.execute(dtoAssembler.asembleDomain(budget));
		
	}


}
