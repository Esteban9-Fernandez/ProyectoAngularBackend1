package org.example.aplicacionviajesbasedatos.Repository;

import org.example.aplicacionviajesbasedatos.Entity.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IViajeRepository extends JpaRepository<Viaje, Long> {
}
