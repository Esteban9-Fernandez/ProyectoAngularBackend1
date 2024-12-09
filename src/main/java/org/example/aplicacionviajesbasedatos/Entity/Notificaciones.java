package org.example.aplicacionviajesbasedatos.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "notificaciones")
public class Notificaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Notificaciones() {
    }

    public Notificaciones(long id, String mensaje, Usuario usuario) {
        this.id = id;
        this.mensaje = mensaje;
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
