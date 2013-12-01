package edu.sjsu.cs272.assignment.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class CommonUtils {
	public static Date getDateFromString(DateFormat df, String dateInStr) {
		Date parsedDate = null;
		try {
			parsedDate = df.parse(dateInStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return parsedDate;
	}
}
