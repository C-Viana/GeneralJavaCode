package lib;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import exceptions.InvalidHourException;
import exceptions.InvalidMinutesException;
import exceptions.InvalidSecondsException;

@Execution(ExecutionMode.CONCURRENT)
class TimeHandlerTest {
	
	@Test
	void getLocalTimeZoneTest() {
		Assertions.assertEquals("America/Sao_Paulo", new TimeHandler().getLocalTimeZone());
	}
	
	@Test
	void getCurrentTimeTest() {
		String test = new TimeHandler().getCurrentTime().toString();
		System.out.println(test);
		Assertions.assertTrue( Pattern.matches("\\d{2}:\\d{2}:\\d{2}.\\d{1,9}", test) );
	}
	
	@Test
	void getCurrentTimeAsStringTest() {
		Assertions.assertTrue( Pattern.matches("\\d{2}:\\d{2}:\\d{2}", new TimeHandler().getCurrentTimeAsString(null)) );
		Assertions.assertTrue( Pattern.matches("\\d{2}:\\d{2}:\\d{2}", new TimeHandler().getCurrentTimeAsString("")) );
		Assertions.assertTrue( Pattern.matches("\\d{2}:\\d{2}:\\d{2}", new TimeHandler().getCurrentTimeAsString("   ")) );
		Assertions.assertTrue( Pattern.matches("\\d{1,2}-\\d{2}-\\d{2}", new TimeHandler().getCurrentTimeAsString("H-mm-ss")) );
		Assertions.assertTrue( Pattern.matches("\\d{1,2}\\ \\d{1,2}\\ \\d{2}", new TimeHandler().getCurrentTimeAsString("H m ss")) );
		Assertions.assertTrue( Pattern.matches("\\d{1,2}-\\d{1,2}-\\d{1,2}", new TimeHandler().getCurrentTimeAsString("h-m-s")) );
	}
	
	@Test
	void getTimeAsString() {
		LocalTime t = LocalTime.of(9, 9, 9);
		DateTimeFormatter.ofPattern("HH:mm:ss").format( t );
		
		String test = new TimeHandler().getTimeAsString(t, null);
		
		Assertions.assertTrue( Pattern.matches("\\d{2}:\\d{2}:\\d{2}", test) );
		Assertions.assertEquals( "09:09:09", test );
		
		test = new TimeHandler().getTimeAsString(t, "");
		Assertions.assertTrue( Pattern.matches("\\d{2}:\\d{2}:\\d{2}", test) );
		Assertions.assertEquals( "09:09:09", test );
		
		test = new TimeHandler().getTimeAsString(t, "   ");
		Assertions.assertTrue( Pattern.matches("\\d{2}:\\d{2}:\\d{2}", test) );
		Assertions.assertEquals( "09:09:09", test );
		
		test = new TimeHandler().getTimeAsString(t, "H-mm-ss");
		Assertions.assertTrue( Pattern.matches("\\d{1,2}-\\d{2}-\\d{2}", test) );
		Assertions.assertEquals( "9-09-09", test );
		
		test = new TimeHandler().getTimeAsString(t, "H m ss");
		Assertions.assertTrue( Pattern.matches("\\d{1,2}\\ \\d{1,2}\\ \\d{2}", test) );
		Assertions.assertEquals( "9 9 09", test );
		
		test = new TimeHandler().getTimeAsString(t, "H m s");
		Assertions.assertTrue( Pattern.matches("\\d{1,2}\\ \\d{1,2}\\ \\d{1,2}", test) );
		Assertions.assertEquals( "9 9 9", test );
	}
	
	@Test
	void setTimeTest() {
		LocalTime hour = new TimeHandler().setTime(16, 20, 33);
		String test = new TimeHandler().getTimeAsString(hour, "hh:m:s");
		
		Assertions.assertTrue( Pattern.matches("\\d{2}:\\d{1,2}:\\d{1,2}", test) );
		Assertions.assertEquals( "04:20:33", test );
	}
	
	@Test
	void changeTimeTest() {
		LocalTime initHour = LocalTime.of(9, 10, 20);
		LocalTime testHour = new TimeHandler().adjustTime(initHour, 16, 20, 33);
		
		String hourAsString = new TimeHandler().getTimeAsString(testHour, "hh:m:s");
		Assertions.assertTrue( Pattern.matches("\\d{2}:\\d{1,2}:\\d{1,2}", hourAsString) );
		Assertions.assertEquals( "01:30:53", hourAsString );
	}
	
