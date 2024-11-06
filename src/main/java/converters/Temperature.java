package converters;

public class Temperature {
	
	public double fromCelciusToFahrenheit(double celciusDegrees) {
		return celciusDegrees * 1.8 + 32;
	}
	
	public double fromCelciusToKelvin(double celciusDegrees) {
		return celciusDegrees + 273.15;
	}
	
	public double fromCelciusToRankine(double celciusDegrees) {
		return (celciusDegrees + 273.15) * 1.8;
	}
	
	public double fromCelciusToReaumur(double celciusDegrees) {
		return celciusDegrees * 4 / 5;
	}
	
	public double fromFahrenheitToCelcius(double fahrenheitDegrees) {
		return (fahrenheitDegrees - 32) / 1.8;
	}
	
	public double fromFahrenheitToKelvin(double fahrenheitDegrees) {
		return (fahrenheitDegrees + 459.67) / 1.8;
	}
	
	public double fromFahrenheitToRankine(double fahrenheitDegrees) {
		return (fahrenheitDegrees + 459.67);
	}
	
	public double fromFahrenheitToReaumur(double fahrenheitDegrees) {
		return (fahrenheitDegrees - 32) / 2.25;
	}
	
	public double fromKelvinToCelcius(double kelvinDegrees) {
		return kelvinDegrees - 273.15;
	}
	
	public double fromKelvinToFahrenheit(double kelvinDegrees) {
		return kelvinDegrees * 1.8 - 459.67;
	}
	
	public double fromKelvinToRankine(double kelvinDegrees) {
		return kelvinDegrees * 1.8;
	}
	
	public double fromKelvinToReaumur(double kelvinDegrees) {
		return (kelvinDegrees - 273.15) * 0.8;
	}
	
	public double fromRankineToCelcius(double rankineDegrees) {
		return (rankineDegrees * 5 / 9) - 273.15;
	}
	
	public double fromRankineToFahrenheit(double rankineDegrees) {
		return rankineDegrees - 459.67;
	}
	
	public double fromRankineToKelvin(double rankineDegrees) {
		return rankineDegrees * 5 / 9;
	}
	
	public double fromRankineToReamur(double rankineDegrees) {
		return (rankineDegrees - 491.67) * 4 / 9;
	}
	
	public double fromReamurToCelcius(double reamurDegrees) {
		return reamurDegrees * 5 / 4;
	}
	
	public double fromReamurToFahrenheit(double reamurDegrees) {
		return (reamurDegrees * 9 / 4) + 32;
	}
	
	public double fromReamurToKelvin(double reamurDegrees) {
		return (reamurDegrees * 5 / 4) + 273.15;
	}
	
	public double fromReamurToRankine(double reamurDegrees) {
		return (reamurDegrees * 9 / 4) + 491.67;
	}
	
	
}
