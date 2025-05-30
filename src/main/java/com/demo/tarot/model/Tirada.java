package com.demo.tarot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tirada")
public class Tirada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "tirada_carta",
            joinColumns = @JoinColumn(name = "tirada_id"),
            inverseJoinColumns = @JoinColumn(name = "carta_id"))
    private List<Carta> cartas;
}
