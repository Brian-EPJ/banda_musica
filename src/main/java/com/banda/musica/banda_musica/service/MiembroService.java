package com.banda.musica.banda_musica.service;

import com.banda.musica.banda_musica.model.Miembro;
import java.util.List;

public interface MiembroService {
    List<Miembro> listar();
    List<Miembro> listarActivos();
    List<Miembro> listarExMiembros();
    Miembro buscarPorId(Integer id);
    Miembro guardar(Miembro miembro);
    void eliminar(Integer id);
    List<Miembro> listarPorBandaYEstado(Integer bandaId, Miembro.EstadoMiembro estado);
}
