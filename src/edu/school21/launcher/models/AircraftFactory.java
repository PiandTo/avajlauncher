package edu.school21.launcher.models;

import java.util.Locale;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws NotSuchClassException {
        Flyable flyable;
        switch (type.toLowerCase()) {
            case "baloon":
                flyable = new Baloon(name, new Coordinates(longitude, latitude, height));
                return flyable;
            case "helicopter":
                flyable = new Helicopter(name, new Coordinates(longitude, latitude, height));
                return flyable;
            case "jetplane":
                flyable = new JetPlane(name, new Coordinates(longitude, latitude, height));
                return flyable;
            default: throw new NotSuchClassException("Not such object");
        }
    }
}