package com.banda.musica.banda_musica.service.impl;

import com.banda.musica.banda_musica.model.Banda;
import com.banda.musica.banda_musica.repository.BandaRepository;
import com.banda.musica.banda_musica.service.BandaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BandaServiceImpl implements BandaService {

    private final BandaRepository bandaRepository;

    public BandaServiceImpl(BandaRepository bandaRepository) {
        this.bandaRepository = bandaRepository;
    }

    @Override
    public List<Banda> listar() {
        return bandaRepository.findAll();
    }

    @Override
    public Banda buscarPorId(Integer id) {
        return bandaRepository.findById(id).orElse(null);
    }

    @Override
    public Banda guardar(Banda banda) {
        return bandaRepository.save(banda);
    }

    @Override
    public void eliminar(Integer id) {
        bandaRepository.deleteById(id);
    }
}
