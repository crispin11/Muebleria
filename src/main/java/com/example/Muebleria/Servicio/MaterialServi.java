package com.example.Muebleria.Servicio;
import com.example.Muebleria.Modelo.Material;
import com.example.Muebleria.Repositorio.MaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaterialServi {
    @Autowired
    private MaterialRepo repo;

    public List<Material> ObtenerTodo(){
        return repo.findAll().stream()
                .filter(Material::isEstado)
                .collect(Collectors.toList());
    }
    public Optional<Material> Buscar(Integer id){
        return repo.findById(id);
    }
    public  void Guardar_o_Modificar(Material material){

        repo.save(material);
    }
    public  void eliminar(Integer id){
        repo.eliminar(id);
    }
}
