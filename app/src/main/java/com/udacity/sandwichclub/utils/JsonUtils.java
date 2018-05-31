package com.udacity.sandwichclub.utils;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collections;
import java.util.List;

import static android.content.ContentValues.TAG;

public class JsonUtils {

    public static parseSandwichJson(String json) throws JSONException {
        int position = 0;
        int i = position;

        try {
            JSONObject jsonData = new JSONObject(json);
            JSONArray sandwich_detailsArray = jsonData.getJSONArray("sandwich_details");

            for (i = 0; i < sandwich_detailsArray.length(); i++) {
                JSONObject jsonSandwich = sandwich_detailsArray.getJSONObject(i);
                String mainName = jsonSandwich.getString("mainName");
                List<String> alsoKnownAs = Collections.singletonList(jsonSandwich.getString("alsoKnownAs"));
                String placeOfOrigin = jsonSandwich.getString("placeOfOrigin");
                String description = jsonSandwich.getString("description");
                String image = jsonSandwich.getString("image");
                List<String> ingredients = Collections.singletonList(jsonSandwich.getString("ingredients"));

                Log.d(TAG, "Data download");
            }
        } catch(JSONException json) {
            json.printStackTrace();
            Log.e(TAG, "error processing parseSandwichJson: " + json.getMessage());
        }
        return null;
    }
}

