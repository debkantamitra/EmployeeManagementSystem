package debkanta.projects.EmployeeManagementSystem.repository;

import debkanta.projects.EmployeeManagementSystem.entity.Department;
import debkanta.projects.EmployeeManagementSystem.model.Function;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
     int deleteByName(Function name);
}
