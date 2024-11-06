package converters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LengthConverterTest {
	
	@Test
	void heightInCmToFeetTest() {
		Temperature conv = new Temperature();
		Assertions.assertEquals( 50.0, conv.fromCelciusToFahrenheit(10));
	}
	
	@Test
	void fromCelciusToKelvinTest() {
		Temperature conv = new Temperature();
		Assertions.assertEquals( 283.15, conv.fromCelciusToKelvin(10));
	}
	
	@Test
	void fromCelciusToRankineTest() {
		Temperature conv = new Temperature();
		Assertions.assertEquals( 509.66999999999996, conv.fromCelciusToRankine(10));
	}
	
	@Test
	void fromCelciusToReaumurTest() {
		Temperature conv = new Temperature();
		Assertions.assertEquals( 8.0, conv.fromCelciusToReaumur(10));
	}
	
	@Test
	void fromFahrenheitToCelciusTest() {
		Temperature conv = new Temperature();
		Assertions.assertEquals( -12.222222222222221, conv.fromFahrenheitToCelcius(10));
	}
	
	@Test
	void fromFahrenheitToKelvinTest() {
		Temperature conv = new Temperature();
		Assertions.assertEquals( 260.9277777777778, conv.fromFahrenheitToKelvin(10));
	}
	
	@Test
	void fromFahrenheitToRankineTest() {
		Temperature conv = new Temperature();
		Assertions.assertEquals( 469.67, conv.fromFahrenheitToRankine(10));
	}
	
	@Test
	void fromFahrenheitToReaumurTest() {
		Temperature conv = new Temperature();
		Assertions.assertEquals( -9.777777777777779, conv.fromFahrenheitToReaumur(10));
	}
	
	@Test
	void fromKelvinToCelciusTest() {
		Temperature conv = new Temperature();
		Assertions.assertEquals( -263.15, conv.fromKelvinToCelcius(10));
	}
	
	@Test
	void fromKelvinToFahrenheitTest() {
		Temperature conv = new Temperature();
		Assertions.assertEquals( -441.67, conv.fromKelvinToFahrenheit(10));
	}
	
	@Test
	void fromKelvinToRankineTest() {
		Temperature conv = new Temperature();
		Assertions.assertEquals( 18.0, conv.fromKelvinToRankine(10));
	}
	
	@Test
	void fromKelvinToReaumurTest() {
		Temperature conv = new Temperature();
		Assertions.assertEquals( -210.51999999999998, conv.fromKelvinToReaumur(10));
	}
	
	@Test
	void fromRankineToCelciusTest() {
		Temperature conv = new Temperature();
		Assertions.assertEquals( -267.59444444444443, conv.fromRankineToCelcius(10));
	}
	
	@Test
	void fromRankineToFahrenheitTest() {
		Temperature conv = new Temperature();
		Assertions.assertEquals( -449.67, conv.fromRankineToFahrenheit(10));
	}
	
	@Test
	void fromRankineToKelvinTest() {
		Temperature conv = new Temperature();
		Assertions.assertEquals( 5.555555555555555, conv.fromRankineToKelvin(10));
	}
	
	@Test
	void fromRankineToReamurTest() {
		Temperature conv = new Temperature();
		Assertions.assertEquals( -214.07555555555555, conv.fromRankineToReamur(10));
	}
	
	@Test
	void fromReamurToCelciusTest() {
		Temperature conv = new Temperature();
		Assertions.assertEquals( 12.5, conv.fromReamurToCelcius(10));
	}
	
	@Test
	void fromReamurToFahrenheitTest() {
		Temperature conv = new Temperature();
		Assertions.assertEquals( 54.5, conv.fromReamurToFahrenheit(10));
	}
	
	@Test
	void fromReamurToKelvinTest() {
		Temperature conv = new Temperature();
		Assertions.assertEquals( 285.65, conv.fromReamurToKelvin(10));
	}
	
	@Test
	void fromReamurToRankineTest() {
		Temperature conv = new Temperature();
		Assertions.assertEquals( 514.1700000000001, conv.fromReamurToRankine(10));
	}
	
}
