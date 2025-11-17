package com.example.Muebleria.Repositorio;

import com.example.Muebleria.Modelo.ComprobantePago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprobantePagoRepo extends JpaRepository<ComprobantePago,Integer> {

}
