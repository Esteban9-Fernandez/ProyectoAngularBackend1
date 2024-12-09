package org.example.aplicacionviajesbasedatos.DTOs;

import lombok.*;

@Getter
@Setter
@ToString
@Data
public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String email;
    private String contrasenya;
    private String telefono;
}