package org.example.aplicacionviajesbasedatos.Service;

import org.example.aplicacionviajesbasedatos.DTOs.agregarViajeDTO;
import org.example.aplicacionviajesbasedatos.Entity.Paradas;
import org.example.aplicacionviajesbasedatos.Entity.Usuario;
import org.example.aplicacionviajesbasedatos.Entity.Viaje;
import org.example.aplicacionviajesbasedatos.Entity.Voto;
import org.example.aplicacionviajesbasedatos.Repository.IParadasRepository;
import org.example.aplicacionviajesbasedatos.Repository.IUsuarioRepository;
import org.example.aplicacionviajesbasedatos.Repository.IViajeRepository;
import org.example.aplicacionviajesbasedatos.Repository.IVotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ViajesService implements IViajesService {

    @Autowired
    private IViajeRepository viajesRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IParadasRepository paradasRepository;

    @Autowired
    private IVotoRepository votoRepository;

    @Override
    public List<Viaje> findAll() {
        return viajesRepository.findAll();
    }

    @Override
    public Viaje findById(Long id) {
        return viajesRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        viajesRepository.deleteById(id);
    }

    @Override
    public Viaje crearViaje(agregarViajeDTO viaje) {
        Viaje nuevoViaje = new Viaje();
        Usuario creador = usuarioRepository.findById(viaje.getIdUsuario()).orElse(null);
        System.out.println(creador.getId());
        nuevoViaje.setDestino(viaje.getDestino());
        nuevoViaje.setDescripcion(viaje.getDescripcion());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        nuevoViaje.setFecha(LocalDate.parse(viaje.getFecha(), formatter));
        nuevoViaje.setUsuarios(viaje.getColaboradores());
        Viaje viajeCreado = viajesRepository.save(nuevoViaje);
        nuevoViaje.setUsuarios(new HashSet<>());
        System.out.println(viajeCreado.getUsuarios());
        viajeCreado.getUsuarios().add(creador);
        return viajesRepository.save(nuevoViaje);
    }

    @Override
    public Viaje anyadirParticipantesViaje(Long idViaje, Long idParticipante) {
        Viaje viaje = viajesRepository.findById(idViaje).orElse(null);
        if (viaje == null) {
            return null;
        }

        Usuario usuario = usuarioRepository.findById(idParticipante).orElse(null);
        if (usuario == null) {
            return null;
        }

        viaje.getUsuarios().add(usuario);
        return viajesRepository.save(viaje);
    }

    @Override
    public List<Usuario> verParticipantesViaje(Long idViaje) {
        Viaje viaje = viajesRepository.findById(idViaje).orElse(null);
        if (viaje == null) {
            return null;
        }
        return new ArrayList<>(viaje.getUsuarios());
    }

    @Override
    public Viaje eliminarParticipantesViaje(Long idViaje, Long idParticipante) {
        Viaje viaje = viajesRepository.findById(idViaje).orElse(null);
        if (viaje == null) {
            return null;
        }

        Usuario usuario = usuarioRepository.findById(idParticipante).orElse(null);
        if (usuario == null) {
            return null;
        }

        viaje.getUsuarios().remove(usuario);
        return viajesRepository.save(viaje);
    }
    @Override
    public List<Viaje> listarViajes(Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario == null) {
            return new ArrayList<>();
        }
        return viajesRepository.findAll().stream()
                .filter(viaje -> viaje.getUsuarios().contains(usuario))
                .collect(Collectors.toList());
    }
    @Override
    public Paradas proponerActividad(Long idUsuario, Paradas actividad) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario == null) {
            return null;
        }

        return paradasRepository.save(actividad);
    }
    @Override
    public Voto votarActividad(Long idActividad, Long idUsuario, boolean voto) {
        Paradas actividad = paradasRepository.findById(idActividad).orElse(null);
        if (actividad == null) {
            return null;
        }

        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario == null) {
            return null;
        }

        Voto existingVoto = votoRepository.findByParadaAndUsuario(actividad, usuario);
        if (existingVoto != null) {
            votoRepository.delete(existingVoto);
        }

        Voto newVoto = new Voto();
        newVoto.setParada(actividad);
        newVoto.setUsuario(usuario);
        newVoto.setaFavor(voto);
        return votoRepository.save(newVoto);
    }
    @Override
    public List<Map<String, Object>> verActividades(Long idViaje) {
        List<Paradas> paradas = paradasRepository.findByViajeId(idViaje);
        return paradas.stream().map(parada -> {
            Map<String, Object> actividad = new HashMap<>();
            actividad.put("parada", parada);
            actividad.put("votos", votoRepository.countByParadaId(parada.getId()));
            return actividad;
        }).collect(Collectors.toList());
    }
}