package br.com.smartpark.controller;

import br.com.smartpark.dto.CreateParkingSpotRequest;
import br.com.smartpark.dto.ParkingSpotResponseDTO;
import br.com.smartpark.service.ParkingSpotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vagas")
public class ParkingSpotController {

    private final ParkingSpotService parkingSpotService;

    public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    @GetMapping
    public ResponseEntity<List<ParkingSpotResponseDTO>> listarVagasDisponiveis() {
        return ResponseEntity.ok(parkingSpotService.listarVagasDisponiveis());
    }

    @PostMapping
    public ResponseEntity<ParkingSpotResponseDTO> cadastrarVaga(@RequestBody CreateParkingSpotRequest request) {
        return ResponseEntity.ok(parkingSpotService.cadastrarVaga(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpotResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(parkingSpotService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerVaga(@PathVariable Long id) {
        parkingSpotService.removerVaga(id);
        return ResponseEntity.noContent().build();
    }
}
