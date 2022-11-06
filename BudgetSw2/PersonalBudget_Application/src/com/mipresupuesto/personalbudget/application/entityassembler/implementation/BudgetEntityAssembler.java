package com.mipresupuesto.personalbudget.application.entityassembler.implementation;

import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.entityassembler.EntityAssembler;
import com.mipresupuesto.personalbudget.crosscutting.Utils.ObjectHelper;
import com.mipresupuesto.personalbudget.domain.BudgetDomain;
import com.mipresupuesto.personalbudget.domain.builder.BudgetDomainBuilder;
import com.mipresupuesto.personalbudget.entity.BudgetEntity;

@Component
public class BudgetEntityAssembler implements EntityAssembler<BudgetEntity, BudgetDomain> {
	
	private YearEntityAssembler yearEntityAssembler;
	private PersonEntityAssembler personEntityAssembler;

	@Override
	public BudgetDomain asembleDomain(BudgetEntity entity) {
		BudgetDomain domain = BudgetDomainBuilder.get().build();
		if (!ObjectHelper.isNull(entity)) {
			domain = BudgetDomainBuilder.get()
					.setId(entity.getId())
					.setYear(yearEntityAssembler.asembleDomain(entity.getYear()))
					.setPerson(personEntityAssembler.asembleDomain(entity.getPerson()))
					.build();
		}
		return domain;
	}

	@Override
	public BudgetEntity asembleEntity(BudgetDomain domain) {
		BudgetEntity entity = new BudgetEntity();
		if (!ObjectHelper.isNull(domain)) {
			entity = new BudgetEntity(
					domain.getId(), 
					yearEntityAssembler.asembleEntity(domain.getYear()), 
					personEntityAssembler.asembleEntity(domain.getPerson()));
		}
		return entity;
	}

}
