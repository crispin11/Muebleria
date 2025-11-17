package com.example.Muebleria.Controlador;
import com.example.Muebleria.Dto.AuthResponseDto;
import com.example.Muebleria.Modelo.AuthRequest;
import com.example.Muebleria.Servicio.JwtUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class auth {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtUtilService jwtUtilService;
    @PostMapping
    public ResponseEntity<?> auth(@RequestBody AuthRequest authRequest){
        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authRequest.getCorreo(), authRequest.getPassword()
            ));
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(authRequest.getCorreo());

            String jwt = this.jwtUtilService.generateToken(userDetails);
            AuthResponseDto authResponseDto = new AuthResponseDto();
            authResponseDto.setToken(jwt);
            return new ResponseEntity<>(authResponseDto, HttpStatus.OK);
        }catch (Exception e){
            return       ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("error" + e.getMessage());
        }
    }


}

