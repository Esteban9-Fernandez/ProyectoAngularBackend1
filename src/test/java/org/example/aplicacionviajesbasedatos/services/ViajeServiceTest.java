package org.example.aplicacionviajesbasedatos.services;

import jakarta.transaction.Transactional;
import org.example.aplicacionviajesbasedatos.Entity.Viaje;
import org.example.aplicacionviajesbasedatos.Repository.IViajeRepository;
import org.example.aplicacionviajesbasedatos.Service.ViajesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
public class ViajeServiceTest {
    @Autowired
    private ViajesService viajeService;

    @Autowired
    private IViajeRepository repository;

    @BeforeEach
    public void inicializarBaseDatos() throws Exception {
        Viaje viaje = new Viaje();
        viaje.setDestino("Madrid");
        viaje.setFecha(LocalDate.of(2023, 12, 25));

        repository.save(viaje);
    }

    @Test
    public void testSaveValidViaje() {
        Viaje viaje = new Viaje();
        viaje.setDestino("Barcelona");
        viaje.setFecha(LocalDate.of(2024, 1, 1));

        Viaje savedViaje = repository.save(viaje);

        assertNotNull(savedViaje);
        assertEquals("Barcelona", savedViaje.getDestino());
        assertEquals(LocalDate.of(2024, 1, 1), savedViaje.getFecha());
    }

    @Test
    public void testSaveInvalidViaje() {
        Viaje viaje = new Viaje();
        viaje.setDestino(null); // Invalid because destination is null
        viaje.setFecha(LocalDate.of(2024, 1, 1));

        assertThrows(Exception.class, () -> {
            repository.save(viaje);
        });
    }
}