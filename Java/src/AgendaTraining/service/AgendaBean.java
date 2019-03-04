package AgendaTraining.service;

import AgendaTraining.model.Agenda;

public class AgendaBean {
    private static final Agenda agenda = new Agenda();

    private AgendaBean() {

    }

    public static Agenda getAgenda() {
        return agenda;
    }
}
