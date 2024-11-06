package lib;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.TimeZone;

import exceptions.InvalidHourException;
import exceptions.InvalidMinutesException;
import exceptions.InvalidSecondsException;

public class TimeHandler {
	
	public String getLocalTimeZone() {
		return TimeZone.getDefault().getID();
	}
	
	public LocalTime getCurrentTime() {
		return LocalTime.now( ZoneId.of(TimeZone.getDefault().getID()) );
	}
	
	public String getCurrentTimeAsString(String format) {
		if(format == null || format.isBlank()) format = "HH:mm:ss";
		return DateTimeFormatter.ofPattern(format).format( getCurrentTime() );
	}
	
	public String getTimeAsString(LocalTime time, String format) {
		if(format == null || format.isBlank()) format = "HH:mm:ss";
		return DateTimeFormatter.ofPattern(format).format( time );
	}
	
	public LocalTime setTime(int hours, int minutes, int seconds) throws InvalidHourException, InvalidMinutesException, InvalidSecondsException {
		if(hours < 0 || hours > 23) throw new InvalidHourException();
		if(minutes < 0 || minutes > 59) throw new InvalidMinutesException();
		if(seconds < 0 || seconds > 59) throw new InvalidSecondsException();
		return LocalTime.of(hours, minutes, seconds);
	}
	
	public LocalTime adjustTime(LocalTime time, int hoursToChange, int minutesToChange, int secondsToChange) {
		time = time.plusHours(hoursToChange);
		time = time.plusMinutes(minutesToChange);
		time = time.plusSeconds(secondsToChange);
		return time;
	}
	
	public long getHoursInterval(LocalTime initTime, LocalTime endTime) {
		return ChronoUnit.HOURS.between(initTime, endTime);
	}
	
	public long getMinutesInterval(LocalTime initTime, LocalTime endTime) {
		return ChronoUnit.MINUTES.between(initTime, endTime);
	}
	
	public long getSecondsInterval(LocalTime initTime, LocalTime endTime) {
		return ChronoUnit.SECONDS.between(initTime, endTime);
	}
	
}
