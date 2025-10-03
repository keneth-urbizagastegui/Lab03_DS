package pe.edu.utec.lab.laboratorio03.repository;

import pe.edu.utec.lab.laboratorio03.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsernameAndPassword(String username, String password);
}
