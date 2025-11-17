package com.example.Muebleria.Controlador;
import com.example.Muebleria.Modelo.TipoProducto;
import com.example.Muebleria.Servicio.TipoProductoServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipoproducto")
public class TipoProductoControlador {
    @Autowired
    private TipoProductoServi servi;

    @GetMapping("/ver")
    public List<TipoProducto> ver(){
        return  servi.ObtenerTodo();
    }
    @GetMapping("/buscarid/{id}")
    public Optional<TipoProducto> Buscar(@PathVariable("id") Integer id){
        return  servi.Buscar(id);
    }

    @PostMapping("/agregar")
    public void Agregar(@RequestBody TipoProducto  tipoProducto){
        servi.Guardar_o_Modificar(tipoProducto);
    }
    @PostMapping("/modificar")
    public void modificar(@RequestBody TipoProducto tipoProducto){
        servi.Guardar_o_Modificar(tipoProducto);
    }
    @GetMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        servi.eliminar(id);
    }
}
