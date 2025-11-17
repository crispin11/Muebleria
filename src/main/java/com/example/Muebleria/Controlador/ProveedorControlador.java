package com.example.Muebleria.Controlador;
import com.example.Muebleria.Modelo.Proveedor;
import com.example.Muebleria.Servicio.ProveedorServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorControlador {
    @Autowired
    private ProveedorServi servi;

    @GetMapping("/ver")
    public List<Proveedor> ver(){
        return  servi.ObtenerTodo();
    }
    @GetMapping("/buscarid/{id}")
    public Optional<Proveedor> Buscar(@PathVariable("id") Integer id){
        return  servi.Buscar(id);
    }

    @PostMapping("/agregar")
    public void Agregar(@RequestBody Proveedor proveedor){
        servi.Guardar_o_Modificar(proveedor);
    }
    @PostMapping("/modificar")
    public void modificar(@RequestBody Proveedor proveedor){
        servi.Guardar_o_Modificar(proveedor);
    }
    @GetMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        servi.eliminar(id);
    }
}
