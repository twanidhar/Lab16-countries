package lab16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class CountriesApp {

	private static Path filePath = Paths.get("Countries.txt");

	public static void main(String[] args) throws IOException {
		Scanner scnr = new Scanner(System.in);

		System.out.println("Enter a country to add:");
		String name = scnr.nextLine();
		System.out.print("Enter it's population: ");
		int populations = scnr.nextInt();
		Country newCountry = new Country(name, populations);
		System.out.println(newCountry);
		appendToFile(newCountry);

		List<Country> countries = readFile();
		for (Country c : countries) {
			System.out.println(c.getName() + " has " + c.getPopulations());
		}

		scnr.close();
	}

	private static void appendToFile(Country country) throws IOException {// writing the file.sys out into a file.
		if (Files.notExists(filePath)) { // checks the filePath
			Files.createFile(filePath);
		}

//		String line = String.format("%s\t%d", player.getName(), player.getJerseyNumber());
		String line = "\n" + country.getName() + "\t" + country.getPopulations();

		// ** Example of adding to the end of a file
		// Create a list with the user's food in it
		List<String> linesToAdd = Arrays.asList(line);
		// Write those lines to the end of the file
		Files.write(filePath, linesToAdd, StandardOpenOption.APPEND);
	}
	// System.out.println(linesToAdd);

	private static List<Country> readFile() {
		// ** Example of reading a file into a list
		try {
			List<String> lines = Files.readAllLines(filePath);
			List<Country> countries = new ArrayList<>();
			for (String line : lines) {
				String[] parts = line.split("\t");
				Country c = new Country();
				c.setName(parts[0]);
				c.setPopulations(Integer.parseInt(parts[1]));
				countries.add(c);
			}
			return countries;

		} catch (NoSuchFileException ex) {
			return new ArrayList<>();
		} catch (IOException ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}
}
// TODO Auto-generated method stub
