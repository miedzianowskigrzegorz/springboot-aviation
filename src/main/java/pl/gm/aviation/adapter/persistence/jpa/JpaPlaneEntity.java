package pl.gm.aviation.adapter.persistence.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "planes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JpaPlaneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String planeType;
    private int planeMaximumPassengers;
    private int planeFuelLevel;
    private boolean planeSubmittedForRepair;
}
