package edu.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.*;

@Indexed
@Entity
@Table(name = "buildings")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type", referencedColumnName = "id")
    private BuildingType type;

    @Column(name = "name", nullable = false)
    @FullTextField(name = "name")
    private String name;

    @Column(name = "address", nullable = false)
    @FullTextField(name = "address")
    private String address;

    // Constructors, getters, and setters

    // Default constructor
    public Building() {
    }

    // Parameterized constructor
    public Building(BuildingType type, String name, String address) {
        this.type = type;
        this.name = name;
        this.address = address;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BuildingType getType() {
        return type;
    }

    public void setType(BuildingType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
