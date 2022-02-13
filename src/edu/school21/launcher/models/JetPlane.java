package edu.school21.launcher.models;

import edu.school21.launcher.observer.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
	WeatherTower weatherTower;

	JetPlane (String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		String state = weatherTower.getWeather(this.coordinates);
//		System.out.println("Hi " + name + " is added to Subscribe");
//		System.out.println("Weather: " + state);
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		System.out.println("Registered " + this.name);
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}
}
