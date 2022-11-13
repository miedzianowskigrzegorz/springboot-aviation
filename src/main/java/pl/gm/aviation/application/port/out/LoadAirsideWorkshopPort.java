package pl.gm.aviation.application.port.out;

import org.hibernate.jdbc.Work;
import pl.gm.aviation.domain.airportzones.airside.Workshop;

public interface LoadAirsideWorkshopPort {

    Workshop loadWorkshop(Long id);

}