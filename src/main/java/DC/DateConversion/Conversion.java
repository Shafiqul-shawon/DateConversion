package DC.DateConversion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Conversion {
	//static Calendar cal;
	//Date date;
	
	
	/***** Calendar to Local Date ******/
   public static LocalDate convert_calendar_to_localdate(Calendar cal) {
		LocalDate localdate = LocalDate.of(cal.get(Calendar.YEAR),
				cal.get(Calendar.MONTH),
				cal.get(Calendar.DAY_OF_MONTH));
		
		return localdate;
	}
	
   /***** Calendar To Local Time ******/
	public static LocalTime convert_calender_to_Localtime(Calendar cal) {
		LocalTime ld = LocalTime.of(cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));
		return ld;	
	} 
	
	/***** Date to Local Date ******/
	public static LocalDate convert_date_to_localdate(Date date) {
		LocalDate localdate=LocalDate.of(date.getYear(),date.getMonth(), date.getDate());
	    return localdate;
	}
	
	/***** Calendar To Local Date Time ******/
	public static LocalDateTime convert_to_localdatetime(Calendar c) {
		LocalDateTime ld = LocalDateTime.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH),
				c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), c.get(Calendar.SECOND));
		return ld;
	}
	
	
	/***** Local Date to Calendar ******/
	public static Calendar convert_localdate_to_calender(LocalDate localdate) {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(localdate.getYear(),localdate.getMonthValue(),localdate.getDayOfMonth());
	    return cal;
		 
	}

	/***** Local Time to Calendar ******/
	public static Calendar convert_localtime_to_calender(LocalTime localtime) {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(localtime.getHour(), localtime.getMinute(), localtime.getSecond());
		return cal;
	}
	
	/***** Date to Calendar ******/
	public static Calendar convert_date_to_calendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
	
	/***** Zoned Date Time to Local Date Time ******/
	public static LocalDateTime convert_ZonedDateTime_to_localDateTime(ZonedDateTime zonedatetime) {
		ZoneId dhakaZone = ZoneId.of("Asia/Dhaka");
		ZonedDateTime DhakaZoned = zonedatetime.withZoneSameInstant(dhakaZone);
		LocalDateTime dhakaLocal = DhakaZoned.toLocalDateTime(); // conversion
		return dhakaLocal;
	}

	/***** Local Date to Date ******/
	public static Date Convert_LocaldateToDate(LocalDate localdate) {
		// TODO Auto-generated method stub
		return Date.from(localdate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
	/***** Calendar To Local Date Time ******/
	public static LocalDateTime convert_CalendaeDatetoLocalDateTime(Calendar cal) {
		TimeZone tz = cal.getTimeZone();
		ZoneId zid = tz == null ? ZoneId.systemDefault() : tz.toZoneId();
		return LocalDateTime.ofInstant(cal.toInstant(), zid);
	}
	

	
	/***** Calendar To Zoned Date Time ******/
	public static ZonedDateTime convert_CalendarToZonedTime(Calendar cl) {
		// TODO Auto-generated method stub
		ZoneId zoneid = ZoneId.of("Asia/Tokyo");
		ZonedDateTime zonedDateTime = ZonedDateTime.of(convert_CalendaeDatetoLocalDateTime(cl), zoneid);
		return zonedDateTime;
	}

}
