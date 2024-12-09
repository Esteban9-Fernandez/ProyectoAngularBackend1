package org.example.aplicacionviajesbasedatos.Controller;

import org.example.aplicacionviajesbasedatos.DTOs.agregarViajeDTO;
import org.example.aplicacionviajesbasedatos.Entity.Paradas;
import org.example.aplicacionviajesbasedatos.Entity.Usuario;
import org.example.aplicacionviajesbasedatos.Entity.Viaje;
import org.example.aplicacionviajesbasedatos.Entity.Voto;
import org.example.aplicacionviajesbasedatos.Service.IViajesService;
import org.example.aplicacionviajesbasedatos.Service.ViajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/viajes")
public class ViajeController {

    @Autowired
    private ViajesService viajesService;

    @GetMapping
    public List<Viaje> getViaje() {
        return viajesService.findAll();
    }

    @GetMapping("/{id}")
    public Viaje getViajeById(@PathVariable Long id) {
        return viajesService.findById(id);
    }

    @PutMapping("/{id}")
    public Viaje updateViaje(@PathVariable Long id, @RequestBody agregarViajeDTO viajes) {
        viajes.setId(id);
        return viajesService.crearViaje(viajes);
    }

    @DeleteMapping("/{id}")
    public void deleteViaje(@PathVariable Long id) {
        viajesService.deleteById(id);
    }

    @PostMapping(value = "/nuevo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Viaje> crearViaje(@RequestBody agregarViajeDTO viaje) {
        Viaje viajeCreado = viajesService.crearViaje(viaje);
        return new ResponseEntity<>(viajeCreado, HttpStatus.CREATED);
    }

    @PostMapping("/participantes/nuevo")
    public Viaje anyadirParticipantesViaje(@RequestParam Long idViaje, @RequestParam Long idParticipante) {
        return viajesService.anyadirParticipantesViaje(idViaje, idParticipante);
    }

    @GetMapping("/participantes")
    public List<Usuario> verParticipantesViaje(@RequestParam Long idViaje) {
        return viajesService.verParticipantesViaje(idViaje);
    }

    @DeleteMapping("/participantes/eliminar")
    public Viaje eliminarParticipantesViaje(@RequestParam Long idViaje, @RequestParam Long idParticipante) {
        return viajesService.eliminarParticipantesViaje(idViaje, idParticipante);
    }

    @GetMapping("/listarViajes/{idUsuario}")
    public ResponseEntity<List<Viaje>> listarViajes(@PathVariable Long idUsuario) {
        List<Viaje> viajes = viajesService.listarViajes(idUsuario);
        return new ResponseEntity<>(viajes, HttpStatus.OK);
    }

    @PostMapping("/actividad/nueva/{idUsuario}")
    public Paradas proponerActividad(@PathVariable Long idUsuario, @RequestBody Paradas actividad) {
        return viajesService.proponerActividad(idUsuario, actividad);
    }

    @PostMapping("/actividad/votar/{idActividad}/{idUsuario}/{voto}")
    public Map<String, Voto> votarActividad(@PathVariable Long idActividad, @PathVariable Long idUsuario, @PathVariable boolean voto) {
        Voto resultado = viajesService.votarActividad(idActividad, idUsuario, voto);
        return Map.of("success", resultado);
    }
    @GetMapping("/actividad/{idViaje}")
    public List<Map<String, Object>> verActividades(@PathVariable Long idViaje) {
        return viajesService.verActividades(idViaje);
    }
}