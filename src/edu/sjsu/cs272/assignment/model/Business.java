package edu.sjsu.cs272.assignment.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* Tables : 
 * Business 
 * BusinessToCategory*/
public class Business implements Serializable {
	private static final long serialVersionUID = -4044314625035030478L;

	public String business_id;
	public String full_address;
	public List<Category> categories = new ArrayList<>();
	public String city;
	public int review_count;
	public double stars;
	public String name;
	public String state;
	public String type;
	public double longitude;
	public double latitude;
}
