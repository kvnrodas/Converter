package gt.com.gm.main;

import javax.swing.*;

import gt.com.gm.converter.CurrencyConverter;
import gt.com.gm.converter.TemperatureConverter;
import gt.com.gm.*;

public class Main {

	public static void main(String[] args) {

		// Create instances of CurrencyConverter and TemperatureConverter classes.
		CurrencyConverter currencyConverter = new CurrencyConverter();
		TemperatureConverter temperatureConverter = new TemperatureConverter();

		// Define the options for the main menu.
		String[] mainOptions = { "Currency Converter", "Temperature Converter" };

		// Show a dialog box to the user with the main menu options.
		int mainChoice = JOptionPane.showOptionDialog(null, "Select Option", "Main Menu", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, mainOptions, mainOptions[0]);

		// Perform an action based on the main option selected.
		switch (mainChoice) {
		case 0:
			// If "Currency Converter" is selected, execute the currency conversion
			// operation.
			currencyConverter.operationCurrency();
			break;
		case 1:
			// If "Temperature Converter" is selected, execute the temperature conversion
			// operation.
			temperatureConverter.operationTemperature();
			break;
		default:
			// If the user closed the window or clicked Cancel, exit the program.
			System.exit(0);
		}
	}
}
