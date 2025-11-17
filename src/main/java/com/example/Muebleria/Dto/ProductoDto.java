package com.example.Muebleria.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductoDto {
    private Integer id;
    private String nombre;
    private String tipoProducto;
    private String material;
    private Integer cantidad;
    private Double precio;
    private String medidas;
    private String descripcion;
    private Boolean estado;


}
