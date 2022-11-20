package pl.gm.aviation.adapter.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.gm.aviation.adapter.persistence.inmemory.InMemoryAirportAdapter;
import pl.gm.aviation.adapter.weather.WeatherAdapter;
import pl.gm.aviation.domain.Airport;
import pl.gm.aviation.domain.airportzones.airside.Hangar;
import pl.gm.aviation.domain.airportzones.airside.Workshop;
import pl.gm.aviation.domain.weather.CurrentWeather;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final InMemoryAirportAdapter inMemoryAirportAdapter;
    private final WeatherAdapter weatherAdapter;

    @ModelAttribute("airport")
    public Airport getAirport() {
        return inMemoryAirportAdapter.load(1L);
    }

    @ModelAttribute("airsideHangars")
    public List<Hangar> getAirsideHangars() {
        return inMemoryAirportAdapter.loadHangars(1L);
    }

    @ModelAttribute("workshop")
    public Workshop getWorkshop() {
        return inMemoryAirportAdapter.loadWorkshop(1L);
    }

    @ModelAttribute("currentWeather")
    public CurrentWeather getCurrentWeather() throws IOException {
        return weatherAdapter.getCurrentWeather();
    }

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

}
