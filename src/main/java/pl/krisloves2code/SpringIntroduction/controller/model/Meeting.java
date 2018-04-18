package pl.krisloves2code.SpringIntroduction.controller.model;


import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @ManyToOne
     /* @OnDelete --> jezeli usunie się np jakiegos ownera to usunie tez jakis meeting przez niego stworzony*/
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Employee owner;

    @ManyToMany
    private List<Employee> attendees;

    @ManyToOne
    private Room room;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;


    public Meeting() {
    }

    public Meeting(String title, String description, Employee owner, List<Employee> attendees, Room room, LocalDate date) {
        this.title = title;
        this.description = description;
        this.owner = owner;
        this.attendees = attendees;
        this.room = room;
        this.date = date;
    }

    /*+1 poniewaz Owner*/
    public int getAttendeesCount() {
        return (attendees == null ? 0 : attendees.size()) + 1;
    }

    /*nasze description bedzie wyswietlalo tylko 20 znakow*/
    public String getShortenedDescription() {
        return StringUtils.abbreviate(description, 20);
    }
}