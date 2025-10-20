package com.example.Muebleria.Controlador;

import com.example.Muebleria.Dto.DetalleVentaDto;
import com.example.Muebleria.Modelo.Cliente;
import com.example.Muebleria.Modelo.DetalleVenta;
import com.example.Muebleria.Servicio.ClienteServi;
import com.example.Muebleria.Servicio.DetalleVentaServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalleventa")
public class DetalleVentaControlador {
    @Autowired
    private DetalleVentaServi servi;

    @GetMapping("/ver")
    public List<DetalleVentaDto> ver(){
        return  servi.ObtenerTodo();
    }
    @GetMapping("/buscarid/{id}")
    public Optional<DetalleVentaDto> Buscar(@PathVariable("id") Integer id){
        return  servi.Buscar(id);
    }

    @PostMapping("/agregar")
    public void agregarDetalle(@RequestBody DetalleVenta detalleVenta) {
            servi.agregarDetalleVenta(detalleVenta);
    }
}
