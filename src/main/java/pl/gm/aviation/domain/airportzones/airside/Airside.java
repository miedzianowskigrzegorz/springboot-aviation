package pl.gm.aviation.domain.airportzones.airside;

import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@NoArgsConstructor
@Data
public class Airside {

    private List<Hangar> hangars;

    public Airside(@NonNull List<Hangar> hangars) {
        this.hangars = hangars;
    }

    public Airside(@NonNull Hangar... hangars) {
        this.hangars = new ArrayList<>(Arrays.asList(hangars));
    }

    public List<Hangar> getHangars() {
        return Collections.unmodifiableList(this.hangars);
    }

    public void addHangar(Hangar hangar) {
        this.hangars.add(hangar);
    }

}
