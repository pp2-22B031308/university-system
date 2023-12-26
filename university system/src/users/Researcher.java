package users;

public interface Researcher {
package users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import enums.Gender;
import research.*;

public abstract class Researcher<T extends User> extends User {
    private static final long serialVersionUID = 1L;
    private int hIndex;
    private List<ResearchProject> researchProjects;
    private List<ResearchPaper> researchPapers;

    public Researcher() {
        super();
        this.hIndex = 0;
        this.researchProjects = new ArrayList<>();
        this.researchPapers = new ArrayList<>();
    }

    public Researcher(String id, String name, String surname, Gender gender,
            String email, String login, String password, LocalDate hireDate) {
        super(id, name, surname, gender, email, login, password);
    }

    public int gethIndex() {
        return hIndex;
    }

    public void sethIndex(int hIndex) {
        this.hIndex = hIndex;
    }

    public void addResearchProject(ResearchProject project) {
        researchProjects.add(project);
    }

    public void addResearchPaper(ResearchPaper paper) {
        researchPapers.add(paper);
    }

    public void printResearchPapers(Comparator<ResearchPaper> comparator) {
        Collections.sort(researchPapers, comparator);
        for (ResearchPaper paper : researchPapers) {
            System.out.println(paper.getCitation(new PlainText()));
        }
    }

    public List<ResearchProject> getResearchProjects() {
        return researchProjects;
    }

    public List<ResearchPaper> getResearchPapers() {
        return researchPapers;
    }

    public void setResearchProjects(List<ResearchProject> researchProjects) {
        this.researchProjects = researchProjects;
    }

    public void setResearchPapers(List<ResearchPaper> researchPapers) {
        this.researchPapers = researchPapers;
    }
}

}
