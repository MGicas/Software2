package com.mipresupuesto.personalbudget.application.dtoassembler;

public interface DTOAssembler<T, D> {

	D asembleDomain(T dto);

	T asembleDTO(D domain);

}
