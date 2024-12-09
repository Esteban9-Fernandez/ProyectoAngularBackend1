package org.example.aplicacionviajesbasedatos.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "votos")
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonBackReference
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_parada")
    private Paradas parada;

    private Boolean aFavor;

    public Voto() {
    }

    public Voto(Usuario usuario, Paradas parada, Boolean aFavor) {
        this.usuario = usuario;
        this.parada = parada;
        this.aFavor = aFavor;
    }

    public Boolean getaFavor() {
        return aFavor;
    }

    public void setaFavor(Boolean aFavor) {
        this.aFavor = aFavor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Paradas getParada() {
        return parada;
    }

    public void setParada(Paradas parada) {
        this.parada = parada;
    }

    public Boolean getAFavor() {
        return aFavor;
    }

    public void setAFavor(Boolean aFavor) {
        this.aFavor = aFavor;
    }
}