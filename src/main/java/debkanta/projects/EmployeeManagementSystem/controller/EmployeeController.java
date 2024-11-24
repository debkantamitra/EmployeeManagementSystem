package debkanta.projects.EmployeeManagementSystem.controller;

import debkanta.projects.EmployeeManagementSystem.entity.Employee;
import debkanta.projects.EmployeeManagementSystem.model.CreateOrUpdateEmployeeDto;
import debkanta.projects.EmployeeManagementSystem.service.EmployeeService;
import jakarta.validation.Valid;
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
}
