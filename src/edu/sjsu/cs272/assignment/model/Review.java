package edu.sjsu.cs272.assignment.model;

import java.io.Serializable;
import java.util.Date;

/*
 * Table : Review
 */
public class Review implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8109030928692908943L;
	public String user_id;
	public String business_id;
	public String review_id;

	public int funny_votes;
	public int useful_votes;
	public int cool_votes;

	public String type;
	public int stars;
//	public String text;
	
	public Date date;
}
