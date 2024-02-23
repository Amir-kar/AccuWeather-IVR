package Util;

import org.json.JSONObject;

public class HoursFormat {
    public static String formatHours(JSONObject res,String ivrResponse){
        if (res.getBoolean("IsDaylight"))
            ivrResponse += "Day Time.";
        else
            ivrResponse += "Night Time.";

        ivrResponse += " The temperature will be " + res.getJSONObject("Temperature").getInt("Value")
                + " degrees celsius. ";
        if (res.getBoolean("HasPrecipitation"))
            ivrResponse += "There will be "
                    + res.getString("PrecipitationIntensity")
                    + res.getString("PrecipitationType");
        else
            ivrResponse += "It will not be not precipitating. ";
        return ivrResponse;
    }
}
