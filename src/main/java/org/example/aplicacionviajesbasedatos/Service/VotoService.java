package org.example.aplicacionviajesbasedatos.Service;

import org.example.aplicacionviajesbasedatos.Entity.Voto;
import org.example.aplicacionviajesbasedatos.Repository.IVotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotoService implements IVotoService {

    @Autowired
    private IVotoRepository votoRepository;

    @Override
    public Voto saveVoto(Voto voto) {
        return votoRepository.save(voto);
    }
}
