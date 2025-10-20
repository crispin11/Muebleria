package com.example.Muebleria.Controlador;
import com.example.Muebleria.Modelo.MetodoPago;
import com.example.Muebleria.Servicio.MetodoPagoServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/metodopago")
public class MetodoPagoControlador {
    @Autowired
    private MetodoPagoServi servi;

    @GetMapping("/ver")
    public List<MetodoPago> ver(){
        return  servi.ObtenerTodo();
    }
    @GetMapping("/buscarid/{id}")
    public Optional<MetodoPago> Buscar(@PathVariable("id") Integer id){
        return  servi.Buscar(id);
    }

    @PostMapping("/agregar")
    public void Agregar(@RequestBody MetodoPago metodoPago){
        servi.Guardar_o_Modificar(metodoPago);
    }
    @PostMapping("/modificar")
    public void modificar(@RequestBody MetodoPago metodoPago){
        servi.Guardar_o_Modificar(metodoPago);
    }
    @GetMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        servi.eliminar(id);
    }
}
