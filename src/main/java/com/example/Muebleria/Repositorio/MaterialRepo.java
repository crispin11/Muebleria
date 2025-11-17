package com.example.Muebleria.Repositorio;

import com.example.Muebleria.Modelo.Material;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepo extends JpaRepository<Material,Integer> {
    @Query("UPDATE Material m SET m.estado = false WHERE m.id = :id")
    @Modifying
    @Transactional
    void eliminar(@Param("id") Integer id);
}
