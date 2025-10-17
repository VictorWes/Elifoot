package com.java10x.elifoot.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "scopes")
public class Scope {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scope_seq")
    @SequenceGenerator(name = "scope_seq", sequenceName = "scope_seq", allocationSize = 1)
    private Long id;
    private String name;


}
