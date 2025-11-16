package com.example.Muebleria.Controlador;

import com.example.Muebleria.Dto.CompraDto;
import com.example.Muebleria.Modelo.Cliente;
import com.example.Muebleria.Modelo.Compra;
import com.example.Muebleria.Servicio.ClienteServi;
import com.example.Muebleria.Servicio.CompraServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/compra")
public class CompraControlador {
    @Autowired
    private CompraServi servi;

    @GetMapping("/ver")
    public List<CompraDto> ver(){
        return  servi.ObtenerTodo();
    }
    @GetMapping("/buscarid/{id}")
    public Optional<CompraDto> Buscar(@PathVariable("id") Long id){
        return  servi.Buscar(id);
    }

    @PostMapping("/agregar")
    public void Agregar(@RequestBody Compra compra){
        servi.Guardar_o_Modificar(compra);
    }
}
