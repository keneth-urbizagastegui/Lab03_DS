package pe.edu.utec.lab.laboratorio03.service.impl;

import pe.edu.utec.lab.laboratorio03.model.Usuario;
import pe.edu.utec.lab.laboratorio03.repository.UsuarioRepository;
import pe.edu.utec.lab.laboratorio03.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repo;
    public UsuarioServiceImpl(UsuarioRepository repo) { this.repo = repo; }

    public List<Usuario> listar() { return repo.findAll(); }
    public Optional<Usuario> porId(Long id) { return repo.findById(id); }
    public Usuario guardar(Usuario u) { return repo.save(u); }
    public void eliminar(Long id) { repo.deleteById(id); }
}