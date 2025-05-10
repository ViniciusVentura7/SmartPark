package br.com.smartpark.service;

import br.com.smartpark.dto.CreateParkingSpotRequest;
import br.com.smartpark.dto.ParkingSpotResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSpotService {

    public List<ParkingSpotResponseDTO> listarVagasDisponiveis() {
        // TODO: implementar lógica
        return List.of();
    }

    public ParkingSpotResponseDTO cadastrarVaga(CreateParkingSpotRequest request) {
        // TODO: implementar lógica
        return new ParkingSpotResponseDTO();
    }

    public ParkingSpotResponseDTO buscarPorId(Long id) {
        // TODO: implementar lógica
        return new ParkingSpotResponseDTO();
    }

    public void removerVaga(Long id) {
        // TODO: implementar lógica
    }
}
