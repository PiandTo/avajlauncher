package edu.school21.launcher.models;

public class NotSuchClassException extends Exception{
    public NotSuchClassException() {
        super ("No such Object");
    }

    public NotSuchClassException(String message) {
        super(message);
    }
}
