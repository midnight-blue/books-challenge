package de.servicehealth.lost_and_found.model;

import java.time.Instant;

public record SearchItem(String description, Instant time, Position location) {
}
