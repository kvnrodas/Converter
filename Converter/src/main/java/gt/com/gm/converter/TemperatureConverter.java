package gt.com.gm.converter;

import javax.swing.JOptionPane;

//This class handles the conversion of temperatures between different units.
public class TemperatureConverter {

	// This method represents the main operation for temperature conversion.
	// It shows a menu to the user and performs temperature conversion based on the
	// user's choice.
	public static double operationTemperature() {
		// Show a menu with temperature conversion options
		String[] options = { "Celsius to Fahrenheit", "Fahrenheit to Celsius", "Celsius to Kelvin", "Kelvin to Celsius",
				"Fahrenheit to Rankine", "Rankine to Fahrenheit", "Kelvin to Rankine", "Rankine to Kelvin", "Exit" };

		while (true) {
			// Display the menu and get the user's choice
			int choice = JOptionPane.showOptionDialog(null, "Select an option", "Temperature Converter",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

			// Perform an action based on the user's choice
			switch (choice) {
			case 0:
				convertCelsiusToFahrenheit();
				break;
			case 1:
				convertFahrenheitToCelsius();
				break;
			case 2:
				convertCelsiusToKelvin();
				break;
			case 3:
				convertKelvinToCelsius();
				break;
			case 4:
				convertFahrenheitToRankine();
				break;
			case 5:
				convertRankineToFahrenheit();
				break;
			case 6:
				convertKelvinToRankine();
				break;
			case 7:
				convertRankineToKelvin();
				break;
			case 8:
				// Exit the program
				System.exit(0);
			}
		}
	}

	// This method prompts the user to enter a temperature in a specified unit.
	// It returns the entered temperature as a double.
	private static double promptForTemperature(String unit) {
		String input = JOptionPane.showInputDialog("Enter the temperature in " + unit + ":");
		if (input != null && !input.isEmpty()) {
			try {
				return Double.parseDouble(input);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		return Double.NaN; // Invalid value
	}

	// This method shows the result of a temperature conversion in a dialog box.
	private static void showResult(double result, String unit) {
		JOptionPane.showMessageDialog(null, "The temperature in " + unit + " is: " + result + " " + unit);
	}

	// Temperature conversion methods

	// Converts Celsius to Fahrenheit
	private static void convertCelsiusToFahrenheit() {
		double celsius = promptForTemperature("Celsius");
		if (!Double.isNaN(celsius)) {
			double fahrenheit = (celsius * 9 / 5) + 32;
			showResult(fahrenheit, "Fahrenheit");
		}
	}

	// Converts Fahrenheit to Celsius
	private static void convertFahrenheitToCelsius() {
		double fahrenheit = promptForTemperature("Fahrenheit");
		if (!Double.isNaN(fahrenheit)) {
			double celsius = (fahrenheit - 32) * 5 / 9;
			showResult(celsius, "Celsius");
		}
	}

	// Converts Celsius to Kelvin
	private static void convertCelsiusToKelvin() {
		double celsius = promptForTemperature("Celsius");
		if (!Double.isNaN(celsius)) {
			double kelvin = celsius + 273.15;
			showResult(kelvin, "Kelvin");
		}
	}

	// Converts Kelvin to Celsius
	private static void convertKelvinToCelsius() {
		double kelvin = promptForTemperature("Kelvin");
		if (!Double.isNaN(kelvin)) {
			double celsius = kelvin - 273.15;
			showResult(celsius, "Celsius");
		}
	}

	// Converts Fahrenheit to Rankine
	private static void convertFahrenheitToRankine() {
		double fahrenheit = promptForTemperature("Fahrenheit");
		if (!Double.isNaN(fahrenheit)) {
			double rankine = fahrenheit + 459.67;
			showResult(rankine, "Rankine");
		}
	}

	// Converts Rankine to Fahrenheit
	private static void convertRankineToFahrenheit() {
		double rankine = promptForTemperature("Rankine");
		if (!Double.isNaN(rankine)) {
			double fahrenheit = rankine - 459.67;
			showResult(fahrenheit, "Fahrenheit");
		}
	}

	// Converts Kelvin to Rankine
	private static void convertKelvinToRankine() {
		double kelvin = promptForTemperature("Kelvin");
		if (!Double.isNaN(kelvin)) {
			double rankine = kelvin * 9 / 5;
			showResult(rankine, "Rankine");
		}
	}

	// Converts Rankine to Kelvin
	private static void convertRankineToKelvin() {
		double rankine = promptForTemperature("Rankine");
		if (!Double.isNaN(rankine)) {
			double kelvin = rankine * 5 / 9;
			showResult(kelvin, "Kelvin");
		}
	}
}
