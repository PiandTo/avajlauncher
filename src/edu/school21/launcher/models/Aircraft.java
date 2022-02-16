package edu.school21.launcher.models;

import java.io.BufferedWriter;
import java.io.IOException;

public abstract class Aircraft {
	protected long id = 0;
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter;

	protected Aircraft(String name, Coordinates coordinates) throws IOException {
		this.name = name;
		this.coordinates = coordinates;
		this.id = nextId();
	}

	private long nextId (){
		return ++idCounter;
	}
}
