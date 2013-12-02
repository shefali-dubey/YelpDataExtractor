package edu.sjsu.cs272.assignment.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import edu.sjsu.cs272.assignment.util.CommonUtils;

/* Tables : 
 * BUSINESS 
 * BUSINESS_TO_CATEGORY*/
public class Business implements Serializable {
	private static final long serialVersionUID = -4044314625035030478L;
	private static final String REVIEW_COUNT = "REVIEW_COUNT";
	private static final String LATITUDE = "LATITUDE";
	private static final String LONGITUDE = "LONGITUDE";
	private static final String TYPE = "TYPE";
	private static final String STATE = "STATE";
	private static final String CITY = "CITY";
	private static final String BUSINESS_ID = "BUSINESS_ID";
	private static final String NAME = "NAME";
	private static final String STARS = "STARS";
	private static final String BUSINESS_TABLE_NAME = "BUSINESS";
	private static final String BUSINESS_TO_CATEGORY_TABLE_NAME = "BUSINESS_TO_CATEGORY";
	private static final String CATEGORY_ID = "CATEGORY_ID";

	public String business_id;
	// public String full_address;
	public List<Category> categories = new ArrayList<>();
	public String city;
	public String name;
	public String state;
	public String type;
	public double longitude;
	public double latitude;
	public int review_count;
	public double stars;

	@Override
	public String toString() {
		return new StringBuilder().append(CommonUtils.getString(business_id))
				.append(",").append(CommonUtils.getString(city)).append(",")
				.append(CommonUtils.getString(name).replaceAll(",", ""))
				.append(",").append(CommonUtils.getString(state)).append(",")
				.append(CommonUtils.getString(type)).append(",")
				.append(longitude).append(",").append(latitude).append(",")
				.append(review_count).append(",").append(stars).append("\n")
				.toString();
	}

	public String toBusinessToCategoryString() {
		StringBuilder sb = new StringBuilder();
		for (Category c : categories) {
			sb.append(CommonUtils.getString(business_id)).append(",")
					.append(c.id).append("\n");
		}
		return sb.toString();
	}

	public static String getBusinessToCategoryCsvHeaderName() {
		return new StringBuilder().append(BUSINESS_ID).append(",")
				.append(CATEGORY_ID).append("\n").toString();
	}

	public static String getBusinessToCategoryDDL() {
		return new StringBuilder("CREATE TABLE ")
				.append(BUSINESS_TO_CATEGORY_TABLE_NAME).append(" ( ")
				.append(BUSINESS_ID).append(" VARCHAR(22) ,")
				.append(CATEGORY_ID).append(" INT);").toString();
	}

	public static String getBusinessCsvHeaderName() {
		return new StringBuilder().append(BUSINESS_ID).append(",").append(CITY)
				.append(",").append(NAME).append(",").append(STATE).append(",")
				.append(TYPE).append(",").append(LONGITUDE).append(",")
				.append(LATITUDE).append(",").append(REVIEW_COUNT).append(",")
				.append(STARS).append("\n").toString();
	}

	public static String getBusinessDDL() {
		return new StringBuilder("CREATE TABLE ").append(BUSINESS_TABLE_NAME)
				.append(" ( ").append(BUSINESS_ID).append(" VARCHAR(22) ,")
				.append(CITY).append(" VARCHAR(30) ,").append(NAME)
				.append(" VARCHAR(50) ,").append(STATE)
				.append(" VARCHAR(50) ,").append(TYPE).append(" VARCHAR(10) ,")
				.append(LONGITUDE).append("  DOUBLE,").append(LATITUDE)
				.append(" DOUBLE,").append(REVIEW_COUNT).append(" DOUBLE,")
				.append(STARS).append(" INT);").toString();
	}
}
