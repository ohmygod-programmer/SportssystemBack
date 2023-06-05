package edu.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Results")
public class Result implements Serializable {
    @EmbeddedId
    private ResultId id;

    @ManyToOne
    @JoinColumn(name = "competition", referencedColumnName = "id", insertable = false, updatable = false)
    private Competition competition;


    @ManyToOne
    @JoinColumn(name = "sportsman", referencedColumnName = "id", insertable = false, updatable = false)
    private Sportsman sportsman;

    @ManyToOne
    @JoinColumn(name = "club")
    private Club club;

    @Column(name = "place")
    private Integer place;

    @Column(name = "result", length = 100)
    private String result;

    @Column(name = "awarded")
    private boolean awarded;

    // Constructors, getters, and setters
    public Result() {
    }

    public Result(Competition competition, Sportsman sportsman, Club club, Integer place, String result, boolean awarded) {
        this.id = new ResultId(sportsman.getId(), competition.getId());
        this.competition = competition;
        this.sportsman = sportsman;
        this.club = club;
        this.place = place;
        this.result = result;
        this.awarded = awarded;
    }

    // Getters and setters
    public ResultId getId() {
        return id;
    }

    public void setId(ResultId id) {
        this.id = id;
    }


    public Sportsman getSportsman() {
        return sportsman;
    }

    public void setSportsman(Sportsman sportsman) {
        this.sportsman = sportsman;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isAwarded() {
        return awarded;
    }

    public void setAwarded(boolean awarded) {
        this.awarded = awarded;
    }

}
