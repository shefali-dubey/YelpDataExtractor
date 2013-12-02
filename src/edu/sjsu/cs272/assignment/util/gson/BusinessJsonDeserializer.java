package edu.sjsu.cs272.assignment.util.gson;

import java.lang.reflect.Type;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import edu.sjsu.cs272.assignment.model.Business;
import edu.sjsu.cs272.assignment.model.Category;

public class BusinessJsonDeserializer implements JsonDeserializer<Business> {

	final private Map<String, Category> categories;

	public BusinessJsonDeserializer(Map<String, Category> categories) {
		this.categories = categories;
	}

	@Override
	public Business deserialize(JsonElement json, Type type,
			JsonDeserializationContext context) throws JsonParseException {

		Business business = new Business();
		final JsonObject jsonObject = json.getAsJsonObject();

		JsonElement jsonElement = jsonObject.get("business_id");
		if (jsonElement != null)
			business.business_id = jsonElement.getAsString();

		// jsonElement = jsonObject.get("full_address");
		// if (jsonElement != null)
		// business.full_address = jsonElement.getAsString();

		jsonElement = jsonObject.get("city");
		if (jsonElement != null)
			business.city = jsonElement.getAsString();

		jsonElement = jsonObject.get("review_count");
		if (jsonElement != null)
			business.review_count = jsonElement.getAsInt();

		jsonElement = jsonObject.get("name");
		if (jsonElement != null)
			business.name = jsonElement.getAsString();

		jsonElement = jsonObject.get("state");
		if (jsonElement != null)
			business.state = jsonElement.getAsString();

		jsonElement = jsonObject.get("type");
		if (jsonElement != null)
			business.type = jsonElement.getAsString();

		jsonElement = jsonObject.get("stars");
		if (jsonElement != null)
			business.stars = jsonElement.getAsDouble();

		jsonElement = jsonObject.get("latitude");
		if (jsonElement != null)
			business.latitude = jsonElement.getAsDouble();

		jsonElement = jsonObject.get("longitude");
		if (jsonElement != null)
			business.longitude = jsonElement.getAsDouble();

		JsonArray catArrays = jsonObject.get("categories").getAsJsonArray();
		if (catArrays != null) {
			for (int i = 0, size = catArrays.size(); i < size; i++) {
				String category_name = catArrays.get(i).getAsString();
				Category cat_obj = categories.get(category_name);
				if (cat_obj == null) {
					cat_obj = new Category(category_name, categories.size() + 1);
				}
				categories.put(category_name, cat_obj);
				business.categories.add(cat_obj);
			}
		}

		return business;
	}
}
