package debkanta.projects.EmployeeManagementSystem.model;

public enum Designation {
    ASSOCIATE("Associate", 15000),
    SENIOR_ASSOCIATE("Senior Associate", 20000),
    MANAGER("Manager", 35000),
    SENIOR_MANAGER("Senior Manager", 40000),
    DIRECTOR("Director", 550000);

    private String title;
    private int baseSalary;

    Designation(String title, int baseSalary) {
        this.title = title;
        this.baseSalary = baseSalary;
    }

    public String getTitle() {
        return title;
    }
    public int getBaseSalary() {
        return baseSalary;
    }
}
