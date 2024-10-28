package ru.practicum.ewm.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@Table(name = "compilations")
@EqualsAndHashCode(of = "id")
public class Compilation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pinned")
    boolean pinned;

    //private List<Event> events;
}
