package edu.sjsu.cs272.assignment.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

	private static final String YELP_DIR_PATH = "/Users/sabhinav/Documents/personal/shefali_project/yelp_phoenix_academic_dataset_mac/json/";
	private static final String YELP_BUSINESS_PATH = YELP_DIR_PATH
			+ "yelp_academic_dataset_business.json";
	private static final String YELP_CHECKIN_PATH = YELP_DIR_PATH
			+ "yelp_academic_dataset_checkin.json";
	private static final String YELP_USER_PATH = YELP_DIR_PATH
			+ "yelp_academic_dataset_user.json";
	private static final String YELP_REVIEW_PATH = YELP_DIR_PATH
			+ "yelp_academic_dataset_review.json";

	// Output paths
	private static final String YELP_OUTPUT_DIR_PATH = "/Users/sabhinav/Documents/personal/shefali_project/yelp_phoenix_academic_dataset_mac/blu_data_files/";
	private static final String YELP_USER_OUTPUT_PATH = YELP_OUTPUT_DIR_PATH
			+ "yelp_academic_dataset_user.csv";
	private static final String YELP_REVIEW_OUTPUT_PATH = YELP_OUTPUT_DIR_PATH
			+ "yelp_academic_dataset_review.csv";
	private static final String YELP_BUSINESS_OUTPUT_PATH = YELP_OUTPUT_DIR_PATH
			+ "yelp_academic_dataset_business.csv";
	private static final String YELP_BUSINESS_TO_CATEGORY_OUTPUT_PATH = YELP_OUTPUT_DIR_PATH
			+ "yelp_academic_dataset_bus2Category.csv";
	private static final String YELP_CATEGORY_OUTPUT_PATH = YELP_OUTPUT_DIR_PATH
			+ "yelp_academic_dataset_category.csv";
	private static final String YELP_CHECKIN_OUTPUT_PATH = YELP_OUTPUT_DIR_PATH
			+ "yelp_academic_dataset_checkin.csv";

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

		try {
			loadYelpData(businesses, users, reviews, checkIns, gson);

			System.out.println("Number of businesses : " + businesses.size());
			System.out.println("Number of Categories : " + categories.size());
			System.out.println("Number of Checkins   : " + checkIns.size());
			System.out.println("Number of Users      : " + users.size());
			System.out.println("Number of Reviews    : " + reviews.size());

			writeUserData(users);
			writeReviewData(reviews);
			writeCheckinData(checkIns);
			writeBusinessData(businesses, categories);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Processing Complete");
		}

	}

	private static void writeBusinessData(List<Business> businesses,
			Map<String, Category> categories) throws IOException {
		FileWriter outputFileBusiness = null;
		FileWriter outputFileCategories = null;
		FileWriter outputFileBusinessToCategories = null;
		try {
			// Writing Category Data
			outputFileCategories = new FileWriter(YELP_CATEGORY_OUTPUT_PATH);
			outputFileCategories.write(Category.getCsvHeaderName());
			for (Category category : categories.values()) {
				outputFileCategories.write(category.toString());
			}
			System.out.println(Category.getDDL());
			System.out.println("Category Data Written");

			// Writing Business Data and Business To Categories
			outputFileBusiness = new FileWriter(YELP_BUSINESS_OUTPUT_PATH);
			outputFileBusinessToCategories = new FileWriter(
					YELP_BUSINESS_TO_CATEGORY_OUTPUT_PATH);
			outputFileBusiness.write(Business.getBusinessCsvHeaderName());
			outputFileBusinessToCategories.write(Business
					.getBusinessToCategoryCsvHeaderName());
			for (Business business : businesses) {
				outputFileBusiness.write(business.toString());
				String str = business.toBusinessToCategoryString();
				if (str != null && !str.isEmpty())
					outputFileBusinessToCategories.write(business
							.toBusinessToCategoryString());
			}
			System.out.println(Business.getBusinessDDL());
			System.out.println(Business.getBusinessToCategoryDDL());
			System.out.println("Business Data Written");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (outputFileBusiness != null) {
				outputFileBusiness.flush();
				outputFileBusiness.close();
			}
			if (outputFileCategories != null) {
				outputFileCategories.flush();
				outputFileCategories.close();
			}
			if (outputFileBusinessToCategories != null) {
				outputFileBusinessToCategories.flush();
				outputFileBusinessToCategories.close();
			}
		}
	}

	private static void writeCheckinData(ArrayList<CheckIn> checkIns)
			throws IOException {
		FileWriter outputFile = null;
		try {
			outputFile = new FileWriter(YELP_CHECKIN_OUTPUT_PATH);
			outputFile.write(CheckIn.getCsvHeaderName());
			for (CheckIn checkin : checkIns) {
				outputFile.write(checkin.toString());
			}
			System.out.println(CheckIn.getDDL());
			System.out.println("CheckIn Data Written");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (outputFile != null) {
				outputFile.flush();
				outputFile.close();
			}
		}
	}

	private static void writeReviewData(List<Review> reviews)
			throws IOException {
		FileWriter outputFile = null;
		try {
			outputFile = new FileWriter(YELP_REVIEW_OUTPUT_PATH);
			outputFile.write(Review.getCsvHeaderName());
			for (Review user : reviews) {
				outputFile.write(user.toString());
			}
			System.out.println(Review.getDDL());
			System.out.println("Review Data Written");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (outputFile != null) {
				outputFile.flush();
				outputFile.close();
			}
		}
	}

	private static void writeUserData(List<User> users) throws IOException {
		FileWriter outputFile = null;
		try {
			outputFile = new FileWriter(YELP_USER_OUTPUT_PATH);
			outputFile.write(User.getCsvHeaderName());
			for (User user : users) {
				outputFile.write(user.toString());
			}
			System.out.println(User.getDDL());
			System.out.println("User Data Written");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (outputFile != null) {
				outputFile.flush();
				outputFile.close();
			}
		}
	}

	private static void loadYelpData(List<Business> businesses,
			List<User> users, List<Review> reviews,
			ArrayList<CheckIn> checkIns, final Gson gson)
			throws FileNotFoundException {
		// Reading the Business Data
		readBusinessData(businesses, gson);

		// Reading the Checkin Data
		readCheckinData(checkIns, gson);

		// Reading the User Data
		readUserData(users, gson);

		// Reading the Review Data
		readReviewData(reviews, gson);
	}

	/**
	 * @param reviews
	 * @param gson
	 * @return
	 * @throws FileNotFoundException
	 */
	private static void readReviewData(List<Review> reviews, final Gson gson)
			throws FileNotFoundException {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(YELP_REVIEW_PATH))
					.useDelimiter("\n");
			while (scanner.hasNext()) {
				reviews.add(gson.fromJson(scanner.next(), Review.class));
			}
		} finally {
			if (scanner != null)
				scanner.close();
		}
	}

	/**
	 * @param users
	 * @param gson
	 * @throws FileNotFoundException
	 */
	private static void readUserData(List<User> users, final Gson gson)
			throws FileNotFoundException {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(YELP_USER_PATH)).useDelimiter("\n");
			while (scanner.hasNext()) {
				users.add(gson.fromJson(scanner.next(), User.class));
			}
		} finally {
			if (scanner != null)
				scanner.close();
		}
	}

	/**
	 * @param checkIns
	 * @param gson
	 * @throws FileNotFoundException
	 */
	private static void readCheckinData(ArrayList<CheckIn> checkIns,
			final Gson gson) throws FileNotFoundException {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(YELP_CHECKIN_PATH))
					.useDelimiter("\n");
			while (scanner.hasNext()) {
				checkIns.addAll(gson.fromJson(scanner.next(),
						checkIns.getClass()));
			}
		} finally {
			if (scanner != null)
				scanner.close();
		}
	}

	/**
	 * @param businesses
	 * @param gson
	 * @throws FileNotFoundException
	 */
	private static void readBusinessData(List<Business> businesses,
			final Gson gson) throws FileNotFoundException {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(YELP_BUSINESS_PATH))
					.useDelimiter("\n");
			while (scanner.hasNext()) {
				businesses.add(gson.fromJson(scanner.next(), Business.class));
			}
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
}
