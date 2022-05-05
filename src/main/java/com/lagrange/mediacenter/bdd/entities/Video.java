package com.lagrange.mediacenter.bdd.entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Video{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column
    private String path;

    @Column
    private String poster;

    public Video(String name, String path) {
        this.name = name;
        this.path = path;
    }
}