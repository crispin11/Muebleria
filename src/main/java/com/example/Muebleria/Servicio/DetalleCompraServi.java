package com.example.Muebleria.Servicio;
import com.example.Muebleria.Dto.DetalleCompraDto;
import com.example.Muebleria.Dto.VentaDto;
import com.example.Muebleria.Modelo.Compra;
import com.example.Muebleria.Modelo.DetalleCompra;
import com.example.Muebleria.Modelo.Producto;
import com.example.Muebleria.Modelo.Venta;
import com.example.Muebleria.Repositorio.CompraRepo;
import com.example.Muebleria.Repositorio.DetalleCompraRepo;
import com.example.Muebleria.Repositorio.ProductoRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DetalleCompraServi {
    @Autowired
    private DetalleCompraRepo repo;
    @Autowired
    private ProductoRepo prepo;
    @Autowired
    private CompraRepo crepo;


    public List<DetalleCompraDto> ObtenerTodo() {
        return repo.findAll().stream().filter(DetalleCompra::isEstado)
                .map(detalleCompra -> new DetalleCompraDto(
                        detalleCompra.getId(),
                        detalleCompra.getCompra().getId(),
                        detalleCompra.getProducto().getNombre(),
                        detalleCompra.getCantidad(),
                        detalleCompra.getPrecioCompra(),
                        detalleCompra.getSubtotal(),
                        detalleCompra.isEstado()))
                .collect(Collectors.toList());
    }
    public Optional<DetalleCompraDto> Buscar(Integer id){

        return repo.findById(id).filter(DetalleCompra::isEstado)
                .map(detalleCompra -> new DetalleCompraDto(
                        detalleCompra.getId(),
                        detalleCompra.getCompra().getId(),
                        detalleCompra.getProducto().getNombre(),
                        detalleCompra.getCantidad(),
                        detalleCompra.getPrecioCompra(),
                        detalleCompra.getSubtotal(),
                        detalleCompra.isEstado()));
    }

    @Transactional
    public void agregarDetalleCompra(DetalleCompra detalleCompra) {

        if (detalleCompra.getCompra() == null || detalleCompra.getCompra().getId() == null) {
            throw new IllegalArgumentException("Debe especificar una compra válida.");
        }
        Compra compra = crepo.findById(detalleCompra.getCompra().getId())
                .orElseThrow(() -> new IllegalArgumentException("Compra no encontrada"));
        detalleCompra.setCompra(compra);

        Producto producto = prepo.findById(detalleCompra.getProducto().getId())
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));


        producto.setCantidad(producto.getCantidad() + detalleCompra.getCantidad());
        prepo.save(producto);

        detalleCompra.setSubtotal(detalleCompra.getCantidad() * detalleCompra.getPrecioCompra());
        detalleCompra.setEstado(true);
        repo.save(detalleCompra);


        double totalActual = compra.getTotal() == null ? 0 : compra.getTotal();
        compra.setTotal(totalActual + detalleCompra.getSubtotal());
        compra.setFecha(LocalDateTime.now());
        crepo.save(compra);
    }

}
