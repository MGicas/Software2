package com.mipresupuesto.personalbudget.application.dtoassembler.implementation;

import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.dtoassembler.DTOAssembler;
import com.mipresupuesto.personalbudget.crosscutting.Utils.ObjectHelper;
import com.mipresupuesto.personalbudget.domain.PersonDomain;
import com.mipresupuesto.personalbudget.domain.builder.PersonDomainBuilder;
import com.mipresupuesto.personalbudget.dto.PersonDTO;
import com.mipresupuesto.personalbudget.crosscutting.Utils.UtilUUID;
@Component
public class PersonDTOAssembler implements DTOAssembler<PersonDTO, PersonDomain>{

	@Override
	public PersonDomain asembleDomain(final PersonDTO dto) {
		PersonDomain domain = PersonDomainBuilder.get().build();
		if(!ObjectHelper.isNull(dto)) {
			domain = PersonDomainBuilder.get().setId(UtilUUID.getUUIDFromString(dto.getId()))
					.setFirstname(dto.getFirstname())
					.setIdCard(dto.getIdCard())
					.setLastname(dto.getLastname())
					.setMiddlename(dto.getMiddlename())
					.build();
		}
		return domain;
	}

	@Override
	public PersonDTO asembleDTO(PersonDomain domain) {
		PersonDTO dto = new PersonDTO();
		if(!ObjectHelper.isNull(domain)) {
			dto = new PersonDTO(UtilUUID.getStringFromUUID(domain.getId()),
					domain.getIdCard(),
					domain.getFirstname(),
					domain.getMiddlename(),
					domain.getLastname(),
					domain.getName(),
					domain.getCompleteName());
		}
		return dto;
	}

}
