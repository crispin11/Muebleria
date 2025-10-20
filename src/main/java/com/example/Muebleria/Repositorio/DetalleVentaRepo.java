package com.example.Muebleria.Repositorio;

import com.example.Muebleria.Modelo.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface DetalleVentaRepo extends JpaRepository<DetalleVenta,Integer> {
    @Query ("SELECT dv.producto, SUM(dv.cantidad) as totalVendido " +
            "FROM DetalleVenta dv GROUP BY dv.producto ORDER BY totalVendido DESC")
    List<Object[]> findTopProductosVendidos(Pageable pageable);
    List<DetalleVenta> findByVentaId(Integer idVenta);
}
