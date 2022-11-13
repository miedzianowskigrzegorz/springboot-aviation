package pl.gm.aviation.adapter.persistence.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "workshops")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JpaWorkshopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<JpaPlaneEntity> planesForRepair = new ArrayList<>();

    public JpaWorkshopEntity(List<JpaPlaneEntity> planes) {
        this.planesForRepair = planes;
    }

}
