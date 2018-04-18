package pl.krisloves2code.SpringIntroduction.controller.model;


        import lombok.Getter;
        import lombok.Setter;
        import org.apache.commons.lang3.StringUtils;

        import javax.persistence.*;
        import java.util.List;

@Getter
@Setter
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    @Enumerated(EnumType.STRING)
    private Department department;

    /*
    @ManyToMany -> wywoluje tablice asocjacyjna, zawsze musi byc na liscie lub secie <List> <Set>
    LAZY nie pobiera z automatu
    * mappedBy --> */
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "attendees")
    private List<Meeting> meetings;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String phoneNumber, String email, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.department = department;
    }

    public String getFormattedDepartment() {
        String loverCase = StringUtils.lowerCase(department.toString());
        return "";
    }
}