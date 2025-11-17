package com.example.Muebleria.Repositorio;

import com.example.Muebleria.Dto.ProductoDto;
import com.example.Muebleria.Modelo.Kardex;
import com.example.Muebleria.Modelo.Producto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepo extends JpaRepository<Producto,Integer> {
    @Query("UPDATE Producto p SET p.estado = false WHERE p.id = :id")
    @Modifying
    @Transactional
    void eliminar(@Param("id") Integer id);

    @Query("SELECT p FROM Producto p WHERE p.cantidad <= :limiteStock")
    List<Object[]> findProductosConBajoStock(@Param("limiteStock") int limiteStock);

    @Transactional
    @Procedure(name = "Gkardex")
    List<Kardex>Kardex();
}
