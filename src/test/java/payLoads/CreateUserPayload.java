package payLoads;

public class CreateUserPayload {

    private String name;
    private String job;

    // Getter
    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }
}