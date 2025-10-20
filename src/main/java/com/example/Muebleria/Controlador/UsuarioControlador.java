package com.example.Muebleria.Controlador;
import com.example.Muebleria.Dto.UsuarioDto;
import com.example.Muebleria.Modelo.Usuario;
import com.example.Muebleria.Servicio.UsuarioServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioControlador {
    @Autowired
    private UsuarioServi servi;

    @GetMapping("/ver")
    public List<UsuarioDto> ver(){
        return  servi.ObtenerUsuarios();
    }
    @GetMapping("/buscarid/{id}")
    public Optional<Usuario> Buscar(@PathVariable("id") Integer id){
        return  servi.ObtenerUsuario(id);
    }

    @PostMapping("/agregar")
    public void Agregar(@RequestBody Usuario usuario){
        servi.Guardar_o_Modificar(usuario);
    }
    @PostMapping("/modificar")
    public void modificar(@RequestBody Usuario usuario){
        servi.Guardar_o_Modificar(usuario);
    }
    @GetMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        servi.eliminar(id);
    }




}
