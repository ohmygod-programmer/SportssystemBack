package edu.entity;

import javax.persistence.*;


@Entity
@Table(name = "coaching")
public class Coaching {

    @EmbeddedId
    private CoachingId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sport", referencedColumnName = "id", insertable = false, updatable = false)
    private Sport sport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sportsman", referencedColumnName = "id", insertable = false, updatable = false)
    private Sportsman sportsman;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer", referencedColumnName = "id", insertable = false, updatable = false)
    private Trainer trainer;

    // Constructors, getters, and setters

    // Default constructor
    public Coaching() {
    }

    // Parameterized constructor
    public Coaching(Sport sport, Sportsman sportsman, Trainer trainer) {
        this.id = new CoachingId(sport.getId(), sportsman.getId(), trainer.getId());
        this.sport = sport;
        this.sportsman = sportsman;
        this.trainer = trainer;
    }

    // Getters and setters
    public CoachingId getId() {
        return id;
    }

    public void setId(CoachingId id) {
        this.id = id;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Sportsman getSportsman() {
        return sportsman;
    }

    public void setSportsman(Sportsman sportsman) {
        this.sportsman = sportsman;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
