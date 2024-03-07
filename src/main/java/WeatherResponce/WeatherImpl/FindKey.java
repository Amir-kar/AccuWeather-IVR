package WeatherResponce.WeatherImpl;

import AccuWeatherAPI.APIKey;
import Util.GETRequest;
import WeatherResponce.WeatherInterface;
import org.json.JSONObject;

public class FindKey implements WeatherInterface {
    @Override
    public String doesSomething(JSONObject parameters) {
        String lat=parameters.getString("lat");
        String lon=parameters.getString("lon");
        String URL= "http://dataservice.accuweather.com/locations/v1/cities/geoposition/search";

        return GETRequest.sendRequest(URL + APIKey.KEY + "&q="+lat+"%2C"+lon);
    }
}
