package com.example.Muebleria.Controlador;
import com.example.Muebleria.Modelo.Cliente;
import com.example.Muebleria.Servicio.ClienteServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClienteControlador {
    @Autowired
    private ClienteServi servi;

    @GetMapping("/ver")
    public List<Cliente> ver(){
        return  servi.ObtenerTodo();
    }
    @GetMapping("/buscarid/{id}")
    public Optional<Cliente> Buscar(@PathVariable("id") Integer id){
        return  servi.Buscar(id);
    }

    @PostMapping("/agregar")
    public void Agregar(@RequestBody Cliente cliente){
        servi.Guardar_o_Modificar(cliente);
    }
    @PostMapping("/modificar")
    public void modificar(@RequestBody Cliente cliente){
        servi.Guardar_o_Modificar(cliente);
    }
    @GetMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        servi.eliminar(id);
    }
}
