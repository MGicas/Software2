package com.mipresupuesto.personalbudget.domain;

public final class YearDomain {
	
	private String id;
	private int year;
	
	private YearDomain(String id, int year) {
		setId(id);
		setYear(year);
	}
	
	public static YearDomain create(String id, int year) {
		return new YearDomain(id, year);
	}
	
	private final void setId(String id) {
		this.id = (id == null)? " ": id.trim();
	}

	private final void setYear(int year) {
		this.year = year;
	}

	public final String getId() {
		return id;
	}

	public final int getYear() {
		return year;
	}
	
}
