package com.example.Muebleria.Repositorio;

import com.example.Muebleria.Base.BaseRepository;
import com.example.Muebleria.Modelo.Compra;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepo extends BaseRepository<Compra, Long> {
    @Query("SELECT SUM(c.total) FROM Compra c WHERE c.estado = true")
    Double calcularTotalCompras();
}
