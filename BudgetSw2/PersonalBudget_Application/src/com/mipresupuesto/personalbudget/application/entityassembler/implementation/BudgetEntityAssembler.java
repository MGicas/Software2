package com.mipresupuesto.personalbudget.application.entityassembler.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.entityassembler.EntityAssembler;
import com.mipresupuesto.personalbudget.domain.BudgetDomain;
import com.mipresupuesto.personalbudget.entity.BudgetEntity;

@Component
public class BudgetEntityAssembler implements EntityAssembler<BudgetEntity, BudgetDomain>{

	@Autowired
	PersonEntityAssembler personEntityAssembler;
	@Autowired
	YearEntityAssembler yearEntityAssembler;
	@Override
	public BudgetDomain asembleDomain(BudgetEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BudgetEntity asembleEntity(BudgetDomain domain) {
		return new BudgetEntity(yearEntityAssembler.asembleEntity(domain.getYear()),personEntityAssembler.asembleEntity(domain.getPerson()));
	}

}
