package WeatherResponce.WeatherImpl;

import AccuWeatherAPI.APIKey;
import Util.GETRequest;
import Util.HoursFormat;
import WeatherResponce.WeatherInterface;
import org.json.JSONArray;
import org.json.JSONObject;

public class Hour1Weather implements WeatherInterface {

    @Override
    public String doesSomething(JSONObject parameters) {
        String locationKey = parameters.getString("Key");
        String URL="http://dataservice.accuweather.com/forecasts/v1/hourly/1hour/";
        JSONObject res;

        String test=GETRequest.sendRequest(URL + locationKey + APIKey.KEY+"&metric=true");
        res = (new JSONArray(test)).getJSONObject(0);

        String ivrResponse = "In one hour it will be ";

        return HoursFormat.formatHours(res,ivrResponse);

    }
}
