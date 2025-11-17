package com.agencia.api.controlador;

import com.agencia.api.dao.ServicioDAO;
import com.agencia.api.modelo.Servicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/servicios")
public class ServicioRestController {

    private final ServicioDAO servicioDAO;

    public ServicioRestController() {
        this.servicioDAO = new ServicioDAO();
    }

    /**
     * Este método responde a:
     * GET http://localhost:8080/api/servicios
     */
    @GetMapping
    public ResponseEntity<List<Servicio>> getTodosLosServicios() {
        List<Servicio> servicios = servicioDAO.listarServicios();
        if (servicios.isEmpty()) {
            return ResponseEntity.noContent().build(); // Devuelve 204 si no hay servicios
        }
        return ResponseEntity.ok(servicios); // Devuelve 200 OK con la lista
    }
}