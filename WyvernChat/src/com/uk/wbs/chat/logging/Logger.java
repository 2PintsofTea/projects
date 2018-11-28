package com.uk.wbs.chat.logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Logger {

	/**
	 * Logs a message using the Logger
	 * 
	 * @param String message		The message to log
	 */
	public abstract void log(String message);
	
	/**
	 * Gets the formatted date & time for logging
	 */
	public String getFormattedDateTime() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
	}
	
}
