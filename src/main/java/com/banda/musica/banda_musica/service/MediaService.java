package com.banda.musica.banda_musica.service;

import com.banda.musica.banda_musica.model.Media;
import java.util.List;

public interface MediaService {
    List<Media> listar();
    Media buscarPorId(Integer id);
    List<Media> listarPorBanda(Integer bandaId);
    List<Media> listarPorBandaYTipo(Integer bandaId, Media.TipoMedia tipo);
    Media guardar(Media media);
    void eliminar(Integer id);
}
