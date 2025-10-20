package com.example.Muebleria.Repositorio;

import com.example.Muebleria.Modelo.TipoProducto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProductoRepo extends JpaRepository<TipoProducto,Integer> {
    @Query("UPDATE TipoProducto t SET t.estado = false WHERE t.id = :id")
    @Modifying
    @Transactional
    void eliminar(@Param("id") Integer id);
}
