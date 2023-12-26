package users;


public interface CanBecomeResearcher<T extends User> {
	public void becomeResearcher();

    public boolean isResearcher();

    public Researcher<?> getResearcher();
}
