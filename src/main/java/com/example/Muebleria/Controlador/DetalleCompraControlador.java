package com.example.Muebleria.Controlador;
import com.example.Muebleria.Dto.DetalleCompraDto;
import com.example.Muebleria.Modelo.DetalleCompra;
import com.example.Muebleria.Servicio.DetalleCompraServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detallecompra")
public class DetalleCompraControlador {
    @Autowired
    private DetalleCompraServi servi;

    @GetMapping("/ver")
    public List<DetalleCompraDto> ver(){
        return  servi.ObtenerTodo();
    }
    @GetMapping("/buscarid/{id}")
    public Optional<DetalleCompraDto> Buscar(@PathVariable("id") Integer id){
        return  servi.Buscar(id);
    }
    @PostMapping("/agregar")
    public void agregarDetalleCompra(@RequestBody DetalleCompra detalleCompra) {
            servi.agregarDetalleCompra(detalleCompra);
    }
}
