package com.banda.musica.banda_musica.repository;

import com.banda.musica.banda_musica.model.Miembro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MiembroRepository extends JpaRepository<Miembro, Integer> {
    // Filtrar por estado: activos o ex miembros
    List<Miembro> findByEstado(Miembro.EstadoMiembro estado);

    // Filtrar por banda
    List<Miembro> findByBandaId(Integer bandaId);

    List<Miembro> findByBandaIdAndEstado(Integer bandaId, Miembro.EstadoMiembro estado);
}
