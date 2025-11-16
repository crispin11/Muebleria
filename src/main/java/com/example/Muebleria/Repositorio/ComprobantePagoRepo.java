package com.example.Muebleria.Repositorio;

import com.example.Muebleria.Base.BaseRepository;
import com.example.Muebleria.Modelo.ComprobantePago;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprobantePagoRepo extends JpaRepository<ComprobantePago, Integer> {

}
