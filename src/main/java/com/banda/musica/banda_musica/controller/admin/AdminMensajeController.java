package com.banda.musica.banda_musica.controller.admin;

import com.banda.musica.banda_musica.service.MensajeContactoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/mensajes")
public class AdminMensajeController {

    private final MensajeContactoService mensajeService;

    public AdminMensajeController(MensajeContactoService mensajeService) {
        this.mensajeService = mensajeService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("mensajes", mensajeService.listar());
        return "admin/mensajes/listar";
    }

    @GetMapping("/{id}")
    public String ver(@PathVariable Integer id, Model model) {
        var mensaje = mensajeService.buscarPorId(id);
        mensajeService.marcarLeido(id);

        model.addAttribute("mensaje", mensaje);
        return "admin/mensajes/ver";
    }

    @GetMapping("/leido/{id}")
    public String marcarLeido(@PathVariable Integer id) {
        mensajeService.marcarLeido(id);
        return "redirect:/admin/mensajes?leido";
    }
}

