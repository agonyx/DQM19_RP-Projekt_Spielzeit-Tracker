package io;

public class FileCreationError extends Exception{
	private String messageString = "File couldn't be created";
	public FileCreationError() {
		
		
	}
	public String getMessage() {
		return messageString;
	}

}
