package edu.school21.launcher.models;

import edu.school21.launcher.observer.WeatherTower;

public interface Flyable {
	public void updateConditions();
	public void registerTower(WeatherTower WeatherTower);
}
