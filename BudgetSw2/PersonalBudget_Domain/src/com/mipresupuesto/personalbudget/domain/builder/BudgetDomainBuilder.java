package com.mipresupuesto.personalbudget.domain.builder;

import com.mipresupuesto.personalbudget.domain.BudgetDomain;
import com.mipresupuesto.personalbudget.domain.PersonDomain;
import com.mipresupuesto.personalbudget.domain.YearDomain;

public class BudgetDomainBuilder {
	
	private YearDomain year;
	private PersonDomain person;
	
	private BudgetDomainBuilder(final YearDomain year, final PersonDomain person) {
		setYear(year);
		setPerson(person);
	}

	public static final BudgetDomainBuilder create(final YearDomain year, final PersonDomain person) {
		return new BudgetDomainBuilder(year, person);
	}

	public final BudgetDomainBuilder setYear(final YearDomain year) {
		this.year = year;
		return this;
	}

	private final void setPerson(final PersonDomain person) {
		this.person = person;
	}

	public final YearDomain getYear() {
		return year;
	}

	public final PersonDomain getPerson() {
		return person;
	}

	
}
