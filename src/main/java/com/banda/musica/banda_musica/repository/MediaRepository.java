package com.banda.musica.banda_musica.repository;

import com.banda.musica.banda_musica.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MediaRepository extends JpaRepository<Media, Integer> {

    // Opcional: buscar solo fotos o videos por banda
    List<Media> findByBandaIdAndTipo(Integer bandaId, Media.TipoMedia tipo);

}
