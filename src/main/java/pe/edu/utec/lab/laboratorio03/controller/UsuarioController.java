package pe.edu.utec.lab.laboratorio03.controller;

import pe.edu.utec.lab.laboratorio03.model.Rol;
import pe.edu.utec.lab.laboratorio03.model.Usuario;
import pe.edu.utec.lab.laboratorio03.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UsuarioController {

    private final UsuarioService service;
    public UsuarioController(UsuarioService service) { this.service = service; }


    @GetMapping("/usuarios")
    public String listar(Model model) {
        model.addAttribute("usuarios", service.listar());
        return "usuarios-listar";
    }

    @GetMapping("/usuarios/crear")
    public String crear(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", Rol.values());
        return "usuarios-crear";
    }

    @PostMapping("/usuarios")
    public String guardar(@ModelAttribute("usuario") Usuario usuario,
                          Model model,
                          RedirectAttributes flash) {
        if (esInvalido(usuario)) {
            model.addAttribute("roles", Rol.values());
            model.addAttribute("error", "Todos los campos son obligatorios");
            return "usuarios-crear";
        }
        service.guardar(usuario);
        flash.addFlashAttribute("ok", "Usuario creado");
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{id}/editar")
    public String editar(@PathVariable Long id, Model model) {
        Usuario u = service.porId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido"));
        model.addAttribute("usuario", u);
        model.addAttribute("roles", Rol.values());
        return "usuarios-editar";
    }

    @PostMapping("/usuarios/{id}")
    public String actualizar(@PathVariable Long id,
                             @ModelAttribute("usuario") Usuario usuario,
                             Model model,
                             RedirectAttributes flash) {
        if (esInvalido(usuario)) {
            model.addAttribute("roles", Rol.values());
            model.addAttribute("error", "Todos los campos son obligatorios");
            return "usuarios-editar";
        }
        usuario.setId(id);
        service.guardar(usuario);
        flash.addFlashAttribute("ok", "Usuario actualizado");
        return "redirect:/usuarios";
    }

    @PostMapping("/usuarios/{id}/eliminar")
    public String eliminar(@PathVariable Long id, RedirectAttributes flash) {
        service.eliminar(id);
        flash.addFlashAttribute("ok","Usuario eliminado");
        return "redirect:/usuarios";
    }

    private boolean esInvalido(Usuario u) {
        return u.getNombre() == null || u.getNombre().isBlank()
                || u.getEmail() == null || u.getEmail().isBlank()
                || u.getUsername() == null || u.getUsername().isBlank()
                || u.getPassword() == null || u.getPassword().isBlank()
                || u.getRol() == null;
    }
}
