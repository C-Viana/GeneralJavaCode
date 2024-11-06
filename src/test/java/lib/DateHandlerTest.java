package lib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import exceptions.InvalidDayException;
import exceptions.InvalidMonthException;
import exceptions.InvalidYearException;

@Execution(ExecutionMode.CONCURRENT)
class DateHandlerTest {
	
	private static DateHandler handler = null;
	
	@BeforeAll
	static void setup() {
		handler = new DateHandler();
	}
	
	@Test
	void getDateAsStringTest() {
		LocalDate date = LocalDate.of(2025, 7, 12);
		assertTrue( Pattern.matches( "\\d{2}\\/\\d{2}\\/\\d{4}", handler.getDateAsString(date, "dd/MM/yyyy")) );
	}
	
	@Test
	void getDateAsStringInvalidArgsTest() {
		LocalDate date = LocalDate.of(2025, 7, 12);
		assertTrue( Pattern.matches( "\\d{2}\\/\\d{2}\\/\\d{4}", handler.getDateAsString(date, null)) );
		assertTrue( Pattern.matches( "\\d{2}\\/\\d{2}\\/\\d{4}", handler.getDateAsString(date, " ")) );
		assertTrue( Pattern.matches( "\\d{2}\\/\\d{2}\\/\\d{4}", handler.getDateAsString(date, "")) );
		assertTrue( Pattern.matches( "Date argument must not be null.", handler.getDateAsString(null, null)) );
		assertTrue( Pattern.matches( "Format argument must not contain specific values like \"MM/dd/yyyy\", \"dd MMM yyyy\", \"MM-dd-yy\", etc.", handler.getDateAsString(date, "yyyy+xx+dd")) );
	}
	
	@Test
	void getCurrentDateTest() {
		Date currentDate = new Date();
		String formatedDate = new SimpleDateFormat("yyyy-MM-dd").format(currentDate);
		LocalDate testDate = handler.getCurrentDate();
		assertEquals( formatedDate, testDate.toString() );
	}
	
	@Test
	void getCurrentDateAsStringTest() {
		String dateFormat = "dd/MM/yyyy";
		String testDate = handler.getCurrentDateAsString(dateFormat);
		
		assertTrue( Pattern.matches( "\\d{2}\\/\\d{2}\\/\\d{4}", testDate) );
	}
	
