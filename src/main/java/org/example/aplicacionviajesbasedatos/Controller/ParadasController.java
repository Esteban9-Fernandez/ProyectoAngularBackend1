package org.example.aplicacionviajesbasedatos.Controller;

import org.example.aplicacionviajesbasedatos.Entity.Paradas;
import org.example.aplicacionviajesbasedatos.Service.IParadasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paradas")
public class ParadasController {

    @Autowired
    private IParadasService paradasService;

    @GetMapping
    public List<Paradas> getParadas() {
        return paradasService.findAll();
    }

    @GetMapping("/{id}")
    public Paradas getParadaById(@PathVariable Long id) {
        return paradasService.findById(id);
    }

    @PostMapping
    public Paradas createParada(@RequestBody Paradas paradas) {
        return paradasService.save(paradas);
    }

    @PutMapping("/{id}")
    public Paradas updateParada(@PathVariable Long id, @RequestBody Paradas paradas) {
        paradas.setId(id);
        return paradasService.save(paradas);
    }

    @DeleteMapping("/{id}")
    public void deleteParada(@PathVariable Long id) {
        paradasService.deleteById(id);
    }
}