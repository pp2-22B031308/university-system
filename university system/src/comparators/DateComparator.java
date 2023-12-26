package comporators;

import java.util.Comparator;
import research.ResearchPaper;

public class DateComparator implements Comparator<ResearchPaper> {
    @Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
        return Integer.compare(paper1.getYear(), paper2.getYear());
    }
}
