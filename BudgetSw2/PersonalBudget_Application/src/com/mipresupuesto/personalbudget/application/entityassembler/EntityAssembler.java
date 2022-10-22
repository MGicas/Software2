package com.mipresupuesto.personalbudget.application.entityassembler;

public interface EntityAssembler <E, D> {
	
	D asembleDomain(E entity);
	E asembleEntity(D domain);

}
