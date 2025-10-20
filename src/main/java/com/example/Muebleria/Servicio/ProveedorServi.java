package com.example.Muebleria.Servicio;
import com.example.Muebleria.Modelo.Proveedor;
import com.example.Muebleria.Repositorio.ProveedorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProveedorServi {
    @Autowired
    private ProveedorRepo repo;

    public List<Proveedor> ObtenerTodo(){
        return repo.findAll().stream()
                .filter(Proveedor::isEstado)
                .collect(Collectors.toList());
    }
    public Optional<Proveedor> Buscar(Integer id){
        return repo.findById(id);
    }
    public  void Guardar_o_Modificar(Proveedor proveedor){

        repo.save(proveedor);
    }
    public  void eliminar(Integer id){
        repo.eliminar(id);
    }
}