	@Test
	void getHoursIntervalTest() {
		LocalTime initHour = LocalTime.of(9, 10, 20);
		LocalTime endHour = LocalTime.of(10, 20, 30);
		Long test = new TimeHandler().getHoursInterval(initHour, endHour);
		Assertions.assertEquals( 1, test );
	}
	
	@Test
	void getMinutesIntervalTest() {
		LocalTime initHour = LocalTime.of(9, 10, 20);
		LocalTime endHour = LocalTime.of(10, 20, 30);
		Long test = new TimeHandler().getMinutesInterval(initHour, endHour);
		Assertions.assertEquals( 70, test );
	}
	
	@Test
	void getSecondsIntervalTest() {
		LocalTime initHour = LocalTime.of(9, 10, 20);
		LocalTime endHour = LocalTime.of(10, 20, 30);
		Long test = new TimeHandler().getSecondsInterval(initHour, endHour);
		Assertions.assertEquals( 4210, test );
	}
	
	@Test
	void invalidHourLessThan0ExceptionTest() {
		TimeHandler th = new TimeHandler();
		InvalidHourException thrown = Assertions.assertThrows(InvalidHourException.class, () -> th.setTime(-1, 30, 30));
		Assertions.assertEquals( "Invalid value for argument HOUR. It has to be a positive number between 0 and 23.", thrown.getMessage() );
	}
	
	@Test
	void invalidHourHigherThan23ExceptionTest() {
		TimeHandler th = new TimeHandler();
		InvalidHourException thrown = Assertions.assertThrows(InvalidHourException.class, () -> th.setTime(24, 30, 30));
		Assertions.assertEquals( "Invalid value for argument HOUR. It has to be a positive number between 0 and 23.", thrown.getMessage() );
	}
	
	@Test
	void invalidHourCustomMessageExceptionTest() {
		InvalidHourException thrown = new InvalidHourException("Custom Error Message");
		Assertions.assertEquals( "Custom Error Message", thrown.getMessage() );
	}
	
	@Test
	void invalidMinutesLessThan0ExceptionTest() {
		TimeHandler th = new TimeHandler();
		InvalidMinutesException thrown = Assertions.assertThrows(InvalidMinutesException.class, () -> th.setTime(12, -2, 30));
		Assertions.assertEquals( "Invalid value for argument MINUTES. It has to be a positive number between 0 and 59.", thrown.getMessage() );
	}
	
	@Test
	void invalidMinutesHigherThan59ExceptionTest() {
		TimeHandler th = new TimeHandler();
		InvalidMinutesException thrown = Assertions.assertThrows(InvalidMinutesException.class, () -> th.setTime(12, 60, 30));
		Assertions.assertEquals( "Invalid value for argument MINUTES. It has to be a positive number between 0 and 59.", thrown.getMessage() );
	}
	
	@Test
	void invalidMinutesCustomMessageExceptionTest() {
		InvalidMinutesException thrown = new InvalidMinutesException("Custom Error Message");
		Assertions.assertEquals( "Custom Error Message", thrown.getMessage() );
	}
	
	@Test
	void invalidSecondsLessThan0ExceptionTest() {
		TimeHandler th = new TimeHandler();
		InvalidSecondsException thrown = Assertions.assertThrows(InvalidSecondsException.class, () -> th.setTime(12, 0, -3));
		Assertions.assertEquals( "Invalid value for argument SECONDS. It has to be a positive number between 0 and 59.", thrown.getMessage() );
	}
	
	@Test
	void invalidSecondsHigherThan59ExceptionTest() {
		TimeHandler th = new TimeHandler();
		InvalidSecondsException thrown = Assertions.assertThrows(InvalidSecondsException.class, () -> th.setTime(12, 0, 60));
		Assertions.assertEquals( "Invalid value for argument SECONDS. It has to be a positive number between 0 and 59.", thrown.getMessage() );
	}
	
	@Test
	void invalidSecondsCustomMessageExceptionTest() {
		InvalidSecondsException thrown = new InvalidSecondsException("Custom Error Message");
		Assertions.assertEquals( "Custom Error Message", thrown.getMessage() );
	}
	
}
