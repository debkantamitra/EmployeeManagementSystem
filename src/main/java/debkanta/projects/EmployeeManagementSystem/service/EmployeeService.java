package debkanta.projects.EmployeeManagementSystem.service;

import debkanta.projects.EmployeeManagementSystem.entity.Department;
import debkanta.projects.EmployeeManagementSystem.entity.Employee;
import debkanta.projects.EmployeeManagementSystem.entity.Project;
import debkanta.projects.EmployeeManagementSystem.model.CreateOrUpdateEmployeeDto;
import debkanta.projects.EmployeeManagementSystem.model.DepartmentType;
import debkanta.projects.EmployeeManagementSystem.repository.DepartmentRepository;
import debkanta.projects.EmployeeManagementSystem.repository.EmployeeRepository;
import debkanta.projects.EmployeeManagementSystem.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ProjectRepository projectRepository;

    public Employee createEmployee(CreateOrUpdateEmployeeDto employee) {
        Department department = departmentRepository.findById(employee.getDepartmentId())
                .orElse(null);

        Employee employeeEntity = new Employee();

        if(department != null) {
            employeeEntity.setName(employee.getName());
            employeeEntity.setEmail(employee.getEmail());
            employeeEntity.setAssignedToAProject(employee.isAssignedToAProject());
            employeeEntity.setJoiningYear(employee.getJoiningYear());
            employeeEntity.setDesignation(employee.getDesignation());
            employeeEntity.setDepartment(department);

            employeeEntity = employeeRepository.save(employeeEntity);
        }

        return employeeEntity;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public boolean deleteEmployee(long employeeId) {
        if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId);
            return true;
        } else {
            return false;
        }
    }

    public Employee updateEmployee(long employeeId, CreateOrUpdateEmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);

        if(employee != null) {
            employee.setEmail(employeeDto.getEmail());
            employee.setDesignation(employeeDto.getDesignation());
            employee.setJoiningYear(employeeDto.getJoiningYear());
            employee.setName(employeeDto.getName());

            List<Project> projectList = projectRepository.findAllById(employeeDto.getAssignedProjectIds());
            Department department = departmentRepository.findById(employeeDto.getDepartmentId())
                    .orElse(employee.getDepartment());


            employee.setAssignedProjects(projectList);
            employee.setDepartment(department);

            return employeeRepository.save(employee);
        }

        return null;
    }

    public List<Employee> searchEmployeeByQuery(String name, DepartmentType department, String project) {
        Department storedDepartment = department != null ? departmentRepository.findByName(department) : null;
        Project storedProject = project != null ? projectRepository.findByNameContainingIgnoreCase(project) : null;

        if (storedDepartment != null && storedProject != null) {
            return employeeRepository.findByNameContainingIgnoreCaseAndDepartmentIdAndAssignedProjectsContaining(
                    name, storedDepartment.getId(), storedProject);
        } else if (storedDepartment != null) {
            return employeeRepository.findByNameContainingIgnoreCaseAndDepartmentId(name, storedDepartment.getId());
        } else if (storedProject != null) {
            return employeeRepository.findByNameContainingIgnoreCaseAndAssignedProjectsContaining(name, storedProject);
        }

        return employeeRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Employee> getProjectUnassignedEmployees() {
        return employeeRepository.findByAssignedProjectsEmpty();
    }

    public List<Employee> getEmployeesByProject(long projectId) {
        Project storedProject = projectRepository.findById(projectId)
                .orElse(null);

        if(storedProject != null) {
            return employeeRepository.findByAssignedProjects_Id(projectId);
        }

        return new ArrayList<>();
    }
}
