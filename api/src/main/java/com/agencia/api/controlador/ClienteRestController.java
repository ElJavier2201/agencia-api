package com.agencia.api.controlador;

import com.agencia.api.controlador.dto.LoginRequest;
import com.agencia.api.dao.ClienteDAO;
import com.agencia.api.dao.PagoDAO;
import com.agencia.api.dao.VentaDAO;
import com.agencia.api.modelo.Cliente;
import com.agencia.api.modelo.Pago;
import com.agencia.api.modelo.Venta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteRestController {

    private final ClienteDAO clienteDAO;
    private final VentaDAO ventaDAO;
    private final PagoDAO pagoDAO;

    // Constructor que inicializa todos los DAOs que necesitamos
    public ClienteRestController() {
        this.clienteDAO = new ClienteDAO();
        this.ventaDAO = new VentaDAO();
        this.pagoDAO = new PagoDAO();
    }

    /**
     * Endpoint para el Login de Clientes
     * Responde a: POST http://localhost:8080/api/clientes/login
     */
    @PostMapping("/login")
    public ResponseEntity<Cliente> login(@RequestBody LoginRequest loginRequest) {
        Cliente cliente = clienteDAO.autenticar(loginRequest.getUsuario(), loginRequest.getPassword());

        if (cliente != null) {
            // Éxito: Devuelve el objeto del cliente (sin contraseña)
            return ResponseEntity.ok(cliente);
        } else {
            // Falla: Devuelve un error 401 (No Autorizado)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    /**
     * Endpoint para el "Estado de Cuenta" del cliente
     * Responde a: GET http://localhost:8080/api/clientes/{id}/ventas-financiadas
     */
    @GetMapping("/{idCliente}/ventas-financiadas")
    public ResponseEntity<List<Venta>> getVentasFinanciadas(@PathVariable int idCliente) {
        List<Venta> ventas = ventaDAO.listarVentasConFinanciamiento(idCliente);
        return ResponseEntity.ok(ventas);
    }

    /**
     * Endpoint para ver los pagos de UNA venta específica
     * Responde a: GET http://localhost:8080/api/clientes/ventas/{idVenta}/pagos
     */
    @GetMapping("/ventas/{idVenta}/pagos")
    public ResponseEntity<List<Pago>> getPagosDeVenta(@PathVariable int idVenta) {
        List<Pago> pagos = pagoDAO.listarPagosPorVenta(idVenta);
        return ResponseEntity.ok(pagos);
    }
}
