package com.agencia.api.controlador;

import com.agencia.api.dao.CitaDAO;
import com.agencia.api.modelo.Cita;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/citas")
public class CitaRestController {

    private final CitaDAO citaDAO;

    public CitaRestController() {
        this.citaDAO = new CitaDAO();
    }

    /**
     * Este método responde a:
     * POST http://localhost:8080/api/citas/agendar
     * Recibe un JSON con los datos de la cita y la guarda en la BD.
     */
    @PostMapping("/agendar")
    public ResponseEntity<String> agendarCita(@RequestBody Cita cita) {
        try {
            boolean exito = citaDAO.agendarCita(cita);
            if (exito) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Cita agendada exitosamente.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar la cita.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el servidor: " + e.getMessage());
        }
    }
}