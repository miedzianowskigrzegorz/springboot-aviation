package pl.gm.aviation.domain.airportzones.airside;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import pl.gm.aviation.domain.plane.Plane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@Data
public class Workshop {

    private Long id;
    private List<Plane> planesForRepair;

    public Workshop(Long id, @NonNull List<Plane> planes) {
        this.id = id;
        this.planesForRepair = planes;
    }

    public Workshop(@NonNull Plane... planes) {
        this.planesForRepair = new ArrayList<>(Arrays.asList(planes));
    }

    public List<Plane> getPlanes() {
        return this.planesForRepair;
    }

    public void addPlane(Plane plane) {
        this.planesForRepair.add(plane);
    }

    public void removePlane(Plane plane) {
        this.planesForRepair.remove(plane);
    }


}
