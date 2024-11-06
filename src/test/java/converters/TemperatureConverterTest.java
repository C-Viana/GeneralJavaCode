package converters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TemperatureConverterTest {
	
	@Test
	void heightInCmToFeetTest() {
		Length conv = new Length();
		Assertions.assertEquals( "5'9\"", conv.heightInCmToFeet(175));
	}
	
	@Test
	void centimetersToInchesTest() {
		Length conv = new Length();
		Assertions.assertEquals( 68.897675, conv.centimetersToInches(175));
	}
	
	@Test
	void centimetersToFeetTest() {
		Length conv = new Length();
		Assertions.assertEquals( 5.7414700000000005, conv.centimetersToFeet(175));
	}
	
	@Test
	void centimetersToYardsTest() {
		Length conv = new Length();
		Assertions.assertEquals( 1.9138175000000002, conv.centimetersToYards(175));
	}
	
	@Test
	void kilometersToMilesTest() {
		Length conv = new Length();
		Assertions.assertEquals( 108.739925, conv.kilometersToMiles(175));
	}
	
	@Test
	void kilometersToLeaguesTest() {
		Length conv = new Length();
		Assertions.assertEquals( 36.2467, conv.kilometersToLeagues(175));
	}
	
	@Test
	void inchesToCentimetersTest() {
		Length conv = new Length();
		Assertions.assertEquals( 444.5, conv.inchesToCentimeters(175));
	}
	
	@Test
	void feetToCentimetersTest() {
		Length conv = new Length();
		Assertions.assertEquals( 5334.0, conv.feetToCentimeters(175));
	}
	
	@Test
	void yardsToCentimetersTest() {
		Length conv = new Length();
		Assertions.assertEquals( 16002.0, conv.yardsToCentimeters(175));
	}
	
	@Test
	void milesToKilometersTest() {
		Length conv = new Length();
		Assertions.assertEquals( 281.6352, conv.milesToKilometers(175));
	}
	
	@Test
	void leaguesToKilometersTest() {
		Length conv = new Length();
		Assertions.assertEquals( 844.90525, conv.leaguesToKilometers(175));
	}
	
}
