package pl.gm.aviation.application.port.out;

import pl.gm.aviation.domain.weather.CurrentWeather;

import java.io.IOException;

public interface LoadWeatherPort {

    CurrentWeather getCurrentWeather() throws IOException;

}
