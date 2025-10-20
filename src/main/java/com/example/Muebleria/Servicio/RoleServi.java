package com.example.Muebleria.Servicio;
import com.example.Muebleria.Modelo.Role;
import com.example.Muebleria.Repositorio.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServi {
    @Autowired
    private RoleRepo repo;

    public List<Role> ObtenerTodo(){
        return repo.findAll().stream()
                .filter(Role::isEstado)
                .collect(Collectors.toList());
    }
    public Optional<Role> Buscar(Integer id){
        return repo.findById(id);
    }
    public  void Guardar_o_Modificar(Role role){

        repo.save(role);
    }
    public  void eliminar(Integer id){
        repo.eliminar(id);
    }
}
