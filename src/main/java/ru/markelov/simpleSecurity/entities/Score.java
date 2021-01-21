package ru.markelov.simpleSecurity.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "score")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "points")
    private Integer points;
}
