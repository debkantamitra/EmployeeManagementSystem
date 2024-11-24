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
    public boolean deleteByDepartmentId(long departmentId) {
        if (departmentRepository.existsById(departmentId)) {
            departmentRepository.deleteById(departmentId);
            return true;
        } else {
            return false;
        }
    }

    public Department updateDepartment(long departmentId, Department departmentRequest) {
        Department department = departmentRepository.findById(departmentId).orElse(null);

        if(department != null) {
            department.setDescription(departmentRequest.getDescription());
            department.setName(departmentRequest.getName());
        }

        System.out.println(department + "here");

        return department;
    }
}
