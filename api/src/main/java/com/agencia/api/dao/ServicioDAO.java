package com.agencia.api.dao;

import com.agencia.api.modelo.Servicio;
import com.agencia.api.util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicioDAO extends BaseDAO {

    /**
     * Helper para mapear un ResultSet a un objeto Servicio
     */
    private Servicio mapearServicio(ResultSet rs) throws SQLException {
        Servicio s = new Servicio();
        s.setIdServicio(rs.getInt("id_servicio"));
        s.setNombre(rs.getString("nombre"));
        s.setDescripcion(rs.getString("descripcion"));
        s.setIdTipoServicio(rs.getInt("id_tipo_servicio"));
        s.setPrecioBase(rs.getDouble("precio_base"));
        s.setDuracionEstimadaMin(rs.getInt("duracion_estimada_min"));
        // Campo del JOIN
        s.setNombreTipo(rs.getString("nombre_tipo"));
        return s;
    }

    /**
     * Lista todos los servicios disponibles, uniendo el nombre del tipo.
     */
    public List<Servicio> listarServicios() {
        List<Servicio> lista = new ArrayList<>();
        String sql = "SELECT s.*, ts.nombre_tipo " +
                "FROM servicios s " +
                "JOIN tipos_servicio ts ON s.id_tipo_servicio = ts.id_tipo_servicio " +
                "ORDER BY ts.nombre_tipo, s.nombre";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(mapearServicio(rs));
            }
            logger.info("Se obtuvieron {} servicios", lista.size());

        } catch (SQLException e) {
            logError("listarServicios", e);
        }
        return lista;
    }
}