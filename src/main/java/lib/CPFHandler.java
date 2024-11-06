package lib;

import java.security.SecureRandom;
import java.util.regex.Pattern;

public class CPFHandler {
	
	private SecureRandom random = new SecureRandom();
	private byte[] bytes;
	
	public CPFHandler() {
		bytes = new byte[20];
		random.nextBytes(bytes);
	}
	
	private int[] generateCPFBaseRandomNumber() {
		int[] numbers = new int[11];
		for (int i = 0; i < 9; i++) {
			numbers[i] = this.random.nextInt(9);
		}
		return numbers;
	}
	
	private int[] generateCPFBaseRandomNumber(String cpfNumber) {
		int[] numbers = new int[11];
		for (int i = 0; i < 9; i++) {
			numbers[i] = Short.parseShort(String.valueOf(cpfNumber.charAt(i)));
		}
		return numbers;
	}
	
	private boolean entryIsNotValid(String cpfNumber) {
		return (cpfNumber == null || cpfNumber.isBlank() || (!Pattern.matches("\\d{9,11}", cpfNumber))
				|| cpfNumber.equals("00000000000") || cpfNumber.equals("11111111111") || cpfNumber.equals("22222222222") 
				|| cpfNumber.equals("33333333333") || cpfNumber.equals("44444444444") || cpfNumber.equals("55555555555") 
				|| cpfNumber.equals("66666666666") || cpfNumber.equals("77777777777") || cpfNumber.equals("88888888888") 
				|| cpfNumber.equals("99999999999") || cpfNumber.equals("01234567890"));
	}
	
	private String rearrangeLeftZeros(String cpfNumber) {
		StringBuilder rearrangement = new StringBuilder();
		if(cpfNumber.length() < 11) {
			int diff = 11-cpfNumber.length();
			for (int i = 0; i < diff; i++) {
				rearrangement.append("0");
			}
		}
		return rearrangement.toString()+cpfNumber;
	}
	
	public boolean validateCPF(String cpfNumber) {
		if( entryIsNotValid(cpfNumber) )
			return false;
		
		cpfNumber = rearrangeLeftZeros(cpfNumber);
		
		short digit1 = Short.parseShort(String.valueOf(cpfNumber.charAt(9)));
		short digit2 = Short.parseShort(String.valueOf(cpfNumber.charAt(10)));
		short[] numbers = new short[10];
		short sumA = 0;
		short sumB = 0;
		float resultA;
		float resultB;
		
		for (int i = 0; i < 9; i++) {
			numbers[i] = Short.parseShort(String.valueOf(cpfNumber.charAt(i)));
			sumA += (numbers[i]*(1+i));
			sumB += (numbers[i]*(i));
		}
		sumB += (digit1*9);
		
		resultA = sumA%11;
		resultB = sumB%11;
		
		if( resultA > 9 ) resultA = 0;
		if( resultB > 9 ) resultB = 0;
		
		return (resultA == digit1 && resultB == digit2);
	}
	
	public String generate(String baseNumbers) {
		int[] cpfNumbers = (baseNumbers == null) ? generateCPFBaseRandomNumber() : generateCPFBaseRandomNumber(baseNumbers);
		int sumA = 0;
		int sumB = 0;
		int resultA = 0;
		int resultB = 0;
		
		for (int i = 0; i < 9; i++) {
			sumA += (cpfNumbers[i]*(1+i));
		}
		
		resultA = sumA%11;
		if( resultA > 9 ) resultA = 0;
		
		cpfNumbers[9] = resultA;
		for (int i = 0; i < 10; i++) {
			sumB += (cpfNumbers[i]*(i));
		}
		
		resultB = sumB%11;
		if( resultB > 9 ) resultB = 0;
		cpfNumbers[10] = resultB;
		
		StringBuilder newCPF = new StringBuilder();
		for (int i = 0; i < 11; i++) {
			newCPF.append(cpfNumbers[i]);
		}
		
		return newCPF.toString();
	}
	
}
