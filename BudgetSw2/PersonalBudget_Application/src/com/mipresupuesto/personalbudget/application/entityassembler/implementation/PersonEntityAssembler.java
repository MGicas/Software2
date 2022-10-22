package com.mipresupuesto.personalbudget.application.entityassembler.implementation;

import org.springframework.stereotype.Component;

import com.mipresupuesto.personalbudget.application.entityassembler.EntityAssembler;
import com.mipresupuesto.personalbudget.domain.PersonDomain;

import entity.PersonEntity;

@Component
public class PersonEntityAssembler implements EntityAssembler<PersonEntity, PersonDomain>{
	

	@Override
	public PersonDomain asembleDomain(PersonEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonEntity asembleEntity(PersonDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}
}
