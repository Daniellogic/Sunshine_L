package udacity.daniellogic.sunshinel;

/**
 * Created by daniellogic on 1/21/15.
 */

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDataParser {

    /**
     * Given a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex
     * (Note: 0-indexed, so 0 would refer to the first day).
     */
    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
            throws JSONException {
        // TODO: add parsing code here
        JSONObject allJson = new JSONObject(weatherJsonStr);

        //then we get the list
        try {
            JSONArray days = allJson.getJSONArray("list");
            //then we get the day
            JSONObject requestedDay = days.getJSONObject(dayIndex);
            //then we get the field (temp)
            JSONObject requestedField = requestedDay.getJSONObject("temp");
            //then we return the field's detail (max)
            return requestedField.getDouble("max");


        }catch (JSONException e)
        {
            Log.e("JSON ERROR",e.toString());
        }

        return -1;
    }

}
