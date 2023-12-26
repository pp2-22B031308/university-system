package users

import java.util.ArrayList;
import java.util.List;

public abstract class ResearcherDecorator implements Researcher {
    private User user;
    private List<ResearchProject> printedPapers;
    private static final int MAX_PAPERS = 100;

    public ResearcherDecorator(User user) {
        this.user = user;
        this.printedPapers = new ArrayList<>();
    }

    public ResearchProject[] printPapers() {
        return printedPapers.toArray(new ResearchProject[0]);
    }

    public ResearchProject publishPaper(ResearchProject project, ResearchPaper paper) {
        if (user instanceof Researcher) {
            Researcher researcher = (Researcher) user;

            ResearchProject publishedProject = researcher.publishPaper(project, paper);

            if (publishedProject != null && printedPapers.size() < MAX_PAPERS) {
                printedPapers.add(publishedProject);
            }

            return publishedProject;
        }
        return null;
    }

    public String getCitation() {
        if (user instanceof Researcher) {
            Researcher researcher = (Researcher) user;
            ResearchPaper paper = researcher.getResearchPaper();

            if (paper != null) {
                String author = paper.getAuthor();
                String title = paper.getTitle();
                String journal = paper.getJournal();
                int year = paper.getYear();

                
                return author + ". (" + year + "). " + title + ". " + journal + ".";
            }
        }
        return null;
    }
    @Override
    public Integer calculateHIndex() {
        int hIndex = 0;
        for (ResearchProject project : printedPapers) {
            int citations = project.getCitations(); // Assuming getCitations() gives the citations of the project

            if (citations >= hIndex + 1) {
                hIndex++;
            } else {
                break;
            }
        }
        return hIndex;
    }
    
    public static ResearcherDecorator wrapWithResearcherDecorator(User user) {
        if (user instanceof Researcher) {
            return new ResearcherDecorator((Researcher) user);
        }
      
        return null;
    }


   
}
