package org.example.aplicacionviajesbasedatos.Service;

import org.example.aplicacionviajesbasedatos.Entity.Paradas;
import org.example.aplicacionviajesbasedatos.Repository.IParadasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParadasService implements IParadasService {

    @Autowired
    private IParadasRepository paradasRepository;

    @Override
    public List<Paradas> findAll() {
        return paradasRepository.findAll();
    }

    @Override
    public Paradas findById(Long id) {
        return paradasRepository.findById(id).orElse(null);
    }

    @Override
    public Paradas save(Paradas paradas) {
        return paradasRepository.save(paradas);
    }

    @Override
    public void deleteById(Long id) {
        paradasRepository.deleteById(id);
    }
}