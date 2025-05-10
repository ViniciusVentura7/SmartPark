package br.com.smartpark.service;

import br.com.smartpark.dto.CreateParkingSpotRequest;
import br.com.smartpark.dto.ParkingSpotResponseDTO;
import br.com.smartpark.model.ParkingSpotModel;
import br.com.smartpark.repository.ParkingSpotRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParkingSpotService {

    private final ParkingSpotRepository repository;

    public ParkingSpotService(ParkingSpotRepository repository) {
        this.repository = repository;
    }

    public List<ParkingSpotResponseDTO> listarVagasDisponiveis() {
        return repository.findAll().stream()
                .filter(ParkingSpotModel::isDisponivel)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ParkingSpotResponseDTO cadastrarVaga(CreateParkingSpotRequest request) {
        ParkingSpotModel spot = new ParkingSpotModel();
        spot.setEndereco(request.endereco);
        spot.setLatitude(request.latitude);
        spot.setLongitude(request.longitude);
        spot.setDisponivel(true);

        ParkingSpotModel saved = repository.save(spot);
        return toDTO(saved);
    }

    public ParkingSpotResponseDTO buscarPorId(Long id) {
        Optional<ParkingSpotModel> opt = repository.findById(id);
        return opt.map(this::toDTO).orElseThrow(() -> new RuntimeException("Vaga não encontrada"));
    }

    public void removerVaga(Long id) {
        repository.deleteById(id);
    }

    private ParkingSpotResponseDTO toDTO(ParkingSpotModel spot) {
        ParkingSpotResponseDTO dto = new ParkingSpotResponseDTO();
        dto.id = spot.getId();
        dto.endereco = spot.getEndereco();
        dto.disponivel = spot.isDisponivel();
        return dto;
    }
}
