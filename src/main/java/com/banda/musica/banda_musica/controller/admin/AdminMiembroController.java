package com.banda.musica.banda_musica.controller.admin;

import com.banda.musica.banda_musica.model.Banda;
import com.banda.musica.banda_musica.model.Miembro;
import com.banda.musica.banda_musica.service.BandaService;
import com.banda.musica.banda_musica.service.MiembroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/miembros")
public class AdminMiembroController {

    private final MiembroService miembroService;
    private final BandaService bandaService;

    public AdminMiembroController(MiembroService miembroService, BandaService bandaService) {
        this.miembroService = miembroService;
        this.bandaService = bandaService;
    }

    // Lista todos los miembros
    @GetMapping
    public String listar(Model model) {
        List<Miembro> miembros = miembroService.listar();
        if (miembros == null) miembros = new ArrayList<>();

        Miembro nuevoMiembro = new Miembro();
        Banda banda = bandaService.listar().stream().findFirst().orElse(null);
        nuevoMiembro.setBanda(banda);

        model.addAttribute("miembros", miembros);
        model.addAttribute("miembro", nuevoMiembro);
        model.addAttribute("estados", Miembro.EstadoMiembro.values());

        return "admin/miembros/form";
    }

    // Nuevo miembro
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        Miembro miembro = new Miembro();
        Banda banda = bandaService.listar().stream().findFirst().orElse(null);

        if (banda == null) {
            model.addAttribute("error", "Primero crea una banda antes de agregar miembros");
            return "redirect:/admin/banda";
        }

        miembro.setBanda(banda);

        model.addAttribute("miembro", miembro);
        model.addAttribute("estados", Miembro.EstadoMiembro.values());
        return "admin/miembros/form";
    }

    // Editar miembro
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Miembro miembro = miembroService.buscarPorId(id);
        if (miembro == null) {
            return "redirect:/admin/miembros?error";
        }

        model.addAttribute("miembro", miembro);
        model.addAttribute("miembros", miembroService.listar());
        model.addAttribute("estados", Miembro.EstadoMiembro.values());
        return "admin/miembros/form";
    }

    // Guardar miembro
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Miembro miembro) {
        // Traer la banda de la DB antes de guardar para que JPA la maneje correctamente
        if (miembro.getBanda() != null && miembro.getBanda().getId() != null) {
            Banda banda = bandaService.buscarPorId(miembro.getBanda().getId());
            miembro.setBanda(banda);
        }

        miembroService.guardar(miembro);
        return "redirect:/admin/miembros?ok";
    }

    // Eliminar miembro
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        miembroService.eliminar(id);
        return "redirect:/admin/miembros?eliminado";
    }
}

