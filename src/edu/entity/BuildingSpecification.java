package edu.entity;

import javax.persistence.*;

@Entity
@Table(name = "BuildingsSpecifications")
public class BuildingSpecification {

    @EmbeddedId
    private BuildingSpecificationId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("buildingId")
    @JoinColumn(name = "building", referencedColumnName = "id")
    private Building building;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("specificationId")
    @JoinColumn(name = "specification", referencedColumnName = "id")
    private Specification specification;

    @Column(name = "value", nullable = false)
    private String value;

    // Constructors, getters, and setters

    // Default constructor
    public BuildingSpecification() {
    }

    // Parameterized constructor
    public BuildingSpecification(Building building, Specification specification, String value) {
        this.building = building;
        this.specification = specification;
        this.value = value;
        this.id = new BuildingSpecificationId(building.getId(), specification.getId());
    }

    // Getters and setters
    public BuildingSpecificationId getId() {
        return id;
    }

    public void setId(BuildingSpecificationId id) {
        this.id = id;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
