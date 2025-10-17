package com.java10x.elifoot.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "club_seq")
    @SequenceGenerator(name = "club_seq", sequenceName = "club_seq", allocationSize = 1)
    private Long id;
    private String name;
    private LocalDate founded;
    private String urlImg;

    @OneToOne
    @JoinColumn(name = "stadium_id")
    private Stadium stadium;

    @OneToMany
    private List<Player> players;





}
