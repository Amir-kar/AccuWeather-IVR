package RequestHandle;

import WeatherResponce.WeatherInterface;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import Options.Options;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;



public class Weather implements RequestHandler<Map<String, Object>, Map<String, String>> {
    @Override
    public Map<String, String> handleRequest(Map<String, Object> stringObjectMap, Context context) {

        JSONObject parameters = new JSONObject(stringObjectMap);

        parameters = parameters.getJSONObject("Details").getJSONObject("Parameters");
        String locationKey = parameters.getString("Key");

        try {
            Options op = Options.valueOf(parameters.getString("AskWeather"));
            WeatherInterface weatherClass = (WeatherInterface) op
                    .getWeatherType()
                    .getDeclaredConstructor()
                    .newInstance();

            Map<String, String> ret = new HashMap<>();
            ret.put("ret", weatherClass.doesSomething(locationKey));
            return ret;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
