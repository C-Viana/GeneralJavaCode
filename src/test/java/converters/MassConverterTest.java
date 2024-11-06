package converters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MassConverterTest {
	
	Mass m = new Mass();
	
	@Test
	void gramsToKilogramsTest() {
		Assertions.assertEquals(58.0, m.gramsToKilograms(58000.0));
	}
	
	@Test
	void gramsToPoundsTest() {
		Assertions.assertEquals(127.86596119929453, m.gramsToPounds(58000.0));
	}
	
	@Test
	void gramsToOuncesTest() {
		Assertions.assertEquals(2045.8553791887125, m.gramsToOunces(58000.0));
	}
	
	@Test
	void gramsToStonesTest() {
		Assertions.assertEquals(9.133858267716535, m.gramsToStones(58000.0));
	}
	
	@Test
	void kilogramsToGramsTest() {
		Assertions.assertEquals(58000.0, m.kilogramsToGrams(58.0));
	}
	
	@Test
	void kilogramsToPoundsTest() {
		Assertions.assertEquals(127.89, m.kilogramsToPounds(58.0));
	}
	
	@Test
	void kilogramsToOuncesTest() {
		Assertions.assertEquals(2045.892, m.kilogramsToOunces(58.0));
	}
	
	@Test
	void kilogramsToStonesTest() {
		Assertions.assertEquals(9.133858267716535, m.kilogramsToStones(58.0));
	}
	
	@Test
	void poundsToGramsTest() {
		Assertions.assertEquals(58000.879440000004, m.poundsToGrams(127.8679));
	}
	
	@Test
	void poundsToKilogramsTest() {
		Assertions.assertEquals(57.98997732426304, m.poundsToKilograms(127.8679));
	}
	
	@Test
	void poundsToOuncesTest() {
		Assertions.assertEquals(2045.8864, m.poundsToOunces(127.8679));
	}
	
	@Test
	void poundsToStonesTest() {
		Assertions.assertEquals(9.13342142857143, m.poundsToStones(127.8679));
	}
	
	@Test
	void ouncesToGramsTest() {
		Assertions.assertEquals(58001.0382, m.ouncesToGrams(2045.892));
	}
	
	@Test
	void ouncesToKilogramsTest() {
		Assertions.assertEquals(58.0, m.ouncesToKilograms(2045.892));
	}
	
	@Test
	void ouncesToPoundsTest() {
		Assertions.assertEquals(127.86825, m.ouncesToPounds(2045.892));
	}
	
	@Test
	void ouncesToStonesTest() {
		Assertions.assertEquals(9.133446428571428, m.ouncesToStones(2045.892));
	}
	
	@Test
	void stonesToGramsTest() {
		Assertions.assertEquals(57997.3059, m.stonesToGrams(9.133434));
	}
	
	@Test
	void stonesToKilogramsTest() {
		Assertions.assertEquals(57.99730589999999, m.stonesToKilograms(9.133434));
	}
	
	@Test
	void stonesToPoundsTest() {
		Assertions.assertEquals(127.86807599999999, m.stonesToPounds(9.133434));
	}
	
	@Test
	void stonesToOuncesTest() {
		Assertions.assertEquals(2045.8892159999998, m.stonesToOunces(9.133434));
	}
	
}
