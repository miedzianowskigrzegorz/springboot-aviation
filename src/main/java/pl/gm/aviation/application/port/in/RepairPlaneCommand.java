package pl.gm.aviation.application.port.in;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import pl.gm.aviation.domain.airportzones.airside.Hangar;
import pl.gm.aviation.domain.airportzones.airside.Workshop;
import pl.gm.aviation.domain.plane.Plane;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class RepairPlaneCommand {

    @NotNull
    private final Hangar hangar;

    @NotNull
    private final Workshop workshop;

    @NotNull
    private final Plane plane;

}
