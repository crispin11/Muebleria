package com.example.Muebleria.Repositorio;

import com.example.Muebleria.Modelo.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente,Integer> {
    @Query("UPDATE Cliente c SET c.estado = false WHERE c.id = :id")
    @Modifying
    @Transactional
    void eliminar(@Param("id") Integer id);
}
