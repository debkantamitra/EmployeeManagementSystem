# Employee Management System

## Description
The **Employee Management System** is a Spring Boot application designed to manage employees, projects, and departments. It supports essential CRUD operations for employees, projects, and departments while offering advanced functionalities like project assignment and department-based project budget calculations.

## Features
- CRUD Operations for Employees, Projects, and Departments.
- Advanced Search for employees by name, department, and project.
- Track Project Budgets per department.
- Relationship Management:
  - Many-to-One between Employees and Departments.
  - Many-to-Many between Employees and Projects.
- Validation for user inputs using **Jakarta Validation API**.


## Tech Stack
- **Java 17**
- **Spring Boot 3.3.5**
  - Spring Boot Starter Data JPA
  - Spring Boot Starter Validation
  - Spring Boot Starter Web
- **MySQL** for database management.
- **Lombok** for boilerplate code reduction.
- **Maven** for dependency management.

## Entities
### Employee
- **Fields**:
  - `id`: Unique identifier.
  - `name`: Name of the employee.
  - `email`: Email (must be unique).
  - `isAssignedToAProject`: Project assignment status.
  - `joiningYear`: Date of joining.
  - `designation`: Employee designation.
  - `department`: Linked department.
  - `assignedProjects`: List of assigned projects.
  
### Project
- **Fields**:
  - `id`: Unique identifier.
  - `name`: Project name (must be unique).
  - `yearStarted`: Start year of the project.
  - `budget`: Budget allocated to the project.
  - `isLive`: Status of the project.
  - `description`: Details about the project.
  - `department`: Associated department.
  - `employeeList`: Employees assigned to the project.
  
### Department
- **Fields**:
  - `id`: Unique identifier.
  - `name`: Department name (enum type).
  - `description`: Description of the department.

## API Endpoints
### Employee Endpoints
- **POST** `/employees`: Create a new employee.
- **GET** `/employees`: Retrieve all employees.
- **PUT** `/employees/{employeeId}`: Update an existing employee.
- **DELETE** `/employees/{employeeId}`: Delete an employee by ID.
- **GET** `/employees/search`: Search employees by name, department, or project.
- **GET** `/employees/project/unassigned`: List employees not assigned to any project.
- **GET** `/employees/project/{projectId}`: Get employees by project.

### Project Endpoints
- **POST** `/projects`: Create a new project.
- **GET** `/projects`: Retrieve all projects.
- **PUT** `/projects/{projectId}`: Update an existing project.
- **DELETE** `/projects/{projectId}`: Delete a project by ID.
- **GET** `/projects/budget/{departmentId}`: Get total project budget for a department.

### Department Endpoints
- **POST** `/departments`: Create a new department.
- **GET** `/departments`: Retrieve all departments.
- **PUT** `/departments/{departmentId}`: Update an existing department.
- **DELETE** `/departments/{departmentId}`: Delete a department by ID.

## Database Configuration
This project uses **MySQL** for data persistence. Make sure to configure your `application.properties` with the correct database credentials.
