package com.mipresupuesto.personalbudget.domain;

import java.util.UUID;

import com.mipresupuesto.personalbudget.domain.builder.PersonDomainBuilder;

public class PersonDomain {
	
	private UUID id;
	private String idCard;
	private String firstname;
	private String middlename;
	private String lastname;
	
	private PersonDomain(final UUID id, final String idCard, final String firstname, final String middlename, final String lastname){
		setId(id);
		setIdCard(idCard);
		setFirstname(firstname);
		setMiddlename(middlename);
		setLastname(lastname);
	}
	
	public static PersonDomain create(UUID id, String idCard, String firstname, String middlename, String lastname) {
		return new PersonDomain(id, idCard, firstname, middlename, lastname);
	}
	
//los setters de build
	
	private final void setId(UUID id) {
		this.id = (id == null) ? UUID.randomUUID(): id;
	}

	private final void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	private final void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	private final void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	private final void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public final UUID getId() {
		return id;
	}

	public final String getIdCard() {
		return idCard;
	}

	public final String getFirstname() {
		return firstname;
	}

	public final String getMiddlename() {
		return middlename;
	}

	public final String getLastname() {
		return lastname;
	}
	
	public final String getName() {
		return getFirstname()+" " + getMiddlename().trim();
	}
	
	public final String getCompleteName() {
		return getName()+" " + getLastname();
	}
}
