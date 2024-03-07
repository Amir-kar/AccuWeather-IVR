package WeatherResponce.WeatherImpl;

import WeatherResponce.WeatherInterface;
import AccuWeatherAPI.APIKey;
import Util.GETRequest;
import org.json.JSONArray;
import org.json.JSONObject;

public class CurrentWeather implements WeatherInterface {

    @Override
    public String doesSomething(JSONObject parameters) {
        String locationKey = parameters.getString("Key");

        String URL = "http://dataservice.accuweather.com/currentconditions/v1/";
        JSONObject res = (new JSONArray(GETRequest.sendRequest(URL + locationKey + APIKey.KEY))).getJSONObject(0);
        String ivrResponse = "It is currently ";
        if (res.getBoolean("IsDayTime"))
            ivrResponse += "Day Time";
        else
            ivrResponse += "Night Time";
        ivrResponse += " with it being " + res.getString("WeatherText");
        ivrResponse += ". The current temperature is " + res.getJSONObject("Temperature").getJSONObject("Metric").getInt("Value")
                + " degrees celsius. ";
        if (res.getBoolean("HasPrecipitation"))
            ivrResponse += "It is currently there is "
                    + res.getString("PrecipitationIntensity")
                    + res.getString("PrecipitationType");
        else
            ivrResponse += "There is no precipitation.";
        return ivrResponse;

    }
}
