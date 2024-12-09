package org.example.aplicacionviajesbasedatos.Controller;

import org.example.aplicacionviajesbasedatos.Entity.Voto;
import org.example.aplicacionviajesbasedatos.Service.IVotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votos")
public class VotoController {

    @Autowired
    private IVotoService votoService;

    @PostMapping
    public Voto createVoto(@RequestBody Voto voto) {
        return votoService.saveVoto(voto);
    }
}
