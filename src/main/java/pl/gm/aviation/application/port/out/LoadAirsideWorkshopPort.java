package pl.gm.aviation.application.port.out;

import pl.gm.aviation.domain.airportzones.airside.Workshop;

public interface LoadAirsideWorkshopPort {

    Workshop loadWorkshop(Long id);

}