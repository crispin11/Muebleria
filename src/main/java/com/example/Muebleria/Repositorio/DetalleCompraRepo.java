package com.example.Muebleria.Repositorio;

import com.example.Muebleria.Modelo.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleCompraRepo extends JpaRepository<DetalleCompra,Integer> {
    List<DetalleCompra> findByCompraId(Integer compraId);
}
