package gt.com.gm.converter;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class CurrencyConverter {

	public CurrencyConverter() {
	}

	private static final HttpClient httpClient = HttpClient.newHttpClient();
	private static final String API_BASE_URL = "https://api.exchangerate-api.com/v4/latest/";

	// List of ISO 4217 currency codes
	private static final List<String> validCurrencies = Arrays.asList("AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS",
			"AUD", "AWG", "AZN", "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL", "BSD", "BTN",
			"BWP", "BYN", "BZD", "CAD", "CDF", "CHF", "CLP", "CNY", "COP", "CRC", "CUP", "CVE", "CZK", "DJF", "DKK",
			"DOP", "DZD", "EGP", "ERN", "ETB", "EUR", "FJD", "FKP", "FOK", "GBP", "GEL", "GGP", "GHS", "GIP", "GMD",
			"GNF", "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF", "IDR", "ILS", "IMP", "INR", "IQD", "IRR", "ISK",
			"JEP", "JMD", "JOD", "JPY", "KES", "KGS", "KHR", "KID", "KIN", "KMF", "KRW", "KWD", "KYD", "KZT", "LAK",
			"LBP", "LKR", "LRD", "LSL", "LYD", "MAD", "MDL", "MGA", "MKD", "MMK", "MNT", "MOP", "MRU", "MRW", "MUR",
			"MVR", "MWK", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK",
			"PHP", "PKR", "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "RWF", "SAR", "SBD", "SCR", "SDG", "SEK", "SGD",
			"SHP", "SLL", "SOS", "SPL", "SRD", "STN", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD",
			"TVD", "TWD", "TZS", "UAH", "UGX", "USD", "UYU", "UZS", "VES", "VND", "VUV", "WST", "XAF", "XCD", "XDR",
			"XOF", "XPF", "YER", "ZAR", "ZMW", "ZWD");

	// Method to get the exchange rate from one currency to another
	public static double getExchangeRate(String fromCurrency, String toCurrency) throws Exception {
		// Validate the input currencies
		if (!validCurrencies.contains(fromCurrency) || !validCurrencies.contains(toCurrency)) {
			throw new IllegalArgumentException("Invalid currency code");
		}

		// Build the API URL
		String apiUrl = API_BASE_URL + fromCurrency;

		// Create an HTTP request
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).build();

		// Send the HTTP request and get the response
		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		// Parse the JSON response
		Gson gson = new Gson();
		JsonObject exchangeRateData = gson.fromJson(response.body(), JsonObject.class);

		// Extract and return the exchange rate
		return exchangeRateData.getAsJsonObject("rates").get(toCurrency).getAsDouble();
	}

	public static void operationCurrency() {
	    int answer;

	    while (true) {
	        try {
	            // Prompt the user to enter the amount and currency codes
	            String amountString = JOptionPane.showInputDialog(null, "Enter the amount:");
	            
	            // Check if the user clicked "Cancel" or closed the dialog
	            if (amountString == null) {
	                JOptionPane.showMessageDialog(null, "Program terminated");
	                return;  // exit the method if the user cancels
	            }

	            String fromCurrency = JOptionPane.showInputDialog(null, "Enter the source currency code (e.g., USD):");
	            // Check if the user clicked "Cancel" or closed the dialog
	            if (fromCurrency == null) {
	                JOptionPane.showMessageDialog(null, "Program terminated");
	                return;  // exit the method if the user cancels
	            }

	            String toCurrency = JOptionPane.showInputDialog(null, "Enter the target currency code (e.g., EUR):");
	            // Check if the user clicked "Cancel" or closed the dialog
	            if (toCurrency == null) {
	                JOptionPane.showMessageDialog(null, "Program terminated");
	                return;  // exit the method if the user cancels
	            }

	            // Convert the amount to a number
	            double amount = Double.parseDouble(amountString);

	            // Get the exchange rate
	            double exchangeRate = getExchangeRate(fromCurrency.toUpperCase(), toCurrency.toUpperCase());

	            // Calculate the result
	            double result = amount * exchangeRate;

	            // Show the result to the user
	            JOptionPane.showMessageDialog(null,
	                    amount + " " + fromCurrency + " is equivalent to " + result + " " + toCurrency, "Result",
	                    JOptionPane.INFORMATION_MESSAGE);

	            // Ask the user if they want to continue
	            answer = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Continue",
	                    JOptionPane.YES_NO_OPTION);

	            if (answer != JOptionPane.YES_OPTION) {
	                JOptionPane.showMessageDialog(null, "Program terminated");
	                return; // exit the method if the user chooses not to continue
	            }

	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
	        } catch (IllegalArgumentException e) {
	            JOptionPane.showMessageDialog(null, "Invalid currency code.", "Error", JOptionPane.ERROR_MESSAGE);
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error fetching exchange rate.", "Error",
	                    JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}

	}


