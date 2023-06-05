package edu.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Indexed
@Entity
@Table(name = "Sportsmans")
/*@Getter
@Setter
@ToString
@EqualsAndHashCode*/
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Sportsman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    @FullTextField(name = "first_name")
    private String first_name;

    @Column(name = "middle_name")
    @FullTextField(name = "middle_name")
    private String middle_name;

    @Column(name = "last_name", nullable = false)
    @FullTextField(name = "last_name")
    private String last_name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_of_birth", nullable = false)
    private Date date_of_birth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club", referencedColumnName = "id")
    private Club club;


    // Default constructor
    public Sportsman() {
    }

    // Parameterized constructor
    public Sportsman(String first_name, String middleName, String lastName, Date dateOfBirth, Club club) {
        this.first_name = first_name;
        this.middle_name = middleName;
        this.last_name = lastName;
        this.date_of_birth = dateOfBirth;
        this.club = club;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
