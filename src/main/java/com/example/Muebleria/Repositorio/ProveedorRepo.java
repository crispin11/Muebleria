package com.example.Muebleria.Repositorio;

import com.example.Muebleria.Modelo.Proveedor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepo extends JpaRepository<Proveedor,Integer> {
    @Query("UPDATE Proveedor p SET p.estado = false WHERE p.id = :id")
    @Modifying
    @Transactional
    void eliminar(@Param("id") Integer id);
}
