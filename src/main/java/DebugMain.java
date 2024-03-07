import RequestHandle.Weather;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class DebugMain {
    public static void main(String[] args) throws IOException {
        Weather weather=new Weather();
        String test=new String(
         Files.readAllBytes(Path.of("C:\\Users\\karpo\\Desktop\\WeatherIVR\\src\\main\\java\\test.JSON")));
        JSONObject jsonObject=new JSONObject(test);
        System.out.println( weather.handleRequest(jsonObject.toMap(),null));
    }
}
