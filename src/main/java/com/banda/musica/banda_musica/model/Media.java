package com.banda.musica.banda_musica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "media")
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private TipoMedia tipo;

    private String url;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "banda_id")
    private Banda banda;

    public enum TipoMedia {
        foto, video
    }

}

