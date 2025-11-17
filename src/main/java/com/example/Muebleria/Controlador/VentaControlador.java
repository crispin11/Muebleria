package com.example.Muebleria.Controlador;
import com.example.Muebleria.Dto.VentaDto;
import com.example.Muebleria.Modelo.Kardex;
import com.example.Muebleria.Modelo.Venta;

import com.example.Muebleria.Repositorio.KardexRepo;
import com.example.Muebleria.Servicio.VentaServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/venta")
public class VentaControlador {
    @Autowired
    private VentaServi servi;
    @Autowired
    private KardexRepo repo;

    @GetMapping("/ver")
    public List<VentaDto> ver(){
        return  servi.ObtenerTodo();
    }
    @GetMapping("/buscarid/{id}")
    public Optional<VentaDto> Buscar(@PathVariable("id") Integer id){
        return  servi.Buscar(id);
    }

    @PostMapping("/agregar")
    public ResponseEntity<Venta> Agregar(@RequestBody Venta venta){
        Venta ventaGuardada = servi.Guardar(venta);
        return ResponseEntity.ok(ventaGuardada);
    }


    @GetMapping("/kardex")
    public List<Kardex> kardex(){
        return repo.obtenerKardex();
    }


}
