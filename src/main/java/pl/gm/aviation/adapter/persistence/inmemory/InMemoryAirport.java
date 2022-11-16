package pl.gm.aviation.adapter.persistence.inmemory;

import lombok.Data;
import pl.gm.aviation.adapter.persistence.jpa.*;
import pl.gm.aviation.domain.Airport;
import pl.gm.aviation.domain.airportzones.airside.Airside;
import pl.gm.aviation.domain.airportzones.airside.Hangar;
import pl.gm.aviation.domain.airportzones.airside.Workshop;
import pl.gm.aviation.domain.plane.Plane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class InMemoryAirport {
     private Airport airport;

    InMemoryAirport() {

        Airside airside = new Airside();
        airside.setId(1L);

        Plane plane = new Plane(1L,"Boeing 747-400",524,100,false);
        Plane plane2 = new Plane(2L,"Boeing 747-400",524,100,false);
        Plane plane3 = new Plane(3L,"Boeing 747-400",524,100,true);
        Plane plane4 = new Plane(4L,"Boeing 747-400",524,100,false);
        Plane plane5 = new Plane(5L,"Boeing 747-400",524,100,true);
        Plane plane6 = new Plane(6L,"Boeing 747-400",524,100,true);
        Plane plane7 = new Plane(7L,"Boeing 747-400",524,100,true);

        List<Hangar> hangars = new ArrayList<>();
        hangars.add(new Hangar(1L,new ArrayList<>(List.of(plane))));
        hangars.add(new Hangar(2L,new ArrayList<>(List.of(plane2,plane5))));
        hangars.add(new Hangar(3L,new ArrayList<>(List.of(plane3))));
        hangars.add(new Hangar(4L,new ArrayList<>(List.of(plane4))));

        Workshop workshop = new Workshop(1L,new ArrayList<Plane>(List.of(plane6,plane7)));

        airside.setHangars(hangars);
        airside.setWorkshop(workshop);

        this.airport = new Airport(1L,"Chopin Airport in Warsaw",airside);

    }

    public Hangar findHangarById(Long id) {
        return airport.getAirside().getHangars().stream()
                .filter(hangar -> hangar.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public Plane findPlaneById( Long id) {

        List<Hangar> hangars = this.airport.getAirside().getHangars();
        Plane searchedPlane = null;
        for (Hangar hangar : hangars) {
            List<Plane> planes = hangar.getPlanes();
            for (Plane plane : planes) {
                if (plane.getId().equals(id)) {
                    searchedPlane = plane;
                }
            }
        }
        return searchedPlane;

    }

    public void upgradeHangarState(Hangar hangar) {

    }

}
