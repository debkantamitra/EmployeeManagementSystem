package debkanta.projects.EmployeeManagementSystem.controller;

import debkanta.projects.EmployeeManagementSystem.entity.Department;
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

    // create
    @PostMapping
    public Department createDepartment(@Valid @RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    // read
    @GetMapping
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    // update
    @PutMapping("{departmentId}")
    public Department updateDepartment(@PathVariable long departmentId,
                                       @RequestBody @Valid Department department) {
        return departmentService.updateDepartment(departmentId, department);
    }

    // delete
    @DeleteMapping("{departmentId}")
    public boolean deleteDepartment(@PathVariable long departmentId) {
        return departmentService.deleteByDepartmentId(departmentId);
    }
}
