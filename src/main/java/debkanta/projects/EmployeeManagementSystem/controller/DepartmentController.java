package debkanta.projects.EmployeeManagementSystem.controller;

import debkanta.projects.EmployeeManagementSystem.entity.Department;
import debkanta.projects.EmployeeManagementSystem.model.Function;
import debkanta.projects.EmployeeManagementSystem.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department createDepartment(@RequestBody @Valid Department department) {
        return departmentService.createDepartment(department);
    }

    @GetMapping
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @DeleteMapping("{name}")
    public boolean deleteDepartment(@PathVariable Function name) {
        return departmentService.deleteDepartment(name);
    }
}
