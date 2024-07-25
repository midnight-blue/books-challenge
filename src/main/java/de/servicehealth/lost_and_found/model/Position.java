package de.servicehealth.lost_and_found.model;

public class Position {
	private double latitude;
	private double longitude;

	private Position(double longitude, double latitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public static Position fromString(String text) {
		String[] parts = text.split(",");
		return new Position(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
	}

	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
}
