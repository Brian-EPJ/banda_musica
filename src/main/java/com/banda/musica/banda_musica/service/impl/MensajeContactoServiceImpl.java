package com.banda.musica.banda_musica.service.impl;

import com.banda.musica.banda_musica.model.MensajeContacto;
import com.banda.musica.banda_musica.repository.MensajeContactoRepository;
import com.banda.musica.banda_musica.service.MensajeContactoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensajeContactoServiceImpl implements MensajeContactoService {

    private final MensajeContactoRepository repository;

    public MensajeContactoServiceImpl(MensajeContactoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MensajeContacto> listar() {
        return repository.findAll();
    }

    @Override
    public MensajeContacto guardar(MensajeContacto mensaje) {
        return repository.save(mensaje);
    }

    @Override
    public MensajeContacto buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void marcarLeido(Integer id) {
        repository.findById(id).ifPresent(msg -> {
            msg.setLeido(true);
            repository.save(msg);
        });
    }
}
