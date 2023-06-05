package edu.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "Clubs")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "sport")
    private Sport sport;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    // Constructors, getters, and setters

    // Additional methods, if needed
}
