package com.example.Muebleria.Repositorio;

import com.example.Muebleria.Modelo.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepo extends JpaRepository<Compra,Integer> {
    @Query("SELECT SUM(c.total) FROM Compra c WHERE c.estado = true")
    Double calcularTotalCompras();
}
