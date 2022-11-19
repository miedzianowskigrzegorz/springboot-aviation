package pl.gm.aviation.adapter.persistence.inmemory;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;
import pl.gm.aviation.application.port.out.*;
import pl.gm.aviation.domain.Airport;
import pl.gm.aviation.domain.airportzones.airside.Airside;
import pl.gm.aviation.domain.airportzones.airside.Hangar;
import pl.gm.aviation.domain.airportzones.airside.Workshop;
import pl.gm.aviation.domain.plane.Plane;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InMemoryAirportAdapter implements
        LoadAirportPort,
        LoadAirportZonesPort,
        LoadAirsideHangarsPort,
        LoadAirsideWorkshopPort,
        LoadPlanePort,
        UpdateWorkshopStatePort,
        UpdateHangarStatePort {

    private final InMemoryAirport inMemoryAirport = new InMemoryAirport();

    @Override
    public Airport load(Long id) {
        return inMemoryAirport.getAirport();
    }

    @Override
    public Airside loadAirside(Long id) {
        return inMemoryAirport.getAirport().getAirside();
    }

    @Override
    public Hangar loadHangar(Long id) {
        return inMemoryAirport.findHangarById(id);

    }

    @Override
    public List<Hangar> loadHangars(Long id) {
        return inMemoryAirport.getAirport().getAirside().getHangars();
    }

    @Override
    public Workshop loadWorkshop(Long id) {
        return inMemoryAirport.getAirport().getAirside().getWorkshop();
    }

    @Override
    public void updateWorkshopState(Workshop workshop) {
        inMemoryAirport.getAirport().getAirside().setWorkshop(workshop);

    }@Override
    public void updateHangarState(Hangar hangar) {

        inMemoryAirport.upgradeHangarState(hangar);

    }

    @Override
    public Plane loadPlaneFromHangar(Long id) {

        return inMemoryAirport.findPlaneInHangarById(id);

    }

    @Override
    public Plane loadPlaneFromWorkshop(Long id) {

        return inMemoryAirport.findPlaneInWorkshopById(id);

    }
}