	@Test
	void getDateTest() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2016, 8, 20, 0, 0, 0);
		Date date = new Date();
		date.setTime(calendar.getTimeInMillis());
		String formatedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
		LocalDate testDate = handler.getDate(2016, 9, 20);
		
		assertTrue( Pattern.matches( "\\d{2}\\/\\d{2}\\/\\d{4}", handler.getDateAsString(testDate, "dd/MM/yyyy")) );
		assertEquals( formatedDate, testDate.toString() );
	}
	
	@Test
	void changeDateTest() {
		int daysToChange = 3;
		int monthsToChange = 1;
		int yearsToChange = 1;
		LocalDate ld = LocalDate.now();
		ld = ld.plusDays(daysToChange).plusMonths(monthsToChange).plusYears(yearsToChange);
		
		String expectedDate = 
				((ld.getDayOfMonth() < 10) ? "0"+ld.getDayOfMonth() : ld.getDayOfMonth()) +"/"+
				((ld.getMonthValue() < 10) ? "0"+ ld.getMonthValue() : ld.getMonthValue())+"/"+
				((ld.getYear() < 10) ? "0" + ld.getYear() : ld.getYear());
		
		LocalDate testDate = handler.changeDate(yearsToChange, monthsToChange, daysToChange);
		String formatedTestDate = handler.getDateAsString(testDate, "dd/MM/yyyy");
		
		assertTrue( Pattern.matches( "\\d{2}\\/\\d{2}\\/\\d{4}", formatedTestDate) );
		assertEquals( expectedDate, formatedTestDate );
	}
	
	@Test
	void getDaysDifferenceTest() {
		long test0DaysDiff = handler.getDaysDifference(handler.getDate(2000, 1, 1), handler.getDate(2000, 1, 1));
		long test1DayDiff = handler.getDaysDifference(handler.getDate(2000, 1, 1), handler.getDate(2000, 1, 2));
		long test1MonthDiff = handler.getDaysDifference(handler.getDate(2000, 1, 1), handler.getDate(2000, 2, 1));
		long test1YearDiff = handler.getDaysDifference(handler.getDate(2000, 1, 1), handler.getDate(2001, 1, 1));
		long test1DayPast = handler.getDaysDifference(handler.getDate(2000, 1, 2), handler.getDate(2000, 1, 1));
		
		assertEquals( 0, test0DaysDiff );
		assertEquals( 1, test1DayDiff );
		assertEquals( 31, test1MonthDiff );
		assertEquals( 366, test1YearDiff );
		assertEquals( -1, test1DayPast );
	}
	
	@Test
	void getMonthsDifferenceTest() {
		long test0MonthsDiff = handler.getMonthsDifference(handler.getDate(2000, 1, 1), handler.getDate(2000, 1, 1));
		long test1MonthDiff = handler.getMonthsDifference(handler.getDate(2000, 3, 1), handler.getDate(2000, 4, 1));
		long test1YearDiff = handler.getMonthsDifference(handler.getDate(2000, 1, 1), handler.getDate(2001, 1, 1));
		long test1MonthPast = handler.getMonthsDifference(handler.getDate(2000, 4, 1), handler.getDate(2000, 3, 1));
		
		assertEquals( 0, test0MonthsDiff );
		assertEquals( 1, test1MonthDiff );
		assertEquals( 12, test1YearDiff );
		assertEquals( -1, test1MonthPast );
	}
	
	@Test
	void getYearsDifferenceTest() {
		long test0YearsDiff = handler.getYearsDifference(handler.getDate(2000, 1, 1), handler.getDate(2000, 1, 1));
		long test1YearDiff = handler.getYearsDifference(handler.getDate(2000, 1, 1), handler.getDate(2001, 1, 1));
		long test1YearPast = handler.getYearsDifference(handler.getDate(2001, 1, 1), handler.getDate(2000, 1, 1));
		long test1YearChange = handler.getYearsDifference(handler.getDate(2000, 4, 1), handler.getDate(2001, 4, 1));
		
		assertEquals( 0, test0YearsDiff );
		assertEquals( 1, test1YearDiff );
		assertEquals( -1, test1YearPast );
		assertEquals( 1, test1YearChange );
	}
	
	@Test
	void invalidYearExceptionTest() {
		InvalidYearException thrown = assertThrows(InvalidYearException.class, () -> {
			handler.getDate(0, 9, 20);
		});
		assertEquals("Invalid value for argument YEAR. It has to be higher than ZERO.", thrown.getMessage());
	}
	
	@Test
	void invalidYearExceptionWithCustomMessageArgTest() {
		InvalidYearException thrown = assertThrows(InvalidYearException.class, () -> {
			throw new InvalidYearException("Custom exception message");
		});
		assertEquals("Custom exception message", thrown.getMessage());
	}
	
	@Test
	void invalidMonthHigherThan12ExceptionTest() {
		InvalidMonthException thrown = assertThrows(InvalidMonthException.class, () -> {
			handler.getDate(1, 13, 20);
		});
		assertEquals("Invalid value for argument MONTH. It has to be a positive number between 1 and 12.", thrown.getMessage());
	}
	
	@Test
	void invalidMonthLessThan1ExceptionTest() {
		InvalidMonthException thrown = assertThrows(InvalidMonthException.class, () -> {
			handler.getDate(1, 0, 20);
		});
		assertEquals("Invalid value for argument MONTH. It has to be a positive number between 1 and 12.", thrown.getMessage());
	}
	
	@Test
	void invalidMonthWithCustomMessageArgTest() {
		InvalidMonthException thrown = assertThrows(InvalidMonthException.class,  () -> {
			throw new InvalidMonthException("Custom exception message");
		});
		assertEquals("Custom exception message", thrown.getMessage());
	}
	
	@Test
	void invalidDayHigherThan31ExceptionTest() {
		InvalidDayException thrown = assertThrows(InvalidDayException.class, () -> {
			handler.getDate(1, 1, 32);
		});
		assertEquals("Invalid value for argument DAY. It has to be a positive number between 1 and 31.", thrown.getMessage());
	}
	
	@Test
	void invalidDayLessThan1ExceptionTest() {
		InvalidDayException thrown = assertThrows(InvalidDayException.class, () -> {
			handler.getDate(1, 1, 0);
		});
		assertEquals("Invalid value for argument DAY. It has to be a positive number between 1 and 31.", thrown.getMessage());
	}
	
	@Test
	void invalidDayWithCustomMessageArgTest() {
		InvalidDayException thrown = assertThrows(InvalidDayException.class, () -> {
			throw new InvalidDayException("Custom exception message");
		});
		assertEquals("Custom exception message", thrown.getMessage());
	}
	
	
}
