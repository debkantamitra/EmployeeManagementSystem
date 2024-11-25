package debkanta.projects.EmployeeManagementSystem.controller;

import debkanta.projects.EmployeeManagementSystem.entity.Project;
import debkanta.projects.EmployeeManagementSystem.model.CreateOrUpdateProjectDto;
import debkanta.projects.EmployeeManagementSystem.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping
    public Project createProject(@RequestBody @Valid CreateOrUpdateProjectDto projectDto) {
        return projectService.createProject(projectDto);
    }

    @GetMapping
    public List<Project> getProjects() {
        return projectService.getProjects();
    }

    @DeleteMapping("{projectId}")
    public boolean deleteProject(@PathVariable("projectId") long projectId) {
        return projectService.deleteProject(projectId);
    }

    @PutMapping("{projectId}")
    public Project updateProject(@PathVariable("projectId") long projectId, @RequestBody @Valid CreateOrUpdateProjectDto projectDto) {
        return projectService.updateProject(projectId, projectDto);
    }

    @GetMapping("budget/{departmentId}")
    public long getProjectsBudgetByDepartmentId(@PathVariable("departmentId") long departmentId) {
        return projectService.getProjectsBudgetByDepartmentId(departmentId);
    }
}
