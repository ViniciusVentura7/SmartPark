package br.com.smartpark;

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

    // GET /api/vagas
    @GetMapping
    public ResponseEntity<List<ParkingSpotResponseDTO>> listarVagasDisponiveis() {
        return ResponseEntity.ok(parkingSpotService.listarVagasDisponiveis());
    }

    // POST /api/vagas
    @PostMapping
    public ResponseEntity<ParkingSpotResponseDTO> cadastrarVaga(@RequestBody CreateParkingSpotRequest request) {
        return ResponseEntity.ok(parkingSpotService.cadastrarVaga(request));
    }

    // GET /api/vagas/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpotResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(parkingSpotService.buscarPorId(id));
    }

    // DELETE /api/vagas/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerVaga(@PathVariable Long id) {
        parkingSpotService.removerVaga(id);
        return ResponseEntity.noContent().build();
    }
}
