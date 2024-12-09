package org.example.aplicacionviajesbasedatos.DTOs;

import lombok.Getter;
import lombok.Setter;
import org.example.aplicacionviajesbasedatos.Entity.Usuario;

import java.lang.reflect.Array;
import java.util.Set;

@Getter
@Setter
public class agregarViajeDTO {

    private Long id;
    private String destino;
    private String descripcion;
    private Double precioTotal;
    private String fecha;
    private Set<Usuario> colaboradores;
    private Long idUsuario;

}
