package pl.gm.aviation.application.port.out;

import pl.gm.aviation.domain.airportzones.airside.Hangar;

public interface UpdateHangarStatePort {

    void updateHangarState(Hangar hangar);

}
