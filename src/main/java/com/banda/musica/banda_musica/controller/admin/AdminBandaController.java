package com.banda.musica.banda_musica.controller.admin;

import com.banda.musica.banda_musica.model.Banda;
import com.banda.musica.banda_musica.service.BandaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/banda")
public class AdminBandaController {

    private final BandaService bandaService;

    public AdminBandaController(BandaService bandaService) {
        this.bandaService = bandaService;
    }

    @GetMapping
    public String vistaBanda(Model model) {
        Banda banda = bandaService.listar().stream().findFirst().orElse(new Banda());
        model.addAttribute("banda", banda);
        return "admin/banda/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Banda banda) {
        bandaService.guardar(banda);
        return "redirect:/admin/banda?ok";
    }
}
