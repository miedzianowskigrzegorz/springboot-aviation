package pl.gm.aviation.application.port.out;

import pl.gm.aviation.domain.airportzones.airside.Airside;

public interface LoadAirportZonesPort {

    Airside loadAirside(Long id);

}
