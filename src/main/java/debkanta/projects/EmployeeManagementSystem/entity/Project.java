package debkanta.projects.EmployeeManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private Date yearStarted;
    @Column(nullable = false)
    private long budget;
    private boolean isLive;
    private String description;

    @ManyToOne
    @JoinColumn(name="department_id", nullable = false)
    private Department department;

    @ManyToMany(mappedBy = "assignedProjects")
    private List<Employee> employeeList;
}
