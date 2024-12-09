package org.example.aplicacionviajesbasedatos.Repository;

import org.example.aplicacionviajesbasedatos.Entity.Notificaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INotificacionesRepository extends JpaRepository<Notificaciones, Long> {
}
