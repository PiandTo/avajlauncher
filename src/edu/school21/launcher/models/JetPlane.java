package edu.school21.launcher.models;

import edu.school21.launcher.observer.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
	JetPlane (String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {

	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		weatherTower.register(this);
	}
}
