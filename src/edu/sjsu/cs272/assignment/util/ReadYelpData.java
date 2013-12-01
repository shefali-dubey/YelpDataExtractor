package edu.sjsu.cs272.assignment.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.sjsu.cs272.assignment.model.Business;
import edu.sjsu.cs272.assignment.model.Category;
import edu.sjsu.cs272.assignment.model.CheckIn;
import edu.sjsu.cs272.assignment.model.Review;
import edu.sjsu.cs272.assignment.model.User;
import edu.sjsu.cs272.assignment.util.gson.BusinessJsonDeserializer;
import edu.sjsu.cs272.assignment.util.gson.CheckinJsonDeserializer;
import edu.sjsu.cs272.assignment.util.gson.ReviewJsonDeserializer;
import edu.sjsu.cs272.assignment.util.gson.UserJsonDeserializer;

public class ReadYelpData {

	private static final String YELP_DIR_PATH = "/Users/sabhinav/Documents/personal/shefali_project/yelp_phoenix_academic_dataset_mac/";
	private static final String YELP_BUSINESS_PATH = YELP_DIR_PATH
			+ "yelp_academic_dataset_business.json";
	// private static final String YELP_CHECKIN_PATH = YELP_DIR_PATH
	// + "sample/checkin-s.json";
	private static final String YELP_CHECKIN_PATH = YELP_DIR_PATH
			+ "yelp_academic_dataset_checkin.json";
	// private static final String YELP_USER_PATH = YELP_DIR_PATH
	// + "sample/user-s.json";
	private static final String YELP_USER_PATH = YELP_DIR_PATH
			+ "yelp_academic_dataset_user.json";
	private static final String YELP_REVIEW_PATH = YELP_DIR_PATH
			+ "yelp_academic_dataset_review.json";

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		List<Business> businesses = new ArrayList<>();
		Map<String, Category> categories = new HashMap<>();
		List<User> users = new ArrayList<>();
		List<Review> reviews = new ArrayList<>();
		ArrayList<CheckIn> checkIns = new ArrayList<>();

		final Gson gson = new GsonBuilder()
				.registerTypeAdapter(Business.class,
						new BusinessJsonDeserializer(categories))
				.registerTypeAdapter(checkIns.getClass(),
						new CheckinJsonDeserializer())
				.registerTypeAdapter(User.class, new UserJsonDeserializer())
				.registerTypeAdapter(Review.class, new ReviewJsonDeserializer())
				.create();
		Scanner scanner = null;

		try {
			// Reading the Business Data
			scanner = new Scanner(new File(YELP_BUSINESS_PATH))
					.useDelimiter("\n");
			while (scanner.hasNext()) {
				businesses.add(gson.fromJson(scanner.next(), Business.class));
			}
			scanner.close();

			// Reading the Checkin Data
			scanner = new Scanner(new File(YELP_CHECKIN_PATH))
					.useDelimiter("\n");
			while (scanner.hasNext()) {
				checkIns.addAll(gson.fromJson(scanner.next(),
						checkIns.getClass()));
			}
			scanner.close();

			// Reading the User Data
			scanner = new Scanner(new File(YELP_USER_PATH)).useDelimiter("\n");
			while (scanner.hasNext()) {
				users.add(gson.fromJson(scanner.next(), User.class));
			}
			scanner.close();

			// Reading the Review Data
			scanner = new Scanner(new File(YELP_REVIEW_PATH))
					.useDelimiter("\n");
			while (scanner.hasNext()) {
				reviews.add(gson.fromJson(scanner.next(), Review.class));
			}
			scanner.close();

			System.out.println("Number of businesses : " + businesses.size());
			System.out.println("Number of Categories : " + categories.size());
			System.out.println("Number of Checkins   : " + checkIns.size());
			System.out.println("Number of Users      : " + users.size());
			System.out.println("Number of Reviews    : " + reviews.size());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

	}
}
