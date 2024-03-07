package Options;

import WeatherResponce.WeatherImpl.*;

public enum Options {
    FIND( FindKey.class),
    CURRENT( CurrentWeather.class),
    HOURS_1( Hour1Weather.class),
    HOURS_2(Hour2Weather .class),
    HOURS_4(Hour4Weather .class),
    HOURS_6( Hour6Weather.class),
    HOURS_12(Hour12Weather .class);
    private final Class<?> weatherType;

    Options( Class<?> weatherTypeClass) {
        this.weatherType = weatherTypeClass;
    }

    public Class<?> getWeatherType() {
        return weatherType;
    }
}