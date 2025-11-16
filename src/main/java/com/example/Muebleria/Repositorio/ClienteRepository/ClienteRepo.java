package com.example.Muebleria.Repositorio.ClienteRepository;

import com.example.Muebleria.Base.BaseRepository;
import com.example.Muebleria.Modelo.Cliente;

import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepo extends BaseRepository <Cliente, Integer> {
}
