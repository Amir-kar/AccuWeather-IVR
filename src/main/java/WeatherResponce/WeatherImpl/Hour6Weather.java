package WeatherResponce.WeatherImpl;

import AccuWeatherAPI.APIKey;
import Util.GETRequest;
import Util.HoursFormat;
import WeatherResponce.WeatherInterface;
import org.json.JSONArray;
import org.json.JSONObject;

public class Hour6Weather implements WeatherInterface {

    @Override
    public String doesSomething(JSONObject parameters) {
        String locationKey = parameters.getString("Key");
        String URL="http://dataservice.accuweather.com/forecasts/v1/hourly/12hour/";
        JSONArray res = (new JSONArray(GETRequest.sendRequest(URL + locationKey + APIKey.KEY+"&metric=true")));

        StringBuilder ivrResponse= new StringBuilder();
        for (int i=0;i<6;i++){
            ivrResponse.append(HoursFormat.formatHours(res.getJSONObject(i), "In " + (i + 1) + " hour it will be "));
        }
        return ivrResponse.toString();
    }
}
