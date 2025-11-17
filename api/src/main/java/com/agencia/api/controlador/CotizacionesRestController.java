package com.agencia.api.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
@RequestMapping("/api/cotizar")
public class CotizacionesRestController {

    // Esta es una tasa de interés fija de ejemplo.
    // En el futuro, podrías leerla de la base de datos.
    private static final double TASA_INTERES_ANUAL = 12.5;

    /**
     * Este método responde a una URL como:
     * GET http://localhost:8080/api/cotizar/simular?precio=500000&enganche=100000&plazo=36
     */
    @GetMapping("/simular")
    public CotizacionResponse simularCotizacion(
            @RequestParam double precio,
            @RequestParam double enganche,
            @RequestParam int plazo) {

        // --- ¡LÓGICA REUTILIZADA! ---
        // Esta es la misma lógica de cálculo de tu PagoControlador
        // Usamos BigDecimal para precisión monetaria.

        BigDecimal precioFinal = BigDecimal.valueOf(precio);
        BigDecimal bigEnganche = BigDecimal.valueOf(enganche);
        BigDecimal tasaInteres = BigDecimal.valueOf(TASA_INTERES_ANUAL / 100.0);

        BigDecimal montoAFinanciar = precioFinal.subtract(bigEnganche);

        // Asumimos un interés simple sobre el total del crédito
        BigDecimal interesTotal = montoAFinanciar.multiply(tasaInteres);
        BigDecimal totalAPagar = montoAFinanciar.add(interesTotal);

        // Monto de cada mensualidad
        BigDecimal montoMensual = totalAPagar.divide(BigDecimal.valueOf(plazo), 2, RoundingMode.HALF_UP);

        // Devolvemos un objeto JSON con el resultado
        return new CotizacionResponse(
                montoMensual.doubleValue(),
                montoAFinanciar.doubleValue(),
                totalAPagar.doubleValue(),
                plazo
        );
    }

    /**
     * Clase interna simple para formatear la respuesta JSON.
     * Spring Boot la convertirá automáticamente.
     */
    private static class CotizacionResponse {
        private final double pagoMensual;
        private final double montoFinanciado;
        private final double totalAPagar;
        private final int plazoMeses;

        public CotizacionResponse(double pagoMensual, double montoFinanciado, double totalAPagar, int plazoMeses) {
            this.pagoMensual = pagoMensual;
            this.montoFinanciado = montoFinanciado;
            this.totalAPagar = totalAPagar;
            this.plazoMeses = plazoMeses;
        }

        // Getters (necesarios para que Spring cree el JSON)
        public double getPagoMensual() { return pagoMensual; }
        public double getMontoFinanciado() { return montoFinanciado; }
        public double getTotalAPagar() { return totalAPagar; }
        public int getPlazoMeses() { return plazoMeses; }
    }
}