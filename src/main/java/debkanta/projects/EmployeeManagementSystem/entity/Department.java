package debkanta.projects.EmployeeManagementSystem.entity;

import debkanta.projects.EmployeeManagementSystem.model.Function;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private Function name;
    private String description;
}
