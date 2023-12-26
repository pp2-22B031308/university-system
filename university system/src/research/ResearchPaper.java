package research;

import interfaces.Format;

public class ResearchPaper {
	private String title;
    private String authors;
    private String journal;
    private int year;
    private int pages;
    private int citations;
    
    // Constructor
    public ResearchPaper(String title, String authors, String journal, int year, int pages, int citations) {
		super();
		this.title = title;
		this.authors = authors;
		this.journal = journal;
		this.year = year;
		this.pages = pages;
		this.citations = citations;
		
	}

    // getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getCitations() {
        return citations;
    }
	
	//methods
	public String getCitation(Format f) {
		return Format.formatCitation(title, authors, journal, year, pages);
	}
}
