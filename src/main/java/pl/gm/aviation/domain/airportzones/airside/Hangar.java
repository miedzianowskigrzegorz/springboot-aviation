package pl.gm.aviation.domain.airportzones.airside;

import lombok.*;
import pl.gm.aviation.domain.plane.Plane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@NoArgsConstructor
@Data
public class Hangar {
    private List<Plane> planes;

    public Hangar(@NonNull List<Plane> planes) {
        this.planes = planes;
    }

    public Hangar(@NonNull Plane... planes) {
        this.planes = new ArrayList<>(Arrays.asList(planes));
    }

    public List<Plane> getPlanes() {
        return Collections.unmodifiableList(this.planes);
    }

    public void addPlane(Plane plane) {
        this.planes.add(plane);
    }
}
