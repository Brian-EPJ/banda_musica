package com.banda.musica.banda_musica.controller;

import com.banda.musica.banda_musica.model.Banda;
import com.banda.musica.banda_musica.model.Miembro;
import com.banda.musica.banda_musica.model.Media;
import com.banda.musica.banda_musica.model.MensajeContacto;
import com.banda.musica.banda_musica.service.BandaService;
import com.banda.musica.banda_musica.service.MediaService;
import com.banda.musica.banda_musica.service.MiembroService;
import com.banda.musica.banda_musica.service.MensajeContactoService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PublicController {

    private final BandaService bandaService;
    private final MiembroService miembroService;
    private final MediaService mediaService;
    private final MensajeContactoService mensajeContactoService;

    public PublicController(
            BandaService bandaService,
            MiembroService miembroService,
            MediaService mediaService,
            MensajeContactoService mensajeContactoService
    ) {
        this.bandaService = bandaService;
        this.miembroService = miembroService;
        this.mediaService = mediaService;
        this.mensajeContactoService = mensajeContactoService;
    }

    // Home
    @GetMapping("/")
    public String home(Model model) {
        Banda banda = bandaService.listar().stream().findFirst().orElse(null);
        model.addAttribute("banda", banda);

        if (banda != null) {
            List<Miembro> activos = miembroService.listarPorBandaYEstado(banda.getId(), Miembro.EstadoMiembro.activo);
            List<Miembro> exMiembros = miembroService.listarPorBandaYEstado(banda.getId(), Miembro.EstadoMiembro.ex);
            model.addAttribute("activos", activos);
            model.addAttribute("ex", exMiembros);

            model.addAttribute("fotos", mediaService.listarPorBandaYTipo(banda.getId(), Media.TipoMedia.foto));
            model.addAttribute("videos", mediaService.listarPorBandaYTipo(banda.getId(), Media.TipoMedia.video));
        }

        return "public/home";
    }

    // Página de miembros (opcional)
    @GetMapping("/miembros")
    public String miembros(Model model) {
        Banda banda = bandaService.listar().stream().findFirst().orElse(null);

        if (banda != null) {
            List<Miembro> activos = miembroService.listarPorBandaYEstado(banda.getId(), Miembro.EstadoMiembro.activo);
            List<Miembro> exMiembros = miembroService.listarPorBandaYEstado(banda.getId(), Miembro.EstadoMiembro.ex);
            model.addAttribute("activos", activos);
            model.addAttribute("ex", exMiembros);
        }

        return "public/miembros";
    }

    // Banda
    @GetMapping("/banda")
    public String banda(Model model) {
        model.addAttribute("banda", bandaService.listar().stream().findFirst().orElse(null));
        return "public/banda";
    }

    // Galería
    @GetMapping("/galeria")
    public String galeria(Model model) {
        Banda banda = bandaService.listar().stream().findFirst().orElse(null);
        if (banda != null) {
            model.addAttribute("fotos", mediaService.listarPorBandaYTipo(banda.getId(), Media.TipoMedia.foto));
            model.addAttribute("videos", mediaService.listarPorBandaYTipo(banda.getId(), Media.TipoMedia.video));
        }
        return "public/galeria";
    }

    // Contacto
    @GetMapping("/contacto")
    public String contacto(Model model) {
        model.addAttribute("mensaje", new MensajeContacto());
        return "public/contacto";
    }

    @PostMapping("/contacto/enviar")
    public String enviarMensaje(@ModelAttribute MensajeContacto mensaje) {
        mensajeContactoService.guardar(mensaje);
        return "redirect:/contacto?ok";
    }
}
