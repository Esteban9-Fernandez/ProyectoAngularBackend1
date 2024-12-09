package org.example.aplicacionviajesbasedatos.Service;

import org.example.aplicacionviajesbasedatos.Entity.Usuario;
import java.util.List;

public interface IUsuariosService {
    List<Usuario> findAll();
    Usuario findById(Long id);
    Usuario save(Usuario usuario);
    void deleteById(Long id);
}