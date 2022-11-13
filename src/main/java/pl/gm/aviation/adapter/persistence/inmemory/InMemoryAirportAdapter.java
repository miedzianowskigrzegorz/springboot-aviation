package pl.gm.aviation.adapter.persistence.inmemory;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.gm.aviation.application.port.out.LoadAirportPort;
import pl.gm.aviation.application.port.out.LoadAirportZonesPort;
import pl.gm.aviation.application.port.out.LoadAirsideHangarsPort;
import pl.gm.aviation.application.port.out.LoadAirsideWorkshopPort;
import pl.gm.aviation.domain.Airport;
import pl.gm.aviation.domain.airportzones.airside.Airside;
import pl.gm.aviation.domain.airportzones.airside.Hangar;
import pl.gm.aviation.domain.airportzones.airside.Workshop;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InMemoryAirportAdapter implements
        LoadAirportPort,
        LoadAirportZonesPort,
        LoadAirsideHangarsPort,
        LoadAirsideWorkshopPort {

    private final InMemoryAirport inMemoryAirport = new InMemoryAirport();
    private final ModelMapper modelMapper;

    @Override
    public Airport load(Long id) {
        return modelMapper.map(inMemoryAirport.getAirport(), Airport.class);
    }

    @Override
    public Airside loadAirside(Long id) {
        return modelMapper.map(inMemoryAirport.getAirport().getAirside(), Airside.class);
    }

    @Override
    public Hangar loadHangar(Long id) {
        return modelMapper.map(inMemoryAirport.getAirport().getAirside().getHangars().stream()
                .filter(hangar -> hangar.getId().equals(id))
                .findAny()
                .orElse(null),Hangar.class);

    }

    @Override
    public List<Hangar> loadHangars(Long id) {
        return modelMapper.map(inMemoryAirport.getAirport().getAirside().getHangars(), ArrayList.class);
    }

    @Override
    public Workshop loadWorkshop(Long id) {
        return modelMapper.map(inMemoryAirport.getAirport().getAirside().getWorkshop(), Workshop.class);
    }

}
