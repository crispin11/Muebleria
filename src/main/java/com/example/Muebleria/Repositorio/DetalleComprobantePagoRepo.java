package com.example.Muebleria.Repositorio;

import com.example.Muebleria.Modelo.DetalleComprobantePago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleComprobantePagoRepo extends JpaRepository<DetalleComprobantePago,Integer> {
}
