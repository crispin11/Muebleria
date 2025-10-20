package com.example.Muebleria.Servicio;
import com.example.Muebleria.Modelo.TipoProducto;
import com.example.Muebleria.Repositorio.TipoProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoProductoServi {
    @Autowired
    private TipoProductoRepo repo;

    public List<TipoProducto> ObtenerTodo(){
        return repo.findAll().stream()
                .filter(TipoProducto::isEstado)
                .collect(Collectors.toList());
    }
    public Optional<TipoProducto> Buscar(Integer id){
        return repo.findById(id);
    }
    public  void Guardar_o_Modificar(TipoProducto tipoProducto){

        repo.save(tipoProducto);
    }
    public  void eliminar(Integer id){
        repo.eliminar(id);
    }
}
