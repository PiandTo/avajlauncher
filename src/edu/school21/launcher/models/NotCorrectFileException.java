package edu.school21.launcher.models;

public class NotCorrectFileException extends Exception{

	public NotCorrectFileException() {
		super("Not correct file data");
	}
	public NotCorrectFileException(String message) {
		super(message);
	}



}
