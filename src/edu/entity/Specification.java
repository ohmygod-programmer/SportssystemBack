package edu.entity;

import javax.persistence.*;

@Entity
@Table(name = "Specifications")
public class Specification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "isnumeric", nullable = false)
    private boolean isNumeric;

    // Constructors, getters, and setters

    // Default constructor
    public Specification() {
    }

    // Parameterized constructor
    public Specification(String name, boolean isNumeric) {
        this.name = name;
        this.isNumeric = isNumeric;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNumeric() {
        return isNumeric;
    }

    public void setNumeric(boolean numeric) {
        isNumeric = numeric;
    }
}

