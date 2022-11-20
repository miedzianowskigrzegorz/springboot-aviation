package pl.gm.aviation.adapter.weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.gm.aviation.application.port.out.LoadWeatherPort;
import pl.gm.aviation.domain.weather.CurrentWeather;

import java.io.IOException;
import java.net.URL;

@Component
@RequiredArgsConstructor
public class WeatherAdapter implements LoadWeatherPort {

    private final String DAILY_WEATHER_URL = "https://api.open-meteo.com/v1/forecast?latitude=52.31&longitude=20.98&current_weather=true&timezone=Europe%2FBerlin";
    private final ObjectMapper objectMapper = new ObjectMapper();

    private DailyWeather getDailyWeather() throws IOException {

        URL weather = new URL(DAILY_WEATHER_URL);
        DailyWeather dailyWeather = objectMapper.readValue(weather, DailyWeather.class);
        return dailyWeather;

    }

    @Override
    public CurrentWeather getCurrentWeather() throws IOException {

        return new CurrentWeather(getDailyWeather().getCurrentWeather());

    }
}
