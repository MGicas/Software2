package entity;

import java.util.UUID;

import com.mipresupuesto.personalbudget.crosscutting.Itils.UtilUUID;

public final class PersonEntity {
	
	private UUID id;
	private String idCard;
	private String firstname;
	private String middlename;
	private String lastname;
	
	public PersonEntity() {
		setId(UtilUUID.DEFAULT_UUID);
		setIdCard("");
		setFirstname("");
		setMiddlename("");
		setLastname("");
	}

	public PersonEntity(final UUID id, final String idCard, final String firstname, final String middlename, final String lastname) {
		setId(id);
		setIdCard(idCard);
		setFirstname(firstname);
		setMiddlename(middlename);
		setLastname(lastname);
	}
	
	public static final PersonEntity create() {
		return new PersonEntity();
	}

	public final UUID getId() {
		if (id==null) {
			setId(UtilUUID.DEFAULT_UUID);
		}
		return id;
	}

	public final void setId(final UUID id) {
		this.id = id;
	}

	public final String getIdCard() {
		if(idCard == null) {
			setIdCard("");
		}
		return idCard.trim();
	}

	public final void setIdCard(final String idCard) {
		this.idCard = idCard;
	}

	public final String getFirstname() {
		if(firstname == null) {
			setFirstname("");
		}
		return firstname.trim();
	}

	public final void setFirstname(final String firstname) {
		this.firstname = firstname;
	}

	public final String getMiddlename() {
		if(middlename == null) {
			setMiddlename("");
		}
		return middlename.trim();
	}

	public final void setMiddlename(final String middlename) {
		this.middlename = middlename;
	}

	public final String getLastname() {
		if(lastname == null) {
			setLastname("");
		}
		return lastname.trim();
	}

	public final void setLastname(final String lastname) {
		this.lastname = lastname;
	}


}
