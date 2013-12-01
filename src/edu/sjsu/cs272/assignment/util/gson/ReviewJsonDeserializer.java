package edu.sjsu.cs272.assignment.util.gson;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import edu.sjsu.cs272.assignment.model.Review;
import edu.sjsu.cs272.assignment.util.CommonUtils;

public class ReviewJsonDeserializer implements JsonDeserializer<Review> {
	private static DateFormat df = new SimpleDateFormat("yyyy-mm-dd");

	public ReviewJsonDeserializer() {
	}

	@Override
	public Review deserialize(JsonElement json, Type type,
			JsonDeserializationContext context) throws JsonParseException {

		Review review = new Review();
		final JsonObject jsonObject = json.getAsJsonObject();

		JsonElement jsonElement = jsonObject.get("user_id");
		if (jsonElement != null)
			review.user_id = jsonElement.getAsString();

		jsonElement = jsonObject.get("review_id");
		if (jsonElement != null)
			review.review_id = jsonElement.getAsString();

		jsonElement = jsonObject.get("business_id");
		if (jsonElement != null)
			review.business_id = jsonElement.getAsString();

		jsonElement = jsonObject.get("type");
		if (jsonElement != null)
			review.type = jsonElement.getAsString();

		jsonElement = jsonObject.get("stars");
		if (jsonElement != null)
			review.stars = jsonElement.getAsInt();

		// jsonElement = jsonObject.get("text");
		// if (jsonElement != null)
		// review.text = jsonElement.getAsString();

		jsonElement = jsonObject.get("date");
		if (jsonElement != null)
			review.date = CommonUtils.getDateFromString(df,
					jsonElement.getAsString());

		JsonObject checkinMap = jsonObject.get("votes").getAsJsonObject();
		for (Map.Entry<String, JsonElement> entry : checkinMap.entrySet()) {
			if (entry.getKey().equals("funny")) {
				review.funny_votes = entry.getValue().getAsInt();
			} else if (entry.getKey().equals("useful")) {
				review.useful_votes = entry.getValue().getAsInt();
			} else if (entry.getKey().equals("cool")) {
				review.cool_votes = entry.getValue().getAsInt();
			} else {
				System.out.println("Unknown vote type : " + entry.getKey());
			}
		}

		return review;
	}
}
