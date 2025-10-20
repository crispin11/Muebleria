package com.example.Muebleria.Controlador;
import com.example.Muebleria.Dto.ProductoDto;
import com.example.Muebleria.Modelo.Producto;
import com.example.Muebleria.Repositorio.*;
import com.example.Muebleria.Servicio.ProductoServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashBoard {
    @Autowired
    private ProductoRepo productoRepo;
    @Autowired
    private VentaRepo ventaRepo;
    @Autowired
    private CompraRepo compraRepo;
    @Autowired
    private ClienteRepo clienteRepo;
    @Autowired
    private DetalleVentaRepo dvrepo;
    @Autowired
    private ProductoServi servi;

    @GetMapping("/productos-mas-vendidos")
    public List<Map<String, Object>> obtenerProductosMasVendidos() {
        Pageable pageable = PageRequest.of(0, 5);
        List<Object[]> resultados = dvrepo.findTopProductosVendidos(pageable);

        List<Map<String, Object>> productosVendidos = new ArrayList<>();

        for (Object[] resultado : resultados) {
            Producto producto = (Producto) resultado[0];
            Long totalVendido = (Long) resultado[1];

            Map<String, Object> map = new HashMap<>();
            map.put("id", producto.getId());
            map.put("nombre", producto.getNombre());
            map.put("totalVendido", totalVendido);
            productosVendidos.add(map);
        }
        return productosVendidos;
    }
    @GetMapping("/productos-bajo-stock")
    public List<Map<String, Object>> obtenerProductoStockBajo() {
        int limiteStock = 10;
        List<Object[]> resultados = productoRepo.findProductosConBajoStock(limiteStock);

        List<Map<String, Object>> productosStockBajo = new ArrayList<>();

        for (Object[] resultado : resultados) {
            Producto producto = (Producto) resultado[0];

            Map<String, Object> map = new HashMap<>();
            map.put("id", producto.getId());
            map.put("nombre", producto.getNombre());
            map.put("cantidad", producto.getCantidad());
            productosStockBajo.add(map);
        }
        return productosStockBajo;
    }


    public List<Object[]> obtenerProductosConBajoStock() {
        int limiteStock = 10;
        return productoRepo.findProductosConBajoStock(limiteStock);

    }

    @GetMapping("/resumen")
    public Map<String, Object> obtenerResumen() {
        Map<String, Object> resumen = new HashMap<>();
        resumen.put("totalProductos", productoRepo.count());
        resumen.put("totalVentas", ventaRepo.calcularTotalVentas());
        resumen.put("totalCompras", compraRepo.calcularTotalCompras());
        resumen.put("totalClientes", clienteRepo.count());
        return resumen;
    }
}
