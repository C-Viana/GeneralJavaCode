package lib;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import annotations.MyAnnotation;

@Execution(ExecutionMode.CONCURRENT)
class JavaUtilitiesTest {
	
	private JavaUtilities ju = null;
	
	@Test
	void getCurrentMethodNameTest() {
		ju = new JavaUtilities();
		Assertions.assertEquals("getCurrentMethodNameTest", ju.getCurrentMethodName(2));
	}
	
	@Test
	void getOSNameTest() {
		ju = new JavaUtilities();
		Assertions.assertEquals("Windows 10", ju.getOSName());
	}
	
	@Test
	void getCurrentMethodNameNullParamTest() {
		ju = new JavaUtilities();
		String test = ju.getCurrentMethodName(null);
		Assertions.assertNotEquals("getCurrentMethodNameTest", test);
		Assertions.assertTrue(test.equals("run") || test.equals("main"));
	}
	
	@MyAnnotation("Test annotation method") @Test
	void getAnnotationMethodTest() {
		ju = new JavaUtilities();
		Assertions.assertEquals( "@annotations.MyAnnotation(value=\"Test annotation method\")", ju.getAnnotationMethod(new Object(){}).orElse(null) );
	}
	
	@Test
	void formatDoubleNumberTest() {
		ju = new JavaUtilities();
		Assertions.assertEquals( 5.05, ju.formatDoubleNumber(5.05, null));
		Assertions.assertEquals( 4.56, ju.formatDoubleNumber(4.56, ""));
		Assertions.assertEquals( 5.5, ju.formatDoubleNumber(5.45, "#.#"));
		Assertions.assertEquals( 5.05, ju.formatDoubleNumber(5.052, "#.0#"));
		Assertions.assertEquals( 5.06, ju.formatDoubleNumber(5.056, "#.0#"));
	}
	
	@Test
	void invertTextTest() {
		ju = new JavaUtilities();
		Assertions.assertEquals("retrevni arap otxeT", ju.invertText("Texto para inverter"));
	}
	
	@Test
	void isPalindromoTest() {
		ju = new JavaUtilities();
		Assertions.assertEquals(true, ju.isPalindromo("arara"));
		Assertions.assertEquals(true, ju.isPalindromo("aibofobia"));
		Assertions.assertEquals(true, ju.isPalindromo("omissíssimo"));
		Assertions.assertEquals(true, ju.isPalindromo("osso"));
		Assertions.assertEquals(true, ju.isPalindromo("reviver"));
		Assertions.assertEquals(true, ju.isPalindromo("radar"));
		Assertions.assertEquals(true, ju.isPalindromo("sopapos"));
		Assertions.assertEquals(false, ju.isPalindromo("palavra"));
	}
	
	@Test
	void gameLoopTest() {
		ju = new JavaUtilities();
		Assertions.assertDoesNotThrow( () -> ju.gameLoop(3) );
	}
	
}
