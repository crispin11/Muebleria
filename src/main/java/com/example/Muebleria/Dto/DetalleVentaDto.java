package com.example.Muebleria.Dto;

import com.example.Muebleria.Modelo.Producto;
import com.example.Muebleria.Modelo.Venta;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class DetalleVentaDto {
    private Integer id;
    private Integer venta;
    private String producto;
    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;
    private boolean estado;

    public DetalleVentaDto(Integer id, Integer venta, String producto, Integer cantidad, Double precioUnitario, Double subtotal, boolean estado) {
        this.id = id;
        this.venta = venta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
        this.estado = estado;
    }
}
