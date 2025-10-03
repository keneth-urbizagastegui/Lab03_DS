package pe.edu.utec.lab.laboratorio03.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.utec.lab.laboratorio03.repository.UsuarioRepository;

@Controller
public class AuthController {

    private final UsuarioRepository repo;
    public AuthController(UsuarioRepository repo) { this.repo = repo; }

    @GetMapping("/login")
    public String loginForm() { return "login"; }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username,
                          @RequestParam String password,
                          HttpSession session,
                          Model model) {
        return repo.findByUsernameAndPassword(username, password)
                .map(u -> { session.setAttribute("usuarioActual", u); return "redirect:/admin"; })
                .orElseGet(() -> { model.addAttribute("loginError", true); return "login"; });
    }

    @GetMapping("/admin")
    public String admin() { return "admin"; }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        if (session != null) session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/admin"; // raíz -> panel
    }
}
