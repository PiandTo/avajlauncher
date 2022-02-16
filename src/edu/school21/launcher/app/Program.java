package edu.school21.launcher.app;

import edu.school21.launcher.models.*;
import edu.school21.launcher.observer.WeatherTower;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Program {

	private static void printError ()
	{
		System.out.print("Incorrect simulation file");
		System.exit(1);
	}

	private static void validateString(String[] str) throws NotCorrectFileException, NoSuchAlgorithmException, UnsupportedEncodingException {
		HashingWords hs = new HashingWords();
		if (hs.convert("Baloon").equals(str[0]) || str[0].equals("Baloon") || str[0].equals("Helicopter") || str[0].equals("JetPlane") || hs.convert("JetPlane").equals(str[0]) || hs.convert("Helicopter").equals(str[0])){}
		else
			throw new NotCorrectFileException("not correct type Aircraft");
		if (str.length != 5 || str[0].equals("") || str[1].equals("") || str[2].equals("") || str[3].equals("") || str[4].equals(""))
			throw new NotCorrectFileException("Not correct Simulation.txt");
		Integer longitude = Integer.parseInt(str[2]);
		Integer latitude = Integer.parseInt(str[3]);
		Integer height = Integer.parseInt(str[4]);
		if (longitude < 0 || latitude < 0 || height < 0)
			throw new NotCorrectFileException("Coordinates should positive");
	}

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		int numberOfSimulation;
		List<Flyable> obj = new ArrayList<>();
		WeatherTower weatherTower = new WeatherTower();
		HashingWords hs = new HashingWords();
		String name;
//		FileReader fr = new FileReader("/Users/mikhailmalev/Documents/School21/AvajLauncher/scenario.txt");
		FileReader fr = new FileReader(args[0]);
		Scanner sc = new Scanner(fr);
		numberOfSimulation = sc.nextInt();
		sc.nextLine();
		try {
			if (numberOfSimulation < 0)
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
				if (height > 100)
					height = 100;
				if (arr[0].equals(hs.convert("Baloon")))
					name = "Baloon";
				else if (arr[0].equals(hs.convert("Helicopter")))
					name = "Helicopter";
				else if (arr[0].equals(hs.convert("JetPlane")))
					name = "JetPlane";
				else
					name = arr[0];
				Flyable a = AircraftFactory.newAircraft(name, arr[1], longitude, latitude, height);
				obj.add(a);
			} catch (NotCorrectFileException e) {
				System.out.println(e.getMessage());
				System.exit(1);
			} catch (NotSuchClassException | NoSuchAlgorithmException e) {
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
