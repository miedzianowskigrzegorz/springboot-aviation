package pl.gm.aviation.domain.weather;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.Map;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Data
public class CurrentWeather {

    private Map<String,String> currentWeatherDetails;

}
