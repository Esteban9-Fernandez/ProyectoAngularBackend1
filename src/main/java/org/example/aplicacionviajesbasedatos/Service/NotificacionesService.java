package org.example.aplicacionviajesbasedatos.Service;

import org.example.aplicacionviajesbasedatos.Entity.Notificaciones;
import org.example.aplicacionviajesbasedatos.Repository.INotificacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionesService implements INotificacionesService {

    @Autowired
    private INotificacionesRepository notificacionesRepository;

    @Override
    public List<Notificaciones> findAll() {
        return notificacionesRepository.findAll();
    }

    @Override
    public Notificaciones findById(Long id) {
        return notificacionesRepository.findById(id).orElse(null);
    }

    @Override
    public Notificaciones save(Notificaciones notificaciones) {
        return notificacionesRepository.save(notificaciones);
    }

    @Override
    public void deleteById(Long id) {
        notificacionesRepository.deleteById(id);
    }
}