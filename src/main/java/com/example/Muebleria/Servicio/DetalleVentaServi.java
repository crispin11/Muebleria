package com.example.Muebleria.Servicio;
import com.example.Muebleria.Dto.DetalleVentaDto;
import com.example.Muebleria.Dto.VentaDto;
import com.example.Muebleria.Modelo.DetalleVenta;
import com.example.Muebleria.Modelo.Producto;
import com.example.Muebleria.Modelo.Venta;
import com.example.Muebleria.Repositorio.DetalleVentaRepo;
import com.example.Muebleria.Repositorio.ProductoRepo;
import com.example.Muebleria.Repositorio.VentaRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DetalleVentaServi {
    @Autowired
    private DetalleVentaRepo repo;
    @Autowired
    private VentaRepo vrepo;
    @Autowired
    private ProductoRepo prepo;



    public List<DetalleVentaDto> ObtenerTodo() {
        return repo.findAll().stream().filter(DetalleVenta::isEstado)
                .map(detalleVenta -> new DetalleVentaDto(
                        detalleVenta.getId(),
                        detalleVenta.getVenta().getId(),
                        detalleVenta.getProducto().getNombre(),
                        detalleVenta.getCantidad(),
                        detalleVenta.getPrecioUnitario(),
                        detalleVenta.getSubtotal(),
                        detalleVenta.isEstado()))
                .collect(Collectors.toList());
    }
    public Optional<DetalleVentaDto> Buscar(Integer id){
        return repo.findById(id).filter(DetalleVenta::isEstado)
                .map(detalleVenta -> new DetalleVentaDto(
                        detalleVenta.getId(),
                        detalleVenta.getVenta().getId(),
                        detalleVenta.getProducto().getNombre(),
                        detalleVenta.getCantidad(),
                        detalleVenta.getPrecioUnitario(),
                        detalleVenta.getSubtotal(),
                        detalleVenta.isEstado()));
    }

    @Transactional
    public void agregarDetalleVenta(DetalleVenta detalleVenta) {

        if (detalleVenta.getVenta() == null || detalleVenta.getVenta().getId() == null) {
            throw new IllegalArgumentException("Debe especificar una venta válida.");
        }

        Venta venta = vrepo.findById(detalleVenta.getVenta().getId())
                .orElseThrow(() -> new IllegalArgumentException("Venta no encontrada"));

        detalleVenta.setVenta(venta);

        Producto producto = prepo.findById(detalleVenta.getProducto().getId())
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        if (producto.getCantidad() < detalleVenta.getCantidad()) {
            throw new IllegalArgumentException("Stock insuficiente para el producto.");
        }

        detalleVenta.setPrecioUnitario(producto.getPrecio());//
        detalleVenta.setSubtotal(detalleVenta.getCantidad() * producto.getPrecio());
        producto.setCantidad(producto.getCantidad() - detalleVenta.getCantidad());
        prepo.save(producto);
        detalleVenta.setEstado(true);
        repo.save(detalleVenta);


        double totalActual = venta.getTotal() == null ? 0 : venta.getTotal();
        venta.setTotal(totalActual + detalleVenta.getSubtotal());
        venta.setFecha(LocalDateTime.now());
        vrepo.save(venta);
    }


}
