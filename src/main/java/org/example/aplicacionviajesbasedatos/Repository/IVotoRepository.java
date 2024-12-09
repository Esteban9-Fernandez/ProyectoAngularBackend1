package org.example.aplicacionviajesbasedatos.Repository;

import org.example.aplicacionviajesbasedatos.Entity.Paradas;
import org.example.aplicacionviajesbasedatos.Entity.Usuario;
import org.example.aplicacionviajesbasedatos.Entity.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVotoRepository extends JpaRepository<Voto, Long> {
    Voto findByParadaAndUsuario(Paradas parada, Usuario usuario);
    int countByParadaId(Long paradaId);

}