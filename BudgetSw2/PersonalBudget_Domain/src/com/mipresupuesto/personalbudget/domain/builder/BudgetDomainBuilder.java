package com.mipresupuesto.personalbudget.domain.builder;

import java.util.UUID;

import com.mipresupuesto.personalbudget.domain.BudgetDomain;
import com.mipresupuesto.personalbudget.domain.PersonDomain;
import com.mipresupuesto.personalbudget.domain.YearDomain;
import com.mipresupuesto.personalbudget.crosscutting.Utils.UtilUUID;

public class BudgetDomainBuilder {
	
	private UUID id;
	private YearDomain year;
	private PersonDomain person;
	
	private BudgetDomainBuilder() {
		setId(UtilUUID.DEFAULT_UUID);
		setYear(year);
		setPerson(person);
	}
	
	public static final BudgetDomainBuilder get() {
		return new BudgetDomainBuilder();
	}

	public final BudgetDomain build() {
		return BudgetDomain.create(id, year, person);
	}
	
	public final BudgetDomainBuilder setId(final UUID id) {
		this.id = (id==null)? UUID.randomUUID():id;
		return this;
	}

	public final BudgetDomainBuilder setYear(final YearDomain year) {
		this.year = year;
		return this;
	}

	public final BudgetDomainBuilder setPerson(final PersonDomain person) {
		this.person = person;
		return this;
	}

	private final YearDomain getYear() {
		return year;
	}

	private final PersonDomain getPerson() {
		return person;
	}

	
}
