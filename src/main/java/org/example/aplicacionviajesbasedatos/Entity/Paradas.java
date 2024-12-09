package org.example.aplicacionviajesbasedatos.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "paradas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Paradas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_parada")
    private String nombreParada;
    @Column(name = "precio")
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_viaje")
    @JsonBackReference
    private Viaje viaje;
}