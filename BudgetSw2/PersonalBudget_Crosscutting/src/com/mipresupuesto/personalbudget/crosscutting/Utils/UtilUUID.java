package com.mipresupuesto.personalbudget.crosscutting.Utils;

import java.util.UUID;

public final class UtilUUID {

	public static final String DEFAULT_UUID_STRING = "00000000-0000-0000-0000-000000000000";
	public static final UUID DEFAULT_UUID = UUID.fromString(DEFAULT_UUID_STRING);

	private UtilUUID() {
		super();
	}
	
	public static final UUID getDefaultUUID(final UUID uuid) {
		return (uuid == null)? DEFAULT_UUID :uuid;
	}
	
	public static final boolean isEqual(final UUID uuidOne, final UUID uuidTwo) {
		return getDefaultUUID(uuidOne).equals(getDefaultUUID(uuidTwo));
	}
	
	public static final UUID getNewUUID() {
		UUID uuid;
		do {
			uuid = UUID.randomUUID();
		}while (isEqual(uuid, DEFAULT_UUID));
		return uuid;
	}

	public static UUID getUUIDFromString(String id) {
		return UUID.fromString(id);
	}
	
	public static String getStringFromUUID(UUID id) {
		return id.toString();
	}
	
}
