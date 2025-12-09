package com.banda.musica.banda_musica.controller.admin;

import com.banda.musica.banda_musica.model.Banda;
import com.banda.musica.banda_musica.model.Media;
import com.banda.musica.banda_musica.service.BandaService;
import com.banda.musica.banda_musica.service.MediaService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/media")
public class AdminMediaController {

    private final MediaService mediaService;
    private final BandaService bandaService;

    public AdminMediaController(MediaService mediaService, BandaService bandaService) {
        this.mediaService = mediaService;
        this.bandaService = bandaService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("media", mediaService.listar());
        return "admin/media/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        var media = new Media();
        Banda banda = bandaService.listar().stream().findFirst().orElse(null);
        media.setBanda(banda);

        model.addAttribute("media", media);
        model.addAttribute("tipos", Media.TipoMedia.values());
        return "admin/media/form";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("media", mediaService.buscarPorId(id));
        model.addAttribute("tipos", Media.TipoMedia.values());
        return "admin/media/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Media media) {
        mediaService.guardar(media);
        return "redirect:/admin/media?ok";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        mediaService.eliminar(id);
        return "redirect:/admin/media?eliminado";
    }
}
