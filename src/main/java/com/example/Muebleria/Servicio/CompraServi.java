package com.example.Muebleria.Servicio;
import com.example.Muebleria.Dto.CompraDto;
import com.example.Muebleria.Dto.VentaDto;
import com.example.Muebleria.Modelo.Compra;
import com.example.Muebleria.Modelo.Venta;
import com.example.Muebleria.Repositorio.CompraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompraServi {
    @Autowired
    private CompraRepo repo;


    public List<CompraDto> ObtenerTodo() {
        return repo.findAll().stream().filter(Compra::isEstado)
                .map(compra -> new CompraDto(
                        compra.getId(),
                        compra.getProveedor().getRazon_social(),
                        compra.getFecha(),
                        compra.getTotal(),
                        compra.isEstado()))
                .collect(Collectors.toList());
    }

    public Optional<CompraDto> Buscar(Integer id){
        return repo.findById(id)
                .map(compra -> new CompraDto(
                        compra.getId(),
                        compra.getProveedor().getRazon_social(),
                        compra.getFecha(),
                        compra.getTotal(),
                        compra.isEstado()));
    }
    public  void Guardar_o_Modificar(Compra compra){
        compra.setEstado(true);
        repo.save(compra);
    }

}
