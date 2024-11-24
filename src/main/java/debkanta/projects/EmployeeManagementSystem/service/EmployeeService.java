package debkanta.projects.EmployeeManagementSystem.service;

import debkanta.projects.EmployeeManagementSystem.entity.Department;
import debkanta.projects.EmployeeManagementSystem.entity.Employee;
import debkanta.projects.EmployeeManagementSystem.entity.Project;
import debkanta.projects.EmployeeManagementSystem.model.CreateOrUpdateEmployeeDto;
import debkanta.projects.EmployeeManagementSystem.repository.DepartmentRepository;
import debkanta.projects.EmployeeManagementSystem.repository.EmployeeRepository;
import debkanta.projects.EmployeeManagementSystem.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        employeeEntity.setName(employee.getName());
        employeeEntity.setEmail(employee.getEmail());
        employeeEntity.setAssignedToAProject(employee.isAssignedToAProject());
        employeeEntity.setJoiningYear(employee.getJoiningYear());
        employeeEntity.setDesignation(employee.getDesignation());
        employeeEntity.setDepartment(department);

        return employeeRepository.save(employeeEntity);
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
}
