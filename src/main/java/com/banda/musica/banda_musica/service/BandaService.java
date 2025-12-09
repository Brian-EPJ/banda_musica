package com.banda.musica.banda_musica.service;

import com.banda.musica.banda_musica.model.Banda;
import java.util.List;

public interface BandaService {
    List<Banda> listar();
    Banda buscarPorId(Integer id);
    Banda guardar(Banda banda);
    void eliminar(Integer id);
}
