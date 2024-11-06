package lib;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
class CPFHandlerTest {
	private CPFHandler handler = new CPFHandler();
	
	@Test
	void validCPFTest() {
		Assertions.assertTrue(handler.validateCPF("30333162200"));
		Assertions.assertTrue(handler.validateCPF("72048199003"));
		Assertions.assertTrue(handler.validateCPF("25146653020"));
		Assertions.assertTrue(handler.validateCPF("43169299093"));
	}
	
	@Test
	void validCPFWithZeroAtLeftTest() {
		Assertions.assertTrue(handler.validateCPF("7910376812"));
	}
	
	@Test
	void invalidCPFTest() {
		Assertions.assertFalse(handler.validateCPF("72048189003"));
		Assertions.assertFalse(handler.validateCPF("43169299033"));
		Assertions.assertFalse(handler.validateCPF("43169299099"));
	}
	
	@Test
	void nullCPFTest() {
		Assertions.assertFalse(handler.validateCPF(null));
	}
	
	@Test
	void blankCPFTest() {
		Assertions.assertFalse(handler.validateCPF(""));
		Assertions.assertFalse(handler.validateCPF("           "));
	}
	
	@Test
	void repetitiveNumbersCPFTest() {
		Assertions.assertFalse(handler.validateCPF("00000000000"));
		Assertions.assertFalse(handler.validateCPF("11111111111"));
		Assertions.assertFalse(handler.validateCPF("22222222222"));
		Assertions.assertFalse(handler.validateCPF("33333333333"));
		Assertions.assertFalse(handler.validateCPF("44444444444"));
		Assertions.assertFalse(handler.validateCPF("55555555555"));
		Assertions.assertFalse(handler.validateCPF("66666666666"));
		Assertions.assertFalse(handler.validateCPF("77777777777"));
		Assertions.assertFalse(handler.validateCPF("88888888888"));
		Assertions.assertFalse(handler.validateCPF("99999999999"));
		Assertions.assertFalse(handler.validateCPF("01234567890"));
	}
	
	@Test
	void incompleteCPFTest() {
		Assertions.assertFalse(handler.validateCPF("34567890"));
	}
	
	@Test
	void generateValidCPFTest() {
		String cpf = Assertions.assertDoesNotThrow( () -> handler.generate(null) );
		Assertions.assertTrue(handler.validateCPF(cpf));
	}
	
	@Test
	void generateValidCPFFirstDigitZeroTest() {
		String cpfA = handler.generate("740214190"); //04
		Assertions.assertTrue(handler.validateCPF(cpfA));
	}
	
	@Test
	void generateValidCPFSecondDigitZeroTest() {
		String cpfB = handler.generate("635807440"); //70
		Assertions.assertTrue(handler.validateCPF(cpfB));
	}
	
	@Test
	void generateValidCPFBothDigitsZeroTest() {
		String cpfC = handler.generate("004000340"); //00
		Assertions.assertTrue(handler.validateCPF(cpfC));
	}
	
	@Test
	void generateValidCPFNeitherDigitsZeroTest() {
		String cpfD = handler.generate("355870820"); //24
		Assertions.assertTrue(handler.validateCPF(cpfD));
	}
	
}
