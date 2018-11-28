package com.uk.wbs.chat.logging;

public class ConsoleLogger extends Logger {

	@Override
	public void log(String message) {
		System.out.println("[" + getFormattedDateTime() + "] " + message);
	}

}
