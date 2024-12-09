package org.example.aplicacionviajesbasedatos.services;

import jakarta.transaction.Transactional;
import org.example.aplicacionviajesbasedatos.Entity.Usuario;
import org.example.aplicacionviajesbasedatos.Repository.IUsuarioRepository;
import org.example.aplicacionviajesbasedatos.Service.UsuariosService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
public class UsuarioServiceTest {
    @Autowired
    private UsuariosService usuarioService;

    @Autowired
    private IUsuarioRepository repository;

    @BeforeEach
    public void inicializarBaseDatos() throws Exception {
        Usuario usuario1 = new Usuario();
        usuario1.setApellido("Perez");
        usuario1.setContrasenya("1234");
        usuario1.setEmail("email@test.com");
        usuario1.setNombre("Juan");
        usuario1.setTelefono("123456789");
        repository.save(usuario1);

        Usuario usuario2 = new Usuario();
        usuario2.setApellido("Juan");
        usuario2.setContrasenya("1234");
        usuario2.setEmail("email@test.com");
        usuario2.setNombre("Juanito");
        usuario2.setTelefono("123456789");
        repository.save(usuario2);
    }

    @Test
    @DisplayName("Test saving a valid user")
    @Tag("save")
    public void testSaveValidUsuario() {
        Usuario usuario = new Usuario();
        usuario.setApellido("Gonzalez");
        usuario.setContrasenya("password");
        usuario.setEmail("carlos@test.com");
        usuario.setNombre("Carlos");
        usuario.setTelefono("987654321");

        Long userId = usuarioService.insertUsuario(usuario);

        assertNotNull(userId);
        Usuario savedUsuario = repository.findById(userId).orElse(null);
        assertNotNull(savedUsuario);
        assertEquals("Carlos", savedUsuario.getNombre());
        assertEquals("carlos@test.com", savedUsuario.getEmail());
    }

    @Test
    @DisplayName("Test saving an invalid user")
    @Tag("save")
    public void testSaveInvalidUsuario() {
        Usuario usuario = new Usuario();
        usuario.setApellido("Gonzalez");
        usuario.setContrasenya("password");
        usuario.setEmail("invalid@test.com");
        usuario.setNombre(null);
        usuario.setTelefono("987654321");

        assertThrows(Exception.class, () -> {
            usuarioService.insertUsuario(usuario);
        });
    }
}