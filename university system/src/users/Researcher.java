package users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import enums.Gender;
import research.*;

public class Researcher extends Employee{
	private static final long serialVersionUID = 1L;
	private String name;
    private int hIndex;
    private List<ResearchProject> researchProjects;
    private List<ResearchPaper> researchPapers;
	
	public Researcher() {
		super();
	}
	public Researcher(String id, String name, String surname, LocalDate birthDate, Gender gender, String adress,
			String email, String contactNumber, String login, String password, LocalDate hireDate) {
		super(id, name, surname, birthDate, gender, adress, email, contactNumber, login, password, hireDate);
		// TODO Auto-generated constructor stub
	}
	public Researcher(String name, int hIndex) {
		this.name = name;
		this.hIndex = hIndex;
		this.researchProjects = new ArrayList<>();
        this.researchPapers = new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
    public void printPapers(Comparator<ResearchPaper> comparator) {
        Collections.sort(researchPapers, comparator);
        for (ResearchPaper paper : researchPapers) {
            System.out.println(paper.getCitation(new PlainText()));
        }
    }

    public int calculateHIndex() {
        // Implement h-index calculation logic
        // You may need to sort the papers by citations and then find the largest index i such that citations[i] >= i + 1
        // Update the hIndex field and return it
    }
	
	
    
    

}
