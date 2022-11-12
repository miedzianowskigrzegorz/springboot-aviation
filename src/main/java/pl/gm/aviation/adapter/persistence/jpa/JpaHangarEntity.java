package pl.gm.aviation.adapter.persistence.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hangars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JpaHangarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(fetch = FetchType.EAGER)
    private List<JpaPlaneEntity> planes = new ArrayList<>();

    public JpaHangarEntity(List<JpaPlaneEntity> planes) {
        this.planes = planes;
    }
}
