package com.mipresupuesto.personalbudget.application.dtoassembler.implementation;

import com.mipresupuesto.personalbudget.application.dtoassembler.DTOAssembler;
import com.mipresupuesto.personalbudget.domain.YearDomain;
import com.mipresupuesto.personalbudget.domain.builder.YearDomainBuilder;
import com.mipresupuesto.personalbudget.dto.YearDTO;

public final class YearDTOAssembler implements DTOAssembler<YearDTO, YearDomain> {

	@Override
	public final YearDomain asembleDomain(final YearDTO dto) {
		
		YearDomain domain = YearDomainBuider.get().build();
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public YearDTO asembleDTO(YearDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

}
