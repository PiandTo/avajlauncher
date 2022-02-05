package edu.school21.launcher.models;

public abstract class Aircraft {
	protected long id = 0;
	protected String name;
	protected Coordinates coordinates;
	private long idCounter;

	protected Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
		this.id = idCounter;
	}
	private long nextId (){
		return idCounter++;
	}
}
