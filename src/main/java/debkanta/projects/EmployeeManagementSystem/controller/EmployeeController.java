package debkanta.projects.EmployeeManagementSystem.controller;

import debkanta.projects.EmployeeManagementSystem.entity.Employee;
import debkanta.projects.EmployeeManagementSystem.model.CreateOrUpdateEmployeeDto;
import debkanta.projects.EmployeeManagementSystem.model.DepartmentType;
import debkanta.projects.EmployeeManagementSystem.service.EmployeeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee creatEmployee(@Valid @RequestBody CreateOrUpdateEmployeeDto employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @DeleteMapping("{employeeId}")
    public boolean deleteEmployee(@PathVariable("employeeId") long employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }

    @PutMapping("{employeeId}")
    public Employee updateEmployee(@PathVariable("employeeId") long employeeId, @Valid @RequestBody CreateOrUpdateEmployeeDto employeeDto) {
        return employeeService.updateEmployee(employeeId, employeeDto);
    }

    @GetMapping("search")
    public List<Employee> searchEmployeeByQuery(@RequestParam("name") String name,
                                                @RequestParam(value ="department", required = false) DepartmentType department,
                                                @RequestParam(value ="project", required = false) String project) {

        return employeeService.searchEmployeeByQuery(name, department, project);
    }

    @GetMapping("/project/unassigned")
    public List<Employee> getProjectUnassignedEmployees() {
        return employeeService.getProjectUnassignedEmployees();
    }

    @GetMapping("/project/{projectId}")
    public List<Employee> getEmployeesByProject(@PathVariable("projectId") long projectId) {
        return employeeService.getEmployeesByProject(projectId);
    }
}
