package edu.school21.launcher.weatherProvider;

import edu.school21.launcher.models.Coordinates;

public class WeatherProvider {
	private static WeatherProvider weatherProvider;
	private String[] state = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider() {};
	public static WeatherProvider getProvider(){
		if (weatherProvider == null) {
			weatherProvider = new WeatherProvider();
		}
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		return state[(coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude()) % 4];
	}
}
