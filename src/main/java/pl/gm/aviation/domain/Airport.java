package pl.gm.aviation.domain;

import pl.gm.aviation.domain.airportzones.airside.Airside;

import lombok.*;

import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Data
public class Airport {

    private Long id;
    private String airportName;
    private Airside airside;

    public Optional<Long> getId() {
        return Optional.ofNullable(this.id);
    }
}
