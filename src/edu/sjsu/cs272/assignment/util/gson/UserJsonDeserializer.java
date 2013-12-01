package edu.sjsu.cs272.assignment.util.gson;

import java.lang.reflect.Type;
import java.util.Map;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import edu.sjsu.cs272.assignment.model.User;

public class UserJsonDeserializer implements JsonDeserializer<User> {

	public UserJsonDeserializer() {
	}

	@Override
	public User deserialize(JsonElement json, Type type,
			JsonDeserializationContext context) throws JsonParseException {

		User user = new User();
		final JsonObject jsonObject = json.getAsJsonObject();

		JsonElement jsonElement = jsonObject.get("user_id");
		if (jsonElement != null)
			user.user_id = jsonElement.getAsString();

		jsonElement = jsonObject.get("name");
		if (jsonElement != null)
			user.name = jsonElement.getAsString();

		jsonElement = jsonObject.get("type");
		if (jsonElement != null)
			user.type = jsonElement.getAsString();

		jsonElement = jsonObject.get("review_count");
		if (jsonElement != null)
			user.review_count = jsonElement.getAsInt();

		jsonElement = jsonObject.get("average_stars");
		if (jsonElement != null)
			user.average_stars = jsonElement.getAsDouble();

		JsonObject checkinMap = jsonObject.get("votes").getAsJsonObject();
		for (Map.Entry<String, JsonElement> entry : checkinMap.entrySet()) {
			if (entry.getKey().equals("funny")) {
				user.funny_votes = entry.getValue().getAsInt();
			} else if (entry.getKey().equals("useful")) {
				user.useful_votes = entry.getValue().getAsInt();
			} else if (entry.getKey().equals("cool")) {
				user.cool_votes = entry.getValue().getAsInt();
			} else {
				System.out.println("Unknown vote type : " + entry.getKey());
			}
		}

		return user;
	}
}
