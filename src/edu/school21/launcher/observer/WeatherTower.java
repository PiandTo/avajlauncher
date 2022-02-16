package edu.school21.launcher.observer;

import edu.school21.launcher.models.Coordinates;
import edu.school21.launcher.weatherProvider.WeatherProvider;

import java.io.IOException;

public class WeatherTower extends Tower {

	public String getWeather(Coordinates coordinates){
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}

	public void changeWeather() throws IOException {
		conditionsChanged();
	}
}
