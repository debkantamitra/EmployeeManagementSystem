package debkanta.projects.EmployeeManagementSystem.repository;

import debkanta.projects.EmployeeManagementSystem.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
