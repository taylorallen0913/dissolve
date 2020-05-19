public class CreateProject {
    private String name;
    private String location;

    public CreateProject() {
        this.name = null;
        this.location = null;
    }

    public CreateProject(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}