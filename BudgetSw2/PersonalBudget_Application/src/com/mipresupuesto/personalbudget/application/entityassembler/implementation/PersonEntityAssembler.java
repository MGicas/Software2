package com.mipresupuesto.personalbudget.application.entityassembler.implementation;

import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.entityassembler.EntityAssembler;
import com.mipresupuesto.personalbudget.domain.PersonDomain;
import com.mipresupuesto.personalbudget.domain.builder.PersonDomainBuilder;
import com.mipresupuesto.personalbudget.entity.PersonEntity;
import com.mipresupuesto.personalbudget.crosscutting.Utils.ObjectHelper;

@Component
public class PersonEntityAssembler implements EntityAssembler<PersonEntity, PersonDomain>{
	

	@Override
	public PersonDomain asembleDomain(PersonEntity entity) {
		PersonDomain domain = PersonDomainBuilder.get().build();
		if (!ObjectHelper.isNull(entity)) {
			domain = PersonDomainBuilder.get()
					.setId(entity.getId())
					.setFirstname(entity.getFirstname())
					.setLastname(entity.getLastname())
					.setIdCard(entity.getIdCard())
					.setMiddlename(entity.getMiddlename())
					.build();
		}
		return domain;
	}

	@Override
	public PersonEntity asembleEntity(PersonDomain domain) {
		PersonEntity entity = new PersonEntity();
		if (!ObjectHelper.isNull(domain)) {
			entity = new PersonEntity(domain.getId(), domain.getIdCard(), domain.getFirstname(), domain.getMiddlename(),
					domain.getLastname());
		}
		return entity;
	}
}
