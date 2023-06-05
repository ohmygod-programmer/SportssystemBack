package edu.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class ResultId implements Serializable{

    @Column(nullable = false)
    private Integer sportsman;
    @Column(nullable = false)
    private Integer competition;

    // Constructors, equals, and hashCode methods

    // Default constructor
    public ResultId() {
    }

    // Parameterized constructor
    public ResultId(Integer sportsman, Integer competition) {
        this.sportsman = sportsman;
        this.competition = competition;
    }

    // Getters and setters

    public Integer getSportsman() {
        return sportsman;
    }

    public void setSportsman(Integer sportsman) {
        this.sportsman = sportsman;
    }

    public Integer getCompetition() {
        return competition;
    }

    public void setCompetition(Integer competition) {
        this.competition = competition;
    }



    @Override
    public int hashCode() {
        return Objects.hash(sportsman, competition);
    }
}