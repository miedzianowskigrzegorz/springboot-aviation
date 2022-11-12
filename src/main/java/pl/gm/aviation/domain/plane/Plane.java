package pl.gm.aviation.domain.plane;

import lombok.*;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Data
public class Plane {

    private Long id;
    private String planeType;
    private int planeMaximumPassengers;
    private int planeFuelLevel;
    private boolean planeSubmittedForRepair;

}
