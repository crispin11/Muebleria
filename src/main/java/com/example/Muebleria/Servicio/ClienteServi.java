package com.example.Muebleria.Servicio;
import com.example.Muebleria.Modelo.Cliente;
import com.example.Muebleria.Repositorio.ClienteRepository.ClienteRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServi {
    @Autowired
    private ClienteRepo repo;

    public List<Cliente> ObtenerTodo(){
        return repo.findAll().stream()
                .filter(Cliente::isEstado)
                .collect(Collectors.toList());
    }
    public Optional<Cliente> Buscar(Integer id){
        return repo.findById(id);
    }
    public  void Guardar_o_Modificar(Cliente cliente){

        repo.save(cliente);
    }
    public  void eliminar(Integer id){
        repo.eliminar(id);
    }
}
