package edu.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CoachingId implements Serializable {
    @Column(nullable = false)
    private Integer sport;
    @Column(nullable = false)
    private Integer sportsman;
    @Column(nullable = false)
    private Integer trainer;

    // Constructors, equals, and hashCode methods

    // Default constructor
    public CoachingId() {
    }

    // Parameterized constructor
    public CoachingId(Integer sport, Integer sportsman, Integer trainer) {
        this.sport = sport;
        this.sportsman = sportsman;
        this.trainer = trainer;
    }

    // Getters and setters
    public Integer getSport() {
        return sport;
    }

    public void setSport(Integer sport) {
        this.sport = sport;
    }

    public Integer getSportsman() {
        return sportsman;
    }

    public void setSportsman(Integer sportsman) {
        this.sportsman = sportsman;
    }

    public Integer getTrainer() {
        return trainer;
    }

    public void setTrainer(Integer trainer) {
        this.trainer = trainer;
    }

    // Equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoachingId that = (CoachingId) o;
        return Objects.equals(sport, that.sport) &&
                Objects.equals(sportsman, that.sportsman) &&
                Objects.equals(trainer, that.trainer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sport, sportsman, trainer);
    }
}