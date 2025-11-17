package com.example.Muebleria.Servicio;
import com.example.Muebleria.Dto.VentaDto;
import com.example.Muebleria.Modelo.Venta;
import com.example.Muebleria.Repositorio.ProductoRepo;
import com.example.Muebleria.Repositorio.VentaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VentaServi {
    @Autowired
    private VentaRepo repo;
    @Autowired
    private ProductoRepo preo;

    public List<VentaDto> ObtenerTodo() {
        return repo.findAll().stream().filter(Venta::isEstado)
                .map(venta -> new VentaDto(
                        venta.getId(),
                        venta.getCliente().getDni(),
                        venta.getUsuario().getCorreo(),
                        venta.getMetodoPago().getNombre(),
                        venta.getFecha(),
                        venta.getTotal(),
                        venta.isEstado()))
                .collect(Collectors.toList());
    }
    public Optional<VentaDto> Buscar(Integer id){
        return repo.findById(id).map(venta -> new VentaDto(
                venta.getId(),
                venta.getCliente().getDni(),
                venta.getUsuario().getCorreo(),
                venta.getMetodoPago().getNombre(),
                venta.getFecha(),
                venta.getTotal(),
                venta.isEstado()));
    }

    public Venta Guardar(Venta venta){
        venta.setEstado(true);
        Venta ventaGuardada = repo.save(venta); 
        return ventaGuardada; 
    }

}
