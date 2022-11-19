package pl.gm.aviation.application.port.out;

import pl.gm.aviation.domain.plane.Plane;

public interface LoadPlanePort {

    Plane loadPlaneFromHangar(Long id);
    Plane loadPlaneFromWorkshop(Long id);

}
