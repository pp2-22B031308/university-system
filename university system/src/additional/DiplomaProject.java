package additional;

public class DiplomaProject {
    private String id;
    private String title;
    private boolean isSubmitted;

    public DiplomaProject(String id, String title) {
        this.id = id;
        this.title = title;
        this.isSubmitted = false;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public void setSubmitted(boolean submitted) {
        isSubmitted = submitted;
    }

    @Override
    public String toString() {
        return "DiplomaProject{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", isSubmitted=" + isSubmitted +
                '}';
    }
}
