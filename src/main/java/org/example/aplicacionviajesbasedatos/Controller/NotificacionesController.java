package org.example.aplicacionviajesbasedatos.Controller;

import org.example.aplicacionviajesbasedatos.Entity.Notificaciones;
import org.example.aplicacionviajesbasedatos.Service.INotificacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionesController {

    @Autowired(required = true)
    private INotificacionesService notificacionesService;

    @GetMapping
    public List<Notificaciones> getNotificaciones() {
        return notificacionesService.findAll();
    }

    @GetMapping("/{id}")
    public Notificaciones getNotificacionById(@PathVariable Long id) {
        return notificacionesService.findById(id);
    }

    @PostMapping
    public Notificaciones createNotificacion(@RequestBody Notificaciones notificaciones) {
        return notificacionesService.save(notificaciones);
    }

    @PutMapping("/{id}")
    public Notificaciones updateNotificacion(@PathVariable Long id, @RequestBody Notificaciones notificaciones) {
        notificaciones.setId(id);
        return notificacionesService.save(notificaciones);
    }

    @DeleteMapping("/{id}")
    public void deleteNotificacion(@PathVariable Long id) {
        notificacionesService.deleteById(id);
    }
}