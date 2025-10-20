package com.example.Muebleria.Repositorio;

import com.example.Muebleria.Modelo.MetodoPago;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoPagoRepo extends JpaRepository<MetodoPago,Integer> {
    @Query("UPDATE MetodoPago m SET m.estado = false WHERE m.id = :id")
    @Modifying
    @Transactional
    void eliminar(@Param("id") Integer id);
}
