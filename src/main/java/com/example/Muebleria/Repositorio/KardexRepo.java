package com.example.Muebleria.Repositorio;
import com.example.Muebleria.Modelo.Kardex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class KardexRepo  {
    @Autowired
    private  JdbcTemplate jdbcTemplate;


    public List<Kardex> obtenerKardex() {
        String sql = "EXEC dbo.kardex";  // Llamada al procedimiento almacenado
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Kardex kardex = new Kardex();
            kardex.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
            kardex.setProducto(rs.getString("producto"));
            kardex.setDetalle(rs.getString("detalle"));
            kardex.setEntradas(rs.getInt("entradas"));
            kardex.setSalidas(rs.getInt("salidas"));
            kardex.setStock(rs.getInt("stock"));
            return kardex;
        });
    }
}
