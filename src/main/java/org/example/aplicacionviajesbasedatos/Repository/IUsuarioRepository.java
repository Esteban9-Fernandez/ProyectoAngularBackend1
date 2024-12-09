package org.example.aplicacionviajesbasedatos.Repository;

import org.example.aplicacionviajesbasedatos.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
}