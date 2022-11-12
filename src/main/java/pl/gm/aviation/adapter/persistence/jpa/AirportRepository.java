package pl.gm.aviation.adapter.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<JpaAirportEntity,Long> {
}
