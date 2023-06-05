package edu.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BuildingSpecificationId implements Serializable {

    @Column(name = "building")
    private Integer buildingId;

    @Column(name = "specification")
    private Integer specificationId;

    // Constructors, equals, and hashCode methods

    // Default constructor
    public BuildingSpecificationId() {
    }

    // Parameterized constructor
    public BuildingSpecificationId(Integer buildingId, Integer specificationId) {
        this.buildingId = buildingId;
        this.specificationId = specificationId;
    }

    // Getters and setters
    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Integer specificationId) {
        this.specificationId = specificationId;
    }

    // Equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuildingSpecificationId that = (BuildingSpecificationId) o;
        return Objects.equals(buildingId, that.buildingId) &&
                Objects.equals(specificationId, that.specificationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buildingId, specificationId);
    }
}
