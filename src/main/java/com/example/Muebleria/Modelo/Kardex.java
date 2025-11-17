package com.example.Muebleria.Modelo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Data
public class Kardex {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime  fecha;
    private String producto;
    private String detalle;
    private int entradas;
    private int salidas;
    private int stock;


}
