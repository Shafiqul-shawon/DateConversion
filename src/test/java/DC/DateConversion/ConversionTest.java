package DC.DateConversion;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

public class ConversionTest extends TestCase {
	
	@Test
	public void testCalendartoLocalDate() {
		//Conversion conversion = new Conversion();
		Calendar cal = Calendar.getInstance();
		cal.set(2019,1,16);
		LocalDate a = Conversion.convert_calendar_to_localdate(cal);
		LocalDate b = LocalDate.of(2019, 1, 16);
		assertEquals(b,a);
		//System.out.println(a);
		
		}
	@Test
	public void testCalendartoLocalTime() {
		Calendar cl = Calendar.getInstance();
		cl.set(2019, Calendar.JANUARY, 16, 16, 20);
		LocalTime lt = Conversion.convert_calender_to_Localtime(cl);
		assertEquals(LocalTime.of(16, 20), lt);
	}
	//////////////
	@Test
	public void testLocalTtoCalender() {
		LocalTime localtime = LocalTime.of(5, 50, 56);
		Calendar cal1 = Conversion.convert_localtime_to_calender(localtime);
		Calendar cal2 = Calendar.getInstance(); // pasrsing hbe
		cal2.clear();
		cal2.set(0, 0, 0, 5, 56, 56);
        //System.out.println(cal1);
		//System.out.println(cal2);
		assertEquals(cal2, cal1);	
	
	}
	
	@Test
	public void testDatetoLocaldate() {
		Date date = new Date(2019,1,16);
		LocalDate a = Conversion.convert_date_to_localdate(date);
		LocalDate b = LocalDate.of(2019, 1, 16);
		assertEquals(b, a);
		}
	@Test
	public void testCaltoLDT() {
		Calendar cl = Calendar.getInstance();
		cl.set(2019, Calendar.FEBRUARY, 12, 10, 02, 10);
		LocalDateTime ldt = Conversion.convert_to_localdatetime(cl);
		assertEquals(LocalDateTime.of(2019, Calendar.FEBRUARY, 12, 10, 02, 10), ldt);
	}
	
	@Test
	public void testLocaldateToDate() throws ParseException {
		String string = "Wed Jan 16 00:00:00 BDT 2019";

		LocalDate localDate = LocalDate.parse(string, DateTimeFormatter.ofPattern("EE MMM dd hh:mm:ss z yyyy"));
		Date date = Conversion.Convert_LocaldateToDate(localDate);

		Date dtDate = new SimpleDateFormat("EE MMM dd hh:mm:ss z yyyy").parse(string);
		assertEquals(date, dtDate);
	}
	
	@Test
	public void testLocalDtoCalender() {
		String string = "Wed Jan 16 00:00:00 BDT 2019";
		LocalDate localDate = LocalDate.parse(string, DateTimeFormatter.ofPattern("EE MMM dd hh:mm:ss z yyyy"));
		
		//LocalDate localdate = LocalDate.of(2019, 1, 17);
		Calendar  cal1 = Conversion.convert_localdate_to_calender(localDate);
		Calendar cal2 = Calendar.getInstance();
		cal2.clear();
		cal2.set(2019, 1, 16);
		assertEquals(cal2, cal1);
		
		}
	
	
	@Test
	public void testDatetoCalendar() throws ParseException{
		Date date = new Date();
		Calendar cal = Conversion.convert_date_to_calendar(date);
		SimpleDateFormat s1 = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		s1.format(cal.getTime());

		String stringDate = "2019 Jan 16 15:06:49";
		SimpleDateFormat s2 = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		s2.parse(stringDate);

		assertEquals(s1, s2);
		}
	@Test
	public void testZonedDTtoLocalDT() {
		ZonedDateTime utcZoned = ZonedDateTime.of(LocalDate.now().atTime(12, 57), ZoneOffset.UTC);
		LocalDateTime a = Conversion.convert_ZonedDateTime_to_localDateTime(utcZoned);
		LocalDateTime b = LocalDateTime.of(2019, 1, 17, 12, 57);
		//System.out.println(a);
		//System.out.println(b);
		assertEquals(b, a);
		
	}
	
	@Test
	public void testCalenderDatetoLocalDateTime() {
		Calendar cal = Calendar.getInstance();

		LocalDateTime d1 = LocalDateTime.now();

		assertEquals(d1.getHour(), Conversion.convert_CalendaeDatetoLocalDateTime(cal).getHour());
}
	
	@Test
	public void testCalendarToZonedTime() {
		Calendar cl = Calendar.getInstance();
		cl.set(2019, Calendar.FEBRUARY, 17, 14, 30);
		ZonedDateTime zdtDateTime = Conversion.convert_CalendarToZonedTime(cl);
		
		LocalDateTime ldt = LocalDateTime.of(2019, Calendar.FEBRUARY, 17, 14, 30);
		ZonedDateTime klDateTime = ldt.atZone(ZoneId.of("Asia/Tokyo"));
		assertEquals(zdtDateTime.getZone(), klDateTime.getZone());
	}
	

}
