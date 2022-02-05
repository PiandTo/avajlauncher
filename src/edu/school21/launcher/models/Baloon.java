package edu.school21.launcher.models;

import edu.school21.launcher.observer.WeatherTower;
import edu.school21.launcher.models.Flyable;

public class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Baloon (String name, Coordinates coordinates)
	{
		super (name, coordinates);
	}

	@Override
	public void updateConditions() {

	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		weatherTower.register(this);
	}
}
