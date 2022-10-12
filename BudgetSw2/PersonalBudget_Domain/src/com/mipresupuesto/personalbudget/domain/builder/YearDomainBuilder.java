package com.mipresupuesto.personalbudget.domain.builder;

import com.mipresupuesto.personalbudget.domain.YearDomain;

public class YearDomainBuilder {
	private String id;
	private int year;
	
	private YearDomainBuilder() {
		setId("");
		setYear(0);
	}
	
	public static final YearDomainBuilder get() {
		return new YearDomainBuilder();
	}

	public final YearDomainBuilder setId(String id) {
		this.id = (id == null)? " ": id.trim();
		return this;
	}

	public final YearDomainBuilder setYear(int year) {
		this.year = year;
		return this;
	}

	
	public YearDomain build() {
		return YearDomain.create(id,year);
	}

}
