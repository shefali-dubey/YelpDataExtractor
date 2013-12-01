package edu.sjsu.cs272.assignment.model;

import java.io.Serializable;

/*
 * Table : User
 */
public class User implements Serializable {

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
}
