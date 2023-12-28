package charge;

import users.*;
import research.*;
import database.*;

public class ResearcherCharge {
	
	public static void viewResearchProjects(Researcher researcher) {
		System.out.println("Research Projects for Researcher " + researcher.getId() + ":");
		
        for (ResearchProject project : researcher.getResearchProjects() ) {
            System.out.println("Project ID: " + project.getId() + ", Title: " + project.getName());
        }
	}
	
	public static void ViewResearchPapers(Researcher researcher) {
		System.out.println("Research Papers for Researcher " + researcher.getId() + ":");
        for (ResearchPaper paper : researcher.getResearchPapers() ) {
            System.out.println("Paper ID: " + paper.getId() + ", Title: " + paper.getTitle());
        }
	}
}
