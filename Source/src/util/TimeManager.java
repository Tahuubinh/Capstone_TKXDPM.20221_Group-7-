package util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeManager {
	// date format MM-YYYY
    public static DateTimeFormatter formatMMYY = DateTimeFormatter.ofPattern("MM-yyyy");

	// date format yyyy-MM-dd HH:mm:ss
    public static DateTimeFormatter formatDayTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
	// get time different in milisec
    public static long getTimeDiff(LocalDateTime _before, LocalDateTime _after) {
		long before = ZonedDateTime.of(_after, ZoneId.systemDefault()).toInstant().toEpochMilli();
		long after = ZonedDateTime.of(_before, ZoneId.systemDefault()).toInstant().toEpochMilli();
		if (after > before) {
			return after - before;
		} else
			return 0;
	}
}