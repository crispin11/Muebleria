package com.example.Muebleria.Dto;

import com.example.Muebleria.Modelo.Proveedor;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
@Data
public class CompraDto {

    private Integer id;
    private String proveedor;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime fecha;
    private Double total;
    private boolean estado;

    public CompraDto(Integer id, String proveedor, LocalDateTime fecha, Double total, boolean estado) {
        this.id = id;
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
    }
}
