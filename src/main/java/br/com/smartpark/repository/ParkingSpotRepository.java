package br.com.smartpark.repository;

import br.com.smartpark.model.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, Long> {
    // Exemplo de método customizado:
    // List<ParkingSpot> findByDisponivelTrue();
}
