package com.agencia.api.dao;

import com.agencia.api.modelo.Cita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CitaDAO extends BaseDAO {

    /**
     * Inserta una nueva cita en la base de datos.
     * Devuelve true si fue exitoso.
     */
    public boolean agendarCita(Cita cita) {
        String sql = "INSERT INTO citas (id_servicio, id_cliente, nombre_cliente, email_cliente, telefono_cliente, " +
                "vehiculo_info, vehiculo_anio, fecha_cita, hora_cita, comentarios, estado) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'AGENDADA')";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, cita.getIdServicio());

            if (cita.getIdCliente() != null && cita.getIdCliente() > 0) {
                ps.setInt(2, cita.getIdCliente());
            } else {
                ps.setNull(2, java.sql.Types.INTEGER);
            }

            ps.setString(3, cita.getNombreCliente());
            ps.setString(4, cita.getEmailCliente());
            ps.setString(5, cita.getTelefonoCliente());
            ps.setString(6, cita.getVehiculoInfo());
            ps.setInt(7, cita.getVehiculoAnio());
            ps.setDate(8, cita.getFechaCita());
            ps.setTime(9, cita.getHoraCita());
            ps.setString(10, cita.getComentarios());

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                logger.info("Nueva cita agendada exitosamente.");
                return true;
            }

        } catch (SQLException e) {
            logError("agendarCita", e);
        }
        return false;
    }
}