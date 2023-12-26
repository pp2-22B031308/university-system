package users;

import enums.CitFormat;

public interface Researcher{
	
    
    ResearchProject[] printPapers();

    
    ResearchProject publishPaper(ResearchProject project, ResearchPaper paper);

    
    String getCitation(CitFormat citFormat);

    
    Integer calculateHIndex();

    
}
