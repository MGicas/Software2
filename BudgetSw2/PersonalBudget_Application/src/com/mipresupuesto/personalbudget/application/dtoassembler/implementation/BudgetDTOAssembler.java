package com.mipresupuesto.personalbudget.application.dtoassembler.implementation;

import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.dtoassembler.DTOAssembler;
import com.mipresupuesto.personalbudget.crosscutting.Utils.ObjectHelper;
import com.mipresupuesto.personalbudget.crosscutting.Utils.UtilUUID;
import com.mipresupuesto.personalbudget.domain.BudgetDomain;
import com.mipresupuesto.personalbudget.domain.builder.BudgetDomainBuilder;
import com.mipresupuesto.personalbudget.domain.builder.YearDomainBuilder;
import com.mipresupuesto.personalbudget.dto.BudgetDTO;
import com.mipresupuesto.personalbudget.dto.YearDTO;

@Component
public final class BudgetDTOAssembler implements DTOAssembler<BudgetDTO, BudgetDomain>{
	
	private PersonDTOAssembler personDTOAssembler;
	private YearDTOAssembler yearDTOAssembler;

	@Override
	public final BudgetDomain asembleDomain(BudgetDTO dto) {
		BudgetDomain domain = BudgetDomainBuilder.get().build();
		if(!ObjectHelper.isNull(dto)) {
			domain = BudgetDomainBuilder.get()
					.setYear(yearDTOAssembler.asembleDomain(dto.getYear()))
					.setPerson(personDTOAssembler.asembleDomain(dto.getPerson()))
					.build();
		}
		return domain;
	}

	@Override
	public BudgetDTO asembleDTO(BudgetDomain domain) {
		BudgetDTO dto = new BudgetDTO();
		if(!ObjectHelper.isNull(domain)) {
			dto = new BudgetDTO(yearDTOAssembler.asembleDTO(domain.getYear()),
					personDTOAssembler.asembleDTO(domain.getPerson()));
		}
		return dto;
	}

}
