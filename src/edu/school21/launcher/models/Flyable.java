package edu.school21.launcher.models;

import edu.school21.launcher.observer.WeatherTower;

import java.io.IOException;

public interface Flyable {
	public void updateConditions() throws IOException;
	public void registerTower(WeatherTower WeatherTower) throws IOException;
	public void unregisterTower(WeatherTower weatherTower) throws IOException;
}
