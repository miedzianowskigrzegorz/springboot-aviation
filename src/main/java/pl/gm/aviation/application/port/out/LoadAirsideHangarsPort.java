package pl.gm.aviation.application.port.out;

import pl.gm.aviation.domain.airportzones.airside.Airside;
import pl.gm.aviation.domain.airportzones.airside.Hangar;

import java.util.List;

public interface LoadAirsideHangarsPort {

    Hangar loadHangar(Long id);
    List<Hangar> loadHangars(Long id);
}
