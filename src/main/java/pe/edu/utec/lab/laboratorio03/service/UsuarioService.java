package pe.edu.utec.lab.laboratorio03.service;

import pe.edu.utec.lab.laboratorio03.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> listar();
    Optional<Usuario> porId(Long id);
    Usuario guardar(Usuario u);
    void eliminar(Long id);
}