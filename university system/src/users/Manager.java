package users;

import enums.*;

public class Manager extends Employee {
    private static final long serialVersionUID = 1L;
    private ManagerType managerType;

    public Manager() {
        super();
    }

    public Manager(String id, String name, String surname, Gender gender, String email,
                   String login, String password, ManagerType managerType) {
        super(id, name, surname, gender, email, login, password);
        this.managerType = managerType;
    }

    public ManagerType getManagerType() {
        return managerType;
    }

    public void setManagerType(ManagerType managerType) {
        this.managerType = managerType;
    }

    @Override
    public String toString() {
        return "Manager [managerType=" + managerType + ", toString()=" + super.toString() + "]";
    }
}
