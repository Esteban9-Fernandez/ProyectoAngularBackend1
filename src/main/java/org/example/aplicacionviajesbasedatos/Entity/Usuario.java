package org.example.aplicacionviajesbasedatos.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios", schema = "gogotravel")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    @Column(name = "apellido", columnDefinition = "VARCHAR(255) NOT NULL")
    private String apellido;

    @Column(name = "email", columnDefinition = "VARCHAR(255) NOT NULL")
    private String email;

    @Column(name = "contrasenya", columnDefinition = "VARCHAR(255) NOT NULL")
    private String contrasenya;

    @Column(name = "telefono", columnDefinition = "VARCHAR(255)")
    private String telefono;

    @OneToMany(mappedBy = "usuario")
    @JsonBackReference
    private Set<Voto> votos = new HashSet<>();

    public Usuario() {
    }

    public Usuario(Long id, String nombre, String apellido, String email, String contrasenya, String telefono, Set<Voto> votos, Set<Viaje> viajesParticipados) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasenya = contrasenya;
        this.telefono = telefono;
        this.votos = votos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<Voto> getVotos() {
        return votos;
    }

    public void setVotos(Set<Voto> votos) {
        this.votos = votos;
    }
}