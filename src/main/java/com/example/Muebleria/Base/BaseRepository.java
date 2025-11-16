package com.example.Muebleria.Base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

@NoRepositoryBean
public interface BaseRepository <T, ID> extends JpaRepository <T, ID> {
    @Modifying
    @Transactional
    @Query("UPDATE #{#entityName} e SET e.estado = false WHERE e.id = :id")
    void eliminar(ID id);
}
