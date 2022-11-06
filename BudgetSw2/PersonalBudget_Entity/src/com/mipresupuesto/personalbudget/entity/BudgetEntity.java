package com.mipresupuesto.personalbudget.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.mipresupuesto.personalbudget.crosscutting.Utils.UtilUUID;

@Entity
@Table(name="Budget")
public final class BudgetEntity {

	@Id
	@Column(name="id")
	private UUID id;
	@ManyToOne
	@JoinColumn(name="idYear")
	private YearEntity year;
	@ManyToOne
	@JoinColumn(name="idPerson")
	private PersonEntity person;
	
	public BudgetEntity() {
		setId(UtilUUID.DEFAULT_UUID);
		setYear(new YearEntity());
		setPerson(new PersonEntity());
	}

	public BudgetEntity(final UUID id, final YearEntity year, final PersonEntity person) {
		setId(id);
		setYear(year);
		setPerson(person);
	}

	public final YearEntity getYear() {
		if(year == null) {
			setYear(new YearEntity());
		}
		return year;
	}

	public final void setYear(YearEntity year) {
		this.year = year;
	}

	public final PersonEntity getPerson() {
		if(person==null) {
			setPerson(new PersonEntity());
		}
		return person;
	}

	public final void setPerson(PersonEntity person) {
		this.person = person;
	}

	public final UUID getId() {
		return id;
	}

	public final void setId(final UUID id) {
		this.id = id;
	}
	

}
