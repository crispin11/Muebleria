package com.example.Muebleria.Servicio;
import com.example.Muebleria.Modelo.MetodoPago;
import com.example.Muebleria.Repositorio.MetodoPagoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MetodoPagoServi {
    @Autowired
    private MetodoPagoRepo repo;

    public List<MetodoPago> ObtenerTodo(){
        return repo.findAll().stream()
                .filter(MetodoPago::isEstado)
                .collect(Collectors.toList());
    }
    public Optional<MetodoPago> Buscar(Integer id){
        return repo.findById(id);
    }
    public  void Guardar_o_Modificar(MetodoPago metodoPago){

        repo.save(metodoPago);
    }
    public  void eliminar(Integer id){
        repo.eliminar(id);
    }
}
