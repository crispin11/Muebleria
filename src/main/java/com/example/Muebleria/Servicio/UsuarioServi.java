package com.example.Muebleria.Servicio;
import com.example.Muebleria.Dto.ProductoDto;
import com.example.Muebleria.Dto.UsuarioDto;
import com.example.Muebleria.Modelo.Producto;
import com.example.Muebleria.Modelo.Usuario;
import com.example.Muebleria.Repositorio.RoleRepo;
import com.example.Muebleria.Repositorio.UsuarioRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServi {
    @Autowired
    private UsuarioRepo repo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UsuarioDto> ObtenerUsuarios() {
        return repo.findAll().stream().filter(Usuario::isEstado)
                .map(usuario -> new UsuarioDto(
                        usuario.getId(),
                        usuario.getNombre(),
                        usuario.getApellido_pa(),
                        usuario.getApellido_ma(),
                        usuario.getCorreo(),
                        usuario.getPassword(),
                        usuario.getRole().getNombre(),
                        usuario.isEstado()))
                .collect(Collectors.toList());
    }
    public Optional<Usuario> ObtenerUsuario(Integer id){
        return repo.findById(id);
    }
    public  void Guardar_o_Modificar(Usuario usuario){
        String contrasenaEncriptada = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(contrasenaEncriptada);

        repo.save(usuario);
    }
    public  void eliminar(Integer id){
        repo.eliminar(id);
    }


}
