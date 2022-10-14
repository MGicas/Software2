package com.mipresupuesto.personalbudget.domain.builder;

import java.util.UUID;

import com.mipresupuesto.personalbudget.domain.PersonDomain;

public class PersonDomainBuilder {
	private UUID id;
	private String idCard;
	private String firstname;
	private String middlename;
	private String lastname;
	
	private PersonDomainBuilder() {
		setId(UUID.randomUUID());
		setIdCard("");
		setFirstname("");
		setMiddlename("");
		setLastname("");
	}
	
	public static final PersonDomainBuilder get() {
		return new PersonDomainBuilder();
	}

	public final PersonDomainBuilder setId(UUID id) {
		this.id = (id == null)? UUID.randomUUID(): id;
		return this;
	}

	public PersonDomainBuilder setIdCard(String idCard) {
		this.idCard = idCard;
		return this;
	}

	public PersonDomainBuilder setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public PersonDomainBuilder setMiddlename(String middlename) {
		this.middlename = middlename;
		return this;
	}

	public PersonDomainBuilder setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	private UUID getId() {
		return id;
	}

	private String getIdCard() {
		return idCard;
	}

	private String getFirstname() {
		return firstname;
	}

	private String getMiddlename() {
		return middlename;
	}

	private String getLastname() {
		return lastname;
	}
	
	public PersonDomain build() {
		return PersonDomain.create(id, idCard, firstname, middlename, lastname);
	}


}
