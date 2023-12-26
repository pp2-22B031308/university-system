package users;

import enums.*;

public class TechSupportSpecialist extends Employee {

    private static final long serialVersionUID = 1L;

    private Manager manager;
    
    public TechSupportSpecialist() {
        super();
    }

    public TechSupportSpecialist(String id, String name, String surname, Gender gender, String email,
                                 String login, String password, Manager manager) {
        super(id, name, surname, gender, email, login, password);
        this.manager = manager;

    }
    public TechSupportSpecialist(String id, String name, String surname, Gender gender, String email,
            String login, String password) {
    		super(id, name, surname, gender, email, login, password);
}
    
    public Manager getManager() {
        return manager;
    }
}
