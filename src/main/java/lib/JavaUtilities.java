package lib;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaUtilities {
	
	String getCurrentMethodName(Integer index) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		return stackTrace[(index == null) ? stackTrace.length-1 : index].getMethodName();
	}
	
	public String getOSName() {
		return System.getProperty("os.name");
	}
	
	/**
	 * Use new Object(){} as parameter.
	 * @param classObj
	 * @return
	 */
	Optional<String> getAnnotationMethod(Object classObj) {
		return Optional.ofNullable(classObj.getClass().getEnclosingMethod().getAnnotations()[0].toString());
	}
	
	Double formatDoubleNumber(double number, String format) {
		if(format == null || format.isBlank()) format = "#.0#";
		String roundedNumber = (new DecimalFormat(format, DecimalFormatSymbols.getInstance(Locale.US))).format(number);
		return Double.parseDouble(roundedNumber);
	}
	
	String invertText(String text) {
		char[] wordArray = text.toCharArray();
		StringBuilder bld = new StringBuilder();
		  for (int i = wordArray.length-1; i >= 0 ; --i) {
		    bld.append(wordArray[i]);
		  }
		  return bld.toString();
	}
	
	boolean isPalindromo(String word) {
		String test = invertText(word);
		return test.equals(word); 
	}
	
	void gameLoop(int totalSeconds) {
		long lastTime = System.currentTimeMillis();
		int counter = 1;
		
		int frames = 0;
		int framesLimit = 30;
		double nanoFrameRate = 1000000000/(double)framesLimit;
		long nanosLast = System.nanoTime();
		long nanosNow = 0;
		double delta = 0;
		
		while(counter <= totalSeconds) {
			nanosNow = System.nanoTime();
			delta += (nanosNow-nanosLast)/nanoFrameRate;
			nanosLast = nanosNow;
			
			if(delta >= 1) {
				frames++;
				delta--;
			}
			
			if(System.currentTimeMillis() - lastTime > 1000) {
				lastTime+=1000;
				Logger logger = Logger.getLogger(this.getClass().getName());
				logger.log(Level.INFO, "GAME IS RUNNING | {0}", "FOR: "+counter+" SECONDS\tFPS: "+frames);
				counter++;
				frames = 0;
			}
		}
	}
	
	
	
	
	
}
