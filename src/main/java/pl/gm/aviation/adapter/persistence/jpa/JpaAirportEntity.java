package pl.gm.aviation.adapter.persistence.jpa;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "airports")
@Data
@AllArgsConstructor
@NoArgsConstructor
public
class JpaAirportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String airportName;
    @OneToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "airside_id")
    private JpaAirsideEntity airside;

//
//
//   private Landside landside;
//   private Support support;

}
