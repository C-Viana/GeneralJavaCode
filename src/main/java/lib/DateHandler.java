package lib;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.UnsupportedTemporalTypeException;

import exceptions.InvalidDayException;
import exceptions.InvalidMonthException;
import exceptions.InvalidYearException;

public class DateHandler {
	
	public LocalDate getCurrentDate() {
		return LocalDate.now();
	}
	
	public String getCurrentDateAsString(String format) {
		return DateTimeFormatter.ofPattern(format).format(LocalDateTime.now());
	}
	
	public LocalDate getDate(int year, int month, int day) throws InvalidYearException, InvalidMonthException, InvalidDayException {
		if(year <= 0) throw new InvalidYearException();
		if(month < 1 || month > 12) throw new InvalidMonthException();
		if(day < 1 || day > 31) throw new InvalidDayException();
		
		return LocalDate.of(year, month, day);
	}
	
	public String getDateAsString(LocalDate date, String format) {
		try {
			if(format == null || format.isBlank()) format = "dd/MM/yyyy";
			return DateTimeFormatter.ofPattern(format).format(date);
		} catch (NullPointerException e) {
			return "Date argument must not be null.";
		} catch (UnsupportedTemporalTypeException e) {
			return "Format argument must not contain specific values like \"MM/dd/yyyy\", \"dd MMM yyyy\", \"MM-dd-yy\", etc.";
		}
	}
	
	public LocalDate changeDate(int yearsDiff, int monthsDiff, int daysDiff) {
		LocalDate d = LocalDate.now();
		d = d.plusYears(yearsDiff);
		d = d.plusMonths(monthsDiff);
		d = d.plusDays(daysDiff);
		return d;
	}
	
	public long getDaysDifference(LocalDate date1, LocalDate date2) {
	    return ChronoUnit.DAYS.between(date1, date2);
	}
	
	public long getMonthsDifference(LocalDate date1, LocalDate date2) {
	    return ChronoUnit.MONTHS.between(date1, date2);
	}
	
	public long getYearsDifference(LocalDate date1, LocalDate date2) {
	    return ChronoUnit.YEARS.between(date1, date2);
	}
	
}
