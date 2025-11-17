
package com.agencia.api.controlador;

// Asegúrate de que los imports apunten a tus paquetes nuevos
import com.agencia.api.dao.VehiculoDAO;
import com.agencia.api.modelo.Vehiculo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/vehiculos") // URL base
public class VehiculoRestController {

    private final VehiculoDAO vehiculoDAO;

    // Constructor
    public VehiculoRestController() {
        // Instanciamos el DAO exactamente como lo hacías en Swing
        this.vehiculoDAO = new VehiculoDAO();
    }

    /**
     * Este método responde a:
     * GET http://localhost:8080/api/vehiculos/catalogo
     */
    @GetMapping("/catalogo")
    public List<Vehiculo> getCatalogoDisponible() {
        // ¡Reutilizando tu código DAO existente!
        return vehiculoDAO.listarVehiculosDisponibles();
    }
}
