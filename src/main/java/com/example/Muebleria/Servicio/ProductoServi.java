package com.example.Muebleria.Servicio;
import com.example.Muebleria.Dto.ProductoDto;
import com.example.Muebleria.Modelo.Kardex;
import com.example.Muebleria.Modelo.Producto;
import com.example.Muebleria.Repositorio.ProductoRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductoServi {
    @Autowired
    private ProductoRepo repo;


    public List<ProductoDto> ObtenerTodo() {
        return repo.findAll().stream().filter(Producto::isEstado)
                .map(producto -> new ProductoDto(
                        producto.getId(),
                        producto.getNombre(),
                        producto.getTipoProducto().getNombre(),
                        producto.getMaterial().getNombre(),
                        producto.getCantidad(),
                        producto.getPrecio(),
                        producto.getMedidas(),
                        producto.getDescripcion(),
                        producto.isEstado()))
                .collect(Collectors.toList());
    }
    public Optional<ProductoDto> Buscar(Integer id){
        return repo.findById(id).filter(Producto::isEstado)
                .map(producto -> new ProductoDto(
                        producto.getId(),
                        producto.getNombre(),
                        producto.getTipoProducto().getNombre(),
                        producto.getMaterial().getNombre(),
                        producto.getCantidad(),
                        producto.getPrecio(),
                        producto.getMedidas(),
                        producto.getDescripcion(),
                        producto.isEstado()));
    }
    public  void Guardar_o_Modificar(Producto producto){

        repo.save(producto);
    }
    public  void eliminar(Integer id){
        repo.eliminar(id);
    }





}
