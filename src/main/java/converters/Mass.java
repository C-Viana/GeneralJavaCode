package converters;

public class Mass {
	
	public double gramsToKilograms(double grams) {
		return grams/1000.0;
	}
	
	public double gramsToPounds(double grams) {
		return grams/453.6;
	}
	
	public double gramsToOunces(double grams) {
		return grams/28.35;
	}
	
	public double gramsToStones(double grams) {
		return grams/6350.0;
	}
	
	public double kilogramsToGrams(double kilograms) {
		return kilograms*1000;
	}
	
	public double kilogramsToPounds(double kilograms) {
		return kilograms*2.205;
	}
	
	public double kilogramsToOunces(double kilograms) {
		return kilograms*35.274;
	}
	
	public double kilogramsToStones(double kilograms) {
		return kilograms/6.35;
	}
	
	public double poundsToGrams(double pounds) {
		return pounds*453.6;
	}
	
	public double poundsToKilograms(double pounds) {
		return pounds/2.205;
	}
	
	public double poundsToOunces(double pounds) {
		return pounds*16;
	}
	
	public double poundsToStones(double pounds) {
		return pounds/14;
	}
	
	public double ouncesToGrams(double ounces) {
		return ounces*28.35;
	}
	
	public double ouncesToKilograms(double ounces) {
		return ounces/35.274;
	}
	
	public double ouncesToPounds(double ounces) {
		return ounces/16;
	}
	
	public double ouncesToStones(double ounces) {
		return ounces/224;
	}
	
	public double stonesToGrams(double stones) {
		return stones*6350.0;
	}
	
	public double stonesToKilograms(double stones) {
		return stones*6.35;
	}
	
	public double stonesToPounds(double stones) {
		return stones*14;
	}
	
	public double stonesToOunces(double stones) {
		return stones*224;
	}
	
}
