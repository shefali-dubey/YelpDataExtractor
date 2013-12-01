package edu.sjsu.cs272.assignment.util.gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import edu.sjsu.cs272.assignment.model.CheckIn;
import edu.sjsu.cs272.assignment.model.CheckIn.DAY;
import edu.sjsu.cs272.assignment.model.CheckIn.HOUR;

public class CheckinJsonDeserializer implements JsonDeserializer<ArrayList<CheckIn>> {

	@Override
	public ArrayList<CheckIn> deserialize(JsonElement json, Type classType,
			JsonDeserializationContext context) throws JsonParseException {

		ArrayList<CheckIn> perBusinessCheckinList = new ArrayList<>();
		final JsonObject jsonObject = json.getAsJsonObject();

		String businessid = null;
		String type = null;
		JsonElement jsonElement = jsonObject.get("business_id");
		if (jsonElement != null)
			businessid = jsonElement.getAsString();

		jsonElement = jsonObject.get("type");
		if (jsonElement != null)
			type = jsonElement.getAsString();

		JsonObject checkinMap = jsonObject.get("checkin_info")
				.getAsJsonObject();
		for (Map.Entry<String, JsonElement> entry : checkinMap.entrySet()) {
			String split[] = entry.getKey().split("-");
			DAY day = DAY.getType(Integer.parseInt(split[1]));
			HOUR hour = HOUR.getType(Integer.parseInt(split[0]));
			int count = entry.getValue().getAsInt();
			perBusinessCheckinList.add(new CheckIn(day, hour, count,
					businessid, type));

		}

		return perBusinessCheckinList;
	}

}
