package AgendaTraining.model;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    static final String NUME = "AGENDA";
    private List<Contact> contacte;

    public Agenda() {
        this.contacte = new ArrayList<>();
    }

    public List<Contact> getContacte() {
        return contacte;
    }

    public void setContacte(Contact contact) {
        this.contacte.add(contact);
    }
}
