package org.example.aplicacionviajesbasedatos.Service;

import org.example.aplicacionviajesbasedatos.Entity.Paradas;
import java.util.List;

public interface IParadasService {
    List<Paradas> findAll();
    Paradas findById(Long id);
    Paradas save(Paradas paradas);
    void deleteById(Long id);
}