package com.example.Muebleria.Controlador;
import com.example.Muebleria.Modelo.Role;
import com.example.Muebleria.Servicio.RoleServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/role")
public class RoleControlador {
    @Autowired
    private RoleServi servi;

    @GetMapping("/ver")
    @CrossOrigin
    public List<Role> ver(){
        return  servi.ObtenerTodo();
    }
    @GetMapping("/buscarid/{id}")
    @CrossOrigin
    public Optional<Role> Buscar(@PathVariable("id") Integer id){
        return  servi.Buscar(id);
    }

    @PostMapping("/agregar")
    @CrossOrigin
    public void Agregar(@RequestBody Role role){
        servi.Guardar_o_Modificar(role);
    }
    @PostMapping("/modificar")
    @CrossOrigin
    public void modificar(@RequestBody Role role){
        servi.Guardar_o_Modificar(role);
    }
    @GetMapping("/eliminar/{id}")
    @CrossOrigin
    public void eliminar(@PathVariable("id") Integer id){
        servi.eliminar(id);
    }
}
