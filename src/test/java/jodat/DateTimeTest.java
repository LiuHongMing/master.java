package jodat;

import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;

public class DateTimeTest {

	public static void main(String[] args) {
		System.out.println(TimeUnit.DAYS.toSeconds(1));
		
		DateTime dt = new DateTime();
		long st = dt.withField(DateTimeFieldType.hourOfDay(), 0)
				.withField(DateTimeFieldType.minuteOfHour(), 0)
				.withField(DateTimeFieldType.secondOfMinute(), 0).getMillis() / 1000;
		long et = st + TimeUnit.DAYS.toSeconds(1) - 1;
		System.out.println(st);
		System.out.println(et);
		
		System.out.println(String.format("%1$tY年%1$tm月%1$td日", new DateTime().toDate()));
	}
}
