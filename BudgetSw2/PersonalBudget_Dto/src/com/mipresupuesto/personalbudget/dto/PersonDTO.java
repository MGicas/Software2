package com.mipresupuesto.personalbudget.dto;

public final class PersonDTO {
	private String id;
	private String idCard;
	private String firstname;
	private String middlename;
	private String lastname;
	private String name;
	private String completename;
	
	public PersonDTO() {
		setId("");
		setIdCard("");
		setFirstname("");
		setMiddlename("");
		setLastname("");
		setName("");
		setCompletename("");
	}

	public PersonDTO(final String id, final String idCard, final String firstname, final String middlename, final String lastname, final String name, final String completename) {
		setId(id);
		setIdCard(idCard);
		setFirstname(firstname);
		setMiddlename(middlename);
		setLastname(lastname);
		setName(name);
		setCompletename(completename);
	}
	
	public static final PersonDTO create() {
		return new PersonDTO();
	}

	public final String getId() {
		if(id == null) {
			setId("");
		}
		return id.trim();
	}

	public final void setId(final String id) {
		this.id = id;
	}

	public final String getIdCard() {
		if(idCard == null) {
			setId("");
		}
		return idCard.trim();
	}

	public final void setIdCard(final String idCard) {
		this.idCard = idCard;
	}

	public final String getFirstname() {
		if(firstname == null) {
			setId("");
		}
		return firstname.trim();
	}

	public final void setFirstname(final String firstname) {
		this.firstname = firstname;
	}

	public final String getMiddlename() {
		if(middlename == null) {
			setId("");
		}
		return middlename.trim();
	}

	public final void setMiddlename(final String middlename) {
		this.middlename = middlename;
	}

	public final void setLastname(final String lastname) {
		this.lastname = lastname;
	}
	
	public final String getLastname() {
		if(lastname == null) {
			setLastname("");
		}
		return lastname.trim();
	}

	public final String getName() {
		if(name == null) {
			setName("");
		}
		return name.trim();
	}

	public final void setName(final String name) {
		this.name = name;
	}

	public final String getCompletename() {
		if(completename == null) {
			setCompletename("");
		}
		return completename.trim();
	}

	public final void setCompletename(final String completename) {
		this.completename = completename;
	}
	
	

}
