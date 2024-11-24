package debkanta.projects.EmployeeManagementSystem.service;

import debkanta.projects.EmployeeManagementSystem.entity.Department;
import debkanta.projects.EmployeeManagementSystem.entity.Employee;
import debkanta.projects.EmployeeManagementSystem.entity.Project;
import debkanta.projects.EmployeeManagementSystem.model.CreateOrUpdateProjectDto;
import debkanta.projects.EmployeeManagementSystem.repository.DepartmentRepository;
import debkanta.projects.EmployeeManagementSystem.repository.EmployeeRepository;
import debkanta.projects.EmployeeManagementSystem.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public Project createProject(CreateOrUpdateProjectDto projectDto) {
        Department department = departmentRepository.findById(projectDto.getDepartmentId())
                .orElse(null);

        Project project = new Project();

        if(department != null) {
            project.setName(projectDto.getName());
            project.setDepartment(department);
            project.setBudget(projectDto.getBudget());
            project.setLive(projectDto.isLive());
            project.setDescription(projectDto.getDescription());

            List<Employee> employeeList = employeeRepository.findAllById(projectDto.getEmployeeIds());

            project.setEmployeeList(employeeList);
            project.setYearStarted(projectDto.getYearStarted());

            project = projectRepository.save(project);
        }

        return project;
    }

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public boolean deleteProject(long projectId) {
        if(projectRepository.existsById(projectId)) {
            projectRepository.deleteById(projectId);

            return true;
        } else {
            return false;
        }
    }

    public Project updateProject(long projectId, CreateOrUpdateProjectDto projectDto) {
        Project project = projectRepository.findById(projectId).orElse(null);

        if(project != null) {
            Department department = departmentRepository.findById(projectDto.getDepartmentId())
                    .orElse(null);

            if(department != null) {
                project.setName(projectDto.getName());
                project.setDepartment(department);
                project.setBudget(projectDto.getBudget());
                project.setLive(projectDto.isLive());
                project.setDescription(projectDto.getDescription());

                List<Employee> employeeList = employeeRepository.findAllById(projectDto.getEmployeeIds());

                project.setEmployeeList(employeeList);
                project.setYearStarted(projectDto.getYearStarted());

                project = projectRepository.save(project);

                for(Employee employee: employeeList) {
                    employee.getAssignedProjects().add(project);
                }

                employeeRepository.saveAll(employeeList);
            }

            return project;
        }

        return project;
    }
}
