package com.example.Muebleria.Conf;

import com.example.Muebleria.Modelo.Cliente;
import com.example.Muebleria.Repositorio.ClienteRepository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestRunner {

    @Bean
    public CommandLineRunner test(ClienteRepo clienteRepo) {
        return args -> {

            System.out.println("===== TEST: INSERTAR =====");
            Cliente c = new Cliente();
            c.setNombre("Juan");
            c.setApellido_pa("Perez");
            c.setApellido_ma("Herrera");
            c.setDni("12345678");
            c.setTelefono("999888777");
            c.setEstado(true);
            

            clienteRepo.save(c); // INSERT
            System.out.println("Insertado ID: " + c.getId());

            System.out.println("===== TEST: SOFT DELETE =====");
            clienteRepo.eliminar(c.getId());
            System.out.println("Soft delete realizado");

            System.out.println("===== TEST: FIND =====");
            System.out.println(clienteRepo.findById(c.getId()));
        };
    }
}
