package edu.school21.launcher.app;

import edu.school21.launcher.models.*;
import edu.school21.launcher.observer.WeatherTower;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program {


	private static void printError ()
	{
		System.out.print("Incorrect simulation file");
		System.exit(1);
	}

	private static void validateString(String[] str) throws NotCorrectFileException {
		switch (str[0].toLowerCase()){
			case "baloon":
				break;
			case "helicopter":
				break;
			case "jetplane":
				break;
			default: throw new NotCorrectFileException("not correct type Aircraft");
		}
		if (str[1] == null)
			throw new NotCorrectFileException("No name of Aircraft");
		Integer longitude = Integer.parseInt(str[2]);
		Integer latitude = Integer.parseInt(str[3]);
		Integer height = Integer.parseInt(str[4]);
		if (longitude < 0 || latitude < 0 || height < 0)
			throw new NotCorrectFileException("Coordinates should positive");
		if (height > 100)
			height = 100;
	}

	public static void main(String[] args) throws IOException {
		int numberOfSimulation;
		List<Flyable> obj = new ArrayList<>();
		WeatherTower weatherTower = new WeatherTower();

		FileReader fr = new FileReader("/Users/mikhailmalev/Documents/School21/AvajLauncher/scenario.txt");
		Scanner sc = new Scanner(fr);
		numberOfSimulation = sc.nextInt();
		sc.nextLine();
		try {
			if (numberOfSimulation < 0 || numberOfSimulation > Integer.MAX_VALUE)
				throw new NotCorrectFileException("Simulation integer is positive and not more than MAX_VALUE");
		} catch (NotCorrectFileException e){
			System.out.println(e.getMessage());
			System.exit(1);
		} catch (InputMismatchException e) {
			printError();
		}
		while (sc.hasNext()) {
			String str = sc.nextLine();
			try {
				String[] arr = str.split(" ");
				validateString(arr);
				Integer longitude = Integer.parseInt(arr[2]);
				Integer latitude = Integer.parseInt(arr[3]);
				Integer height = Integer.parseInt(arr[4]);
				Flyable a = AircraftFactory.newAircraft(arr[0], arr[1], longitude, latitude, height);
				obj.add(a);
			} catch (NotCorrectFileException e) {
				System.out.println(e.getMessage());
				System.exit(1);
			} catch (NotSuchClassException e) {
				e.printStackTrace();
			}
		}
		for (Flyable fl : obj)
			fl.registerTower(weatherTower);
		for (int i = 0; i <= numberOfSimulation; i++) {
			weatherTower.changeWeather();
		}
	}
}
