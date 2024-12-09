package org.example.aplicacionviajesbasedatos.Service;

import org.example.aplicacionviajesbasedatos.DTOs.agregarViajeDTO;
import org.example.aplicacionviajesbasedatos.Entity.Paradas;
import org.example.aplicacionviajesbasedatos.Entity.Usuario;
import org.example.aplicacionviajesbasedatos.Entity.Viaje;
import org.example.aplicacionviajesbasedatos.Entity.Voto;

import java.util.List;
import java.util.Map;

public interface IViajesService {
    List<Viaje> findAll();
    Viaje findById(Long id);
    void deleteById(Long id);

    Viaje crearViaje(agregarViajeDTO viaje);

    Viaje anyadirParticipantesViaje(Long idViaje, Long idParticipante);
    List<Usuario> verParticipantesViaje(Long idViaje);
    Viaje eliminarParticipantesViaje(Long idViaje, Long idParticipante);
    List<Viaje> listarViajes(Long idUsuario);
    Paradas proponerActividad(Long idUsuario, Paradas actividad);
    Voto votarActividad(Long idActividad, Long idUsuario, boolean voto);
    List<Map<String, Object>> verActividades(Long idViaje);

}