package main;

import java.time.*;
import java.time.format.*;

public class DateTime {
	
	private LocalDateTime dateTime;
	private int day, month, year;
	private int hours, minutes;
		
	public
		DateTime(int day, int month, int year, int hours, int minutes)
		{
			this.day = day;
			this.month = month;
			this.year = year;
			
			this.hours = hours;
			this.minutes = minutes;
			
			dateTime = LocalDateTime.of(year, month, month, hours, minutes);
		}
		String getDateTime()
		{
			String dateTimeString;
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
			dateTimeString = dateTime.format(format);
			return dateTimeString;
		}
		void setDateTime(int day, int month, int year, int hours, int minutes)
		{
			this.day = day;
			this.month = month;
			this.year = year;
			
			this.hours = hours;
			this.minutes = minutes;
			
			dateTime = LocalDateTime.of(year, month, month, hours, minutes);	
		}
}
