package edu.sjsu.cs272.assignment.model;

import java.io.Serializable;
import java.util.Date;

import edu.sjsu.cs272.assignment.util.CommonUtils;

/*
 * Table : REVIEW
 */
public class Review implements Serializable {
	/**
	 * 
	 */
	private static final String REVIEW_DATE = "REVIEW_DATE";
	private static final String STARS = "STARS";
	private static final String COOL_VOTES = "COOL_VOTES";
	private static final String USEFUL_VOTES = "USEFUL_VOTES";
	private static final String FUNNY_VOTES = "FUNNY_VOTES";
	private static final String REVIEW_ID = "REVIEW_ID";
	private static final String BUSINESS_ID = "BUSINESS_ID";
	private static final String USER_ID = "USER_ID";
	private static final String TYPE = "TYPE";

	private static final String TABLE_NAME = "REVIEW";

	private static final long serialVersionUID = 8109030928692908943L;
	public String user_id;
	public String business_id;
	public String review_id;

	public int funny_votes;
	public int useful_votes;
	public int cool_votes;

	public String type;
	public int stars;
	// public String text;

	public Date date;

	@Override
	public String toString() {
		return new StringBuilder().append(CommonUtils.getString(user_id))
				.append(",").append(CommonUtils.getString(business_id))
				.append(",").append(CommonUtils.getString(review_id))
				.append(",").append(CommonUtils.getString(type)).append(",")
				.append(funny_votes).append(",").append(useful_votes)
				.append(",").append(cool_votes).append(",").append(stars)
				.append(",").append(CommonUtils.getString(date)).append("\n")
				.toString();
	}

	public static String getCsvHeaderName() {
		return new StringBuilder().append(USER_ID).append(",")
				.append(BUSINESS_ID).append(",").append(REVIEW_ID).append(",")
				.append(TYPE).append(",").append(FUNNY_VOTES).append(",")
				.append(USEFUL_VOTES).append(",").append(COOL_VOTES)
				.append(",").append(STARS).append(",").append(REVIEW_DATE)
				.append("\n").toString();
	}

	public static String getDDL() {
		return new StringBuilder("CREATE TABLE ").append(TABLE_NAME)
				.append(" ( ").append(USER_ID).append(" VARCHAR(22) ,")
				.append(BUSINESS_ID).append(" VARCHAR(22) ,").append(REVIEW_ID)
				.append(" VARCHAR(22) ,").append(TYPE).append(" VARCHAR(10) ,")
				.append(FUNNY_VOTES).append(" INT,").append(USEFUL_VOTES)
				.append(" INT,").append(COOL_VOTES).append("  INT,")
				.append(STARS).append(" INT,").append(REVIEW_DATE)
				.append(" DATE);").toString();
	}

}
