package com.mipresupuesto.personalbudget.dto;

public final class BudgetDTO {
	
	private YearDTO year;
	private PersonDTO person;
	
	public BudgetDTO() {
		setYear(year);
		setPerson(person);
	}
	
	public BudgetDTO(YearDTO year, PersonDTO person) {
		setYear(year);
		setPerson(person);
	}

	public static final BudgetDTO create() {
		return new BudgetDTO();
	}

	public final YearDTO getYear() {
		return year;
	}


	public final void setYear(YearDTO year) {
		this.year = year;
	}


	public final PersonDTO getPerson() {
		return person;
	}


	public final void setPerson(PersonDTO person) {
		this.person = person;
	}
	
	
	

}
