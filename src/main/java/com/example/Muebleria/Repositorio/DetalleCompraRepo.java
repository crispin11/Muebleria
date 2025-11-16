package com.example.Muebleria.Repositorio;

import com.example.Muebleria.Base.BaseRepository;
import com.example.Muebleria.Modelo.DetalleCompra;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface DetalleCompraRepo extends BaseRepository<DetalleCompra,Integer> {
    List<DetalleCompra> findByCompraId(Long compraId);
}
