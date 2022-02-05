package edu.school21.launcher.app;

import edu.school21.launcher.models.Aircraft;
import edu.school21.launcher.models.NotCorrectFileException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
	private static void printError ()
	{
		System.out.print("Incorrect simulation file");
		System.exit(1);
	}

	private static void validateString(String str) throws NotCorrectFileException {


	}

	public static void main(String[] args) throws IOException {
		int numberOfSimulation;
		List<Aircraft> obj = new ArrayList<>();

		FileReader fr = new FileReader("/Users/snaomi/School21/avaj-launcer/my_code/src/edu/school21/launcher/resources/scenario.txt");
		Scanner sc = new Scanner(fr);
		try {
			numberOfSimulation = sc.nextInt();
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
				validateString(str);
			} catch (NotCorrectFileException e) {
				System.out.println(e.getMessage());
				System.exit(-1);
			}
		}
	}
}
