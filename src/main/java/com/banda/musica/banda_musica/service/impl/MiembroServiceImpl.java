package com.banda.musica.banda_musica.service.impl;

import com.banda.musica.banda_musica.model.Miembro;
import com.banda.musica.banda_musica.repository.MiembroRepository;
import com.banda.musica.banda_musica.service.MiembroService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiembroServiceImpl implements MiembroService {

    private final MiembroRepository miembroRepository;

    public MiembroServiceImpl(MiembroRepository miembroRepository) {
        this.miembroRepository = miembroRepository;
    }

    @Override
    public List<Miembro> listar() {
        return miembroRepository.findAll();
    }

    @Override
    public List<Miembro> listarActivos() {
        return miembroRepository.findByEstado(Miembro.EstadoMiembro.activo);
    }

    @Override
    public List<Miembro> listarExMiembros() {
        return miembroRepository.findByEstado(Miembro.EstadoMiembro.ex);
    }

    @Override
    public Miembro buscarPorId(Integer id) {
        return miembroRepository.findById(id).orElse(null);
    }

    @Override
    public Miembro guardar(Miembro miembro) {
        return miembroRepository.save(miembro);
    }

    @Override
    public void eliminar(Integer id) {
        miembroRepository.deleteById(id);
    }
    @Override
    public List<Miembro> listarPorBandaYEstado(Integer bandaId, Miembro.EstadoMiembro estado) {
        return miembroRepository.findByBandaIdAndEstado(bandaId, estado);
    }
}
