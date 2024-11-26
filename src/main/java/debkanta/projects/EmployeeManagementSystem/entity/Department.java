package debkanta.projects.EmployeeManagementSystem.entity;

import debkanta.projects.EmployeeManagementSystem.model.DepartmentType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private DepartmentType name;

    private String description;
}
