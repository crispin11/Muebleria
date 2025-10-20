package com.example.Muebleria.Controlador;
import com.example.Muebleria.Dto.ProductoDto;
import com.example.Muebleria.Modelo.Producto;
import com.example.Muebleria.Servicio.ProductoServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/producto")
public class ProductoControlador {
    @Autowired
    private ProductoServi servi;

    @GetMapping("/ver")
    public List<ProductoDto> ver(){
        return  servi.ObtenerTodo();
    }
    @GetMapping("/buscarid/{id}")
    public Optional<ProductoDto> Buscar(@PathVariable("id") Integer id){
        return  servi.Buscar(id);
    }

    @PostMapping("/agregar")
    public void Agregar(@RequestBody Producto producto){
        servi.Guardar_o_Modificar(producto);
    }
    @PostMapping("/modificar")
    public void modificar(@RequestBody Producto producto){
        servi.Guardar_o_Modificar(producto);
    }
    @GetMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        servi.eliminar(id);
    }

}
