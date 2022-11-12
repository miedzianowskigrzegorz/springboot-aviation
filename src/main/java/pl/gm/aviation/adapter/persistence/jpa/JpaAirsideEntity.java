package pl.gm.aviation.adapter.persistence.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "airsides")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class JpaAirsideEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(fetch = FetchType.EAGER)
    private List<JpaHangarEntity> hangars = new ArrayList<>();
}
