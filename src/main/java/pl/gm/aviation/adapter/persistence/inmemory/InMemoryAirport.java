package pl.gm.aviation.adapter.persistence.inmemory;

import lombok.Getter;
import pl.gm.aviation.adapter.persistence.jpa.*;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAirport {
    @Getter private final JpaAirportEntity airport;

    InMemoryAirport() {

        JpaAirsideEntity airside = new JpaAirsideEntity();

        JpaPlaneEntity plane = new JpaPlaneEntity(1L,"Boeing 747-400",524,100,false);
        JpaPlaneEntity plane2 = new JpaPlaneEntity(2L,"Boeing 747-400",524,100,false);
        JpaPlaneEntity plane3 = new JpaPlaneEntity(3L,"Boeing 747-400",524,100,false);
        JpaPlaneEntity plane4 = new JpaPlaneEntity(4L,"Boeing 747-400",524,100,false);
        JpaPlaneEntity plane5 = new JpaPlaneEntity(5L,"Boeing 747-400",524,100,false);
        JpaPlaneEntity plane6 = new JpaPlaneEntity(6L,"Boeing 747-400",524,100,true);
        JpaPlaneEntity plane7 = new JpaPlaneEntity(7L,"Boeing 747-400",524,100,true);


        List<JpaHangarEntity> hangars = new ArrayList<>();
        hangars.add(new JpaHangarEntity(1L,List.of(plane)));
        hangars.add(new JpaHangarEntity(2L,List.of(plane2,plane5)));
        hangars.add(new JpaHangarEntity(3L,List.of(plane3)));
        hangars.add(new JpaHangarEntity(4L,List.of(plane4)));

        JpaWorkshopEntity workshop = new JpaWorkshopEntity(1L,List.of(plane6,plane7));

        airside.setHangars(hangars);
        airside.setWorkshop(workshop);

        this.airport = new JpaAirportEntity(1L,"Chopin Airport in Warsaw",airside);
    }
}
