package debkanta.projects.EmployeeManagementSystem.repository;

import debkanta.projects.EmployeeManagementSystem.entity.Employee;
import debkanta.projects.EmployeeManagementSystem.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByNameContainingIgnoreCaseAndDepartmentId(String name, long id);
    List<Employee> findByNameContainingIgnoreCaseAndDepartmentIdAndAssignedProjectsContaining(String name, long id, Project storedProject);

    List<Employee> findByNameContainingIgnoreCaseAndAssignedProjectsContaining(String name, Project storedProject);

    List<Employee> findByNameContainingIgnoreCase(String name);
}
