package com.example.Muebleria.Repositorio;

import com.example.Muebleria.Modelo.Kardex;
import com.example.Muebleria.Modelo.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface VentaRepo extends JpaRepository<Venta,Integer> {
    @Query("SELECT SUM(v.total) FROM Venta v WHERE v.estado = true")
    Double calcularTotalVentas();

}
