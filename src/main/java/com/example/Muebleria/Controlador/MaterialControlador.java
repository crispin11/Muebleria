package com.example.Muebleria.Controlador;
import com.example.Muebleria.Modelo.Material;
import com.example.Muebleria.Servicio.MaterialServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/material")
public class MaterialControlador {
    @Autowired
    private MaterialServi servi;

    @GetMapping("/ver")
    public List<Material> ver(){
        return  servi.ObtenerTodo();
    }
    @GetMapping("/buscarid/{id}")
    public Optional<Material> Buscar(@PathVariable("id") Integer id){
        return  servi.Buscar(id);
    }

    @PostMapping("/agregar")
    public void Agregar(@RequestBody Material material){
        servi.Guardar_o_Modificar(material);
    }
    @PostMapping("/modificar")
    public void modificar(@RequestBody Material material){
        servi.Guardar_o_Modificar(material);
    }
    @GetMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        servi.eliminar(id);
    }
}
