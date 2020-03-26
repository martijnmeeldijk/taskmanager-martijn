package be.ucll.ip.demo;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Locale;
@Component
public class DateTimeFormatter implements Formatter<LocalDateTime> {
	@Override
	public LocalDateTime parse(String text, Locale locale) throws ParseException {
		return LocalDateTime.parse(text, java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}

	@Override
	public String print(LocalDateTime object, Locale locale) {
		return object.format(java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}
}
