package com.banda.musica.banda_musica.service;

import com.banda.musica.banda_musica.model.MensajeContacto;
import java.util.List;

public interface MensajeContactoService {
    List<MensajeContacto> listar();
    MensajeContacto guardar(MensajeContacto mensaje);
    MensajeContacto buscarPorId(Integer id);
    void marcarLeido(Integer id);
}
