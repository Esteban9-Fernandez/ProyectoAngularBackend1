package org.example.aplicacionviajesbasedatos.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "viajes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Viaje implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "destino")
    private String destino;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "precio_total")
    private Double precioTotal;
    @Column(name = "fecha")
    private LocalDate fecha;

    @ManyToMany
    @JoinTable(
            name = "viaje_usuario",
            joinColumns = @JoinColumn(name = "viaje_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private Set<Usuario> usuarios = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "viaje_colaborador",
            joinColumns = @JoinColumn(name = "viaje_id"),
            inverseJoinColumns = @JoinColumn(name = "colaborador_id")
    )
    private Set<Usuario> colaboradores = new HashSet<>();

    @OneToMany(mappedBy = "viaje")
    @JsonManagedReference
    private Set<Paradas> paradas = new HashSet<>();
}