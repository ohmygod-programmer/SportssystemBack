package edu.entity;

import javax.persistence.*;

import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

@Indexed
@Entity
@Table(name = "Competitions")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sport", referencedColumnName = "id")
    private Sport sport;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building", referencedColumnName = "id")
    private Building building;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizer", referencedColumnName = "id")
    private Organizer organizer;

    /*@Column(name = "date", nullable = false, columnDefinition = "daterange")
    private Range<Date> date;*/

    // Constructors, getters, and setters

    // Default constructor
    public Competition() {
    }

    // Parameterized constructor
    public Competition(Sport sport, String name, Building building, Organizer organizer/*, Range<Date> date*/) {
        this.sport = sport;
        this.name = name;
        this.building = building;
        this.organizer = organizer;
        /*this.date = date;*/
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

   /* public Range<Date> getDate() {
        return date;
    }

    public void setDate(Range<Date> date) {
        this.date = date;
    }*/
}

