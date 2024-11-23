package debkanta.projects.EmployeeManagementSystem.service;

import debkanta.projects.EmployeeManagementSystem.entity.Department;
import debkanta.projects.EmployeeManagementSystem.model.Function;
import debkanta.projects.EmployeeManagementSystem.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Transactional
    public boolean deleteDepartment(Function name) {
        int deletedCount = departmentRepository.deleteByName(name);

        return deletedCount > 0;
    }
}
