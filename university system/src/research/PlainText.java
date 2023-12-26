package research;

import interfaces.*;

public class PlainText implements Format {

    public String formatCitation(String title, String authors, String journal, int year, int pages) {
        // Implement plain text citation format
        // Example: Author(s). "Title." Journal, vol(issue), pages, year.
        return String.format("%s. \"%s.\" %s, %d(%d), %d, %s.", authors, title, journal, year, pages);
    }
}
