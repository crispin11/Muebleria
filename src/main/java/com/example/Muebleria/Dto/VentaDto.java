package com.example.Muebleria.Dto;

import com.example.Muebleria.Modelo.Cliente;
import com.example.Muebleria.Modelo.MetodoPago;
import com.example.Muebleria.Modelo.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
@Data
public class VentaDto {

    private Integer id;
    private String cliente;
    private String usuario;
    private String metodoPago;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fecha;
    private Double total;
    private boolean estado;

    public VentaDto(Integer id, String cliente, String usuario, String metodoPago, LocalDateTime fecha, Double total, boolean estado) {
        this.id = id;
        this.cliente = cliente;
        this.usuario = usuario;
        this.metodoPago = metodoPago;
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
    }
}

