package WeatherResponce.WeatherImpl;

import AccuWeatherAPI.APIKey;
import Util.GETRequest;
import Util.HoursFormat;
import WeatherResponce.WeatherInterface;
import org.json.JSONArray;

public class Hour12Weather implements WeatherInterface {

    @Override
    public String doesSomething(String locationKey) {
        String URL="http://dataservice.accuweather.com/forecasts/v1/hourly/12hour/";
        JSONArray res;
        try {
            res = (new JSONArray(GETRequest.sendRequest(URL + locationKey + APIKey.KEY+"&metric=true")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        StringBuilder ivrResponse= new StringBuilder();
        for (int i=0;i<res.length();i++){
            ivrResponse.append(HoursFormat.formatHours(res.getJSONObject(i), "In " + (i + 1) + " hour it will be "));
        }
        return ivrResponse.toString();
    }
}
