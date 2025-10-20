package com.example.Muebleria.Dto;
import lombok.Data;

@Data
public class UsuarioDto {
    private Integer id;
    private String nombre;
    private String apellido_pa;
    private String apellido_ma;
    private String correo;
    private String password;
    private String role;
    private boolean estado;

    public UsuarioDto(Integer id, String apellido_pa, String nombre, String correo, String apellido_ma, String password, String role, boolean estado) {
        this.id = id;
        this.apellido_pa = apellido_pa;
        this.nombre = nombre;
        this.correo = correo;
        this.apellido_ma = apellido_ma;
        this.password = password;
        this.role = role;
        this.estado = estado;
    }
}
