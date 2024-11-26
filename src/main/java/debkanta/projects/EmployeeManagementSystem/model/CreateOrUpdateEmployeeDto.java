package debkanta.projects.EmployeeManagementSystem.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CreateOrUpdateEmployeeDto {
    @NotNull
    private String name;

    @Email
    @NotNull
    private String email;
    private boolean isAssignedToAProject;
    private Date joiningYear;

    @NotNull
    private Designation designation;

    @NotNull
    private long departmentId;

    private List<Long> assignedProjectIds;
}

