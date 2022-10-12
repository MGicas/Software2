package com.mipresupuesto.personalbudget.domain;

import com.mipresupuesto.personalbudget.domain.builder.PersonDomainBuilder;
import com.mipresupuesto.personalbudget.domain.builder.YearDomainBuilder;

public class BudgetDomain {
	
	private YearDomain year;
	private PersonDomain person;
	
	private BudgetDomain(final YearDomain year, final PersonDomain person) {
		setYear(year);
		setPerson(person);
	}
	
	public static final BudgetDomain create(final YearDomain year, final PersonDomain person) {
		return new BudgetDomain(year,person);
	}

	private final void setYear(final YearDomain year) {
		this.year = (year == null)? YearDomainBuilder.get().build():year;
	}

	private final void setPerson(final PersonDomain person) {
		this.person = (person == null)? PersonDomainBuilder.get().build(): person;
	}

	public final YearDomain getYear() {
		return year;
	}

	public final PersonDomain getPerson() {
		return person;
	}
	

}
