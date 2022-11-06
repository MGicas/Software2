package com.mipresupuesto.personalbudget.application.dtoassembler.implementation;

import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.dtoassembler.DTOAssembler;
import com.mipresupuesto.personalbudget.crosscutting.Utils.ObjectHelper;
import com.mipresupuesto.personalbudget.crosscutting.Utils.UtilUUID;
import com.mipresupuesto.personalbudget.domain.PersonDomain;
import com.mipresupuesto.personalbudget.domain.YearDomain;
import com.mipresupuesto.personalbudget.domain.builder.PersonDomainBuilder;
import com.mipresupuesto.personalbudget.domain.builder.YearDomainBuilder;
import com.mipresupuesto.personalbudget.dto.PersonDTO;
import com.mipresupuesto.personalbudget.dto.YearDTO;
@Component
public final class YearDTOAssembler implements DTOAssembler<YearDTO, YearDomain> {

	@Override
	public final YearDomain asembleDomain(final YearDTO dto) {
		YearDomain domain = YearDomainBuilder.get().build();
		if(!ObjectHelper.isNull(dto)) {
			domain = YearDomainBuilder.get().setId(UtilUUID.getUUIDFromString(dto.getId()))
					.setYear(dto.getYear())
					.build();
		}
		return domain;
	}

	@Override
	public YearDTO asembleDTO(YearDomain domain) {
		YearDTO dto = new YearDTO();
		if(!ObjectHelper.isNull(domain)) {
			dto = new YearDTO(UtilUUID.getStringFromUUID(domain.getId()),
					domain.getYear());
		}
		return dto;
	}

}
