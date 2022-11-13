package pl.gm.aviation.application.port.out;

import pl.gm.aviation.domain.plane.Plane;

public interface LoadPlanePort {

    Plane loadPlane(Long id);

}
