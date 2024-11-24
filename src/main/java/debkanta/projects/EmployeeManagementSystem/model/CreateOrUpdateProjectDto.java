package debkanta.projects.EmployeeManagementSystem.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CreateOrUpdateProjectDto {
    @NotNull
    private String name;

    private Date yearStarted;
    private long budget;
    private boolean isLive;

    @NotNull
    private String description;

    @NotNull
    private long departmentId;
    private List<Long> employeeIds;
}
