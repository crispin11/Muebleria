package com.example.Muebleria.Dto;

import com.example.Muebleria.Modelo.Compra;
import com.example.Muebleria.Modelo.Producto;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class DetalleCompraDto {

    private Integer id;
    private Integer compra;
    private String producto;
    private Integer cantidad;
    private Double precioCompra;
    private Double subtotal;
    private boolean estado;

    public DetalleCompraDto(Integer id, Integer compra, String producto, Integer cantidad, Double precioCompra, Double subtotal, boolean estado) {
        this.id = id;
        this.compra = compra;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
        this.subtotal = subtotal;
        this.estado = estado;
    }
}
