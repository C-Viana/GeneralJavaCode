package converters;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Length {
	
	public String heightInCmToFeet(double heightInCentimeters) {
		double feet = Math.floor(centimetersToInches(heightInCentimeters) / 12);
		double inches = centimetersToInches(heightInCentimeters) % 12;
		String formatedHeight = new DecimalFormat("#", DecimalFormatSymbols.getInstance(Locale.US)).format(feet);
		formatedHeight += "'" + new DecimalFormat("#", DecimalFormatSymbols.getInstance(Locale.US)).format(inches) + "\"";
		return formatedHeight;
	}
	
	public double centimetersToInches(double centimeters) {
		return centimeters * 0.393701;
	}
	
	public double centimetersToFeet(double centimeters) {
		return centimeters * 0.0328084;
	}
	
	public double centimetersToYards(double centimeters) {
		return centimeters * 0.0109361;
	}
	
	public double kilometersToMiles(double kilometers) {
		return kilometers * 0.621371;
	}
	
	public double kilometersToLeagues(double kilometers) {
		return kilometers * 0.207124;
	}
	
	public double inchesToCentimeters(double inches) {
		return inches * 2.54;
	}
	
	public double feetToCentimeters(double feet) {
		return feet * 30.48;
	}
	
	public double yardsToCentimeters(double yards) {
		return yards * 91.44;
	}
	
	public double milesToKilometers(double miles) {
		return miles * 1.609344;
	}
	
	public double leaguesToKilometers(double leagues) {
		return leagues * 4.82803;
	}
	
	
}
