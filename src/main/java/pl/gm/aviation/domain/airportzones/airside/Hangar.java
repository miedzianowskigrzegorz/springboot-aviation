package pl.gm.aviation.domain.airportzones.airside;

import lombok.*;
import pl.gm.aviation.domain.plane.Plane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@Data
public class Hangar {

    private Long id;
    private List<Plane> planes;

    public Hangar(Long id, @NonNull List<Plane> planes) {
        this.id = id;
        this.planes = planes;
    }

    public Hangar(@NonNull Plane... planes) {
        this.planes = new ArrayList<>(Arrays.asList(planes));
    }

    public List<Plane> getPlanes() {
        return this.planes;
    }

    public void addPlane(Plane plane) {
        this.planes.add(plane);
    }

    public void removePlane(Plane plane) {
        this.planes.remove(plane);
    }

}
