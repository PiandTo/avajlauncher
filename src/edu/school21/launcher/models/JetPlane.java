package edu.school21.launcher.models;

import edu.school21.launcher.observer.WeatherTower;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;
	private BufferedWriter simulation;

	JetPlane (String name, Coordinates coordinates) throws IOException {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() throws IOException {
		String state = weatherTower.getWeather(this.coordinates);
		simulation = new BufferedWriter(new FileWriter("simulation.txt", true));
		switch(state) {
			case "RAIN":
				coordinates.setLatitude(coordinates.getLatitude() + 5);
				simulation.write(this.getClass().getSimpleName() + "#" + this.name + "(" + this.id +"): It is too rainy!!!");
				simulation.newLine();
				break;
			case "SUN":
				coordinates.setLatitude(coordinates.getLatitude() + 10);
				coordinates.setHeight(coordinates.getHeight() + 2);
				simulation.write(this.getClass().getSimpleName() + "#" + this.name + "(" + this.id +"): It is too hot!!!");
				simulation.newLine();
				break;
			case "FOG":
				coordinates.setLatitude(coordinates.getLatitude() + 1);
				simulation.write(this.getClass().getSimpleName() + "#" + this.name + "(" + this.id +"): It is too foggy!!!");
				simulation.newLine();
				break;
			case "SNOW":
				coordinates.setHeight(coordinates.getHeight() - 7);
				simulation.write(this.getClass().getSimpleName() + "#" + this.name + "(" + this.id +"): It is too snowy!!!");
				simulation.newLine();
				break;
		}
		if (coordinates.getHeight() < 0)
			coordinates.setHeight(0);
		if (coordinates.getHeight() > 100)
			coordinates.setHeight(100);
		if (coordinates.getHeight() == 0){
			weatherTower.unregister(this);
		}
		simulation.close();
	}

	@Override
	public void registerTower(WeatherTower weatherTower) throws IOException {
		simulation = new BufferedWriter(new FileWriter("simulation.txt", true));
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		simulation.write("Tower says: " + this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ") registered to weather tower.");
		simulation.newLine();

		simulation.close();
	}

	@Override
	public void unregisterTower(WeatherTower weatherTower) throws IOException {
		simulation = new BufferedWriter(new FileWriter("simulation.txt", true));
		simulation.write(this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ") landing.");
		simulation.newLine();
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		simulation.write("Tower says: " + this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ") unregistered from weather tower.");
	}
}
