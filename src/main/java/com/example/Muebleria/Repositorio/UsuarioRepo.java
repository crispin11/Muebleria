package com.example.Muebleria.Repositorio;

import com.example.Muebleria.Modelo.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario,Integer> {
    @Query("UPDATE Usuario u SET u.estado = false WHERE u.id = :id")
    @Modifying
    @Transactional
    void eliminar(@Param("id") Integer id);

   Usuario findByCorreo(String correo);
    boolean existsByCorreo(String username);
}
