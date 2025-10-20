package com.example.Muebleria.Servicio;

import com.example.Muebleria.Modelo.Usuario;
import com.example.Muebleria.Repositorio.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepo repo;
    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario usuario=this.repo.findByCorreo(correo);
        if(usuario==null){
            throw  new UsernameNotFoundException(correo);
        }

        return new User(usuario.getCorreo(),usuario.getPassword(),new ArrayList<>());
    }
}
