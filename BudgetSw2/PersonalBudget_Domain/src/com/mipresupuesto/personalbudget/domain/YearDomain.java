package com.mipresupuesto.personalbudget.domain;

import java.util.UUID;

public final class YearDomain {
	
	private UUID id;
	private int year;
	
	private YearDomain(UUID id, int year) {
		setId(id);
		setYear(year);
	}
	
	public static YearDomain create(UUID id, int year) {
		return new YearDomain(id, year);
	}
	
	private final void setId(UUID id) {
		this.id = (id == null)? UUID.randomUUID(): id;
	}

	private final void setYear(int year) {
		this.year = year;
	}

	public final UUID getId() {
		return id;
	}

	public final int getYear() {
		return year;
	}
	
}
