package pl.gm.aviation.application.port.out;

import pl.gm.aviation.domain.Airport;

public interface LoadAirportPort {

    Airport load(Long id);
}
