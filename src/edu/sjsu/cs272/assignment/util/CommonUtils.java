package edu.sjsu.cs272.assignment.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {
	private static DateFormat df = new SimpleDateFormat("yyyy-mm-dd");

	public static Date getDateFromString(DateFormat df, String dateInStr) {
		Date parsedDate = null;
		try {
			parsedDate = df.parse(dateInStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return parsedDate;
	}

	public static String getString(String str) {
		return str == null ? "" : str;
	}

	public static String getString(Date date) {
		return date == null ? "2000-01-01" : df.format(date);
	}
}
