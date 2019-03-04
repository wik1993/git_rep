package AgendaTraining;

import AgendaTraining.model.Agenda;
import AgendaTraining.model.Contact;
import AgendaTraining.service.AgendaBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class WorkWithAgenda {

    public static void main(String[] args) {
        //Show menu first time
        showMenuOptionsAndWaitForInput();
    }

    void createConnection(){

    }
    // Creating a new contact

    private static void createContact() {
        Scanner newInput = new Scanner(System.in);

        Contact newContact = new Contact();

        System.out.println("Enter please ID: ");
        Integer id = newInput.nextInt();
        newContact.setId(id);

        System.out.println("Enter please the Name");
        String name = newInput.next();
        newContact.setNume(name);

        System.out.println("Enter please the Last Name");
        String lastName = newInput.next();
        newContact.setPrenume(lastName);

        System.out.println("Enter please the Phone number");
        String phoneNumber = newInput.next();
        newContact.setNrTelefon(phoneNumber);

        System.out.println("Add to Favorite?");
        Boolean newInfoB = newInput.hasNextBoolean();
        newContact.setFavorite(newInfoB);


        Agenda agenda = AgendaBean.getAgenda();
        agenda.setContacte(newContact);
    }

    // Read a contact by ID
    private static Contact readContactById(int id) {
        for (Contact contact : AgendaBean.getAgenda().getContacte()) {
            if (contact.getId() == id) {
                return contact;
            }
        }
        System.out.println("No Contact with provided ID");
        return null;
    }

    // Read a contact by Name
    private static List<Contact> getContactsByName(String name) {
        List<Contact> foundedContacts = new ArrayList<>();
        for (Contact contact : AgendaBean.getAgenda().getContacte()) {
            if (contact.getNume().equals(name)) {
                foundedContacts.add(contact);
            }
        }
        if (foundedContacts.isEmpty()) {
            System.out.println("No contact with provided name!");
        }
        return foundedContacts;
    }

    // Update a contact by ID
    private static void updateContactById(int id) {
        Contact currentContact = readContactById(id);

        Scanner newInput = new Scanner(System.in);

        System.out.println("Enter please the Name");
        String name = newInput.next();
        currentContact.setNume(name);

        System.out.println("Enter please the Last Name");
        String lastName = newInput.next();
        currentContact.setPrenume(lastName);

        System.out.println("Enter please the Phone number");
        String phoneNumber = newInput.next();
        currentContact.setNrTelefon(phoneNumber);

        System.out.println("Add to Favorite?");
        Boolean newInfoB = newInput.hasNextBoolean();
        currentContact.setFavorite(newInfoB);

    }

    // Delete a contact by ID
    private static void deleteContactById(int id) {
        Contact currentContact = readContactById(id);
        AgendaBean.getAgenda().getContacte().remove(currentContact);
    }

    private static void showMenuOptionsAndWaitForInput() {
        System.out.println("1. Create Contact");
        System.out.println("2. Read Contact by ID");
        System.out.println("3. Update Contact by ID");
        System.out.println("4. Delete Contact by ID");
        System.out.println("5. Quit");

        Scanner newInput = new Scanner(System.in);
        System.out.println("Chose the option: ");
        int selectedOption = newInput.nextInt();
        switch (selectedOption) {
            case 1:
                createContact();
                showMenuOptionsAndWaitForInput();
                break;
            case 2:
                System.out.println("Enter please the ID: ");
                System.out.println(readContactById(newInput.nextInt()));
                showMenuOptionsAndWaitForInput();
                break;
            case 3:
                System.out.println("Enter please the ID for update: ");
                updateContactById(newInput.nextInt());
                showMenuOptionsAndWaitForInput();
                break;
            case 4:
                System.out.println("Enter please the ID to delete: ");
                deleteContactById(newInput.nextInt());
                showMenuOptionsAndWaitForInput();
                break;
            case 5:
                System.out.println("See you");
                break;
        }
    }
}
