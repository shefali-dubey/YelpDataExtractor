package edu.sjsu.cs272.assignment.model;

import java.io.Serializable;

import edu.sjsu.cs272.assignment.util.CommonUtils;

/*
 * Table : USER
 */
public class User implements Serializable {

	private static final String AVERAGE_STARS = "AVERAGE_STARS";
	private static final String REVIEW_COUNT = "REVIEW_COUNT";
	private static final String COOL_VOTES = "COOL_VOTES";
	private static final String USEFUL_VOTES = "USEFUL_VOTES";
	private static final String FUNNY_VOTES = "FUNNY_VOTES";
	private static final String TYPE = "TYPE";
	private static final String NAME = "NAME";
	private static final String USER_ID = "USER_ID";
	private static final String TABLE_NAME = "USER";
	/**
	 * 
	 */
	private static final long serialVersionUID = 7835591200413809922L;
	public int funny_votes;
	public int useful_votes;
	public int cool_votes;
	public String user_id;
	public String name;
	public double average_stars;
	public int review_count;
	public String type;

	@Override
	public String toString() {
		return new StringBuilder().append(CommonUtils.getString(user_id))
				.append(",").append(CommonUtils.getString(name)).append(",")
				.append(CommonUtils.getString(type)).append(",")
				.append(funny_votes).append(",").append(useful_votes)
				.append(",").append(cool_votes).append(",")
				.append(review_count).append(",").append(average_stars)
				.append("\n").toString();
	}

	public static String getCsvHeaderName() {
		return new StringBuilder().append(USER_ID).append(",").append(NAME)
				.append(",").append(TYPE).append(",").append(FUNNY_VOTES)
				.append(",").append(USEFUL_VOTES).append(",")
				.append(COOL_VOTES).append(",").append(REVIEW_COUNT)
				.append(",").append(AVERAGE_STARS).append("\n").toString();
	}

	public static String getDDL() {
		return new StringBuilder("CREATE TABLE ").append(TABLE_NAME)
				.append(" ( ").append(USER_ID).append(" VARCHAR(22) ,")
				.append(NAME).append(" VARCHAR(30) ,").append(TYPE)
				.append(" VARCHAR(10) ,").append(FUNNY_VOTES).append(" INT,")
				.append(USEFUL_VOTES).append(" INT,").append(COOL_VOTES)
				.append("  INT,").append(REVIEW_COUNT).append(" INT,")
				.append(AVERAGE_STARS).append(" DOUBLE);").toString();
	}

}
