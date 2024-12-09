package org.example.aplicacionviajesbasedatos.Repository;

import org.example.aplicacionviajesbasedatos.Entity.Paradas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IParadasRepository extends JpaRepository<Paradas, Long> {
    List<Paradas> findByViajeId(Long viajeId);

}