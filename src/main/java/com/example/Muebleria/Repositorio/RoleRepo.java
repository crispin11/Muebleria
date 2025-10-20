package com.example.Muebleria.Repositorio;

import com.example.Muebleria.Modelo.Role;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Integer> {
    @Query("UPDATE Role r SET r.estado = false WHERE r.id = :id")
    @Modifying
    @Transactional
    void eliminar(@Param("id") Integer id);
}
