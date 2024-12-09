package org.example.aplicacionviajesbasedatos.Service;

import org.example.aplicacionviajesbasedatos.Entity.Notificaciones;
import java.util.List;

public interface INotificacionesService {
    List<Notificaciones> findAll();
    Notificaciones findById(Long id);
    Notificaciones save(Notificaciones notificaciones);
    void deleteById(Long id);
}