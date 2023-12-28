package research;

import users.*;

public class Bibtex implements Format {
    public String formatCitation(String title, String authors, String journal, int year, int pages) {
        // Implement Bibtex citation format
        // Example: @article{key, author={Author(s)}, title={Title}, journal={Journal}, year={Year}, pages={Pages}}
        return String.format("@article{key, author={%s}, title={%s}, journal={%s}, year={%d}, pages={%d}, doi={%s}}",
                             authors, title, journal, year, pages);
    }
}
