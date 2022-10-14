package entity;

import java.util.UUID;

public final class YearEntity {
	

	private UUID id;
	private int year;
	
	public YearEntity(){
		setYear(0);
	}
	
	public YearEntity(final UUID id, final int year) {
		setId(id);
		setYear(year);
	}
	
	public static final YearEntity create() {
		return new YearEntity();
	}
	public final UUID getId() {
		return id;
	}
	public final void setId(final UUID id) {
		this.id = id;
	}
	public final int getYear() {
		return year;
	}
	public final void setYear(final int year) {
		this.year = year;
	}

}
