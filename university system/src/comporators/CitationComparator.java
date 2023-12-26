package comporators;

import java.util.Comparator;
import research.*;;

public class CitationComparator implements Comparator<ResearchPaper> {
	
    @Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
        // Compare by citations (you need to have a method to get citations in ResearchPaper)
        return Integer.compare(paper1.getCitations(), paper2.getCitations());
    }
}
