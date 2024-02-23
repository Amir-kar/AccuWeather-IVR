package WeatherResponce.WeatherImpl;

import AccuWeatherAPI.APIKey;
import Util.GETRequest;
import Util.HoursFormat;
import WeatherResponce.WeatherInterface;
import org.json.JSONArray;
import org.json.JSONObject;

public class Hour1Weather implements WeatherInterface {

    @Override
    public String doesSomething(String locationKey) {
        String URL="http://dataservice.accuweather.com/forecasts/v1/hourly/1hour/";
        JSONObject res;
        try {
            res = (new JSONArray(GETRequest.sendRequest(URL + locationKey + APIKey.KEY+"&metric=true"))).getJSONObject(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String ivrResponse = "In one hour it will be ";

        return HoursFormat.formatHours(res,ivrResponse);

    }
}
