package com.banda.musica.banda_musica.service.impl;

import com.banda.musica.banda_musica.model.Media;
import com.banda.musica.banda_musica.repository.MediaRepository;
import com.banda.musica.banda_musica.service.MediaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaServiceImpl implements MediaService {

    private final MediaRepository mediaRepository;

    public MediaServiceImpl(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    @Override
    public List<Media> listar() {
        return mediaRepository.findAll();
    }

    @Override
    public Media buscarPorId(Integer id) {
        return mediaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Media> listarPorBanda(Integer bandaId) {
        return mediaRepository.findByBandaIdAndTipo(bandaId, null);
    }

    @Override
    public List<Media> listarPorBandaYTipo(Integer bandaId, Media.TipoMedia tipo) {
        return mediaRepository.findByBandaIdAndTipo(bandaId, tipo);
    }

    @Override
    public Media guardar(Media media) {
        return mediaRepository.save(media);
    }

    @Override
    public void eliminar(Integer id) {
        mediaRepository.deleteById(id);
    }
}

